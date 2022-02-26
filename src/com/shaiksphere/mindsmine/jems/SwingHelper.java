/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.mindsmine.jems;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Component;

import java.io.File;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * A collection of useful static methods to deal with Java Swing Framework.
 *
 * @see javax.swing
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 4.0.0
 *
 */
public final class SwingHelper {
    private SwingHelper() {}

    /**
     * Convenient file extension filter for binary files.
     *
     * @since 4.0.0
     *
     */
    public static final FileNameExtensionFilter BIN_EXTENSION_FILTER = new FileNameExtensionFilter(
            "Binary Files",
            "bin"
    );

    /**
     * Convenient file extension filter for text files.
     */
    public static final FileNameExtensionFilter TXT_EXTENSION_FILTER = new FileNameExtensionFilter(
            "Text Files",
            "txt"
    );

    /**
     * Displays a File Chooser to pick a single file using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.pickFile(null, null, null)</code>
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFile() {
        return pickFile(null);
    }

    /**
     * Displays a File Chooser to pick a single file using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.pickFile(null, title, null)</code>
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @param dialogTitle for the file picker window
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFile(String dialogTitle) {
        return pickFile(dialogTitle, (FileNameExtensionFilter[]) null);
    }

    /**
     * Displays a File Chooser to pick a single file using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.pickFile(null, title, filter)</code>
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @param dialogTitle for the file picker window
     * @param fileNameExtensionFilter to limit the types of acceptable files
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFile(String dialogTitle, FileNameExtensionFilter... fileNameExtensionFilter) {
        return pickFile(null, dialogTitle, fileNameExtensionFilter);
    }

    /**
     * Displays a File Chooser to pick a single file using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param dialogTitle for the file picker window
     * @param fileNameExtensionFilter to limit the types of acceptable files
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFile(Component component,
                                          String dialogTitle,
                                          FileNameExtensionFilter... fileNameExtensionFilter) {
        return useJFileChooser(component, dialogTitle, JFileChooser.FILES_ONLY, fileNameExtensionFilter);
    }

    /**
     * Displays a File Chooser to pick a single folder using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.pickFolder(null, null)</code>
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFolder() {
        return pickFolder(null);
    }

    /**
     * Displays a File Chooser to pick a single folder using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.pickFolder(null, title)</code>
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @param dialogTitle for the folder picker window
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFolder(String dialogTitle) {
        return pickFolder(null, dialogTitle);
    }

    /**
     * Displays a File Chooser to pick a single folder using
     * {@link javax.swing.JFileChooser#showOpenDialog(java.awt.Component)} window.
     *
     * @see javax.swing.JFileChooser#showOpenDialog(java.awt.Component)
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param dialogTitle for the folder picker window
     *
     * @return the {@link java.util.Optional} object containing the selected file
     *
     * @since 4.0.0
     *
     */
    public static Optional<File> pickFolder(Component component, String dialogTitle) {
        return useJFileChooser(component, dialogTitle, JFileChooser.DIRECTORIES_ONLY);
    }

    private static Optional<File> useJFileChooser(Component component,
                                                  String dialogTitle,
                                                  int fileSelectionMode,
                                                  FileNameExtensionFilter... fileNameExtensionFilter) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setName("for_testing_JFileChooser");
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileSelectionMode(fileSelectionMode);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        if (dialogTitle != null && !dialogTitle.isBlank()) {
            jFileChooser.setDialogTitle(dialogTitle);
        }

        if (fileNameExtensionFilter != null) {
            Stream.of(fileNameExtensionFilter).forEach(jFileChooser::addChoosableFileFilter);
        }

        jFileChooser.showOpenDialog(component);

        return Optional.ofNullable(jFileChooser.getSelectedFile());
    }

    /**
     * Displays a error message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.showErrorDialog(null, title, message)</code>
     *
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showErrorDialog(String title, String message) {
        showErrorDialog(null, title, message);
    }

    /**
     * Displays a error message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showErrorDialog(Component component, String title, String message) {
        useJOptionPane(component, title, message, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a information message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.showInformationDialog(null, title, message)</code>
     *
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showInformationDialog(String title, String message) {
        showInformationDialog(null, title, message);
    }

    /**
     * Displays a information message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showInformationDialog(Component component, String title, String message) {
        useJOptionPane(component, title, message, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a warning message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.showWarningDialog(null, title, message)</code>
     *
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showWarningDialog(String title, String message) {
        showWarningDialog(null, title, message);
    }

    /**
     * Displays a warning message using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showWarningDialog(Component component, String title, String message) {
        useJOptionPane(component, title, message, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Displays a question using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.showQuestionDialog(null, title, message)</code>
     *
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showQuestionDialog(String title, String message) {
        showQuestionDialog(null, title, message);
    }

    /**
     * Displays a question using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showQuestionDialog(Component component, String title, String message) {
        useJOptionPane(component, title, message, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Displays a plain message without an icon using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * Convenient method equivalent to <code>SwingHelper.showPlainDialog(null, title, message)</code>
     *
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showPlainDialog(String title, String message) {
        showPlainDialog(null, title, message);
    }

    /**
     * Displays a plain message without an icon using the
     * {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, java.lang.Object)} window.
     *
     * @param component the parent component of the dialog, can be <code>null</code>
     * @param title the title string for the dialog
     * @param message the message to display in the dialog
     *
     * @since 4.0.0
     *
     */
    public static void showPlainDialog(Component component, String title, String message) {
        useJOptionPane(component, title, message, JOptionPane.PLAIN_MESSAGE);
    }

    private static void useJOptionPane(Component component, String title, String message, int type) {
        JOptionPane.showMessageDialog(component, message, title, type);
    }
}
