set(TARGET_NAME autogen_java)

include(RoqAutogen)

set(SCHEMA_DIR $ENV{PREFIX}/share/roq/schema/java)

set(ENUMS
    BufferCapacity.json
    Category.json
    ConnectionStatus.json
    Encoding.json
    Error.json
    ExecutionInstruction.json
    Filter.json
    Liquidity.json
    MarginMode.json
    OptionType.json
    OrderCancelPolicy.json
    OrderManagement.json
    OrderStatus.json
    OrderType.json
    Origin.json
    PositionEffect.json
    Precision.json
    Priority.json
    Protocol.json
    RateLimitType.json
    RequestIdType.json
    RequestStatus.json
    RequestType.json
    RouteRequestStatus.json
    SecurityType.json
    Side.json
    StatisticsType.json
    SupportType.json
    TimeInForce.json
    TradingStatus.json
    Transport.json
    UpdateAction.json
    UpdateReason.json
    UpdateType.json)

set(HELPERS
    Fill.json
    Layer.json
    MBOUpdate.json
    MBPUpdate.json
    RateLimit.json
    Statistics.json
    Trade.json)

set(EVENTS
    BatchBegin.json
    BatchEnd.json
    CancelAllOrdersAck.json
    Connected.json
    Disconnected.json
    DownloadBegin.json
    DownloadEnd.json
    ExternalLatency.json
    FundsUpdate.json
    GatewaySettings.json
    GatewayStatus.json
    MarketByOrderUpdate.json
    MarketByPriceUpdate.json
    MarketStatus.json
    MessageInfo.json
    OrderAck.json
    OrderUpdate.json
    PositionUpdate.json
    RateLimitsUpdate.json
    RateLimitTrigger.json
    Ready.json
    ReferenceData.json
    Start.json
    StatisticsUpdate.json
    Stop.json
    StreamStatus.json
    TopOfBook.json
    TradeSummary.json
    TradeUpdate.json)

set(REQUESTS CancelAllOrders.json CancelOrder.json CreateOrder.json ModifyOrder.json)

set(SOURCES ${ENUMS} ${HELPERS} ${EVENTS} ${REQUESTS})

roq_autogen(
  OUTPUT
  AUTOGEN_JAVA
  NAMESPACE
  "com/roq"
  OUTPUT_TYPE
  "java"
  FILE_TYPE
  "java"
  SCHEMA_DIR
  ${SCHEMA_DIR}
  SOURCES
  ${SOURCES})

add_custom_target(${TARGET_NAME} ALL DEPENDS ${AUTOGEN_JAVA})

roq_gitignore(OUTPUT .gitignore SOURCES ${AUTOGEN_JAVA})
