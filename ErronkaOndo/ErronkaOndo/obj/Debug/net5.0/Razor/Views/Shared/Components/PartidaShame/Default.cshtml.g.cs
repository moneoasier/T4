#pragma checksum "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "f3f41366447e5379d2f0cce6f831a832b0c374cb"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Components_PartidaShame_Default), @"mvc.1.0.view", @"/Views/Shared/Components/PartidaShame/Default.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\_ViewImports.cshtml"
using ErronkaOndo;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\_ViewImports.cshtml"
using ErronkaOndo.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"f3f41366447e5379d2f0cce6f831a832b0c374cb", @"/Views/Shared/Components/PartidaShame/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"148d45b9fa047d481d80db30a0f52954e0b674ca", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_PartidaShame_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<ErronkaOndo.Models.Partida>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Foroa", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
  
    ViewData["Title"] = "Default";

#line default
#line hidden
#nullable disable
            WriteLiteral(@"



<table class=""table"">
    <thead>
        <tr>
            <th>
                Partida Id
            </th>
            <th>
                Puntuazioa
            </th>
            <th>
                Data
            </th>
            <th>
                Langile Id
            </th>
            <th>
                Adina
            </th>
            <th>
                Departamendua
            </th>
            <th></th>
        </tr>
    </thead>
    <tbody>





");
#nullable restore
#line 40 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
         foreach (var item in Model)
        {

#line default
#line hidden
#nullable disable
            WriteLiteral("            <tr>\r\n                <td>\r\n                    ");
#nullable restore
#line 44 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.partidaId));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 47 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 50 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.data));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 53 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.employeeid));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 56 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.adina));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 59 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.departamentua));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n\r\n                    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "f3f41366447e5379d2f0cce6f831a832b0c374cb6923", async() => {
                WriteLiteral("<button type=\"button\" class=\"btn btn-outline-info\">Komentatu</button>");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                </td>\r\n            </tr>\r\n");
#nullable restore
#line 66 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\PartidaShame\Default.cshtml"
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\r\n</table>\r\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<ErronkaOndo.Models.Partida>> Html { get; private set; }
    }
}
#pragma warning restore 1591