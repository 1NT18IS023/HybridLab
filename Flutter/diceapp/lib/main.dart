import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Dice App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Dice App'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _roll = 6;

  void _rerollDice() {
    setState(() {
      _roll = Random().nextInt(6) + 1;
    });

    print('Rolling... $_roll');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: TextButton(
          child: Image.asset("images/dice$_roll.png"),
          onPressed: _rerollDice,
          style: TextButton.styleFrom(backgroundColor: Colors.blue),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _rerollDice,
        tooltip: 'Re-roll',
        child: const Icon(Icons.change_circle),
      ),
    );
  }
}
