# Barrel Extender

**Barrel Extender** is a lightweight Minecraft Fabric utility mod that doubles vanilla barrel capacity from **27 slots (3 rows)** to **54 slots (6 rows)**, matching a double chest while retaining the compact 1-block profile of a barrel.

---

## ✨ Features

- **Double Capacity**: Upgrades barrel storage to 54 slots (6 rows).
- **Vanilla Friendly**: Uses the vanilla barrel block — no custom blocks, custom items, or altered recipes.
- **Save Integrity**: Preserves existing items safely in their original slots.
- **Server-Side Friendly**: In multiplayer, installing on the server allows all vanilla clients to use 54-slot barrels without needing the mod client-side.
- **Singleplayer Ready**: Install directly in your client's mods folder to enjoy expanded barrels in singleplayer worlds.

---

## 📥 Downloadable Versions

Download the matching JAR for your Minecraft version from the [`outputs/`](./outputs) directory or from [Modrinth](https://modrinth.com/mod/barrel-extender):

| Target Minecraft Versions | Release JAR |
| :--- | :--- |
| **Minecraft 26.3** | [`barrelextender-26.3-1.0.0+mc26.3.jar`](./outputs/barrelextender-26.3-1.0.0+mc26.3.jar) |
| **Minecraft 26.2** | [`barrelextender-26.2-1.0.0+mc26.2.jar`](./outputs/barrelextender-26.2-1.0.0+mc26.2.jar) |
| **Minecraft 26.1 – 26.1.2** | [`barrelextender-fabric-mc26.1x-1.0.0.jar`](./outputs/barrelextender-fabric-mc26.1x-1.0.0.jar) |
| **Minecraft 1.21.1 – 1.21.11** | [`barrelextender-fabric-mc1.21x-1.0.0.jar`](./outputs/barrelextender-fabric-mc1.21x-1.0.0.jar) |
| **Minecraft 1.20.5 – 1.20.6** | [`barrelextender-fabric-mc1.20.5-1.20.6-1.0.0.jar`](./outputs/barrelextender-fabric-mc1.20.5-1.20.6-1.0.0.jar) |
| **Minecraft 1.20 – 1.20.4** | [`barrelextender-fabric-mc1.20.0-1.20.4-1.0.0.jar`](./outputs/barrelextender-fabric-mc1.20.0-1.20.4-1.0.0.jar) |

---

## 🛠️ Building From Source

Run the Gradle wrapper:

```bash
# Build for 26.3
./gradlew :26.3:build :26.3:copyBuiltJarToOutputs

# Build for 26.2
./gradlew :26.2:build :26.2:copyBuiltJarToOutputs
```

---

## ⚠️ Important Note Before Uninstalling

Before uninstalling the mod, make sure to remove items from the bottom 3 rows (slots 28–54), as vanilla Minecraft only recognizes the first 27 slots.

---

## 📄 License

This mod is available under the MIT License.