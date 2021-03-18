package org.mskcc.cmo.metadb.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import org.mskcc.cmo.metadb.model.web.PublishedMetaDbRequest;
import org.mskcc.cmo.metadb.service.MetaDbRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/")
@Api(tags = "request-controller", description = "Request Controller")
public class RequestController {

    @Autowired
    private MetaDbRequestService metaDbRequestService;

    @Autowired
    public RequestController(MetaDbRequestService metaDbRequestService) {
        this.metaDbRequestService = metaDbRequestService;
    }

    /**
     * fetchRequestGET
     * @param requestId
     */
    @ApiOperation(value = "Retrieve MetaDbRequest",
        nickname = "fetchMetaDbRequestGET")
    @RequestMapping(value = "/request/{requestId}",
        method = RequestMethod.GET,
        produces = "application/json")
    public PublishedMetaDbRequest fetchMetaDbRequestGET(@ApiParam(value =
        "Retrieves MetaDbRequest from a RequestId.",
        required = true)
        @PathVariable String requestId) throws Exception {
        return metaDbRequestService.getMetaDbRequest(requestId);
    }

    /**
     * fetchRequestListPOST
     * @param requestIds
     * TODO properly set-up POST
     */
    @ApiOperation(value = "Retrieves list of MetaDbRequest from a list of RequestIds.",
        nickname = "fetchMetaDbRequestListPOST")
    @RequestMapping(value = "/request",
        method = RequestMethod.POST,
        produces = "application/json")
    public List<PublishedMetaDbRequest> fetchMetaDbRequestPOST(@ApiParam(value =
        "List of request ids", required = true, allowMultiple = true)
        @RequestBody List<String> requestIds) throws Exception {
        List<PublishedMetaDbRequest> requestList = new ArrayList<>();
        for (String requestId: requestIds) {
            requestList.add(metaDbRequestService.getMetaDbRequest(requestId));
        }
        return requestList;
    }
    
    /**
     * fetchMetaDbRequestJson
     * @param requestId
     */
    @ApiOperation(value = "Retrieve MetaDbRequestJson",
        nickname = "fetchMetaDbRequestJsonGET")
    @RequestMapping(value = "/request/json/{requestId}",
        method = RequestMethod.GET,
        produces = "application/json")
    public String fetchMetaDbRequestJsonGET(@ApiParam(value =
        "Retrieves MetaDbRequestJson from a RequestId.",
        required = true)
        @PathVariable String requestId) throws Exception {
        return metaDbRequestService.getMetaDbRequest(requestId).getRequestJson();
    }
    
}
