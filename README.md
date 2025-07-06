# 🚀 Jetpack Compose Navigation Drawer Showcase

This project is a comprehensive exploration of **Navigation Drawers in Jetpack Compose**, starting from Material Design-based drawers to fully **custom animated drawers** with interactive gestures and smooth transitions.

---

## 🧩 Features Covered

### ✅ Standard Navigation Drawers
- **Modal Navigation Drawer** – Temporarily displays drawer content alongside main content.
- **Dismissible Navigation Drawer** – Swipes to dismiss the drawer from the screen.
- **Permanent Navigation Drawer** – Always visible drawer layout used for large screen layouts.

### 🌟 Advanced Animated Drawer (`animatedDrawer3`)
A fully **custom drawer design** with powerful features:
- Custom animated drawer using **`scale`** and **`offset`** transformations.
- Interactive transitions powered by **`Animatable`** and **gesture detection**.
- Custom gestures using **`pointerInput`** and `detectHorizontalDragGestures` to open/close drawer.
- Smooth experience and high responsiveness to user input.

---

## 📁 Project Structure (For `animatedDrawer3`)

```

animatedDrawer3/
│
├── CustomDrawer.kt          // The visual layout and animation of the drawer.
├── CustomDrawerState.kt     // Tracks the current state (Opened/Closed) of the drawer.
├── Data.kt                  // Enum classes for bottom bar, box items, and drawer items.
├── MainContent.kt           // The main UI content shown beside the drawer.
└── MainScreen.kt            // Root screen containing drawer logic, gestures, and layout management.

````

---

## 🎥 Demo Videos

> 🎬 Check out the drawer designs in action below:

- **Standard Drawers Demo**  
  


https://github.com/user-attachments/assets/cdc77b99-c5b3-42ac-a93d-9761b2e5ad3f


- **Animated Custom Drawer Demo**  
https://github.com/user-attachments/assets/928b97dc-9db2-47f6-bdbe-a6799c597202


---

## 🔧 Tech Stack

* **Jetpack Compose**
* **Kotlin**
* **Material3 Components**
---

## ⭐ Feedback

If you found this project helpful or interesting, **please consider giving it a star** ⭐
Your support encourages further development and exploration!

---
