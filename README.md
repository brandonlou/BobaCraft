# BobaCraft

> Satisfy your boba cravings in Minecraft!

### Setup
1. Requirements: `JDK 1.8`
2. Clone this repo: `git clone https://github.com/brandonlou/BobaCraft.git`
3. Open `IntelliJ`. Import the project by selecting `build.gradle`.
2. Gradle will automatically download dependencies. Once that is complete, run `./gradlew genIntellijRuns`.

### Testing
1. Run `./gradlew runClient` (Mac/Linux) or `gradlew runClient` (Windows).
2. All the Minecraft game files will be stored in the `run` directory (useful if you want to look at crash reports,
screenshots, etc).

### Building
1. Run `./gradlew build`.
2. The mod jar file will be located in `build/libs`.
3. Rename the jar file appropriately.

## Possible Features
* Better pixel art
* Boba ball crafting from scratch (growing tapioca, etc)
* Boba straw colors
* Different toppings (grass jelly, etc.)

## License