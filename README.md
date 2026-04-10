## 🚀 The Goal: From Basics to Professional Architecture

![Status](https://img.shields.io/badge/Status-Work_in_Progress-orange)

The main goal of this project is to build an app that consumes an API, starting from the most basic and simple setup, and then evolving it step by step.

**This repository serves as a log for implementing best practices in the modern Android ecosystem:**

*   **Clean Architecture:** Moving from a simple structure to a solid layer-based architecture.
*   **Dependency Injection:** Implementing **Hilt** to manage components the right way.
*   **Coroutines & Suspend Functions:** Using `suspend functions` and **Structured Concurrency** to handle API calls efficiently, ensuring tasks are canceled when no longer needed and keeping the UI smooth without any blocking.
*   **Advanced State Management:** Using **Sealed Classes** to handle every UI state properly:
    *   ⏳ **Loading:** While fetching data.
    *   ✅ **Success:** When everything is ready to show.
    *   ❌ **Error:** Handling API issues or connection problems gracefully.

---

### 🛠️ Current Status: Work in Progress
I am currently building a custom backend solution using **Firebase Realtime Database** to host my own JSON data. This allows me to have full control over the data structure while I continue refactoring the app into a Clean Architecture pattern.

### Why am I doing this?
I want to show not just a working app, but the process of improving the code, making it **scalable**, and handling errors correctly at every step of the way.
