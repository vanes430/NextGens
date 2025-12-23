# NextGens ⚡

**NextGens** is a next-generation Gen Tycoon plugin designed for high performance, supporting **Spigot**, **Paper**, and **Folia**. It comes packed with unique features like a corruption system, sellwands, and full customization capabilities.

## ✨ Key Features
*   **Folia & Paper Support**: Optimized for modern multi-threaded server software.
*   **Generator System**: Upgradeable generators with fully customizable drops.
*   **Corruption System**: Generators can break and need manual fixing by players (unique economy sink).
*   **Sellwands**: Instantly sell container contents with a multiplier.
*   **Autosell**: Automatically sell items from player inventory.
*   **GUI Menus**: Interactive Shop, Upgrade, and Settings menus.
*   **Tiered Generators**: Unlimited configurable generator tiers.

---

## 📜 Commands & Usage

Main command: `/nextgens`, `/gens`, or `/ngens`.

### 👤 Player Commands
These commands are usually available to all players by default (depending on config).

| Command | Description |
| :--- | :--- |
| `/genshop` | Opens the Shop menu to purchase generators. |
| `/upgradegens` | Opens the menu to upgrade generators. |
| `/pickupgens` | Pick up (retrieve) all your placed generators. |
| `/repairgens` | Repair all corrupted/broken generators. |
| `/sell` | Sell inventory items to the server. |
| `/itemworth` | Check the sell value of the item in hand. |
| `/settings` | Adjust personal preferences (e.g., notifications). |
| `/gens view` | View a list of active generators via GUI. |
| `/gens trust <add/remove> <player>` | Grant generator access to other players. |

### 🛠️ Admin Commands
Requires `nextgens.admin` permission.

| Command | Description |
| :--- | :--- |
| `/gens give <player> <gen> <amount>` | Give a specific generator to a player. |
| `/gens sellwand <player> <multi> <uses>` | Give a Sellwand. <br>Ex: `/gens sellwand PlayerName 1.5 50` |
| `/gens addmax <player> <amount>` | Add bonus maximum generator slots to a player. |
| `/gens setmultiplier <player> <amount>` | Set a player's sell multiplier. |
| `/gens reload` | Reload the plugin configuration (`config.yml`). |
| `/gens startevent <event_name>` | Force start a global event (e.g., 2x drops). |
| `/gens stopevent` | Stop the currently running event. |
| `/gens removegenerators <player>` | Force remove all generators belonging to a specific player. |

---

## 🔒 Permissions

Below are the main permissions. Most player features do not require specific permissions unless enabled in `config.yml`.

| Permission | Description |
| :--- | :--- |
| `nextgens.admin` | **Full Access**. Allows use of all admin commands. |
| `nextgens.generator.<id>` | Permission to place a specific generator (if `place-permission: true` in config). |
| `nextgens.sell` | Permission to use the `/sell` command (if enabled). |
| `nextgens.autosell` | Permission to use the Autosell feature. |

---

## ⚙️ Installation

1.  Download the NextGens `.jar` file.
2.  Ensure you have the following dependencies:
    *   **Vault** (Required for economy).
    *   **PlaceholderAPI** (Optional, for placeholders).
    *   **HolographicDisplays / DecentHolograms** (Optional, for holograms above generators).
3.  Drop it into your server's `plugins/` folder.
4.  Restart the server.
5.  Edit `config.yml` and `generators.yml` to suit your server needs.
6.  Use `/gens reload` after editing configurations.

---

## 🔧 Sellwand Configuration
To give a sellwand, use the following command format:
```bash
/gens sellwand <player_name> <multiplier> <uses>
```
*   **Multiplier**: Decimal number (e.g., `1.5` for 1.5x price).
*   **Uses**: Integer (e.g., `100`). Use `-1` (depending on setup) or a very high number for unlimited.
*   **How to Use**: Right-Click on a Chest/Barrel/Shulker/Hopper while holding the Sellwand.

---

**NextGens** © 2025 - Developed by BlockSmithStudio / Modified by Vanes430
