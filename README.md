# tre-polymer

Server-side compatibility patch for [Team Reborn Energy](https://github.com/TechReborn/Energy) on
[Polymer](https://github.com/Patbox/polymer) servers, for Minecraft 26.3 (Fabric).

TR Energy stores item charge in a synced data component, `team_reborn_energy:energy`. Vanilla clients don't know that
component and get disconnected when they receive a stack that carries it. This mod registers the component with Polymer
as server-only, so Polymer strips it from item stacks before they're sent to clients.

It's a library: on its own it does nothing visible. Mods that port a TR Energy mod to Polymer should bundle it.

## Limitations

Vanilla clients see no energy bar. Ports that want to show charge have to do it themselves (for example in a tooltip).

## Using it

Build and publish it to your local Maven repository:

```sh
./gradlew build publishToMavenLocal
```

Then in the consuming mod:

```groovy
repositories { mavenLocal() }

dependencies {
    implementation include("dev.craftmore:tre-polymer:0.1.0+26.3")
}
```

## Requirements

- Minecraft 26.3, Fabric Loader 0.19+
- Team Reborn Energy 5.0.0+
- Polymer (polymer-core)
- Java 25

## License

MIT, see [LICENSE](LICENSE).
