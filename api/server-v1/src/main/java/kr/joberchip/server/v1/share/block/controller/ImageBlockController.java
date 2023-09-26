package kr.joberchip.server.v1.share.block.controller;

import java.util.UUID;
import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.share.block.dto.create.CreateImageBlock;
import kr.joberchip.server.v1.share.block.dto.modify.ModifyImageBlock;
import kr.joberchip.server.v1.share.block.service.ImageBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/page/{pageId}/imageBlock")
@RequiredArgsConstructor
public class ImageBlockController {
  private final ImageBlockService imageBlockService;

  @PostMapping
  public ResponseEntity<ApiResponse.Result<Object>> createImageBlock(
      @PathVariable UUID pageId, @RequestBody CreateImageBlock createImageBlock) {
    imageBlockService.createImageBlock(pageId, createImageBlock);

    return ResponseEntity.ok(ApiResponse.success());
  }

  @PutMapping("/{blockId}")
  public ResponseEntity<ApiResponse.Result<Object>> modifyImageBlock(
      @PathVariable UUID pageId,
      @PathVariable Long blockId,
      @RequestBody ModifyImageBlock modifyImageBlock) {
    imageBlockService.modifyImageBlock(pageId, blockId, modifyImageBlock);

    return ResponseEntity.ok(ApiResponse.success());
  }

  @DeleteMapping("/{blockId}")
  public ResponseEntity<ApiResponse.Result<Object>> deleteImageBlock(
          @PathVariable UUID pageId,
          @PathVariable Long blockId
          ) {
    imageBlockService.deleteImageBlock(pageId, blockId);

    return ResponseEntity.ok(ApiResponse.success());
  }
}
