/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.facturacion.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.facturacion.util.ParametroFactuEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFactuEmpresaConstantesFunciones extends ParametroFactuEmpresaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ParametroFactuEmpresa";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFactuEmpresa"+ParametroFactuEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFactuEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFactuEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFactuEmpresaConstantesFunciones.SCHEMA+"_"+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFactuEmpresaConstantesFunciones.SCHEMA+"_"+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFactuEmpresaConstantesFunciones.SCHEMA+"_"+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFactuEmpresaConstantesFunciones.SCHEMA+"_"+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFactuEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFactuEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFactuEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFactuEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Empresa s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Empresa ";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Factu Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFactuEmpresa";
	public static final String OBJECTNAME="parametrofactuempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_factu_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofactuempresa from "+ParametroFactuEmpresaConstantesFunciones.SPERSISTENCENAME+" parametrofactuempresa";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_cliente_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".costo_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_cliente_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".costo_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".con_transferencia,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_empresa_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_sucursal_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_transaccion_multi_destino,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_multi_origen,"+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME+".id_bodega_multi_destino from "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+"."+ParametroFactuEmpresaConstantesFunciones.TABLENAME;//+" as "+ParametroFactuEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFactuEmpresaConstantesFuncionesAdditional parametrofactuempresaConstantesFuncionesAdditional=null;
	
	public ParametroFactuEmpresaConstantesFuncionesAdditional getParametroFactuEmpresaConstantesFuncionesAdditional() {
		return this.parametrofactuempresaConstantesFuncionesAdditional;
	}
	
	public void setParametroFactuEmpresaConstantesFuncionesAdditional(ParametroFactuEmpresaConstantesFuncionesAdditional parametrofactuempresaConstantesFuncionesAdditional) {
		try {
			this.parametrofactuempresaConstantesFuncionesAdditional=parametrofactuempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPRESAORIGEN= "id_empresa_origen";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTRANSACCIONORIGEN= "id_transaccion_origen";
    public static final String IDBODEGAORIGEN= "id_bodega_origen";
    public static final String IDCLIENTEORIGEN= "id_cliente_origen";
    public static final String COSTOORIGEN= "costo_origen";
    public static final String IDEMPRESADESTINO= "id_empresa_destino";
    public static final String IDSUCURSALDESTINO= "id_sucursal_destino";
    public static final String IDTRANSACCIONDESTINO= "id_transaccion_destino";
    public static final String IDBODEGADESTINO= "id_bodega_destino";
    public static final String IDCLIENTEDESTINO= "id_cliente_destino";
    public static final String COSTODESTINO= "costo_destino";
    public static final String CONTRANSFERENCIA= "con_transferencia";
    public static final String IDEMPRESAMULTIDESTINO= "id_empresa_multi_destino";
    public static final String IDSUCURSALMULTIDESTINO= "id_sucursal_multi_destino";
    public static final String IDTRANSACCIONMULTIDESTINO= "id_transaccion_multi_destino";
    public static final String IDBODEGAMULTIORIGEN= "id_bodega_multi_origen";
    public static final String IDBODEGAMULTIDESTINO= "id_bodega_multi_destino";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPRESAORIGEN= "Empresa Origen";
		public static final String LABEL_IDEMPRESAORIGEN_LOWER= "Empresa Origen";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTRANSACCIONORIGEN= "Transaccion Origen";
		public static final String LABEL_IDTRANSACCIONORIGEN_LOWER= "Transaccion Origen";
    	public static final String LABEL_IDBODEGAORIGEN= "Bodega Origen";
		public static final String LABEL_IDBODEGAORIGEN_LOWER= "Bodega Origen";
    	public static final String LABEL_IDCLIENTEORIGEN= "Cliente Origen";
		public static final String LABEL_IDCLIENTEORIGEN_LOWER= "Cliente Origen";
    	public static final String LABEL_COSTOORIGEN= "Costo Origen";
		public static final String LABEL_COSTOORIGEN_LOWER= "Costo Origen";
    	public static final String LABEL_IDEMPRESADESTINO= "Empresa Destino";
		public static final String LABEL_IDEMPRESADESTINO_LOWER= "Empresa Destino";
    	public static final String LABEL_IDSUCURSALDESTINO= "Sucursal Destino";
		public static final String LABEL_IDSUCURSALDESTINO_LOWER= "Sucursal Destino";
    	public static final String LABEL_IDTRANSACCIONDESTINO= "Transaccion Destino";
		public static final String LABEL_IDTRANSACCIONDESTINO_LOWER= "Transaccion Destino";
    	public static final String LABEL_IDBODEGADESTINO= "Bodega Destino";
		public static final String LABEL_IDBODEGADESTINO_LOWER= "Bodega Destino";
    	public static final String LABEL_IDCLIENTEDESTINO= "Cliente Destino";
		public static final String LABEL_IDCLIENTEDESTINO_LOWER= "Cliente Destino";
    	public static final String LABEL_COSTODESTINO= "Costo Destino";
		public static final String LABEL_COSTODESTINO_LOWER= "Costo Destino";
    	public static final String LABEL_CONTRANSFERENCIA= "Con Transferencia";
		public static final String LABEL_CONTRANSFERENCIA_LOWER= "Con Transferencia";
    	public static final String LABEL_IDEMPRESAMULTIDESTINO= "Empresa Multi Destino";
		public static final String LABEL_IDEMPRESAMULTIDESTINO_LOWER= "Empresa Multi Destino";
    	public static final String LABEL_IDSUCURSALMULTIDESTINO= "Sucursal Multi Destino";
		public static final String LABEL_IDSUCURSALMULTIDESTINO_LOWER= "Sucursal Multi Destino";
    	public static final String LABEL_IDTRANSACCIONMULTIDESTINO= "Transaccion Multi Destino";
		public static final String LABEL_IDTRANSACCIONMULTIDESTINO_LOWER= "Transaccion Multi Destino";
    	public static final String LABEL_IDBODEGAMULTIORIGEN= "Bodega Multi Origen";
		public static final String LABEL_IDBODEGAMULTIORIGEN_LOWER= "Bodega Multi Origen";
    	public static final String LABEL_IDBODEGAMULTIDESTINO= "Bodega Multi Destino";
		public static final String LABEL_IDBODEGAMULTIDESTINO_LOWER= "Bodega Multi Destino";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroFactuEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESADESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGADESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.COSTODESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_CONTRANSFERENCIA;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAMULTIDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALMULTIDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONMULTIDESTINO;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIORIGEN;}
		if(sNombreColumna.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO)) {sLabelColumna=ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIDESTINO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_transferenciaDescripcion(ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactuempresa.getcon_transferencia()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_transferenciaHtmlDescripcion(ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactuempresa.getId(),parametrofactuempresa.getcon_transferencia());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getParametroFactuEmpresaDescripcion(ParametroFactuEmpresa parametrofactuempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofactuempresa !=null/* && parametrofactuempresa.getId()!=0*/) {
			if(parametrofactuempresa.getId()!=null) {
				sDescripcion=parametrofactuempresa.getId().toString();
			}//parametrofactuempresaparametrofactuempresa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFactuEmpresaDescripcionDetallado(ParametroFactuEmpresa parametrofactuempresa) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=parametrofactuempresa.getId().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofactuempresa.getVersionRow().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofactuempresa.getid_empresa().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getid_empresa_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofactuempresa.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getid_transaccion_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getid_bodega_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getid_cliente_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getcosto_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_empresa_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_sucursal_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_transaccion_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_bodega_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_cliente_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.COSTODESTINO+"=";
		sDescripcion+=parametrofactuempresa.getcosto_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA+"=";
		sDescripcion+=parametrofactuempresa.getcon_transferencia().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_empresa_multi_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_sucursal_multi_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_transaccion_multi_destino().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN+"=";
		sDescripcion+=parametrofactuempresa.getid_bodega_multi_origen().toString()+",";
		sDescripcion+=ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO+"=";
		sDescripcion+=parametrofactuempresa.getid_bodega_multi_destino().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFactuEmpresaDescripcion(ParametroFactuEmpresa parametrofactuempresa,String sValor) throws Exception {			
		if(parametrofactuempresa !=null) {
			//parametrofactuempresaparametrofactuempresa.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpresaOrigenDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTransaccionOrigenDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getBodegaOrigenDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getClienteOrigenDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEmpresaDestinoDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDestinoDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTransaccionDestinoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getBodegaDestinoDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getClienteDestinoDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEmpresaMultiDestinoDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalMultiDestinoDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTransaccionMultiDestinoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getBodegaMultiOrigenDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getBodegaMultiDestinoDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodegaDestino")) {
			sNombreIndice="Tipo=  Por Bodega Destino";
		} else if(sNombreIndice.equals("FK_IdBodegaMultiDestino")) {
			sNombreIndice="Tipo=  Por Bodega Multi Destino";
		} else if(sNombreIndice.equals("FK_IdBodegaMultiOrigen")) {
			sNombreIndice="Tipo=  Por Bodega Multi Origen";
		} else if(sNombreIndice.equals("FK_IdBodegaOrigen")) {
			sNombreIndice="Tipo=  Por Bodega Origen";
		} else if(sNombreIndice.equals("FK_IdClienteDestino")) {
			sNombreIndice="Tipo=  Por Cliente Destino";
		} else if(sNombreIndice.equals("FK_IdClienteOrigen")) {
			sNombreIndice="Tipo=  Por Cliente Origen";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEmpresaDestino")) {
			sNombreIndice="Tipo=  Por Empresa Destino";
		} else if(sNombreIndice.equals("FK_IdEmpresaMultiDestino")) {
			sNombreIndice="Tipo=  Por Empresa Multi Destino";
		} else if(sNombreIndice.equals("FK_IdEmpresaOrigen")) {
			sNombreIndice="Tipo=  Por Empresa Origen";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdSucursalDestino")) {
			sNombreIndice="Tipo=  Por Sucursal Destino";
		} else if(sNombreIndice.equals("FK_IdSucursalMultiDestino")) {
			sNombreIndice="Tipo=  Por Sucursal Multi Destino";
		} else if(sNombreIndice.equals("FK_IdTransaccionDestino")) {
			sNombreIndice="Tipo=  Por Transaccion Destino";
		} else if(sNombreIndice.equals("FK_IdTransaccionMultiDestino")) {
			sNombreIndice="Tipo=  Por Transaccion Multi Destino";
		} else if(sNombreIndice.equals("FK_IdTransaccionOrigen")) {
			sNombreIndice="Tipo=  Por Transaccion Origen";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodegaDestino(Long id_bodega_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_destino!=null) {sDetalleIndice+=" Codigo Unico De Bodega Destino="+id_bodega_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaMultiDestino(Long id_bodega_multi_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_multi_destino!=null) {sDetalleIndice+=" Codigo Unico De Bodega Multi Destino="+id_bodega_multi_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaMultiOrigen(Long id_bodega_multi_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_multi_origen!=null) {sDetalleIndice+=" Codigo Unico De Bodega Multi Origen="+id_bodega_multi_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaOrigen(Long id_bodega_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_origen!=null) {sDetalleIndice+=" Codigo Unico De Bodega Origen="+id_bodega_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClienteDestino(Long id_cliente_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_destino!=null) {sDetalleIndice+=" Codigo Unico De Cliente Destino="+id_cliente_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClienteOrigen(Long id_cliente_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_origen!=null) {sDetalleIndice+=" Codigo Unico De Cliente Origen="+id_cliente_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresaDestino(Long id_empresa_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_destino!=null) {sDetalleIndice+=" Codigo Unico De Empresa Destino="+id_empresa_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresaMultiDestino(Long id_empresa_multi_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_multi_destino!=null) {sDetalleIndice+=" Codigo Unico De Empresa Multi Destino="+id_empresa_multi_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresaOrigen(Long id_empresa_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_origen!=null) {sDetalleIndice+=" Codigo Unico De Empresa Origen="+id_empresa_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursalDestino(Long id_sucursal_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_destino!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Destino="+id_sucursal_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursalMultiDestino(Long id_sucursal_multi_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_multi_destino!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Multi Destino="+id_sucursal_multi_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionDestino(Long id_transaccion_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_destino!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Destino="+id_transaccion_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionMultiDestino(Long id_transaccion_multi_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_multi_destino!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Multi Destino="+id_transaccion_multi_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionOrigen(Long id_transaccion_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_origen!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Origen="+id_transaccion_origen.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroFactuEmpresas(List<ParametroFactuEmpresa> parametrofactuempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFactuEmpresa parametrofactuempresa: parametrofactuempresas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofactuempresa.getConCambioAuxiliar()) {
			parametrofactuempresa.setIsDeleted(parametrofactuempresa.getIsDeletedAuxiliar());	
			parametrofactuempresa.setIsNew(parametrofactuempresa.getIsNewAuxiliar());	
			parametrofactuempresa.setIsChanged(parametrofactuempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofactuempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofactuempresa.setIsDeletedAuxiliar(false);	
			parametrofactuempresa.setIsNewAuxiliar(false);	
			parametrofactuempresa.setIsChangedAuxiliar(false);
			
			parametrofactuempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuEmpresas(List<ParametroFactuEmpresa> parametrofactuempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFactuEmpresa parametrofactuempresa : parametrofactuempresas) {
			if(conAsignarBase && parametrofactuempresa.getConCambioAuxiliar()) {
				parametrofactuempresa.setIsDeleted(parametrofactuempresa.getIsDeletedAuxiliar());	
				parametrofactuempresa.setIsNew(parametrofactuempresa.getIsNewAuxiliar());	
				parametrofactuempresa.setIsChanged(parametrofactuempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofactuempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofactuempresa.setIsDeletedAuxiliar(false);	
				parametrofactuempresa.setIsNewAuxiliar(false);	
				parametrofactuempresa.setIsChangedAuxiliar(false);
				
				parametrofactuempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa,Boolean conEnteros) throws Exception  {
		parametrofactuempresa.setcosto_origen(0.0);
		parametrofactuempresa.setcosto_destino(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroFactuEmpresas(List<ParametroFactuEmpresa> parametrofactuempresas,Boolean conEnteros) throws Exception  {
		
		for(ParametroFactuEmpresa parametrofactuempresa: parametrofactuempresas) {
			parametrofactuempresa.setcosto_origen(0.0);
			parametrofactuempresa.setcosto_destino(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFactuEmpresa(List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresa parametrofactuempresaAux) throws Exception  {
		ParametroFactuEmpresaConstantesFunciones.InicializarValoresParametroFactuEmpresa(parametrofactuempresaAux,true);
		
		for(ParametroFactuEmpresa parametrofactuempresa: parametrofactuempresas) {
			if(parametrofactuempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrofactuempresaAux.setcosto_origen(parametrofactuempresaAux.getcosto_origen()+parametrofactuempresa.getcosto_origen());			
			parametrofactuempresaAux.setcosto_destino(parametrofactuempresaAux.getcosto_destino()+parametrofactuempresa.getcosto_destino());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFactuEmpresaConstantesFunciones.getArrayColumnasGlobalesParametroFactuEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFactuEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresa parametrofactuempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFactuEmpresa parametrofactuempresaAux: parametrofactuempresas) {
			if(parametrofactuempresaAux!=null && parametrofactuempresa!=null) {
				if((parametrofactuempresaAux.getId()==null && parametrofactuempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofactuempresaAux.getId()!=null && parametrofactuempresa.getId()!=null){
					if(parametrofactuempresaAux.getId().equals(parametrofactuempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFactuEmpresa(List<ParametroFactuEmpresa> parametrofactuempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_origenTotal=0.0;
		Double costo_destinoTotal=0.0;
	
		for(ParametroFactuEmpresa parametrofactuempresa: parametrofactuempresas) {			
			if(parametrofactuempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_origenTotal+=parametrofactuempresa.getcosto_origen();
			costo_destinoTotal+=parametrofactuempresa.getcosto_destino();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN);
		datoGeneral.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN);
		datoGeneral.setdValorDouble(costo_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroFactuEmpresaConstantesFunciones.COSTODESTINO);
		datoGeneral.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO);
		datoGeneral.setdValorDouble(costo_destinoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFactuEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_ID, ParametroFactuEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_VERSIONROW, ParametroFactuEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESA, ParametroFactuEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAORIGEN, ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSAL, ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONORIGEN, ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAORIGEN, ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEORIGEN, ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN, ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESADESTINO, ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALDESTINO, ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONDESTINO, ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGADESTINO, ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEDESTINO, ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO, ParametroFactuEmpresaConstantesFunciones.COSTODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_CONTRANSFERENCIA, ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAMULTIDESTINO, ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALMULTIDESTINO, ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONMULTIDESTINO, ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIORIGEN, ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIDESTINO, ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFactuEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.COSTODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuEmpresa() throws Exception  {
		return ParametroFactuEmpresaConstantesFunciones.getTiposSeleccionarParametroFactuEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuEmpresa(Boolean conFk) throws Exception  {
		return ParametroFactuEmpresaConstantesFunciones.getTiposSeleccionarParametroFactuEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESADESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGADESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_CONTRANSFERENCIA);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_CONTRANSFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAMULTIDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAMULTIDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALMULTIDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALMULTIDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONMULTIDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONMULTIDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIORIGEN);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIDESTINO);
			reporte.setsDescripcion(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFactuEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresaAux) throws Exception {
		
			parametrofactuempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresa()));
			parametrofactuempresaAux.setempresaorigen_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaOrigen()));
			parametrofactuempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursal()));
			parametrofactuempresaAux.settransaccionorigen_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionOrigen()));
			parametrofactuempresaAux.setbodegaorigen_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaOrigen()));
			parametrofactuempresaAux.setclienteorigen_descripcion(ClienteConstantesFunciones.getClienteDescripcion(parametrofactuempresaAux.getClienteOrigen()));
			parametrofactuempresaAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaDestino()));
			parametrofactuempresaAux.setsucursaldestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursalDestino()));
			parametrofactuempresaAux.settransacciondestino_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionDestino()));
			parametrofactuempresaAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaDestino()));
			parametrofactuempresaAux.setclientedestino_descripcion(ClienteConstantesFunciones.getClienteDescripcion(parametrofactuempresaAux.getClienteDestino()));
			parametrofactuempresaAux.setempresamultidestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaMultiDestino()));
			parametrofactuempresaAux.setsucursalmultidestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursalMultiDestino()));
			parametrofactuempresaAux.settransaccionmultidestino_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionMultiDestino()));
			parametrofactuempresaAux.setbodegamultiorigen_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaMultiOrigen()));
			parametrofactuempresaAux.setbodegamultidestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaMultiDestino()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuEmpresa(List<ParametroFactuEmpresa> parametrofactuempresasTemp) throws Exception {
		for(ParametroFactuEmpresa parametrofactuempresaAux:parametrofactuempresasTemp) {
			
			parametrofactuempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresa()));
			parametrofactuempresaAux.setempresaorigen_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaOrigen()));
			parametrofactuempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursal()));
			parametrofactuempresaAux.settransaccionorigen_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionOrigen()));
			parametrofactuempresaAux.setbodegaorigen_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaOrigen()));
			parametrofactuempresaAux.setclienteorigen_descripcion(ClienteConstantesFunciones.getClienteDescripcion(parametrofactuempresaAux.getClienteOrigen()));
			parametrofactuempresaAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaDestino()));
			parametrofactuempresaAux.setsucursaldestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursalDestino()));
			parametrofactuempresaAux.settransacciondestino_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionDestino()));
			parametrofactuempresaAux.setbodegadestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaDestino()));
			parametrofactuempresaAux.setclientedestino_descripcion(ClienteConstantesFunciones.getClienteDescripcion(parametrofactuempresaAux.getClienteDestino()));
			parametrofactuempresaAux.setempresamultidestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactuempresaAux.getEmpresaMultiDestino()));
			parametrofactuempresaAux.setsucursalmultidestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactuempresaAux.getSucursalMultiDestino()));
			parametrofactuempresaAux.settransaccionmultidestino_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactuempresaAux.getTransaccionMultiDestino()));
			parametrofactuempresaAux.setbodegamultiorigen_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaMultiOrigen()));
			parametrofactuempresaAux.setbodegamultidestino_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactuempresaAux.getBodegaMultiDestino()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Bodega.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFactuEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuEmpresaConstantesFunciones.getClassesRelationshipsOfParametroFactuEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFactuEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ParametroFactuEmpresa parametrofactuempresa,List<ParametroFactuEmpresa> parametrofactuempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFactuEmpresa parametrofactuempresaEncontrado=null;
			
			for(ParametroFactuEmpresa parametrofactuempresaLocal:parametrofactuempresas) {
				if(parametrofactuempresaLocal.getId().equals(parametrofactuempresa.getId())) {
					parametrofactuempresaEncontrado=parametrofactuempresaLocal;
					
					parametrofactuempresaLocal.setIsChanged(parametrofactuempresa.getIsChanged());
					parametrofactuempresaLocal.setIsNew(parametrofactuempresa.getIsNew());
					parametrofactuempresaLocal.setIsDeleted(parametrofactuempresa.getIsDeleted());
					
					parametrofactuempresaLocal.setGeneralEntityOriginal(parametrofactuempresa.getGeneralEntityOriginal());
					
					parametrofactuempresaLocal.setId(parametrofactuempresa.getId());	
					parametrofactuempresaLocal.setVersionRow(parametrofactuempresa.getVersionRow());	
					parametrofactuempresaLocal.setid_empresa(parametrofactuempresa.getid_empresa());	
					parametrofactuempresaLocal.setid_empresa_origen(parametrofactuempresa.getid_empresa_origen());	
					parametrofactuempresaLocal.setid_sucursal(parametrofactuempresa.getid_sucursal());	
					parametrofactuempresaLocal.setid_transaccion_origen(parametrofactuempresa.getid_transaccion_origen());	
					parametrofactuempresaLocal.setid_bodega_origen(parametrofactuempresa.getid_bodega_origen());	
					parametrofactuempresaLocal.setid_cliente_origen(parametrofactuempresa.getid_cliente_origen());	
					parametrofactuempresaLocal.setcosto_origen(parametrofactuempresa.getcosto_origen());	
					parametrofactuempresaLocal.setid_empresa_destino(parametrofactuempresa.getid_empresa_destino());	
					parametrofactuempresaLocal.setid_sucursal_destino(parametrofactuempresa.getid_sucursal_destino());	
					parametrofactuempresaLocal.setid_transaccion_destino(parametrofactuempresa.getid_transaccion_destino());	
					parametrofactuempresaLocal.setid_bodega_destino(parametrofactuempresa.getid_bodega_destino());	
					parametrofactuempresaLocal.setid_cliente_destino(parametrofactuempresa.getid_cliente_destino());	
					parametrofactuempresaLocal.setcosto_destino(parametrofactuempresa.getcosto_destino());	
					parametrofactuempresaLocal.setcon_transferencia(parametrofactuempresa.getcon_transferencia());	
					parametrofactuempresaLocal.setid_empresa_multi_destino(parametrofactuempresa.getid_empresa_multi_destino());	
					parametrofactuempresaLocal.setid_sucursal_multi_destino(parametrofactuempresa.getid_sucursal_multi_destino());	
					parametrofactuempresaLocal.setid_transaccion_multi_destino(parametrofactuempresa.getid_transaccion_multi_destino());	
					parametrofactuempresaLocal.setid_bodega_multi_origen(parametrofactuempresa.getid_bodega_multi_origen());	
					parametrofactuempresaLocal.setid_bodega_multi_destino(parametrofactuempresa.getid_bodega_multi_destino());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofactuempresa.getIsDeleted()) {
				if(!existe) {
					parametrofactuempresas.add(parametrofactuempresa);
				}
			} else {
				if(parametrofactuempresaEncontrado!=null && permiteQuitar)  {
					parametrofactuempresas.remove(parametrofactuempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFactuEmpresa parametrofactuempresa,List<ParametroFactuEmpresa> parametrofactuempresas) throws Exception {
		try	{			
			for(ParametroFactuEmpresa parametrofactuempresaLocal:parametrofactuempresas) {
				if(parametrofactuempresaLocal.getId().equals(parametrofactuempresa.getId())) {
					parametrofactuempresaLocal.setIsSelected(parametrofactuempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFactuEmpresa(List<ParametroFactuEmpresa> parametrofactuempresasAux) throws Exception {
		//this.parametrofactuempresasAux=parametrofactuempresasAux;
		
		for(ParametroFactuEmpresa parametrofactuempresaAux:parametrofactuempresasAux) {
			if(parametrofactuempresaAux.getIsChanged()) {
				parametrofactuempresaAux.setIsChanged(false);
			}		
			
			if(parametrofactuempresaAux.getIsNew()) {
				parametrofactuempresaAux.setIsNew(false);
			}	
			
			if(parametrofactuempresaAux.getIsDeleted()) {
				parametrofactuempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresaAux) throws Exception {
		//this.parametrofactuempresaAux=parametrofactuempresaAux;
		
			if(parametrofactuempresaAux.getIsChanged()) {
				parametrofactuempresaAux.setIsChanged(false);
			}		
			
			if(parametrofactuempresaAux.getIsNew()) {
				parametrofactuempresaAux.setIsNew(false);
			}	
			
			if(parametrofactuempresaAux.getIsDeleted()) {
				parametrofactuempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFactuEmpresa parametrofactuempresaAsignar,ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		parametrofactuempresaAsignar.setId(parametrofactuempresa.getId());	
		parametrofactuempresaAsignar.setVersionRow(parametrofactuempresa.getVersionRow());	
		parametrofactuempresaAsignar.setid_empresa(parametrofactuempresa.getid_empresa());
		parametrofactuempresaAsignar.setempresa_descripcion(parametrofactuempresa.getempresa_descripcion());	
		parametrofactuempresaAsignar.setid_empresa_origen(parametrofactuempresa.getid_empresa_origen());
		parametrofactuempresaAsignar.setempresaorigen_descripcion(parametrofactuempresa.getempresaorigen_descripcion());	
		parametrofactuempresaAsignar.setid_sucursal(parametrofactuempresa.getid_sucursal());
		parametrofactuempresaAsignar.setsucursal_descripcion(parametrofactuempresa.getsucursal_descripcion());	
		parametrofactuempresaAsignar.setid_transaccion_origen(parametrofactuempresa.getid_transaccion_origen());
		parametrofactuempresaAsignar.settransaccionorigen_descripcion(parametrofactuempresa.gettransaccionorigen_descripcion());	
		parametrofactuempresaAsignar.setid_bodega_origen(parametrofactuempresa.getid_bodega_origen());
		parametrofactuempresaAsignar.setbodegaorigen_descripcion(parametrofactuempresa.getbodegaorigen_descripcion());	
		parametrofactuempresaAsignar.setid_cliente_origen(parametrofactuempresa.getid_cliente_origen());
		parametrofactuempresaAsignar.setclienteorigen_descripcion(parametrofactuempresa.getclienteorigen_descripcion());	
		parametrofactuempresaAsignar.setcosto_origen(parametrofactuempresa.getcosto_origen());	
		parametrofactuempresaAsignar.setid_empresa_destino(parametrofactuempresa.getid_empresa_destino());
		parametrofactuempresaAsignar.setempresadestino_descripcion(parametrofactuempresa.getempresadestino_descripcion());	
		parametrofactuempresaAsignar.setid_sucursal_destino(parametrofactuempresa.getid_sucursal_destino());
		parametrofactuempresaAsignar.setsucursaldestino_descripcion(parametrofactuempresa.getsucursaldestino_descripcion());	
		parametrofactuempresaAsignar.setid_transaccion_destino(parametrofactuempresa.getid_transaccion_destino());
		parametrofactuempresaAsignar.settransacciondestino_descripcion(parametrofactuempresa.gettransacciondestino_descripcion());	
		parametrofactuempresaAsignar.setid_bodega_destino(parametrofactuempresa.getid_bodega_destino());
		parametrofactuempresaAsignar.setbodegadestino_descripcion(parametrofactuempresa.getbodegadestino_descripcion());	
		parametrofactuempresaAsignar.setid_cliente_destino(parametrofactuempresa.getid_cliente_destino());
		parametrofactuempresaAsignar.setclientedestino_descripcion(parametrofactuempresa.getclientedestino_descripcion());	
		parametrofactuempresaAsignar.setcosto_destino(parametrofactuempresa.getcosto_destino());	
		parametrofactuempresaAsignar.setcon_transferencia(parametrofactuempresa.getcon_transferencia());	
		parametrofactuempresaAsignar.setid_empresa_multi_destino(parametrofactuempresa.getid_empresa_multi_destino());
		parametrofactuempresaAsignar.setempresamultidestino_descripcion(parametrofactuempresa.getempresamultidestino_descripcion());	
		parametrofactuempresaAsignar.setid_sucursal_multi_destino(parametrofactuempresa.getid_sucursal_multi_destino());
		parametrofactuempresaAsignar.setsucursalmultidestino_descripcion(parametrofactuempresa.getsucursalmultidestino_descripcion());	
		parametrofactuempresaAsignar.setid_transaccion_multi_destino(parametrofactuempresa.getid_transaccion_multi_destino());
		parametrofactuempresaAsignar.settransaccionmultidestino_descripcion(parametrofactuempresa.gettransaccionmultidestino_descripcion());	
		parametrofactuempresaAsignar.setid_bodega_multi_origen(parametrofactuempresa.getid_bodega_multi_origen());
		parametrofactuempresaAsignar.setbodegamultiorigen_descripcion(parametrofactuempresa.getbodegamultiorigen_descripcion());	
		parametrofactuempresaAsignar.setid_bodega_multi_destino(parametrofactuempresa.getid_bodega_multi_destino());
		parametrofactuempresaAsignar.setbodegamultidestino_descripcion(parametrofactuempresa.getbodegamultidestino_descripcion());	
	}
	
	public static void inicializarParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		try {
				parametrofactuempresa.setId(0L);	
					
				parametrofactuempresa.setid_empresa(-1L);	
				parametrofactuempresa.setid_empresa_origen(-1L);	
				parametrofactuempresa.setid_sucursal(-1L);	
				parametrofactuempresa.setid_transaccion_origen(-1L);	
				parametrofactuempresa.setid_bodega_origen(-1L);	
				parametrofactuempresa.setid_cliente_origen(-1L);	
				parametrofactuempresa.setcosto_origen(0.0);	
				parametrofactuempresa.setid_empresa_destino(-1L);	
				parametrofactuempresa.setid_sucursal_destino(-1L);	
				parametrofactuempresa.setid_transaccion_destino(-1L);	
				parametrofactuempresa.setid_bodega_destino(-1L);	
				parametrofactuempresa.setid_cliente_destino(-1L);	
				parametrofactuempresa.setcosto_destino(0.0);	
				parametrofactuempresa.setcon_transferencia(false);	
				parametrofactuempresa.setid_empresa_multi_destino(-1L);	
				parametrofactuempresa.setid_sucursal_multi_destino(-1L);	
				parametrofactuempresa.setid_transaccion_multi_destino(-1L);	
				parametrofactuempresa.setid_bodega_multi_origen(-1L);	
				parametrofactuempresa.setid_bodega_multi_destino(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFactuEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDCLIENTEDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_COSTODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_CONTRANSFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDEMPRESAMULTIDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDSUCURSALMULTIDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDTRANSACCIONMULTIDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuEmpresaConstantesFunciones.LABEL_IDBODEGAMULTIDESTINO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFactuEmpresa(String sTipo,Row row,Workbook workbook,ParametroFactuEmpresa parametrofactuempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getempresaorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.gettransaccionorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getbodegaorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getclienteorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getcosto_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getempresadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getsucursaldestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.gettransacciondestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getbodegadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getclientedestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getcosto_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactuempresa.getcon_transferencia()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getempresamultidestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getsucursalmultidestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.gettransaccionmultidestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getbodegamultiorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactuempresa.getbodegamultidestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFactuEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFactuEmpresa() {
		return this.sFinalQueryParametroFactuEmpresa;
	}
	
	public void setsFinalQueryParametroFactuEmpresa(String sFinalQueryParametroFactuEmpresa) {
		this.sFinalQueryParametroFactuEmpresa= sFinalQueryParametroFactuEmpresa;
	}
	
	public Border resaltarSeleccionarParametroFactuEmpresa=null;
	
	public Border setResaltarSeleccionarParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFactuEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFactuEmpresa() {
		return this.resaltarSeleccionarParametroFactuEmpresa;
	}
	
	public void setResaltarSeleccionarParametroFactuEmpresa(Border borderResaltarSeleccionarParametroFactuEmpresa) {
		this.resaltarSeleccionarParametroFactuEmpresa= borderResaltarSeleccionarParametroFactuEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFactuEmpresa=null;
	public Boolean mostraridParametroFactuEmpresa=true;
	public Boolean activaridParametroFactuEmpresa=true;

	public Border resaltarid_empresaParametroFactuEmpresa=null;
	public Boolean mostrarid_empresaParametroFactuEmpresa=true;
	public Boolean activarid_empresaParametroFactuEmpresa=true;
	public Boolean cargarid_empresaParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_empresa_origenParametroFactuEmpresa=null;
	public Boolean mostrarid_empresa_origenParametroFactuEmpresa=true;
	public Boolean activarid_empresa_origenParametroFactuEmpresa=true;
	public Boolean cargarid_empresa_origenParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_origenParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFactuEmpresa=null;
	public Boolean mostrarid_sucursalParametroFactuEmpresa=true;
	public Boolean activarid_sucursalParametroFactuEmpresa=true;
	public Boolean cargarid_sucursalParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_transaccion_origenParametroFactuEmpresa=null;
	public Boolean mostrarid_transaccion_origenParametroFactuEmpresa=true;
	public Boolean activarid_transaccion_origenParametroFactuEmpresa=true;
	public Boolean cargarid_transaccion_origenParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_origenParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_bodega_origenParametroFactuEmpresa=null;
	public Boolean mostrarid_bodega_origenParametroFactuEmpresa=true;
	public Boolean activarid_bodega_origenParametroFactuEmpresa=true;
	public Boolean cargarid_bodega_origenParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_origenParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cliente_origenParametroFactuEmpresa=null;
	public Boolean mostrarid_cliente_origenParametroFactuEmpresa=true;
	public Boolean activarid_cliente_origenParametroFactuEmpresa=true;
	public Boolean cargarid_cliente_origenParametroFactuEmpresa=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_origenParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarcosto_origenParametroFactuEmpresa=null;
	public Boolean mostrarcosto_origenParametroFactuEmpresa=true;
	public Boolean activarcosto_origenParametroFactuEmpresa=true;

	public Border resaltarid_empresa_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_empresa_destinoParametroFactuEmpresa=true;
	public Boolean activarid_empresa_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_empresa_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_sucursal_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_sucursal_destinoParametroFactuEmpresa=true;
	public Boolean activarid_sucursal_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_sucursal_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_transaccion_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_transaccion_destinoParametroFactuEmpresa=true;
	public Boolean activarid_transaccion_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_transaccion_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_bodega_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_bodega_destinoParametroFactuEmpresa=true;
	public Boolean activarid_bodega_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_bodega_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cliente_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_cliente_destinoParametroFactuEmpresa=true;
	public Boolean activarid_cliente_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_cliente_destinoParametroFactuEmpresa=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarcosto_destinoParametroFactuEmpresa=null;
	public Boolean mostrarcosto_destinoParametroFactuEmpresa=true;
	public Boolean activarcosto_destinoParametroFactuEmpresa=true;

	public Border resaltarcon_transferenciaParametroFactuEmpresa=null;
	public Boolean mostrarcon_transferenciaParametroFactuEmpresa=true;
	public Boolean activarcon_transferenciaParametroFactuEmpresa=true;

	public Border resaltarid_empresa_multi_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_empresa_multi_destinoParametroFactuEmpresa=true;
	public Boolean activarid_empresa_multi_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_empresa_multi_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_multi_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_sucursal_multi_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_sucursal_multi_destinoParametroFactuEmpresa=true;
	public Boolean activarid_sucursal_multi_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_sucursal_multi_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_multi_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_transaccion_multi_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_transaccion_multi_destinoParametroFactuEmpresa=true;
	public Boolean activarid_transaccion_multi_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_transaccion_multi_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_multi_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_bodega_multi_origenParametroFactuEmpresa=null;
	public Boolean mostrarid_bodega_multi_origenParametroFactuEmpresa=true;
	public Boolean activarid_bodega_multi_origenParametroFactuEmpresa=true;
	public Boolean cargarid_bodega_multi_origenParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_multi_origenParametroFactuEmpresa=false;//ConEventDepend=true

	public Border resaltarid_bodega_multi_destinoParametroFactuEmpresa=null;
	public Boolean mostrarid_bodega_multi_destinoParametroFactuEmpresa=true;
	public Boolean activarid_bodega_multi_destinoParametroFactuEmpresa=true;
	public Boolean cargarid_bodega_multi_destinoParametroFactuEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_multi_destinoParametroFactuEmpresa=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltaridParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFactuEmpresa() {
		return this.resaltaridParametroFactuEmpresa;
	}

	public void setResaltaridParametroFactuEmpresa(Border borderResaltar) {
		this.resaltaridParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostraridParametroFactuEmpresa() {
		return this.mostraridParametroFactuEmpresa;
	}

	public void setMostraridParametroFactuEmpresa(Boolean mostraridParametroFactuEmpresa) {
		this.mostraridParametroFactuEmpresa= mostraridParametroFactuEmpresa;
	}

	public Boolean getActivaridParametroFactuEmpresa() {
		return this.activaridParametroFactuEmpresa;
	}

	public void setActivaridParametroFactuEmpresa(Boolean activaridParametroFactuEmpresa) {
		this.activaridParametroFactuEmpresa= activaridParametroFactuEmpresa;
	}

	public Border setResaltarid_empresaParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFactuEmpresa() {
		return this.resaltarid_empresaParametroFactuEmpresa;
	}

	public void setResaltarid_empresaParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_empresaParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFactuEmpresa() {
		return this.mostrarid_empresaParametroFactuEmpresa;
	}

	public void setMostrarid_empresaParametroFactuEmpresa(Boolean mostrarid_empresaParametroFactuEmpresa) {
		this.mostrarid_empresaParametroFactuEmpresa= mostrarid_empresaParametroFactuEmpresa;
	}

	public Boolean getActivarid_empresaParametroFactuEmpresa() {
		return this.activarid_empresaParametroFactuEmpresa;
	}

	public void setActivarid_empresaParametroFactuEmpresa(Boolean activarid_empresaParametroFactuEmpresa) {
		this.activarid_empresaParametroFactuEmpresa= activarid_empresaParametroFactuEmpresa;
	}

	public Boolean getCargarid_empresaParametroFactuEmpresa() {
		return this.cargarid_empresaParametroFactuEmpresa;
	}

	public void setCargarid_empresaParametroFactuEmpresa(Boolean cargarid_empresaParametroFactuEmpresa) {
		this.cargarid_empresaParametroFactuEmpresa= cargarid_empresaParametroFactuEmpresa;
	}

	public Border setResaltarid_empresa_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresa_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_origenParametroFactuEmpresa() {
		return this.resaltarid_empresa_origenParametroFactuEmpresa;
	}

	public void setResaltarid_empresa_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_empresa_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresa_origenParametroFactuEmpresa() {
		return this.mostrarid_empresa_origenParametroFactuEmpresa;
	}

	public void setMostrarid_empresa_origenParametroFactuEmpresa(Boolean mostrarid_empresa_origenParametroFactuEmpresa) {
		this.mostrarid_empresa_origenParametroFactuEmpresa= mostrarid_empresa_origenParametroFactuEmpresa;
	}

	public Boolean getActivarid_empresa_origenParametroFactuEmpresa() {
		return this.activarid_empresa_origenParametroFactuEmpresa;
	}

	public void setActivarid_empresa_origenParametroFactuEmpresa(Boolean activarid_empresa_origenParametroFactuEmpresa) {
		this.activarid_empresa_origenParametroFactuEmpresa= activarid_empresa_origenParametroFactuEmpresa;
	}

	public Boolean getCargarid_empresa_origenParametroFactuEmpresa() {
		return this.cargarid_empresa_origenParametroFactuEmpresa;
	}

	public void setCargarid_empresa_origenParametroFactuEmpresa(Boolean cargarid_empresa_origenParametroFactuEmpresa) {
		this.cargarid_empresa_origenParametroFactuEmpresa= cargarid_empresa_origenParametroFactuEmpresa;
	}

	public Border setResaltarid_sucursalParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFactuEmpresa() {
		return this.resaltarid_sucursalParametroFactuEmpresa;
	}

	public void setResaltarid_sucursalParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_sucursalParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFactuEmpresa() {
		return this.mostrarid_sucursalParametroFactuEmpresa;
	}

	public void setMostrarid_sucursalParametroFactuEmpresa(Boolean mostrarid_sucursalParametroFactuEmpresa) {
		this.mostrarid_sucursalParametroFactuEmpresa= mostrarid_sucursalParametroFactuEmpresa;
	}

	public Boolean getActivarid_sucursalParametroFactuEmpresa() {
		return this.activarid_sucursalParametroFactuEmpresa;
	}

	public void setActivarid_sucursalParametroFactuEmpresa(Boolean activarid_sucursalParametroFactuEmpresa) {
		this.activarid_sucursalParametroFactuEmpresa= activarid_sucursalParametroFactuEmpresa;
	}

	public Boolean getCargarid_sucursalParametroFactuEmpresa() {
		return this.cargarid_sucursalParametroFactuEmpresa;
	}

	public void setCargarid_sucursalParametroFactuEmpresa(Boolean cargarid_sucursalParametroFactuEmpresa) {
		this.cargarid_sucursalParametroFactuEmpresa= cargarid_sucursalParametroFactuEmpresa;
	}

	public Border setResaltarid_transaccion_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_origenParametroFactuEmpresa() {
		return this.resaltarid_transaccion_origenParametroFactuEmpresa;
	}

	public void setResaltarid_transaccion_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_transaccion_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_origenParametroFactuEmpresa() {
		return this.mostrarid_transaccion_origenParametroFactuEmpresa;
	}

	public void setMostrarid_transaccion_origenParametroFactuEmpresa(Boolean mostrarid_transaccion_origenParametroFactuEmpresa) {
		this.mostrarid_transaccion_origenParametroFactuEmpresa= mostrarid_transaccion_origenParametroFactuEmpresa;
	}

	public Boolean getActivarid_transaccion_origenParametroFactuEmpresa() {
		return this.activarid_transaccion_origenParametroFactuEmpresa;
	}

	public void setActivarid_transaccion_origenParametroFactuEmpresa(Boolean activarid_transaccion_origenParametroFactuEmpresa) {
		this.activarid_transaccion_origenParametroFactuEmpresa= activarid_transaccion_origenParametroFactuEmpresa;
	}

	public Boolean getCargarid_transaccion_origenParametroFactuEmpresa() {
		return this.cargarid_transaccion_origenParametroFactuEmpresa;
	}

	public void setCargarid_transaccion_origenParametroFactuEmpresa(Boolean cargarid_transaccion_origenParametroFactuEmpresa) {
		this.cargarid_transaccion_origenParametroFactuEmpresa= cargarid_transaccion_origenParametroFactuEmpresa;
	}

	public Border setResaltarid_bodega_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_bodega_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_origenParametroFactuEmpresa() {
		return this.resaltarid_bodega_origenParametroFactuEmpresa;
	}

	public void setResaltarid_bodega_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_bodega_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_bodega_origenParametroFactuEmpresa() {
		return this.mostrarid_bodega_origenParametroFactuEmpresa;
	}

	public void setMostrarid_bodega_origenParametroFactuEmpresa(Boolean mostrarid_bodega_origenParametroFactuEmpresa) {
		this.mostrarid_bodega_origenParametroFactuEmpresa= mostrarid_bodega_origenParametroFactuEmpresa;
	}

	public Boolean getActivarid_bodega_origenParametroFactuEmpresa() {
		return this.activarid_bodega_origenParametroFactuEmpresa;
	}

	public void setActivarid_bodega_origenParametroFactuEmpresa(Boolean activarid_bodega_origenParametroFactuEmpresa) {
		this.activarid_bodega_origenParametroFactuEmpresa= activarid_bodega_origenParametroFactuEmpresa;
	}

	public Boolean getCargarid_bodega_origenParametroFactuEmpresa() {
		return this.cargarid_bodega_origenParametroFactuEmpresa;
	}

	public void setCargarid_bodega_origenParametroFactuEmpresa(Boolean cargarid_bodega_origenParametroFactuEmpresa) {
		this.cargarid_bodega_origenParametroFactuEmpresa= cargarid_bodega_origenParametroFactuEmpresa;
	}

	public Border setResaltarid_cliente_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cliente_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_origenParametroFactuEmpresa() {
		return this.resaltarid_cliente_origenParametroFactuEmpresa;
	}

	public void setResaltarid_cliente_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_cliente_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cliente_origenParametroFactuEmpresa() {
		return this.mostrarid_cliente_origenParametroFactuEmpresa;
	}

	public void setMostrarid_cliente_origenParametroFactuEmpresa(Boolean mostrarid_cliente_origenParametroFactuEmpresa) {
		this.mostrarid_cliente_origenParametroFactuEmpresa= mostrarid_cliente_origenParametroFactuEmpresa;
	}

	public Boolean getActivarid_cliente_origenParametroFactuEmpresa() {
		return this.activarid_cliente_origenParametroFactuEmpresa;
	}

	public void setActivarid_cliente_origenParametroFactuEmpresa(Boolean activarid_cliente_origenParametroFactuEmpresa) {
		this.activarid_cliente_origenParametroFactuEmpresa= activarid_cliente_origenParametroFactuEmpresa;
	}

	public Boolean getCargarid_cliente_origenParametroFactuEmpresa() {
		return this.cargarid_cliente_origenParametroFactuEmpresa;
	}

	public void setCargarid_cliente_origenParametroFactuEmpresa(Boolean cargarid_cliente_origenParametroFactuEmpresa) {
		this.cargarid_cliente_origenParametroFactuEmpresa= cargarid_cliente_origenParametroFactuEmpresa;
	}

	public Border setResaltarcosto_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarcosto_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_origenParametroFactuEmpresa() {
		return this.resaltarcosto_origenParametroFactuEmpresa;
	}

	public void setResaltarcosto_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarcosto_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarcosto_origenParametroFactuEmpresa() {
		return this.mostrarcosto_origenParametroFactuEmpresa;
	}

	public void setMostrarcosto_origenParametroFactuEmpresa(Boolean mostrarcosto_origenParametroFactuEmpresa) {
		this.mostrarcosto_origenParametroFactuEmpresa= mostrarcosto_origenParametroFactuEmpresa;
	}

	public Boolean getActivarcosto_origenParametroFactuEmpresa() {
		return this.activarcosto_origenParametroFactuEmpresa;
	}

	public void setActivarcosto_origenParametroFactuEmpresa(Boolean activarcosto_origenParametroFactuEmpresa) {
		this.activarcosto_origenParametroFactuEmpresa= activarcosto_origenParametroFactuEmpresa;
	}

	public Border setResaltarid_empresa_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresa_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_destinoParametroFactuEmpresa() {
		return this.resaltarid_empresa_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_empresa_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_empresa_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresa_destinoParametroFactuEmpresa() {
		return this.mostrarid_empresa_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_empresa_destinoParametroFactuEmpresa(Boolean mostrarid_empresa_destinoParametroFactuEmpresa) {
		this.mostrarid_empresa_destinoParametroFactuEmpresa= mostrarid_empresa_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_empresa_destinoParametroFactuEmpresa() {
		return this.activarid_empresa_destinoParametroFactuEmpresa;
	}

	public void setActivarid_empresa_destinoParametroFactuEmpresa(Boolean activarid_empresa_destinoParametroFactuEmpresa) {
		this.activarid_empresa_destinoParametroFactuEmpresa= activarid_empresa_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_empresa_destinoParametroFactuEmpresa() {
		return this.cargarid_empresa_destinoParametroFactuEmpresa;
	}

	public void setCargarid_empresa_destinoParametroFactuEmpresa(Boolean cargarid_empresa_destinoParametroFactuEmpresa) {
		this.cargarid_empresa_destinoParametroFactuEmpresa= cargarid_empresa_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_sucursal_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_destinoParametroFactuEmpresa() {
		return this.resaltarid_sucursal_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_sucursal_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_sucursal_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_destinoParametroFactuEmpresa() {
		return this.mostrarid_sucursal_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_sucursal_destinoParametroFactuEmpresa(Boolean mostrarid_sucursal_destinoParametroFactuEmpresa) {
		this.mostrarid_sucursal_destinoParametroFactuEmpresa= mostrarid_sucursal_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_sucursal_destinoParametroFactuEmpresa() {
		return this.activarid_sucursal_destinoParametroFactuEmpresa;
	}

	public void setActivarid_sucursal_destinoParametroFactuEmpresa(Boolean activarid_sucursal_destinoParametroFactuEmpresa) {
		this.activarid_sucursal_destinoParametroFactuEmpresa= activarid_sucursal_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_sucursal_destinoParametroFactuEmpresa() {
		return this.cargarid_sucursal_destinoParametroFactuEmpresa;
	}

	public void setCargarid_sucursal_destinoParametroFactuEmpresa(Boolean cargarid_sucursal_destinoParametroFactuEmpresa) {
		this.cargarid_sucursal_destinoParametroFactuEmpresa= cargarid_sucursal_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_transaccion_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_destinoParametroFactuEmpresa() {
		return this.resaltarid_transaccion_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_transaccion_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_transaccion_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_destinoParametroFactuEmpresa() {
		return this.mostrarid_transaccion_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_transaccion_destinoParametroFactuEmpresa(Boolean mostrarid_transaccion_destinoParametroFactuEmpresa) {
		this.mostrarid_transaccion_destinoParametroFactuEmpresa= mostrarid_transaccion_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_transaccion_destinoParametroFactuEmpresa() {
		return this.activarid_transaccion_destinoParametroFactuEmpresa;
	}

	public void setActivarid_transaccion_destinoParametroFactuEmpresa(Boolean activarid_transaccion_destinoParametroFactuEmpresa) {
		this.activarid_transaccion_destinoParametroFactuEmpresa= activarid_transaccion_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_transaccion_destinoParametroFactuEmpresa() {
		return this.cargarid_transaccion_destinoParametroFactuEmpresa;
	}

	public void setCargarid_transaccion_destinoParametroFactuEmpresa(Boolean cargarid_transaccion_destinoParametroFactuEmpresa) {
		this.cargarid_transaccion_destinoParametroFactuEmpresa= cargarid_transaccion_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_bodega_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_bodega_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_destinoParametroFactuEmpresa() {
		return this.resaltarid_bodega_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_bodega_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_bodega_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_bodega_destinoParametroFactuEmpresa() {
		return this.mostrarid_bodega_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_bodega_destinoParametroFactuEmpresa(Boolean mostrarid_bodega_destinoParametroFactuEmpresa) {
		this.mostrarid_bodega_destinoParametroFactuEmpresa= mostrarid_bodega_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_bodega_destinoParametroFactuEmpresa() {
		return this.activarid_bodega_destinoParametroFactuEmpresa;
	}

	public void setActivarid_bodega_destinoParametroFactuEmpresa(Boolean activarid_bodega_destinoParametroFactuEmpresa) {
		this.activarid_bodega_destinoParametroFactuEmpresa= activarid_bodega_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_bodega_destinoParametroFactuEmpresa() {
		return this.cargarid_bodega_destinoParametroFactuEmpresa;
	}

	public void setCargarid_bodega_destinoParametroFactuEmpresa(Boolean cargarid_bodega_destinoParametroFactuEmpresa) {
		this.cargarid_bodega_destinoParametroFactuEmpresa= cargarid_bodega_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_cliente_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cliente_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_destinoParametroFactuEmpresa() {
		return this.resaltarid_cliente_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_cliente_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_cliente_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cliente_destinoParametroFactuEmpresa() {
		return this.mostrarid_cliente_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_cliente_destinoParametroFactuEmpresa(Boolean mostrarid_cliente_destinoParametroFactuEmpresa) {
		this.mostrarid_cliente_destinoParametroFactuEmpresa= mostrarid_cliente_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_cliente_destinoParametroFactuEmpresa() {
		return this.activarid_cliente_destinoParametroFactuEmpresa;
	}

	public void setActivarid_cliente_destinoParametroFactuEmpresa(Boolean activarid_cliente_destinoParametroFactuEmpresa) {
		this.activarid_cliente_destinoParametroFactuEmpresa= activarid_cliente_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_cliente_destinoParametroFactuEmpresa() {
		return this.cargarid_cliente_destinoParametroFactuEmpresa;
	}

	public void setCargarid_cliente_destinoParametroFactuEmpresa(Boolean cargarid_cliente_destinoParametroFactuEmpresa) {
		this.cargarid_cliente_destinoParametroFactuEmpresa= cargarid_cliente_destinoParametroFactuEmpresa;
	}

	public Border setResaltarcosto_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarcosto_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_destinoParametroFactuEmpresa() {
		return this.resaltarcosto_destinoParametroFactuEmpresa;
	}

	public void setResaltarcosto_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarcosto_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarcosto_destinoParametroFactuEmpresa() {
		return this.mostrarcosto_destinoParametroFactuEmpresa;
	}

	public void setMostrarcosto_destinoParametroFactuEmpresa(Boolean mostrarcosto_destinoParametroFactuEmpresa) {
		this.mostrarcosto_destinoParametroFactuEmpresa= mostrarcosto_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarcosto_destinoParametroFactuEmpresa() {
		return this.activarcosto_destinoParametroFactuEmpresa;
	}

	public void setActivarcosto_destinoParametroFactuEmpresa(Boolean activarcosto_destinoParametroFactuEmpresa) {
		this.activarcosto_destinoParametroFactuEmpresa= activarcosto_destinoParametroFactuEmpresa;
	}

	public Border setResaltarcon_transferenciaParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarcon_transferenciaParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_transferenciaParametroFactuEmpresa() {
		return this.resaltarcon_transferenciaParametroFactuEmpresa;
	}

	public void setResaltarcon_transferenciaParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarcon_transferenciaParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarcon_transferenciaParametroFactuEmpresa() {
		return this.mostrarcon_transferenciaParametroFactuEmpresa;
	}

	public void setMostrarcon_transferenciaParametroFactuEmpresa(Boolean mostrarcon_transferenciaParametroFactuEmpresa) {
		this.mostrarcon_transferenciaParametroFactuEmpresa= mostrarcon_transferenciaParametroFactuEmpresa;
	}

	public Boolean getActivarcon_transferenciaParametroFactuEmpresa() {
		return this.activarcon_transferenciaParametroFactuEmpresa;
	}

	public void setActivarcon_transferenciaParametroFactuEmpresa(Boolean activarcon_transferenciaParametroFactuEmpresa) {
		this.activarcon_transferenciaParametroFactuEmpresa= activarcon_transferenciaParametroFactuEmpresa;
	}

	public Border setResaltarid_empresa_multi_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresa_multi_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_multi_destinoParametroFactuEmpresa() {
		return this.resaltarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_empresa_multi_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_empresa_multi_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresa_multi_destinoParametroFactuEmpresa() {
		return this.mostrarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_empresa_multi_destinoParametroFactuEmpresa(Boolean mostrarid_empresa_multi_destinoParametroFactuEmpresa) {
		this.mostrarid_empresa_multi_destinoParametroFactuEmpresa= mostrarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_empresa_multi_destinoParametroFactuEmpresa() {
		return this.activarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public void setActivarid_empresa_multi_destinoParametroFactuEmpresa(Boolean activarid_empresa_multi_destinoParametroFactuEmpresa) {
		this.activarid_empresa_multi_destinoParametroFactuEmpresa= activarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_empresa_multi_destinoParametroFactuEmpresa() {
		return this.cargarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public void setCargarid_empresa_multi_destinoParametroFactuEmpresa(Boolean cargarid_empresa_multi_destinoParametroFactuEmpresa) {
		this.cargarid_empresa_multi_destinoParametroFactuEmpresa= cargarid_empresa_multi_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_sucursal_multi_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_multi_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_multi_destinoParametroFactuEmpresa() {
		return this.resaltarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_sucursal_multi_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_sucursal_multi_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_multi_destinoParametroFactuEmpresa() {
		return this.mostrarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_sucursal_multi_destinoParametroFactuEmpresa(Boolean mostrarid_sucursal_multi_destinoParametroFactuEmpresa) {
		this.mostrarid_sucursal_multi_destinoParametroFactuEmpresa= mostrarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_sucursal_multi_destinoParametroFactuEmpresa() {
		return this.activarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public void setActivarid_sucursal_multi_destinoParametroFactuEmpresa(Boolean activarid_sucursal_multi_destinoParametroFactuEmpresa) {
		this.activarid_sucursal_multi_destinoParametroFactuEmpresa= activarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_sucursal_multi_destinoParametroFactuEmpresa() {
		return this.cargarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public void setCargarid_sucursal_multi_destinoParametroFactuEmpresa(Boolean cargarid_sucursal_multi_destinoParametroFactuEmpresa) {
		this.cargarid_sucursal_multi_destinoParametroFactuEmpresa= cargarid_sucursal_multi_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_transaccion_multi_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_multi_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_multi_destinoParametroFactuEmpresa() {
		return this.resaltarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_transaccion_multi_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_transaccion_multi_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_multi_destinoParametroFactuEmpresa() {
		return this.mostrarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_transaccion_multi_destinoParametroFactuEmpresa(Boolean mostrarid_transaccion_multi_destinoParametroFactuEmpresa) {
		this.mostrarid_transaccion_multi_destinoParametroFactuEmpresa= mostrarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_transaccion_multi_destinoParametroFactuEmpresa() {
		return this.activarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public void setActivarid_transaccion_multi_destinoParametroFactuEmpresa(Boolean activarid_transaccion_multi_destinoParametroFactuEmpresa) {
		this.activarid_transaccion_multi_destinoParametroFactuEmpresa= activarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_transaccion_multi_destinoParametroFactuEmpresa() {
		return this.cargarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public void setCargarid_transaccion_multi_destinoParametroFactuEmpresa(Boolean cargarid_transaccion_multi_destinoParametroFactuEmpresa) {
		this.cargarid_transaccion_multi_destinoParametroFactuEmpresa= cargarid_transaccion_multi_destinoParametroFactuEmpresa;
	}

	public Border setResaltarid_bodega_multi_origenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_bodega_multi_origenParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_multi_origenParametroFactuEmpresa() {
		return this.resaltarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public void setResaltarid_bodega_multi_origenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_bodega_multi_origenParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_bodega_multi_origenParametroFactuEmpresa() {
		return this.mostrarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public void setMostrarid_bodega_multi_origenParametroFactuEmpresa(Boolean mostrarid_bodega_multi_origenParametroFactuEmpresa) {
		this.mostrarid_bodega_multi_origenParametroFactuEmpresa= mostrarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public Boolean getActivarid_bodega_multi_origenParametroFactuEmpresa() {
		return this.activarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public void setActivarid_bodega_multi_origenParametroFactuEmpresa(Boolean activarid_bodega_multi_origenParametroFactuEmpresa) {
		this.activarid_bodega_multi_origenParametroFactuEmpresa= activarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public Boolean getCargarid_bodega_multi_origenParametroFactuEmpresa() {
		return this.cargarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public void setCargarid_bodega_multi_origenParametroFactuEmpresa(Boolean cargarid_bodega_multi_origenParametroFactuEmpresa) {
		this.cargarid_bodega_multi_origenParametroFactuEmpresa= cargarid_bodega_multi_origenParametroFactuEmpresa;
	}

	public Border setResaltarid_bodega_multi_destinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactuempresaBeanSwingJInternalFrame.jTtoolBarParametroFactuEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_bodega_multi_destinoParametroFactuEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_multi_destinoParametroFactuEmpresa() {
		return this.resaltarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public void setResaltarid_bodega_multi_destinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarid_bodega_multi_destinoParametroFactuEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_bodega_multi_destinoParametroFactuEmpresa() {
		return this.mostrarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public void setMostrarid_bodega_multi_destinoParametroFactuEmpresa(Boolean mostrarid_bodega_multi_destinoParametroFactuEmpresa) {
		this.mostrarid_bodega_multi_destinoParametroFactuEmpresa= mostrarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getActivarid_bodega_multi_destinoParametroFactuEmpresa() {
		return this.activarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public void setActivarid_bodega_multi_destinoParametroFactuEmpresa(Boolean activarid_bodega_multi_destinoParametroFactuEmpresa) {
		this.activarid_bodega_multi_destinoParametroFactuEmpresa= activarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public Boolean getCargarid_bodega_multi_destinoParametroFactuEmpresa() {
		return this.cargarid_bodega_multi_destinoParametroFactuEmpresa;
	}

	public void setCargarid_bodega_multi_destinoParametroFactuEmpresa(Boolean cargarid_bodega_multi_destinoParametroFactuEmpresa) {
		this.cargarid_bodega_multi_destinoParametroFactuEmpresa= cargarid_bodega_multi_destinoParametroFactuEmpresa;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridParametroFactuEmpresa(esInicial);
		this.setMostrarid_empresaParametroFactuEmpresa(esInicial);
		this.setMostrarid_empresa_origenParametroFactuEmpresa(esInicial);
		this.setMostrarid_sucursalParametroFactuEmpresa(esInicial);
		this.setMostrarid_transaccion_origenParametroFactuEmpresa(esInicial);
		this.setMostrarid_bodega_origenParametroFactuEmpresa(esInicial);
		this.setMostrarid_cliente_origenParametroFactuEmpresa(esInicial);
		this.setMostrarcosto_origenParametroFactuEmpresa(esInicial);
		this.setMostrarid_empresa_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_sucursal_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_transaccion_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_bodega_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_cliente_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarcosto_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarcon_transferenciaParametroFactuEmpresa(esInicial);
		this.setMostrarid_empresa_multi_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_sucursal_multi_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_transaccion_multi_destinoParametroFactuEmpresa(esInicial);
		this.setMostrarid_bodega_multi_origenParametroFactuEmpresa(esInicial);
		this.setMostrarid_bodega_multi_destinoParametroFactuEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.ID)) {
				this.setMostraridParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setMostrarid_empresa_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN)) {
				this.setMostrarid_transaccion_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN)) {
				this.setMostrarid_bodega_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN)) {
				this.setMostrarid_cliente_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN)) {
				this.setMostrarcosto_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO)) {
				this.setMostrarid_empresa_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setMostrarid_sucursal_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO)) {
				this.setMostrarid_transaccion_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO)) {
				this.setMostrarid_bodega_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO)) {
				this.setMostrarid_cliente_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTODESTINO)) {
				this.setMostrarcosto_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA)) {
				this.setMostrarcon_transferenciaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO)) {
				this.setMostrarid_empresa_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO)) {
				this.setMostrarid_sucursal_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO)) {
				this.setMostrarid_transaccion_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN)) {
				this.setMostrarid_bodega_multi_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO)) {
				this.setMostrarid_bodega_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridParametroFactuEmpresa(esInicial);
		this.setActivarid_empresaParametroFactuEmpresa(esInicial);
		this.setActivarid_empresa_origenParametroFactuEmpresa(esInicial);
		this.setActivarid_sucursalParametroFactuEmpresa(esInicial);
		this.setActivarid_transaccion_origenParametroFactuEmpresa(esInicial);
		this.setActivarid_bodega_origenParametroFactuEmpresa(esInicial);
		this.setActivarid_cliente_origenParametroFactuEmpresa(esInicial);
		this.setActivarcosto_origenParametroFactuEmpresa(esInicial);
		this.setActivarid_empresa_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_sucursal_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_transaccion_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_bodega_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_cliente_destinoParametroFactuEmpresa(esInicial);
		this.setActivarcosto_destinoParametroFactuEmpresa(esInicial);
		this.setActivarcon_transferenciaParametroFactuEmpresa(esInicial);
		this.setActivarid_empresa_multi_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_sucursal_multi_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_transaccion_multi_destinoParametroFactuEmpresa(esInicial);
		this.setActivarid_bodega_multi_origenParametroFactuEmpresa(esInicial);
		this.setActivarid_bodega_multi_destinoParametroFactuEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.ID)) {
				this.setActivaridParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setActivarid_empresa_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN)) {
				this.setActivarid_transaccion_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN)) {
				this.setActivarid_bodega_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN)) {
				this.setActivarid_cliente_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN)) {
				this.setActivarcosto_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO)) {
				this.setActivarid_empresa_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setActivarid_sucursal_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO)) {
				this.setActivarid_transaccion_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO)) {
				this.setActivarid_bodega_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO)) {
				this.setActivarid_cliente_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTODESTINO)) {
				this.setActivarcosto_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA)) {
				this.setActivarcon_transferenciaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO)) {
				this.setActivarid_empresa_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO)) {
				this.setActivarid_sucursal_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO)) {
				this.setActivarid_transaccion_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN)) {
				this.setActivarid_bodega_multi_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO)) {
				this.setActivarid_bodega_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFactuEmpresa(esInicial);
		this.setResaltarid_empresaParametroFactuEmpresa(esInicial);
		this.setResaltarid_empresa_origenParametroFactuEmpresa(esInicial);
		this.setResaltarid_sucursalParametroFactuEmpresa(esInicial);
		this.setResaltarid_transaccion_origenParametroFactuEmpresa(esInicial);
		this.setResaltarid_bodega_origenParametroFactuEmpresa(esInicial);
		this.setResaltarid_cliente_origenParametroFactuEmpresa(esInicial);
		this.setResaltarcosto_origenParametroFactuEmpresa(esInicial);
		this.setResaltarid_empresa_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_sucursal_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_transaccion_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_bodega_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_cliente_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarcosto_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarcon_transferenciaParametroFactuEmpresa(esInicial);
		this.setResaltarid_empresa_multi_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_sucursal_multi_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_transaccion_multi_destinoParametroFactuEmpresa(esInicial);
		this.setResaltarid_bodega_multi_origenParametroFactuEmpresa(esInicial);
		this.setResaltarid_bodega_multi_destinoParametroFactuEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.ID)) {
				this.setResaltaridParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setResaltarid_empresa_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN)) {
				this.setResaltarid_transaccion_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN)) {
				this.setResaltarid_bodega_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN)) {
				this.setResaltarid_cliente_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN)) {
				this.setResaltarcosto_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO)) {
				this.setResaltarid_empresa_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setResaltarid_sucursal_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO)) {
				this.setResaltarid_transaccion_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO)) {
				this.setResaltarid_bodega_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO)) {
				this.setResaltarid_cliente_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.COSTODESTINO)) {
				this.setResaltarcosto_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA)) {
				this.setResaltarcon_transferenciaParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO)) {
				this.setResaltarid_empresa_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO)) {
				this.setResaltarid_sucursal_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO)) {
				this.setResaltarid_transaccion_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN)) {
				this.setResaltarid_bodega_multi_origenParametroFactuEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO)) {
				this.setResaltarid_bodega_multi_destinoParametroFactuEmpresa(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdBodegaDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdBodegaDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdBodegaDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaMultiDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdBodegaMultiDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdBodegaMultiDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdBodegaMultiDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaMultiDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaMultiOrigenParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdBodegaMultiOrigenParametroFactuEmpresa() {
		return this.mostrarFK_IdBodegaMultiOrigenParametroFactuEmpresa;
	}

	public void setMostrarFK_IdBodegaMultiOrigenParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaMultiOrigenParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaOrigenParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdBodegaOrigenParametroFactuEmpresa() {
		return this.mostrarFK_IdBodegaOrigenParametroFactuEmpresa;
	}

	public void setMostrarFK_IdBodegaOrigenParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaOrigenParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdClienteDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdClienteDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdClienteDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteOrigenParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdClienteOrigenParametroFactuEmpresa() {
		return this.mostrarFK_IdClienteOrigenParametroFactuEmpresa;
	}

	public void setMostrarFK_IdClienteOrigenParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteOrigenParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaParametroFactuEmpresa() {
		return this.mostrarFK_IdEmpresaParametroFactuEmpresa;
	}

	public void setMostrarFK_IdEmpresaParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdEmpresaDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdEmpresaDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMultiDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaMultiDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdEmpresaMultiDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdEmpresaMultiDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMultiDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaOrigenParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaOrigenParametroFactuEmpresa() {
		return this.mostrarFK_IdEmpresaOrigenParametroFactuEmpresa;
	}

	public void setMostrarFK_IdEmpresaOrigenParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaOrigenParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdSucursalParametroFactuEmpresa() {
		return this.mostrarFK_IdSucursalParametroFactuEmpresa;
	}

	public void setMostrarFK_IdSucursalParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdSucursalDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdSucursalDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdSucursalDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMultiDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdSucursalMultiDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdSucursalMultiDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdSucursalMultiDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMultiDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdTransaccionDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdTransaccionDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdTransaccionDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionMultiDestinoParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdTransaccionMultiDestinoParametroFactuEmpresa() {
		return this.mostrarFK_IdTransaccionMultiDestinoParametroFactuEmpresa;
	}

	public void setMostrarFK_IdTransaccionMultiDestinoParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionMultiDestinoParametroFactuEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionOrigenParametroFactuEmpresa=true;

	public Boolean getMostrarFK_IdTransaccionOrigenParametroFactuEmpresa() {
		return this.mostrarFK_IdTransaccionOrigenParametroFactuEmpresa;
	}

	public void setMostrarFK_IdTransaccionOrigenParametroFactuEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionOrigenParametroFactuEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdBodegaDestinoParametroFactuEmpresa() {
		return this.activarFK_IdBodegaDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdBodegaDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaMultiDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdBodegaMultiDestinoParametroFactuEmpresa() {
		return this.activarFK_IdBodegaMultiDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdBodegaMultiDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaMultiDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaMultiOrigenParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdBodegaMultiOrigenParametroFactuEmpresa() {
		return this.activarFK_IdBodegaMultiOrigenParametroFactuEmpresa;
	}

	public void setActivarFK_IdBodegaMultiOrigenParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaMultiOrigenParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaOrigenParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdBodegaOrigenParametroFactuEmpresa() {
		return this.activarFK_IdBodegaOrigenParametroFactuEmpresa;
	}

	public void setActivarFK_IdBodegaOrigenParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaOrigenParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdClienteDestinoParametroFactuEmpresa() {
		return this.activarFK_IdClienteDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdClienteDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteOrigenParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdClienteOrigenParametroFactuEmpresa() {
		return this.activarFK_IdClienteOrigenParametroFactuEmpresa;
	}

	public void setActivarFK_IdClienteOrigenParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdClienteOrigenParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdEmpresaParametroFactuEmpresa() {
		return this.activarFK_IdEmpresaParametroFactuEmpresa;
	}

	public void setActivarFK_IdEmpresaParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdEmpresaDestinoParametroFactuEmpresa() {
		return this.activarFK_IdEmpresaDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdEmpresaDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMultiDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdEmpresaMultiDestinoParametroFactuEmpresa() {
		return this.activarFK_IdEmpresaMultiDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdEmpresaMultiDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMultiDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaOrigenParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdEmpresaOrigenParametroFactuEmpresa() {
		return this.activarFK_IdEmpresaOrigenParametroFactuEmpresa;
	}

	public void setActivarFK_IdEmpresaOrigenParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaOrigenParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdSucursalParametroFactuEmpresa() {
		return this.activarFK_IdSucursalParametroFactuEmpresa;
	}

	public void setActivarFK_IdSucursalParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdSucursalDestinoParametroFactuEmpresa() {
		return this.activarFK_IdSucursalDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdSucursalDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMultiDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdSucursalMultiDestinoParametroFactuEmpresa() {
		return this.activarFK_IdSucursalMultiDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdSucursalMultiDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMultiDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdTransaccionDestinoParametroFactuEmpresa() {
		return this.activarFK_IdTransaccionDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdTransaccionDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionMultiDestinoParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdTransaccionMultiDestinoParametroFactuEmpresa() {
		return this.activarFK_IdTransaccionMultiDestinoParametroFactuEmpresa;
	}

	public void setActivarFK_IdTransaccionMultiDestinoParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionMultiDestinoParametroFactuEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionOrigenParametroFactuEmpresa=true;

	public Boolean getActivarFK_IdTransaccionOrigenParametroFactuEmpresa() {
		return this.activarFK_IdTransaccionOrigenParametroFactuEmpresa;
	}

	public void setActivarFK_IdTransaccionOrigenParametroFactuEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionOrigenParametroFactuEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdBodegaDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdBodegaDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdBodegaDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdBodegaDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa=null;

	public Border getResaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa() {
		return this.resaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa;
	}

	public void setResaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaMultiOrigenParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdBodegaOrigenParametroFactuEmpresa=null;

	public Border getResaltarFK_IdBodegaOrigenParametroFactuEmpresa() {
		return this.resaltarFK_IdBodegaOrigenParametroFactuEmpresa;
	}

	public void setResaltarFK_IdBodegaOrigenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdBodegaOrigenParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdBodegaOrigenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaOrigenParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdClienteDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdClienteDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdClienteDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdClienteDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdClienteDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdClienteDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdClienteOrigenParametroFactuEmpresa=null;

	public Border getResaltarFK_IdClienteOrigenParametroFactuEmpresa() {
		return this.resaltarFK_IdClienteOrigenParametroFactuEmpresa;
	}

	public void setResaltarFK_IdClienteOrigenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdClienteOrigenParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdClienteOrigenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteOrigenParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroFactuEmpresa=null;

	public Border getResaltarFK_IdEmpresaParametroFactuEmpresa() {
		return this.resaltarFK_IdEmpresaParametroFactuEmpresa;
	}

	public void setResaltarFK_IdEmpresaParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdEmpresaDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdEmpresaDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdEmpresaDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaOrigenParametroFactuEmpresa=null;

	public Border getResaltarFK_IdEmpresaOrigenParametroFactuEmpresa() {
		return this.resaltarFK_IdEmpresaOrigenParametroFactuEmpresa;
	}

	public void setResaltarFK_IdEmpresaOrigenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaOrigenParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaOrigenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaOrigenParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFactuEmpresa=null;

	public Border getResaltarFK_IdSucursalParametroFactuEmpresa() {
		return this.resaltarFK_IdSucursalParametroFactuEmpresa;
	}

	public void setResaltarFK_IdSucursalParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdSucursalDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdSucursalDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdSucursalDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdSucursalDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdTransaccionDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdTransaccionDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdTransaccionDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa=null;

	public Border getResaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa() {
		return this.resaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa;
	}

	public void setResaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionMultiDestinoParametroFactuEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionOrigenParametroFactuEmpresa=null;

	public Border getResaltarFK_IdTransaccionOrigenParametroFactuEmpresa() {
		return this.resaltarFK_IdTransaccionOrigenParametroFactuEmpresa;
	}

	public void setResaltarFK_IdTransaccionOrigenParametroFactuEmpresa(Border borderResaltar) {
		this.resaltarFK_IdTransaccionOrigenParametroFactuEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionOrigenParametroFactuEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuEmpresaBeanSwingJInternalFrame parametrofactuempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionOrigenParametroFactuEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}