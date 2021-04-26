-- Bluez monitor config file --

bluez_monitor = {}

bluez_monitor.properties = {
  --["bluez5.sbc-xq-support"] = true,

  -- Enabled headset roles (default: [ hsp_hs hfp_ag ]), this
  -- property only applies to native backend. Currently some headsets
  -- (Sony WH-1000XM3) are not working with both hsp_ag and hfp_ag
  -- enabled, disable either hsp_ag or hfp_ag to work around it.
  --
  -- Supported headset roles: hsp_hs (HSP Headset),
  --                          hsp_ag (HSP Audio Gateway),
  --                          hfp_hf (HFP Hands-Free),
  --                          hfp_ag (HFP Audio Gateway)
  ["bluez5.headset-roles"] = "[ hsp_hs hsp_ag hfp_hf hfp_ag ]",

  -- Enabled A2DP codecs (default: all).
  --["bluez5.codecs"] = "[ sbc aac ldac aptx aptx_hd ]",
}

bluez_monitor.rules = {
  -- An array of matches/actions to evaluate.
  {
    -- Rules for matching a device or node. It is an array of
    -- properties that all need to match the regexp. If any of the
    -- matches work, the actions are executed for the object.
    matches = {
      {
        -- This matches all cards.
        { "device.name", "matches", "bluez_card.*" },
      },
    },
    -- Apply properties on the matched object.
    apply_properties = {
      -- Autoconnect device profiles, disabled by default
      -- if the property is not specified.
      ["bluez5.reconnect-profiles"]  = "[ hfp_hf hsp_hs a2dp_sink ]",

      -- MSBC is not expected to work on all headset + adapter combinations.
      --["bluez5.msbc-support"] = false,

      -- LDAC encoding quality
      -- Available values: auto (Adaptive Bitrate, default)
      --                   hq   (High Quality, 990/909kbps)
      --                   sq   (Standard Quality, 660/606kbps)
      --                   mq   (Mobile use Quality, 330/303kbps)
      --["bluez5.a2dp.ldac.quality"] = "auto",
    },
  },
  {
    -- Make output stream nodes go through the Communication endpoint
    -- Unfortunately we cannot match on "media.class" because this property
    -- is not known before the node is created
    matches = {
      {
        { "api.bluez5.profile", "equals", "headset-audio-gateway" },
        { "factory.name", "matches", "*source*" },
      },
      {
        { "api.bluez5.profile", "equals", "a2dp-source" },
      },
    },
    apply_properties = {
      ["media.role"]  = "Communication",
    },
  },
}

function bluez_monitor.enable()
  load_monitor("bluez", {
    properties = bluez_monitor.properties,
    rules = bluez_monitor.rules,
  })
end
