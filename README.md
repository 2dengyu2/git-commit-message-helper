# git-commit-message-helper

## 使用方式：
- 测试：使用gradle的Tasks -> intellij -> runIde 测试效果
- 生成不发布的插件压缩包：使用gradle的Tasks -> intellij -> buildPlugin，在build\distributions中得到可以直接安装的插件压缩包

## fork后修改内容
> 改写自https://github.com/AutismSuperman
- [x] 标准化了提交类型
- [x] 汉化了用得到的描述
- [ ] TODO: 提取提交类型与描述到配置文件中
  > 目前是直接写在form中的
- [ ] TODO: 配置文件的分享功能
  > 修改出一个团队通用的版本后应当能够以一个文件来同一团队的风格与习惯
- [ ] TODO: 如果commit中的文本符合标准，再次点击按钮反向提取commit中的文本填入弹窗中
  > 此功能比较重要
- [ ] TODO: 使用官方的template重构项目
  > fork来的版本似乎有一些过时的写法，目前简单修复了一些影响build的问题，还需重构
- [ ] TODO: 50/72格式化

This plugin is an upgraded version of the source idea plugin [git-commit-template](https://plugins.jetbrains.com/plugin/9861-git-commit-template) , adding a series of personalized configurations. 


## Installation
Install directly from the IDE plugin manager (File > Settings > Plugins > Browser repositories > Git Commit Message Helper
)

## Usage
![](https://raw.githubusercontent.com/AutismSuperman/git-commit-message-helper/master/image/operation.gif)

If you want to change the type of submission, you can change it in settings

![](https://raw.githubusercontent.com/AutismSuperman/git-commit-message-helper/master/image/settings-2.png)

If you want to personalize your submission template can be set in the settings, the template engine here uses velocity

![](https://raw.githubusercontent.com/AutismSuperman/git-commit-message-helper/master/image/settings-1.png)

# License
Licensed under the  [Apache License](http://www.apache.org/licenses/LICENSE-2.0), Version 2.0 (the "License"); you may not use this file except in compliance with the License.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


#### thank you for   https://github.com/MobileTribe/commit-template-idea-plugin
#### thank you for   https://github.com/MobileTribe/commit-template-idea-plugin
#### thank you for   https://github.com/x-hansong/CodeMaker
#### thank you for   https://github.com/shuzijun/leetcode-editor
