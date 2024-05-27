package com.roq;

import com.roq.Strategy;
import com.roq.client.Config;
import com.roq.client.Dispatcher;
import com.roq.client.Settings;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

// TODO
// - signals
// - logging

public final class Main {
  static boolean finished = false;

  public static void main(String[] args) {
    System.out.println("length=" + args.length);
    registerShutdownHook();
    var dispatcher = create(args);
    var handler = new Strategy(dispatcher);
    dispatcher.start();
    while (dispatcher.dispatch(handler)) {
      if (finished)
        break;
      LockSupport.parkNanos(1000);
    }
    dispatcher = null;
    // force gc
    System.gc();
    System.runFinalization();
  }

  static Dispatcher create(String[] args) {
    var flags = Map.of("name", "trader");
    var settings = new Settings(flags);
    var accounts = Set.of("A.*");
    var symbols = Map.of("deribit", Set.of("BTC-PERPETUAL"));
    var currencies = Set.of(".*");
    var config = new Config(accounts, symbols, currencies);
    var result = new Dispatcher(settings, config, args);
    return result;
  }

  static void registerShutdownHook() {
    final Thread thread = Thread.currentThread();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        try {
          System.out.println("*** SIGTERM ***");
          finished = true;
          thread.join();
        } catch (InterruptedException ex) {
          System.out.println(ex);
        }
      }
    });
  }
}
