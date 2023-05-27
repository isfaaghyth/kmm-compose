/**
 * This suppress need to enable due the ViewController below
 * only used on ContentView.swift
 */
@file:Suppress("unused", "FunctionName")

import androidx.compose.ui.window.ComposeUIViewController
import app.isfa.todolist.TodoApp

fun MainViewController() = ComposeUIViewController {
    TodoApp()
}