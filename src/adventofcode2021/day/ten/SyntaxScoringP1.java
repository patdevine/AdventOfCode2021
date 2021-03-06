package adventofcode2021.day.ten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SyntaxScoringP1 {
    List<String> closingChars = Arrays.asList(")", "]", "}", ">");

    public int calcSyntaxScore(String[] input){
        List<String> inputList = Arrays.asList(input).stream().collect(Collectors.toList());
        int fileScore = 0;
        for (String row : inputList) {
            fileScore += calcIllegalScore(row);
        }
        return  fileScore;
    }

    private int calcIllegalScore(String row) {
        List<String> illegalChars = findIllegalCharacters(row);
        int sum = 0;
        for (String illegalChar : illegalChars) {
            if (")".equals(illegalChar)) {
                sum += 3;
            } else if ("]".equals(illegalChar)) {
                sum += 57;
            } else if ("}".equals(illegalChar)) {
                sum += 1197;
            } else if (">".equals(illegalChar)) {
                sum += 25137;
            }
        }
        return sum;
    }

    private List<String> findIllegalCharacters(String row) {
        Stack expectedClosing = new Stack();
        List<String> illegalCharacters = new ArrayList<>();
        for (char c : row.toCharArray()) {
            String ch = String.valueOf(c);

            if (closingChars.contains(ch)) {
                if (expectedClosing.peek().equals(ch)) {
                    String pop = String.valueOf(expectedClosing.pop());
                } else {
                    illegalCharacters.add(ch);
                    return illegalCharacters;
                }
            } else {
                if ("(".equals(ch)) {
                    expectedClosing.push(")");
                } else if ("{".equals(ch)) {
                    expectedClosing.push("}");
                } else if ("<".equals(ch)) {
                    expectedClosing.push(">");
                } else if ("[".equals(ch)) {
                    expectedClosing.push("]");
                }
            }
        }
//        System.out.println();

        return illegalCharacters;
    }

    public static void main(String[] args) {
        String[] splitInput = input.split("\n");
        System.out.println(new SyntaxScoringP1().calcSyntaxScore(splitInput));
    }
    public static final String example = """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]
            """;

    public static final String input = """
            <<{<[<<<{<<(<({}())({}[]))[[{}[]]<{}[]>])[<[{}[]]{()()}>{((){})<<><>>}]>>[<(<<{}>>[<()()><<><>>]
            {[[[{<[(([[{(({}))([<>[]]((){}))}<<<[][]>[{}{}]>[{()[]}(()())]>][[[{<>()}[{}[]]]]]]<{{{{()[]}}}[[{[][]}{{
            ([((<(<(<<([{{[][]}([]<>)}({<>{}}[[]()])]<[[()()](()[])]([[][]](<><>))>>{{<(<><>)[<>()]>([[]()])}<<[[]()]<[][
            {{{([((([({[{{()()}{<>[]}}({{}{}}([]{}))]{([{}<>])<(<><>){[]<>}}}})({{{(()())[[][]]}{<{}{}>
            {{([[((({(({({<><>}([]{}))([()()]{[]{}})}[[({}{})<(){}>]<<()<>>>]){[[[()()][<>[]]}<[{}()]{{}<>}
            {([<[[<<({[<(<()<>>(()())){<<>[]><()[]>}>[({{}<>})]][[(<()<>>{(){}})[{[]<>}[[]{}])][[(()()){[][]}]<{{}{}}<[
            [<{[((<([[([<<{}()>{{}()}>{(()[])[<>{}]}]<{[<><>]{<>{}}}>)]{[{{{()<>}[{}<>]}<<()>{{}{}}>}]({{<
            [<((<<({[{<{[[<><>](<>{})]{<()()><[]{}>}}<<[{}()]<[][]>><({}<>)>>>{<[[()<>]<{}[]>]<(<>()){<>{}}>>[{(()[])[{
            ([(<<{{<[<(<<[[]{}]({}{})><[()[]]{<><>}>>[[{[]<>}[{}()]][({}{})({}())]>){(<{(){}}[{}[]]>[{[][]}<<
            ([<{<<<[[<{[{({}{})[{}[]]}])[[(({}{}){()<>})<[()[]]<[][]>>]<(<()()>{()()}){(<><>)([]())}>]>]]<<{
            [{((<<{[{[<<<(()[])[[][]]>>><{<{<>[]>{[]{}}>{<<>()>[<><>]}}[{{<>{}}([]())}{({}[])[<><>]}]>][(<({<>()}[[]{}])[
            <(<[[<{(<[(<[([]())]({<>()}({}()))>[({(){}})[[[][]][<>{}]]]){{[[<><>]{{}[]}]<[(){}]<{}()>>}(<(<>{
            {{{([[(<<<{[{(<><>){<>[]}}<<[][]><()<>>>]<[[(){}][<>[]]]{{()<>}[{}()]}>}[{{({}<>)}[[{}{}]{{}[]}]}[([()()]
            {(<[{[{([({[[{<>}]{[<>{}]([][])}]{[(<>[])({}())]<{<><>}({}<>)>}}<[[(<>()){()[]}][<()()>{[]{}}]]<{[[]][[]()]
            <{(({({(<{{<{{()()}<()[]>}{[[]()](<>[])}>}<<({{}()}<[]{}>)[{[]()}]><<<<><>>[<>[]]>>>}([<[{()[]}(()()
            [[[{<({{[[<[{[(){}]<[]<>>}[[<>[]]{()<>}]]({<{}[]>[<>[]]}{({}{})<{}[]>})>{[[{[]{}}{<><>}]{(
            <([<[(([[[[([<[][]>]<([]()){<>()}>){[{[]()}([][])]<{[]<>}({}<>)>}]<[[[[]<>][<>{}]]{{{}()]{<>(
            <({{<<<{<<[[[<()<>>[()[]]]](<[{}<>]{[][]}>[{<>()}<()()>])]><{<[<()<>>[[]()]]<<[][]><()()>>>
            [[{{(([[<{[[(<[][]><<><>>}[{{}()}]]{(<<><>>({}<>))[[[][]]<[]{}>]}]<[{({}<>)[[]]}({()()}[<><>
            ([<[([[<{<((<<{}()>[<>()]>)(<{{}()}>(<[]<>>{()()})))>({<<{(){}}{{}}><[<>{}]<<>{}>>>{([(){}](<>)){{()<>}({
            [{[[<((({[{[<[[]()]<{}[]>>{<{}<>>(<>[])}]<{({}{}){{}[]}}{[[]<>]([][])}>}(<{(<>)[()<>]>>(({{}()})[[{}[]]{[]}
            [{[[({<<{([{{({}())[()[]]}<[<>()]({}{})>}({[{}<>]<<><>>}{{[]<>}{()]})][<([<>()]({}[])){[{}{}](<>[])}>[((()
            {{((<[{{[[(<{({}()){()<>}}[{{}<>)({}{})]>({<(){}>[[]{}]}[[[]()]<{}>]))<<{[[]{}]({}[])}{<()>({}
            <{<({[[({<(<<<[][]>[<>[]]><(()[])>>{([[]<>]({}{}>)})((<[{}][{}<>]>{(()<>)})<<<<>[]>[(){}]>[(<>{})<<>[]>]>)>}
            [[[{[[{<{({<({{}<>}({}<>))>{[({}())]}})[<[[([][])][<{}<>><()<>>]]([[<><>]<[]()>]<({}{})(<><>
            [<({{[(<{(<<((<>)<{}[]>){{<>[]}<{}{}>}>(<(<><>)<{}<>>><{{}()}[{}()]>)>([([[]{}][{}[]])]))}>((({{
            <<{({{(<([[(<[<>()]<<><>>>(<[]()>{{}<>})){{<{}[]>[()()]}<(<>[])<()[]>]}]{({<(){}>{[]()}}[(<>
            (({<[({{[[{{[[()[]]([][])]{(<>[])<(){}>}}<<({}{})([]())><({}[])>>}<<<<{}[]>{[]{}}>(<[][]>[{}{}])>(({()<>
            {[[([<[{[{<[[({}[])<{}[]>]([<>[]]({}{}))][({()[]}(()()))]>{<<({})([]{})>{[[]()](()()]}>[(((){})(()[]))<[[]<>
            ({[(<[(<({<[[[{}()]][<()()>[()[]]]]<{{<>[]}}[[[]{}]([]<>)]>>})<<{[<[()[]](()()}><(()())[<><>]>
            ((<[{([[{(([([<>()][[][]])]))}]])<{(<<{{<<[]{}>({}())>}}>>[{([[{{}()}{(){}}]](((()[])[(){}])<[<><
            {(<{[{<<(<<[<<{}{}>><[[][]}{(){}}>]{{{[]<>}[[]<>]}}>{({<{}<>>({}<>)}<<[]<>>>)[(<{}<>>(<>))<[
            [<({<<({[{[<[([]<>)]{[(){}]({})}>{{((){})}[<[][]>]}]({(<{}<>>(<>())){{[]()}(()())}}(((<>{}){()()}){{[]()}<<>
            [[{{[<<[[[<<[{{}[]}<(){}>][{(){}}<{}[]>]>>(({({}{}}{<>{}}}([<>[]](()[]))))]{[[{((){})<<>()>}{{()[]}{<>()}}]<
            {(([([<({[[{{[<>[]][<>[]]}[([][])[{}()]]}[([()()][{}()])([<>{}])]]][[{[([]{}){[]()}][<(){}
            <{{[{<(((({[{<[]()>({}{})}]}))<[((<([]<>)[{}[]]>{<(){}>[[][]]}))[{<[()()][{}()]>(({}[])<<>[]>)}[((<>()){{}
            [(<[{[[<{[([{{[]()}<()>}(([]())<(){}>)][(({}{})<{}<>>)])(<({{}()}({}))<[()[]]{<>[]}>><(<{}<>><{}<>>)<({}<>
            {([({<<((({[({[][]})<{{}{}}<{}()>>]}<(<<[]()><()<>>>{{[]<>}([][])})(<{[]<>}[[]<>]>)>){([{<[]()>[<>[]]}[{<><
            [{{<<[<<<<{<({[]}[()[]]){{{}<>}[(){}]}>({([]())({}[])>)}><[[{[()<>]({}{})}<<<>{}>{()[]}>]{{[[][]]}(<<>()><
            (({({[{({[{[{([][])[[][]]}]{{{[]()}({}[])}({<>[]}(<>))}}[<<([]<>)>(<{}{}>{()})>[{[<><>][<>{}]}]]]}([{
            (({{<[{[([({([{}{}][{}<>])<<{}{}><<>()>>})]([((<[]()>[{}()])<<{}<>>((){})>)]<{[[{}<>]<[][]>]<(()[]
            {<[({<[[<[(<<({}[])[[]()]>([<>{}]{{}<>})>[<<{}[]>{<>()}><[<>{}]({}[])>])]{{{({{}{}}<[]()>)
            {<(({<[({<<[[[()[]]<{}<>>]]>><[{<{<><>}(<><>)>[[()[]]{<><>}]}[[{<><>}{{}<>}]({{}{}}[[][]])]]<<[{{}{}}<<>[]>]
            [<{({{(({([{(<{}[]>(<>{}))<[[]{}](()[])>}<{(<>{})(<>{})}>])<<<<({}<>){<>{}}>[(()()>(()())]>
            ({((({[(<{{({({}())[[]<>]}([<>[]]{{}()}))<({{}()}<{}{}>)[{[]{}}({}[])]>}[([{{}<>}<{}>])[{{()[]}{{}()}}[([]{
            [<[{<{([<({<[[{}<>]{[][]}]{<<>{}><<><>>}>({[[]{}]<{}<>>}{{{}<>}(()[])})}){{{[<[]()><[][]>]
            <<{<{[[{([{<[<{}[]>{[]<>}]<<{}{}>[{}[]]>>}([([{}{}]{<><>})[{<>{}})])]){{([[<{}[]>({}[])][[<><>]
            ([[(<([[[<[((([]{}){[]<>}))<{<[][]>[[]()]}[(()<>)<[]{}>]>]{[([[][]][()[]]){{(){}}[{}<>]}]}><
            <[{{<{<({{([[[[]{}]<{}()>><([]()){[]{}}>]<{<()[]>([]())}>)}<<{{((){}){[][]}}(({}<>)(()()))}([{[
            ({{({[[{<({[({<>{}}[<>()])(([][]){{}{}])][({{}<>}(()[]))[<[]()><[]{}>]]}[{(<()[]><[]()>)[<{}()>{()[]}]}
            <<<{<{[([[[[(<()[]>){<[]()><[]()>}]<<([])<[]<>>><[[]<>][<>[]]>>]<<[[()()](<><>)]({()()}[<>[]])>([<[]
            ((([{([({({<(<{}()>[()<>])<[{}<>]<{}[]>>>][{<[[][]]{{}()}>[({}()){[]<>}]}([{{}{}}[[]()]])])<[(({<>()}
            ([<<[(<{<<[<[{()[]}{()[]}](({}[]){{}[]})>]{([{()[]}])({{<>()}(()())})}>((({{()()}(()<>)}][[(<>()){()}
            ({[{[((<[<{<([[][]]{{}()})[{<>()}(<>{})]>{{{{}}}{{()}({}[])}}}>]<(<{<(<>())(()())>}>[<{[{}<>]{{
            {({[<{<[[[[<({<>{}}{()[]}){<[]()><[]()>}>([(<>())[[]()]](({}{})[()<>]))]]({([[<>{}]<{}[]>](<()()><()<>>))
            ([<[<{<<<<((({<>}[<>{}])<({}())<()<>>>)[[[[]()][{}{}]]<(()<>)[<>]>]){{[({}())][([][])<()[]>]}{
            [{[({{<[{[<<[[<>()]]<([]())>><<<[][]>>{[()<>]{{}}}>>]}]{<{{{{[<>{}]({}[])}<{{}}{<>{}}>}{<({}){<>
            {<<{{({([{[([{[]<>}{<>[]}](<()[]>))[([{}]<()<>>)<<<>[]>[()<>]>]]}{[{<[()[]][{}{}]>{[[]()][{}[]]}}({[[]{
            ((<(<{{<([{[{{()[]}{<><>}}{{<>}({}{})})[([(){}][[][]])[<()[]><(){}>]]}<([(<>()){[][]}][([]())([]())])[
            <<{[{{<{<[[[<<()<>>[()[]]>([()]{{}[]})]](<[(()<>)[()[]]]>{<[{}{}]>[<<><>><<><>>]})][{((<{}{}>[()
            <<<[[<[[([{[(<()><[]{}>)[(()[])[[]{}]]]{[{{}<>}[{}<>]]}}[(<<<>()><()[]>>[({}())<(){}>])[[[[][]][<
            [[<(({[(([{{<([][])[[][]]>[{{}{}}{<>[]}]}<[(<><>)](<[][]>[<>{}])>}]{{{([(){}]([]))<[{}<>](())>}([[(
            [<{[([<{({([((()>[{}[]])[(<><>){[][]}]])([{([]<>){[][]}}<(()[]){[]()}>]<((<>{}){[][]})({{}()}<()[
            ((((<<<({([<{[{}()]{[]{}}}{({}[]){(){}}}>[[{()[]}[<>()]]<(()<>){(){}}>]]{[<(()())[{}[]]>(<<>()>({}
            (<({((((<{{{[{{}{}}[(){}]][{<>{}}{(){}}]}([[{}[]]{<><>}]<[[]{}]<[][]>>)}({[[{}<>]<(){}>]}<{{<>[]}}<<<>[]>
            {(<{(<{({(([{{()()}}][(({}{})<{}>)])<<(<()<>>{{}<>})(((){})[[]{}])><[[<>{})[<><>]][{()()}]>
            <{[(<[[{(<({[<{}()>{{}{}}]{(()){[]{}}}}[{{[]<>}[{}{}]}])({({[][]}{[]()})})>(<{{(()[])<<>>>[<<>[]><[]<
            ([<[<[[{<[<(([<>{}]){[(){}]<()()>})<{([]{}}<{}<>>}{<{}{}><[]()>}>>(<<{<><>}(<>())>({<>}[{}{}])>(<(<><>)
            ([{[[(<[(([{[{<>[]}{<>()}]<[(){}](<>{})>]<<<<>[]>>{(<><>)<[]{}>}>])){{{{<([]<>)([]{})><{{}{
            [<{({{(({<[([[()<>]{[][]}]({<>[]}(()[])))](<<({}())([][])>[{()<>}(()())]><{[<>{}]<<>()>}[[{}()]{<><>}]>)>{
            {({{{{[{{[<{{<[][]>([])}<[[]{}][{}()]>}>]{{[[<<>[]>[[][]>]<<{}<>>(()<>)>]{[[<>{}]{{}[]}]}}<[[[<><>]<<
            <({{({(({{<{{([]{}){<><>}}<(<>())({}{}]>}[{((){})(<>())}]>(({<[]()>([]{})}({{}{}}<<>()>)))}[[([<{}<>>
            [[<{<{<((<<({(<>())(<>())}{{(){}}[{}()]})<(<{}<>>{(){}})>>{{({[][]}{{}[]})<<{}<>>(()<>)>}<<<<>()>>{({}{}){()
            {[(<<<{(<{<<({<>{}}{()[]}>({<>[]}({}()))>>}>)<{(<(<({}[]){()[]}>)>((({()[]}[[][]]){<[][]><<>()>})[(([]<>)<
            <[<[{<[{[[<([<{}()>[<>]]{[[][]]<{}()>}}>({{{<>[]}{()[]}}{{()}<<><>>}}<<([])([][])>{[{}<>]((
            {[<<[[(<<{[<[[[]]({}())]([{}()][[]<>])>]}<({{(()[])<[][]>}{({})<()<>>}})([((()[])<[]<>>)<{(){}}([]())
            <{{<[[[(((<[{({}()){()()}}(<{}()>{()<>})]{{{()()}}{[[]{}]({}())}}>))<{<(((()<>)[{}[]])){[<[]<>>{{}()
            <([((<<(((({{[{}<>]<[]<>>}(<[]{}><[]{}>)}[{{<>[]}}{(<>{}){[]<>}}])<<{(()())<<>{}>}[[{}[]][{}()]]>[<[[]()
            {({{({[[({[<[<<><>)<{}{}>][<(){}>{[]{}}]>({(<>{})(<>())}<({})({})>)]})]<({[[({[]<>}{()()}){({}()
            ((([[(<(<[([({{}()})[{{}()}({}{})]]{({[]()}{{}()})(<()[]><<>[]>)}){{([{}()])}}]<[(<(<><>)[()[]}>[{{}<>}])]>>[
            {(([(<[[[[<<([(){}][<>[]]){({}())[[]{}]}>>[[<{()[]}{(){}}>(<{}{}><{}{}>)]<([()[]]<{}>)(<()[]>{
            {({([(<{<[[<<[<><>]<<><>>>>[<<{}<>>[{}<>]>{[[]{}][{}<>]}]]][{{<[{}[]]({})><[()()]>}}<[<{[]<>}[[]()]>]{[
            (((<{([<[(<[{([][])<[][]>}({{}<>}[{}{}])]>[[({[]<>}{<>{}})]})[{({(()[])([][])}{<()()>[[][]
            <(<{{<([<(<{<{{}}{<>{}}>}([([]{}){(){}>]{<()<>>([])})>)<<({<[]<>>})({[()[]]}<[(){}]{{}()}>)>{[<<[][]>>({[]{
            ({{(<(([[{((<<()[]><{}<>>>])}][<({<[{}[]][{}{}]><(()())([]())>})>{<(<{[]{}}{{}<>}>{{[]<>}{<><>}})>}]]{<[{[[
            {<[<([(((<[{[(())]}[(<{}()>)([[]][{}])]]{({<[]{}><()[]>}{{[]()}<{}<>>})}>){(({{<(){}>{<>[]}}(<(){}>(
            ([[{<{{{({{<[<[][]><()()>>><<[<>()]>>}{[[(())]<{[]<>}<()<>>>]}})(<({[([]<>)<<>[]>]({<>()}[
            {<[<<[((<<{<{([]<>)(<><>)}([()<>][{}[]])>}<<{{[]()}(<>{})}([<><>]({}[]))>{<[()<>]<{}()>>{<()(
            {<{(<[[[<[{<[({}())<()<>>]>[{([]{})([]<>)}[<[][]>]>}][<([[()<>]{[][]}]){<[[]()](()())>({()}(()()))}>({<[()<
            [{({<<<({{<[(({}[]){{}()})[{[]{}}{<><>}]]<{<[][]>(<>())}([<>{}])>>}[(<{{<>}([][])}>{{[[]()][[][]]}{<<>()><
            <<([{{[(<[([<{[]()}<<><>>><(()())<()[]>>][{<[]()><{}()>}{<<><>>[()<>]}])(<<<<>{}][{}[]]>[{<>}({}
            ((<<<<[{<[[<[{()()}<[][]>]{(()<>)}><{[[]{}]<{}{}>}>]<<{{[]<>}([])}{({}())([]{})]><[(<>())(<>{})]>>]><([<(([]
            {[[<(<[({[[[{{<>()}<()()>}]]]}[({(<[[][]]>(<{}<>>))}[<{<[]{}>(()<>)}{<{}{}>[()<>]}>])(<{([[]<>]){
            {{<<{([<{[[[(<{}{}>[[]<>])({<><>}{{}[]})]]][([([()[]])[(()<>)<[]{}>]]<{{()<>}{[]()}}<<[]{}>{
            <(([[<(({{(<{{()<>}[<>()]}[({}())[[][]]]>{{[{}<>]((){})][<<>{}><[]{}>]})<<({{}()}<<>{}>){(<>())[<>{}]}>(
            (<[(<<(((([<[<{}[]>][[()()]<<>()>]><[<{}{}>{()<>}](<()()])>][{{[{}<>]{<>()}}[<()()><{}>]}<(<{}{
            ({{({[(<[{[<[((){})({}{})]([<>[]][[]()])>](<(<(){}><()()>)({<>{}}<{}()>)><{{<>()}(())}<{()()}<[]()>>
            {<([(<<{([[[[(()<>)(()())]][[([]{})({}())]<[[]<>]{()[]}>)]([[<(){}>{<>{}}]((()())[()()])])]
            (<<(((<[[{[{<[()<>]{<>{}}>([[]()][()()])}]{([<[]<>>{<>[]}]<<[][]>[{}()]>){<{[][]}[<>{}]><[<>[]]({}{}
            <([[[(<[([{((<<>()>{()[]}){(<>())([])})[{<{}[]>([][])}[({}[])[<>()]]]}[(<<<>{}><()<>>><<<>[]>{(
            [[{<[[(<<<(([(<><>)([][])](([]{}){[]{}}))[<[[]{}]>([[]()]{[][]})])>{{{[<()[]>[[]{}]][{()<>}[<>[]]]}}
            ([(<{<<(<{{{[[<>[]]<(){}>]([()[]][()[]])}{((<>()))}}{<[<{}<>>(<><>)](([][])<<>()>)}}}(<<[<{}[]
            <[{{({{<[<[{(<<>[]>(<>()))<([]<>)[{}<>]>}]>{<<{<[]{}>(<>())}>([<(){}><(){}>]{[<>()]([]())})>}]>}})}}{(((
            [<(((<{<<[(<{(<>[])}>){(<<{}<>>([]<>)>{<{}()>}}[[<{}{}>{[][]}](<<>[]>{{}[]})]}]><<([<[(){}]<()>><[(){}]
            ({[[(<[{(<((<[()[]]{[]<>}>){<(<>){()<>}>})(({<(){}>[{}[]]})[[(()[]){[]<>})<{[]()}>])>)<<<(<({}())(<>[])
            [{([<<<[{{([<<{}{}>>[{{}[]]]])}<<[<{{}}{<><>}>(({}{})[<>[]])]({[<><>]([][])}{(()<>)<<><>>})
            [[<(<<[{([[[[<[]{}><[]()>]][{[[][]]<()<>>}]]]{{{(<[]{}>(()<>))<(<>[])<<><>>>}]({{(()[]){{}()}}
            ({<<<{[<[[[{([{}<>]{<>()})(<<><>>)}(<(<>[])<{}>))][({<{}[]>[[][]]}(([]())(()[])))<<[[]()]{<><>}>>
            [{<[[{{[<<([([<><>]([]<>))]({[()[]][{}{}]}{{()()}[[]<>]})){(<(()[])<[]()>><[[]()]<()<>>>)(<<()(
            {<({((<([<(({{[]<>}[{}<>]}[<()[]><[]{}>]){<{[][]}{<><>]>})(({({}())[()()]}{[{}()][[]<>]}))>])<(<{(<{
            """;
}
