# tre-polymer: Team Reborn Energy Polymer patch

A small library mod that makes Team Reborn Energy safe for vanilla clients on Polymer servers. It's meant to be
jar-in-jar'd by any server-side port of a mod that uses TR Energy. `AGENTS.md`/`GEMINI.md` are symlinks to this file.

- `./gradlew build publishToMavenLocal`: consumers depend on `dev.craftmore:tre-polymer` from mavenLocal and jar-in-jar it.
- Current contents: marks `team_reborn_energy:energy` as a server-only component (`mixin/EnergyImplMixin`).
- Possible addition: an energy display helper for vanilla clients (tooltip/bar), shared by all TR Energy ports.
- Keep it generic: nothing here should depend on a specific port.
