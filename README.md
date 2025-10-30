# Keno-Game
# Keno Game — CS342 Project 2 (Fall 2025)

##Overview
This project is a fully functional **Keno Lottery Game** built with **JavaFX**.  
It simulates a simplified casino Keno experience, allowing users to select numbers, play multiple draws, and view payouts based on how many numbers match.

---

### Game Functionality
- **Welcome Screen:**  
  Launch point with navigation menu and options to view Rules or Odds.
- **Rules Screen:**  
  Displays the official Keno rules and gameplay information.
- **Odds Screen:**  
  Shows payout charts and odds for different spot selections.
- **Game Screens:**
  - **GameScreen1:** Player selects:
    - Wager per draw ($1, $2, $3, $5, $10)
    - Consecutive draws (1–4)
    - Number of spots (1, 4, 8, or 10)
  - **GameScreen2:** Main Keno board (80 numbers) where players:
    - Pick their numbers manually or use **Quick Pick**
    - View results as 20 random numbers are drawn
    - See winnings per round and total balance

### Game Logic
- Random 20-number draw (`KenoLogic.randDraw()`).
- Random number quick picks for the user (`KenoLogic.quickPick()`).
- Accurate match detection and prize calculation (`KenoLogic.matches()` and `calculatePrize()`).

### Visuals
- Clean, responsive layout using **JavaFX layouts (VBox, BorderPane, GridPane)**.
- **New Look Theme Toggle:** Switches to a new color scheme and font style dynamically.
- Buttons and text scale properly for full-screen mode.

### Testing
Includes **JUnit 5 test cases** for validating core logic:
- Matching logic between user and drawn numbers.
- Random draw generation.
- Prize calculation for different spot counts.
