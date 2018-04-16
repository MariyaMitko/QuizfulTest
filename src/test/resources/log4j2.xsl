<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Appenders>
        <Console name="Console">
            <PatternLayout>
                <Pattern>%d %p %c{2} [%t] %l %m%n</Pattern>
            </PatternLayout>
        </Console>
        <File name="File" fileName="target/logs/appTest.log">
            <PatternLayout>
                <Pattern>%d %p %c{2} [%t] %m%n</Pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="trace">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>