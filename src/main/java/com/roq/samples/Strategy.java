package com.roq.samples;

import com.roq.BatchBegin;
import com.roq.BatchEnd;
import com.roq.CancelAllOrdersAck;
import com.roq.Connected;
import com.roq.CreateOrder;
import com.roq.Disconnected;
import com.roq.DownloadBegin;
import com.roq.DownloadEnd;
import com.roq.ExternalLatency;
import com.roq.FundsUpdate;
import com.roq.GatewaySettings;
import com.roq.GatewayStatus;
import com.roq.MarginMode;
import com.roq.MarketByOrderUpdate;
import com.roq.MarketByPriceUpdate;
import com.roq.MarketStatus;
import com.roq.MessageInfo;
import com.roq.OrderAck;
import com.roq.OrderType;
import com.roq.OrderUpdate;
import com.roq.PositionEffect;
import com.roq.PositionUpdate;
import com.roq.RateLimitTrigger;
import com.roq.RateLimitsUpdate;
import com.roq.Ready;
import com.roq.ReferenceData;
import com.roq.Side;
import com.roq.Start;
import com.roq.StatisticsUpdate;
import com.roq.Stop;
import com.roq.StreamStatus;
import com.roq.TimeInForce;
import com.roq.TopOfBook;
import com.roq.TradeSummary;
import com.roq.TradeUpdate;
import com.roq.client.Dispatcher;
import com.roq.client.Handler;
import java.lang.Float;

public final class Strategy implements Handler {
  boolean latch = false;
  Dispatcher dispatcher;

  public Strategy(Dispatcher dispatcher) { this.dispatcher = dispatcher; }

  // host

  @Override
  public void handle(MessageInfo message_info, Start start) {
    System.out.println("message_info={" + message_info + "}, start={" + start + "}");
  }
  @Override
  public void handle(MessageInfo message_info, Stop stop) {
    System.out.println("message_info={" + message_info + "}, stop={" + stop + "}");
  }
  @Override
  public void handle(MessageInfo message_info, Connected connected) {
    System.out.println("message_info={" + message_info + "}, connected={" + connected + "}");
  }
  @Override
  public void handle(MessageInfo message_info, Disconnected disconnected) {
    System.out.println("message_info={" + message_info + "}, disconnected={" + disconnected + "}");
  }

  // control

  @Override
  public void handle(MessageInfo message_info, BatchBegin batch_begin) {
    // System.out.println("message_info={" + message_info + "}, batch_begin={" + batch_begin+"}");
  }
  @Override
  public void handle(MessageInfo message_info, BatchEnd batch_end) {
    // System.out.println("message_info={" + message_info + "}, batch_end={" + batch_end+"}");
  }
  @Override
  public void handle(MessageInfo message_info, DownloadBegin download_begin) {
    System.out.println("message_info={" + message_info + "}, download_begin={" + download_begin + "}");
  }
  @Override
  public void handle(MessageInfo message_info, DownloadEnd download_end) {
    System.out.println("message_info={" + message_info + "}, download_end={" + download_end + "}");
  }
  @Override
  public void handle(MessageInfo message_info, Ready ready) {
    System.out.println("message_info={" + message_info + "}, ready={" + ready + "}");
  }

  // config

  @Override
  public void handle(MessageInfo message_info, GatewaySettings gateway_settings) {
    System.out.println("message_info={" + message_info + "}, gateway_settings={" + gateway_settings + "}");
  }

  // stream

  @Override
  public void handle(MessageInfo message_info, StreamStatus stream_status) {
    System.out.println("message_info={" + message_info + "}, stream_status={" + stream_status + "}");
  }

  @Override
  public void handle(MessageInfo message_info, ExternalLatency external_latency) {
    System.out.println("message_info={" + message_info + "}, external_latency={" + external_latency + "}");
  }

  @Override
  public void handle(MessageInfo message_info, RateLimitsUpdate rate_limits_update) {
    System.out.println("message_info={" + message_info + "}, rate_limits_update={" + rate_limits_update + "}");
  }

  @Override
  public void handle(MessageInfo message_info, RateLimitTrigger rate_limit_trigger) {
    System.out.println("message_info={" + message_info + "}, rate_limit_trigger={" + rate_limit_trigger + "}");
  }

  // config

  @Override
  public void handle(MessageInfo message_info, GatewayStatus gateway_status) {
    System.out.println("message_info={" + message_info + "}, gateway_status={" + gateway_status + "}");
  }

  // market data

  @Override
  public void handle(MessageInfo message_info, ReferenceData reference_data) {
    System.out.println("message_info={" + message_info + "}, reference_data={" + reference_data + "}");
  }

  @Override
  public void handle(MessageInfo message_info, MarketStatus market_status) {
    System.out.println("message_info={" + message_info + "}, market_status={" + market_status + "}");
  }

  @Override
  public void handle(MessageInfo message_info, TopOfBook top_of_book) {
    System.out.println("message_info={" + message_info + "}, top_of_book={" + top_of_book + "}");
  }

  @Override
  public void handle(MessageInfo message_info, MarketByPriceUpdate market_by_price_update) {
    System.out.println("message_info={" + message_info + "}, market_by_price_update={" + market_by_price_update + "}");
    try_trade(); // note!
  }

  @Override
  public void handle(MessageInfo message_info, MarketByOrderUpdate market_by_order_update) {
    System.out.println("message_info={" + message_info + "}, market_by_order_update={" + market_by_order_update + "}");
  }

  @Override
  public void handle(MessageInfo message_info, TradeSummary trade_summary) {
    System.out.println("message_info={" + message_info + "}, trade_summary={" + trade_summary + "}");
  }

  @Override
  public void handle(MessageInfo message_info, StatisticsUpdate statistics_update) {
    System.out.println("message_info={" + message_info + "}, statistics_update={" + statistics_update + "}");
  }

  // order management

  @Override
  public void handle(MessageInfo message_info, CancelAllOrdersAck cancel_all_orders_ack) {
    System.out.println("message_info={" + message_info + "}, cancel_all_orders_ack={" + cancel_all_orders_ack + "}");
  }

  @Override
  public void handle(MessageInfo message_info, OrderAck order_ack) {
    System.out.println("message_info={" + message_info + "}, order_ack={" + order_ack + "}");
  }

  @Override
  public void handle(MessageInfo message_info, OrderUpdate order_update) {
    System.out.println("message_info={" + message_info + "}, order_update={" + order_update + "}");
  }

  @Override
  public void handle(MessageInfo message_info, TradeUpdate trade_update) {
    System.out.println("message_info={" + message_info + "}, trade_update={" + trade_update + "}");
  }

  // account management

  @Override
  public void handle(MessageInfo message_info, PositionUpdate position_update) {
    System.out.println("message_info={" + message_info + "}, position_update={" + position_update + "}");
  }

  @Override
  public void handle(MessageInfo message_info, FundsUpdate funds_update) {
    System.out.println("message_info={" + message_info + "}, funds_update={" + funds_update + "}");
  }

  private void try_trade() {
    if (latch)
      return;
    latch = true;
    var create_order = new CreateOrder(
        "A1",
        1234,
        "deribit",
        "BTC-PERPETUAL",
        Side.BUY,
        null, // position_effect
        MarginMode.UNDEFINED,
        Float.NaN,
        OrderType.LIMIT,
        TimeInForce.GTC,
        null, // execution_instructions
        null, // request_template
        1.0,
        32000.0,
        Float.NaN,
        null, // routing_id
        0);
    dispatcher.send(create_order, 0);
  }
}
