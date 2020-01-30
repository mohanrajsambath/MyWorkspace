package com.cc.android.materialthemes.controller.theme;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.cc.android.materialthemes.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Material theme object to be used to display and set themes.
 *
 * @author Steven Byle
 */
public class MaterialTheme implements Serializable {
    // App themes
    public static final MaterialTheme THEME_RED =
            new MaterialTheme(R.string.material_theme_red, R.style.AppTheme_Red);
    public static final MaterialTheme THEME_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.AppTheme_Orange);
    public static final MaterialTheme THEME_YELLOW =
            new MaterialTheme(R.string.material_theme_lime, R.style.AppTheme_Lime);
    public static final MaterialTheme THEME_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.AppTheme_Green);
    public static final MaterialTheme THEME_TEAL =
            new MaterialTheme(R.string.material_theme_teal, R.style.AppTheme_Teal);
    public static final MaterialTheme THEME_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.AppTheme_Blue);
    public static final MaterialTheme THEME_PURPLE =
            new MaterialTheme(R.string.material_theme_purple, R.style.AppTheme_Purple);

    // Dialog themes
    public static final MaterialTheme THEME_DIALOG_RED =
            new MaterialTheme(R.string.material_theme_red, R.style.AppTheme_Dialog_Red);
    public static final MaterialTheme THEME_DIALOG_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.AppTheme_Dialog_Orange);
    public static final MaterialTheme THEME_DIALOG_YELLOW =
            new MaterialTheme(R.string.material_theme_lime, R.style.AppTheme_Dialog_Lime);
    public static final MaterialTheme THEME_DIALOG_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.AppTheme_Dialog_Green);
    public static final MaterialTheme THEME_DIALOG_TEAL =
            new MaterialTheme(R.string.material_theme_teal, R.style.AppTheme_Dialog_Teal);
    public static final MaterialTheme THEME_DIALOG_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.AppTheme_Dialog_Blue);
    public static final MaterialTheme THEME_DIALOG_PURPLE =
            new MaterialTheme(R.string.material_theme_purple, R.style.AppTheme_Dialog_Purple);

    // Alert dialog themes
    public static final MaterialTheme THEME_ALERT_DIALOG_RED =
            new MaterialTheme(R.string.material_theme_red, R.style.AppTheme_Dialog_Alert_Red);
    public static final MaterialTheme THEME_ALERT_DIALOG_ORANGE =
            new MaterialTheme(R.string.material_theme_orange, R.style.AppTheme_Dialog_Alert_Orange);
    public static final MaterialTheme THEME_ALERT_DIALOG_YELLOW =
            new MaterialTheme(R.string.material_theme_lime, R.style.AppTheme_Dialog_Alert_Lime);
    public static final MaterialTheme THEME_ALERT_DIALOG_GREEN =
            new MaterialTheme(R.string.material_theme_green, R.style.AppTheme_Dialog_Alert_Green);
    public static final MaterialTheme THEME_ALERT_DIALOG_TEAL =
            new MaterialTheme(R.string.material_theme_teal, R.style.AppTheme_Dialog_Alert_Teal);
    public static final MaterialTheme THEME_ALERT_DIALOG_BLUE =
            new MaterialTheme(R.string.material_theme_blue, R.style.AppTheme_Dialog_Alert_Blue);
    public static final MaterialTheme THEME_ALERT_DIALOG_PURPLE =
            new MaterialTheme(R.string.material_theme_purple, R.style.AppTheme_Dialog_Alert_Purple);

    private static List<MaterialTheme> sThemeList;
    private static List<MaterialTheme> sDialogThemeList;
    private static List<MaterialTheme> sAlertDialogThemeList;

    @StringRes
    private int nameResId;
    @StyleRes
    private int themeResId;

    public MaterialTheme(@StringRes int nameResId, @StyleRes int themeResId) {
        this.nameResId = nameResId;
        this.themeResId = themeResId;
    }

    public static List<MaterialTheme> getThemeList() {
        if (sThemeList == null) {
            sThemeList = new ArrayList<MaterialTheme>();
            sThemeList.add(THEME_RED);
            sThemeList.add(THEME_ORANGE);
            sThemeList.add(THEME_YELLOW);
            sThemeList.add(THEME_GREEN);
            sThemeList.add(THEME_TEAL);
            sThemeList.add(THEME_BLUE);
            sThemeList.add(THEME_PURPLE);
        }
        return sThemeList;
    }

    public static List<MaterialTheme> getDialogThemeList() {
        if (sDialogThemeList == null) {
            sDialogThemeList = new ArrayList<MaterialTheme>();
            sDialogThemeList.add(THEME_DIALOG_RED);
            sDialogThemeList.add(THEME_DIALOG_ORANGE);
            sDialogThemeList.add(THEME_DIALOG_YELLOW);
            sDialogThemeList.add(THEME_DIALOG_GREEN);
            sDialogThemeList.add(THEME_DIALOG_TEAL);
            sDialogThemeList.add(THEME_DIALOG_BLUE);
            sDialogThemeList.add(THEME_DIALOG_PURPLE);
        }
        return sDialogThemeList;
    }

    public static List<MaterialTheme> getAlertDialogThemeList() {
        if (sAlertDialogThemeList == null) {
            sAlertDialogThemeList = new ArrayList<MaterialTheme>();
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_RED);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_ORANGE);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_YELLOW);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_GREEN);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_TEAL);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_BLUE);
            sAlertDialogThemeList.add(THEME_ALERT_DIALOG_PURPLE);
        }
        return sAlertDialogThemeList;
    }

    public int getNameResId() {
        return nameResId;
    }

    public int getThemeResId() {
        return themeResId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MaterialTheme that = (MaterialTheme) o;

        if (nameResId != that.nameResId) {
            return false;
        }
        return themeResId == that.themeResId;
    }

    @Override
    public int hashCode() {
        int result = nameResId;
        result = 31 * result + themeResId;
        return result;
    }
}
