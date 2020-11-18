/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.uni.controller;

import io.swagger.annotations.Api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.uni.entity.Route;
import org.springblade.modules.uni.vo.RouteVO;
import org.springblade.modules.uni.service.IRouteService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 控制器
 *
 * @author Uni
 * @since 2020-11-17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/route")
@Api(value = "", tags = "接口")
public class RouteController extends BladeController {

	private IRouteService routeService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入route")
	public R<Route> detail(Route route) {
		Route detail = routeService.getOne(Condition.getQueryWrapper(route));
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入route")
	public R<IPage<Route>> list(Route route, Query query) {
		IPage<Route> pages = routeService.page(Condition.getPage(query), Condition.getQueryWrapper(route));
		return R.data(pages);
	}

	/**
	 * 自定义分页
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入route")
	public R<IPage<RouteVO>> page(RouteVO route, Query query) {
		IPage<RouteVO> pages = routeService.selectRoutePage(Condition.getPage(query), route);
		return R.data(pages);
	}

	/**
	 * 新增
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入route")
	public R save(@Valid @RequestBody Route route) {
		return R.status(routeService.save(route));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入route")
	public R update(@Valid @RequestBody Route route) {
		return R.status(routeService.updateById(route));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入route")
	public R submit(@Valid @RequestBody Route route) {
		return R.status(routeService.saveOrUpdate(route));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(routeService.removeByIds(Func.toLongList(ids)));
	}

}
