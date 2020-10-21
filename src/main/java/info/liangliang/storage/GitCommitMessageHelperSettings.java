package info.liangliang.storage;

import info.liangliang.constant.GitCommitConstants;
import info.liangliang.model.DataSettings;
import info.liangliang.model.TypeAlias;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.rits.cloning.Cloner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: git-commit-message-helper
 * @author: fulin
 * @create: 2019-12-05 21:13
 **/
@State(name = "GitCommitMessageHelperSettings", storages = {@Storage("$APP_CONFIG$/GitCommitMessageHelperSettings-settings.xml")})
public class GitCommitMessageHelperSettings implements PersistentStateComponent<GitCommitMessageHelperSettings> {
    private static final Logger log = Logger.getInstance(GitCommitMessageHelperSettings.class);

    public GitCommitMessageHelperSettings() {
    }


    private DataSettings dataSettings;


    @Nullable
    @Override
    public GitCommitMessageHelperSettings getState() {
        if (this.dataSettings == null) {
            loadDefaultSettings();
        }
        return this;
    }


    @Override
    public void loadState(@NotNull GitCommitMessageHelperSettings gitCommitMessageHelperSettings) {
        XmlSerializerUtil.copyBean(gitCommitMessageHelperSettings, this);
    }

    /**
     * 加载默认配置
     */
    private void loadDefaultSettings() {
        dataSettings = new DataSettings();
        try {
            dataSettings.setTemplate(GitCommitConstants.DEFAULT_TEMPLATE);
            List<TypeAlias> typeAliases = new LinkedList<>();
            typeAliases.add(new TypeAlias("feat", "新功能"));
            typeAliases.add(new TypeAlias("fix", "Bug 修复"));
            typeAliases.add(new TypeAlias("docs", "文档更新"));
            typeAliases.add(new TypeAlias("style", "改进代码结构/代码格式"));
            typeAliases.add(new TypeAlias("refactor", "代码重构"));
            typeAliases.add(new TypeAlias("perf", "性能优化"));
            typeAliases.add(new TypeAlias("test", "添加或更新测试"));
            typeAliases.add(new TypeAlias("build", "构建系统或依赖更新"));
            typeAliases.add(new TypeAlias("ci", "CI 配置"));
            typeAliases.add(new TypeAlias("chore", "杂项 非src/test文件的更新"));
            typeAliases.add(new TypeAlias("revert", "commit 回退"));
            dataSettings.setTypeAliases(typeAliases);
        } catch (Exception e) {
            log.error("loadDefaultSettings failed", e);
        }
    }

    /**
     * Getter method for property <tt>codeTemplates</tt>.
     *
     * @return property value of codeTemplates
     */
    public DataSettings getDateSettings() {
        if (dataSettings == null) {
            loadDefaultSettings();
        }
        return dataSettings;
    }


    public void setDateSettings(DataSettings dateSettings) {
        this.dataSettings = dateSettings;
    }


    public void updateTemplate(String template) {
        dataSettings.setTemplate(template);
    }

    public void updateTypeMap(List<TypeAlias> typeAliases) {
        dataSettings.setTypeAliases(typeAliases);
    }


    @Override
    public GitCommitMessageHelperSettings clone() {
        Cloner cloner = new Cloner();
        cloner.nullInsteadOfClone();
        return cloner.deepClone(this);
    }

}
