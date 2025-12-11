package dev.crean.dayseven.splitter.node;

public sealed interface Node permits Start, Split, End, Dot { }
