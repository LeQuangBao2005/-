/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFormat, mView, mZoom, mHelp;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit,
            itemCut, itemUndo, itemCopy, ItemDelete, itemPaste, itemSearch, itemFind, itemFindNext, itemFindPrevios, itemReplace, itemGoto, itemSelecAll, itemTimeDate, itemZoomIn,
            itemZoomOut, itemRestore;

    private JCheckBoxMenuItem itemWrap;
    private JTextArea txtEditor;
    private JToolBar toolBar;
    private JButton btNew, btSave, btOpen;
    int size = 20;

    public JNotepad(String title) {
        super(title);
        createMenu();
        createGUI();
        createToolBar();

        processEvent();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        mBar = new JMenuBar();
        mBar.add(mFile = new JMenu("File"));
        mBar.add(mEdit = new JMenu("Edit"));
        mBar.add(mFormat = new JMenu("Format"));

        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open"));
        mFile.add(itemSave = new JMenuItem("Save"));
        mFile.add(itemSaveAs = new JMenuItem("Save As"));
        mFile.addSeparator();
        mFile.add(new JMenuItem("Pase Setup"));
        mFile.add(new JMenuItem("Print"));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));

        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut = new JMenuItem("cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));
        mEdit.add(ItemDelete = new JMenuItem("Delete"));
        mEdit.addSeparator();
        mEdit.add(itemSearch = new JMenuItem("Search"));
        mEdit.add(itemFind = new JMenuItem("Find"));
        mEdit.add(itemFindNext = new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevios = new JMenuItem("Find Previos"));
        mEdit.add(itemReplace = new JMenuItem("Replace"));
        mEdit.add(itemGoto = new JMenuItem("Goto"));
        mEdit.addSeparator();
        mEdit.add(itemSelecAll = new JMenuItem("SelecAll"));
        mEdit.add(itemTimeDate = new JMenuItem("Time/Date"));

        mView.add(mZoom = new JMenu("Zoom"));
        mZoom.add(itemZoomIn = new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOut = new JMenuItem("Zoom Out"));
        mZoom.add(itemRestore = new JMenuItem("Restore..."));
        mView.add(new JCheckBoxMenuItem("Status Bar"));

        mHelp.add(new JMenuItem("View Help"));
        mHelp.add(new JMenuItem("Send Feedback"));
        mHelp.addSeparator();
        mHelp.add(new JMenuItem("About.."));

        mFormat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap", true));
        mFormat.add(new JMenuItem("Font"));

        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        ItemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        itemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindPrevios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelecAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        itemZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemRestore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));

        setJMenuBar(mBar);
    }

    public static void main(String[] args) {
        JNotepad notepad = new JNotepad("Demo Notepad");
        notepad.setVisible(true);
    }

    private void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollEditor = new JScrollPane(txtEditor);
        add(scrollEditor);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));

    }

    private void processEvent() {
        itemZoomIn.addActionListener((ActionEvent e) -> {
            size += 4;
            txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
        });
        itemZoomOut.addActionListener((ActionEvent e) -> {
            size -= 4;
            txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
        });
        itemWrap.addActionListener((ActionEvent e) -> {
            if (itemWrap.isSelected()) {
                txtEditor.setLineWrap(true);
            } else {
                txtEditor.setLineWrap(false);
            }
        });
        itemOpen.addActionListener((ActionEvent e) -> {
            openFile();
        });
        itemSave.addActionListener((ActionEvent e) -> {
            saveFile();
        });
    }

    private void openFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(dlgFile.getSelectedFile());
                byte[] b = new byte[fis.available()];
                fis.read(b);
                txtEditor.setText(new String(b));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Loi doc file");
            }
        }
    }

    private void saveFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fos = new FileInputStream(dlgFile.getSelectedFile());

                fos.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Loi doc file");
            }
        }

    }

    private void createToolBar() {
        toolBar = new JToolBar();
        toolBar.add(btNew = new JButton("new"));
        toolBar.add(btOpen = new JButton("Open"));
        toolBar.add(btSave = new JButton("Save"));
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/images/new.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/images/open.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/images/save.png")));
        add(toolBar, BorderLayout.NORTH);
    }
}


