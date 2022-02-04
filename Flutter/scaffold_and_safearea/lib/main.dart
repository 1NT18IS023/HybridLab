import 'dart:ui';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Scaffold and safe area',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const WithScaffoldAndSafearea(),
    );
  }
}

class WithoutSafearea extends StatelessWidget {
  const WithoutSafearea({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const Text(
      "Without safe area",
      textAlign: TextAlign.center,
      style: TextStyle(
          fontSize: 40,
          fontWeight: FontWeight.w800,
          color: Colors.deepOrangeAccent),
    );
  }
}

class WithSafearea extends StatelessWidget {
  const WithSafearea({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const SafeArea(
      child: Text(
        "With safe area",
        textAlign: TextAlign.center,
        style: TextStyle(
            fontSize: 40,
            fontWeight: FontWeight.w800,
            color: Colors.deepOrangeAccent),
      ),
    );
  }
}

class WithScaffold extends StatelessWidget {
  const WithScaffold({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Scaffold and safe area'),
        backgroundColor: Colors.redAccent,
      ),
      backgroundColor: Colors.blueAccent,
      body: const Center(
        child: Text(
          'Hello there',
          style: TextStyle(
              fontSize: 40,
              fontStyle: FontStyle.italic,
              fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}

class WithScaffoldAndSafearea extends StatelessWidget {
  const WithScaffoldAndSafearea({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Scaffold and safe area'),
        backgroundColor: Colors.redAccent,
      ),
      backgroundColor: Colors.blueAccent,
      body: const SafeArea(
        child: Center(
          child: Text(
            'Hello there',
            style: TextStyle(
                fontSize: 40,
                fontStyle: FontStyle.italic,
                fontWeight: FontWeight.bold),
          ),
        ),
      ),
    );
  }
}
