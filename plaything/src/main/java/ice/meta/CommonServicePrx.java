// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.5
//
// <auto-generated>
//
// Generated from file `CommonService.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package ice.meta;

public interface CommonServicePrx extends Ice.ObjectPrx
{
    public void request(String s);

    public void request(String s, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_request(String s);

    public Ice.AsyncResult begin_request(String s, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_request(String s, Ice.Callback __cb);

    public Ice.AsyncResult begin_request(String s, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_request(String s, Callback_CommonService_request __cb);

    public Ice.AsyncResult begin_request(String s, java.util.Map<String, String> __ctx, Callback_CommonService_request __cb);

    public Ice.AsyncResult begin_request(String s,
                                         IceInternal.Functional_VoidCallback __responseCb,
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_request(String s,
                                         IceInternal.Functional_VoidCallback __responseCb,
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                         IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_request(String s,
                                         java.util.Map<String, String> __ctx,
                                         IceInternal.Functional_VoidCallback __responseCb,
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_request(String s,
                                         java.util.Map<String, String> __ctx,
                                         IceInternal.Functional_VoidCallback __responseCb,
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                         IceInternal.Functional_BoolCallback __sentCb);

    public void end_request(Ice.AsyncResult __result);
}
