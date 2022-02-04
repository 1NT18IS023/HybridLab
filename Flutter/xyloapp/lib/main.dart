import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Xylophone App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Xylophone App'),
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
  var xyloColours = [
    Colors.purple,
    Colors.indigo,
    Colors.blue,
    Colors.green,
    Colors.yellow,
    Colors.orange,
    Colors.red
  ];

  final player = AudioCache();

  void _playSound(int noteNumber) {
    player.play("note$noteNumber.wav");
    print("Playing note$noteNumber.wav...");
  }

  List<Widget> _getTiles() {
    List<Widget> tiles = [];

    for (int i = 0; i < xyloColours.length; i++) {
      tiles.add(
        Expanded(
          child: TextButton(
            style: TextButton.styleFrom(backgroundColor: xyloColours[i]),
            onPressed: () {
              _playSound(i + 1);
            },
            child: Text('${i + 1}'),
          ),
        ),
      );
    }

    return tiles;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: _getTiles(),
        ),
      ),
    );
  }
}
