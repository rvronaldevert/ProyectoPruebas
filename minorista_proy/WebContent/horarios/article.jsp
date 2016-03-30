<%@ include file="header.jsp" %>
<body>
	<div class="header">
		<div class="center">
			<div class="text">Job Scheduler</div>
			<div class="user-info">
				<div class="logout">
					[ <a href="logout.action">Log off</a> ]
				</div>
				<div class="username">
					Welcome, <span class="bold"><s:property escape="false" value="username" /></span>!
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="scheduler" id="scheduler">
			<div class="leftcol">
				<div class="minical" id="minical"></div>
				<div class="filter" id="filter">
					<div class="f_header">Employee</div>
					<div class="f_list">
						<table id="users">
							<s:iterator value="users" status="userStatus">
								<tr class="<s:if test="#userStatus.even == true">even</s:if><s:else>odd</s:else>">
									<td class="checkbox"><input type="checkbox" id="user_<s:property value="id"/>" checked onchange="update_config();" /></td>
									<td class="last"><label for="user_<s:property value="id" />"><s:property value="name" /></label></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			<div class="rightcol">
				<s:property escape="false" value="planner" />
			</div>
		</div>
		<script>
		function update_config() {
			var coll = [];
			var inputs = document.getElementById("users").getElementsByTagName("input");
			var labels = document.getElementById("users").getElementsByTagName("label");
			for (var i = 0; i < inputs.length; i++) {
				if (!inputs[i].checked) continue;


				var id = inputs[i].id.replace("user_", "");
				var name = labels[i].innerHTML;


				coll.push({key:id, label:name});
			}
			if (coll.length > 0) {
				scheduler._props.units.options = coll;
				scheduler.matrix.timeline.y_unit = coll;
				scheduler.callEvent("onOptionsLoad", []);
				scheduler.setCurrentView();
			}
		}
		scheduler.attachEvent("onBeforeTooltip", function (id){
			var view = scheduler.getState().mode;
		    if (view == "timeline" || view == "month")
		    	return true;
		    return false;
		});
		scheduler.templates.tooltip_text = function(start,end,ev){
		    return  "<b>Task:</b> " + ev.text + "<br/>" +
		    		"<b>Start date:</b> " +  scheduler.templates.tooltip_date_format(start) + "<br/>" + 
    				"<b>End date:</b> " + scheduler.templates.tooltip_date_format(end) + "<br/>" +
	    			"<b>Owner:</b> " + scheduler.getLabel("user", ev.user) + "<br/>" +
		    		"<b>Status:</b> " + scheduler.getLabel("status", ev.status) + "<br/>" +
		    		"<b>Urgency:</b> " + scheduler.getLabel("urgency", ev.urgency) + "<br/>";
		};

		<s:if test="employee == true">
		scheduler.attachEvent("onBeforeLightbox", function(id) {
			var user = <s:property escape="false" value="userid" />;
			var event = scheduler.getEvent(id);

			if (event.user != user) {
				scheduler.config.buttons_left = ["dhx_cancel_btn"];
				scheduler.config.buttons_right = [];
			} else {
				scheduler.config.buttons_left = ["dhx_save_btn", "dhx_cancel_btn"];
				scheduler.config.buttons_right = [];
			}
			scheduler.resetLightbox();

			scheduler.formSection("description").control.disabled = true;
			var time =  scheduler.formSection("time").control;
			for (var i = 0; i < time.length; i++)
				time[i].disabled = true;
			scheduler.formSection("user").control.disabled = true;
			scheduler.formSection("urgency").control.disabled = true;
			scheduler.formSection("status").control.disabled = (event.user != user) ? true : false;

			return true;
		});
		scheduler.config.dblclick_create = false;
		scheduler.attachEvent("onBeforeDrag", function() { return false; });
		scheduler.attachEvent("onDblClick", function(id) { scheduler.showLightbox(id); return false; });
		scheduler.attachEvent("onClick", function() { return false; });
	</s:if>
	scheduler.locale.labels.confirm_deleting = "Task will be deleted permanently, are you sure?";
	scheduler.locale.labels.new_event = "New task";
		</script>
		<script>
			scheduler.templates.event_class=function(start, end, event){
				return event.status;
			};
		</script>
		<style>
		/* pending event style */
		.dhx_cal_event.pending div,
		.dhx_cal_event_line.pending {
			background-color: #1696AF !important;
			color: #ffffff !important;
		}
		.dhx_cal_event_clear.pending {
			color: #1696AF !important;
		}
		
		
		/* started event style*/
		.dhx_cal_event.started div,
		.dhx_cal_event_line.started {
			background-color: #FD7511 !important;
			color: #ffffff !important;
		}
		.dhx_cal_event_clear.started {
			color: #FD7511 !important;
		}
		
		
		/* completed event style */
		.dhx_cal_event.completed div,
		.dhx_cal_event_line.completed {
			background-color: #76B006 !important;
			color: #ffffff !important;
		}
		.dhx_cal_event_clear.completed {
			color: #76B006 !important;
		}
		</style>

<%@ include file="footer.jsp" %>
