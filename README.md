# StockAnalyzer
[Hernan Vivani's](https://vivani.net) Stock Analyzer

This stock analyzer tool reads real time finantial market data and performs analysis over such data.

Currently this tool uses TwelveData API which allows free real time data retrieval with a free account.
https://twelvedata.com/docs#getting-started

A token is required from TwelveAPI to be able to query real time stock market data.

## Compiling:
```
mvn clean && mvn package
```

## Running:
```
java -cp ./target/StockAnalyzer-1.0-SNAPSHOT.jar net.vivani.stock.StockAnalyzer TSLA YOURTOKEN
```

