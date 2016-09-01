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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ParametroInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroInvenConstantesFunciones extends ParametroInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroInven"+ParametroInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroInvenConstantesFunciones.SCHEMA+"_"+ParametroInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroInvenConstantesFunciones.SCHEMA+"_"+ParametroInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroInvenConstantesFunciones.SCHEMA+"_"+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroInvenConstantesFunciones.SCHEMA+"_"+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Inven";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroInven";
	public static final String OBJECTNAME="parametroinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="parametro_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroinven from "+ParametroInvenConstantesFunciones.SPERSISTENCENAME+" parametroinven";
	public static String QUERYSELECTNATIVE="select "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".id,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".version_row,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".id_empresa,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".secuencial_pedido,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_serie,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_decimales,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_items_requisicion,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_contable,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_contable_linea,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_banco,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_copiar_producto,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_crear_producto_sucursal,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_crear_lista_precio_sucursal_bodega,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_compras_aprobacion,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_envio_mail from "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME;//+" as "+ParametroInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroInvenConstantesFuncionesAdditional parametroinvenConstantesFuncionesAdditional=null;
	
	public ParametroInvenConstantesFuncionesAdditional getParametroInvenConstantesFuncionesAdditional() {
		return this.parametroinvenConstantesFuncionesAdditional;
	}
	
	public void setParametroInvenConstantesFuncionesAdditional(ParametroInvenConstantesFuncionesAdditional parametroinvenConstantesFuncionesAdditional) {
		try {
			this.parametroinvenConstantesFuncionesAdditional=parametroinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String SECUENCIALPEDIDO= "secuencial_pedido";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMERODECIMALES= "numero_decimales";
    public static final String NUMEROITEMSREQUISICION= "numero_items_requisicion";
    public static final String CONCUENTACONTABLE= "con_cuenta_contable";
    public static final String CONCUENTACONTABLELINEA= "con_cuenta_contable_linea";
    public static final String CONCUENTABANCO= "con_cuenta_banco";
    public static final String CONCOPIARPRODUCTO= "con_copiar_producto";
    public static final String CONCREARPRODUCTOSUCURSAL= "con_crear_producto_sucursal";
    public static final String CONCREARLISTAPRECIOSUCURSALBODEGA= "con_crear_lista_precio_sucursal_bodega";
    public static final String CONCOMPRASAPROBACION= "con_compras_aprobacion";
    public static final String CONENVIOMAIL= "con_envio_mail";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_SECUENCIALPEDIDO= "Secuencial Pedido";
		public static final String LABEL_SECUENCIALPEDIDO_LOWER= "Secuencial Pedido";
    	public static final String LABEL_NUMEROSERIE= "No Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_NUMERODECIMALES= "No Decimales";
		public static final String LABEL_NUMERODECIMALES_LOWER= "Numero Decimales";
    	public static final String LABEL_NUMEROITEMSREQUISICION= "No Items Requisicion";
		public static final String LABEL_NUMEROITEMSREQUISICION_LOWER= "Numero Items Requisicion";
    	public static final String LABEL_CONCUENTACONTABLE= "Con Cuenta Contable";
		public static final String LABEL_CONCUENTACONTABLE_LOWER= "Con Cuenta Contable";
    	public static final String LABEL_CONCUENTACONTABLELINEA= "Con Cuenta Contable Linea";
		public static final String LABEL_CONCUENTACONTABLELINEA_LOWER= "Con Cuenta Contable Linea";
    	public static final String LABEL_CONCUENTABANCO= "Con Cuenta Banco";
		public static final String LABEL_CONCUENTABANCO_LOWER= "Con Cuenta Banco";
    	public static final String LABEL_CONCOPIARPRODUCTO= "Copiar Producto";
		public static final String LABEL_CONCOPIARPRODUCTO_LOWER= "Con Copiar Producto";
    	public static final String LABEL_CONCREARPRODUCTOSUCURSAL= "Crear Producto Sucursal";
		public static final String LABEL_CONCREARPRODUCTOSUCURSAL_LOWER= "Con Crear Producto Sucursal";
    	public static final String LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA= "Crear Lista Precio Sucursal Bodega";
		public static final String LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA_LOWER= "Con Crear Lista Precio Sucursal Bodega";
    	public static final String LABEL_CONCOMPRASAPROBACION= "Compras Aprobacion";
		public static final String LABEL_CONCOMPRASAPROBACION_LOWER= "Con Compras Aprobacion";
    	public static final String LABEL_CONENVIOMAIL= "Envio Mail";
		public static final String LABEL_CONENVIOMAIL_LOWER= "Con Envio Mail";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.SECUENCIALPEDIDO)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_SECUENCIALPEDIDO;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.NUMEROSERIE)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.NUMERODECIMALES)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_NUMERODECIMALES;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_NUMEROITEMSREQUISICION;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLE)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLE;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLELINEA;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCUENTABANCO)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCUENTABANCO;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCOPIARPRODUCTO;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCREARPRODUCTOSUCURSAL;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONCOMPRASAPROBACION;}
		if(sNombreColumna.equals(ParametroInvenConstantesFunciones.CONENVIOMAIL)) {sLabelColumna=ParametroInvenConstantesFunciones.LABEL_CONENVIOMAIL;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getcon_cuenta_contableDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_cuenta_contable()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuenta_contableHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_cuenta_contable());

		return sDescripcion;
	}	
		
	public static String getcon_cuenta_contable_lineaDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_cuenta_contable_linea()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuenta_contable_lineaHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_cuenta_contable_linea());

		return sDescripcion;
	}	
		
	public static String getcon_cuenta_bancoDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_cuenta_banco()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuenta_bancoHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_cuenta_banco());

		return sDescripcion;
	}	
		
	public static String getcon_copiar_productoDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_copiar_producto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_copiar_productoHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_copiar_producto());

		return sDescripcion;
	}	
		
	public static String getcon_crear_producto_sucursalDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_crear_producto_sucursal()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_crear_producto_sucursalHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_crear_producto_sucursal());

		return sDescripcion;
	}	
		
	public static String getcon_crear_lista_precio_sucursal_bodegaDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_crear_lista_precio_sucursal_bodega()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_crear_lista_precio_sucursal_bodegaHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_crear_lista_precio_sucursal_bodega());

		return sDescripcion;
	}	
		
	public static String getcon_compras_aprobacionDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_compras_aprobacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_compras_aprobacionHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_compras_aprobacion());

		return sDescripcion;
	}	
		
	public static String getcon_envio_mailDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroinven.getcon_envio_mail()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_envio_mailHtmlDescripcion(ParametroInven parametroinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroinven.getId(),parametroinven.getcon_envio_mail());

		return sDescripcion;
	}	
	
	public static String getParametroInvenDescripcion(ParametroInven parametroinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroinven !=null/* && parametroinven.getId()!=0*/) {
			if(parametroinven.getId()!=null) {
				sDescripcion=parametroinven.getId().toString();
			}//parametroinvenparametroinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroInvenDescripcionDetallado(ParametroInven parametroinven) {
		String sDescripcion="";
			
		sDescripcion+=ParametroInvenConstantesFunciones.ID+"=";
		sDescripcion+=parametroinven.getId().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroinven.getVersionRow().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroinven.getid_empresa().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.SECUENCIALPEDIDO+"=";
		sDescripcion+=parametroinven.getsecuencial_pedido().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=parametroinven.getnumero_serie().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.NUMERODECIMALES+"=";
		sDescripcion+=parametroinven.getnumero_decimales().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION+"=";
		sDescripcion+=parametroinven.getnumero_items_requisicion().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCUENTACONTABLE+"=";
		sDescripcion+=parametroinven.getcon_cuenta_contable().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA+"=";
		sDescripcion+=parametroinven.getcon_cuenta_contable_linea().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCUENTABANCO+"=";
		sDescripcion+=parametroinven.getcon_cuenta_banco().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO+"=";
		sDescripcion+=parametroinven.getcon_copiar_producto().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL+"=";
		sDescripcion+=parametroinven.getcon_crear_producto_sucursal().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA+"=";
		sDescripcion+=parametroinven.getcon_crear_lista_precio_sucursal_bodega().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION+"=";
		sDescripcion+=parametroinven.getcon_compras_aprobacion().toString()+",";
		sDescripcion+=ParametroInvenConstantesFunciones.CONENVIOMAIL+"=";
		sDescripcion+=parametroinven.getcon_envio_mail().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroInvenDescripcion(ParametroInven parametroinven,String sValor) throws Exception {			
		if(parametroinven !=null) {
			//parametroinvenparametroinven.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroInven(ParametroInven parametroinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroInvens(List<ParametroInven> parametroinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroInven parametroinven: parametroinvens) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroInven(ParametroInven parametroinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroinven.getConCambioAuxiliar()) {
			parametroinven.setIsDeleted(parametroinven.getIsDeletedAuxiliar());	
			parametroinven.setIsNew(parametroinven.getIsNewAuxiliar());	
			parametroinven.setIsChanged(parametroinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroinven.setIsDeletedAuxiliar(false);	
			parametroinven.setIsNewAuxiliar(false);	
			parametroinven.setIsChangedAuxiliar(false);
			
			parametroinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroInvens(List<ParametroInven> parametroinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroInven parametroinven : parametroinvens) {
			if(conAsignarBase && parametroinven.getConCambioAuxiliar()) {
				parametroinven.setIsDeleted(parametroinven.getIsDeletedAuxiliar());	
				parametroinven.setIsNew(parametroinven.getIsNewAuxiliar());	
				parametroinven.setIsChanged(parametroinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroinven.setIsDeletedAuxiliar(false);	
				parametroinven.setIsNewAuxiliar(false);	
				parametroinven.setIsChangedAuxiliar(false);
				
				parametroinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroInven(ParametroInven parametroinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroinven.setsecuencial_pedido(0);
			parametroinven.setnumero_serie(0);
			parametroinven.setnumero_decimales(0);
			parametroinven.setnumero_items_requisicion(0);
		}
	}		
	
	public static void InicializarValoresParametroInvens(List<ParametroInven> parametroinvens,Boolean conEnteros) throws Exception  {
		
		for(ParametroInven parametroinven: parametroinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroinven.setsecuencial_pedido(0);
				parametroinven.setnumero_serie(0);
				parametroinven.setnumero_decimales(0);
				parametroinven.setnumero_items_requisicion(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroInven(List<ParametroInven> parametroinvens,ParametroInven parametroinvenAux) throws Exception  {
		ParametroInvenConstantesFunciones.InicializarValoresParametroInven(parametroinvenAux,true);
		
		for(ParametroInven parametroinven: parametroinvens) {
			if(parametroinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametroinvenAux.setsecuencial_pedido(parametroinvenAux.getsecuencial_pedido()+parametroinven.getsecuencial_pedido());			
			parametroinvenAux.setnumero_serie(parametroinvenAux.getnumero_serie()+parametroinven.getnumero_serie());			
			parametroinvenAux.setnumero_decimales(parametroinvenAux.getnumero_decimales()+parametroinven.getnumero_decimales());			
			parametroinvenAux.setnumero_items_requisicion(parametroinvenAux.getnumero_items_requisicion()+parametroinven.getnumero_items_requisicion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroInvenConstantesFunciones.getArrayColumnasGlobalesParametroInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroInven> parametroinvens,ParametroInven parametroinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroInven parametroinvenAux: parametroinvens) {
			if(parametroinvenAux!=null && parametroinven!=null) {
				if((parametroinvenAux.getId()==null && parametroinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroinvenAux.getId()!=null && parametroinven.getId()!=null){
					if(parametroinvenAux.getId().equals(parametroinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroInven(List<ParametroInven> parametroinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroInven parametroinven: parametroinvens) {			
			if(parametroinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_ID, ParametroInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_VERSIONROW, ParametroInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_IDEMPRESA, ParametroInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_SECUENCIALPEDIDO, ParametroInvenConstantesFunciones.SECUENCIALPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_NUMEROSERIE, ParametroInvenConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_NUMERODECIMALES, ParametroInvenConstantesFunciones.NUMERODECIMALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_NUMEROITEMSREQUISICION, ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLE, ParametroInvenConstantesFunciones.CONCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLELINEA, ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCUENTABANCO, ParametroInvenConstantesFunciones.CONCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCOPIARPRODUCTO, ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCREARPRODUCTOSUCURSAL, ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA, ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONCOMPRASAPROBACION, ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInvenConstantesFunciones.LABEL_CONENVIOMAIL, ParametroInvenConstantesFunciones.CONENVIOMAIL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.SECUENCIALPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.NUMERODECIMALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInvenConstantesFunciones.CONENVIOMAIL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInven() throws Exception  {
		return ParametroInvenConstantesFunciones.getTiposSeleccionarParametroInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInven(Boolean conFk) throws Exception  {
		return ParametroInvenConstantesFunciones.getTiposSeleccionarParametroInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_SECUENCIALPEDIDO);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_SECUENCIALPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_NUMERODECIMALES);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_NUMERODECIMALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_NUMEROITEMSREQUISICION);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_NUMEROITEMSREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLE);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLELINEA);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCUENTABANCO);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCOPIARPRODUCTO);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCOPIARPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCREARPRODUCTOSUCURSAL);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCREARPRODUCTOSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONCOMPRASAPROBACION);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONCOMPRASAPROBACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInvenConstantesFunciones.LABEL_CONENVIOMAIL);
			reporte.setsDescripcion(ParametroInvenConstantesFunciones.LABEL_CONENVIOMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroInven(ParametroInven parametroinvenAux) throws Exception {
		
			parametroinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroinvenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroInven(List<ParametroInven> parametroinvensTemp) throws Exception {
		for(ParametroInven parametroinvenAux:parametroinvensTemp) {
			
			parametroinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroinvenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroInvenConstantesFunciones.getClassesRelationshipsOfParametroInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroInvenConstantesFunciones.getClassesRelationshipsFromStringsOfParametroInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroInven parametroinven,List<ParametroInven> parametroinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroInven parametroinvenEncontrado=null;
			
			for(ParametroInven parametroinvenLocal:parametroinvens) {
				if(parametroinvenLocal.getId().equals(parametroinven.getId())) {
					parametroinvenEncontrado=parametroinvenLocal;
					
					parametroinvenLocal.setIsChanged(parametroinven.getIsChanged());
					parametroinvenLocal.setIsNew(parametroinven.getIsNew());
					parametroinvenLocal.setIsDeleted(parametroinven.getIsDeleted());
					
					parametroinvenLocal.setGeneralEntityOriginal(parametroinven.getGeneralEntityOriginal());
					
					parametroinvenLocal.setId(parametroinven.getId());	
					parametroinvenLocal.setVersionRow(parametroinven.getVersionRow());	
					parametroinvenLocal.setid_empresa(parametroinven.getid_empresa());	
					parametroinvenLocal.setsecuencial_pedido(parametroinven.getsecuencial_pedido());	
					parametroinvenLocal.setnumero_serie(parametroinven.getnumero_serie());	
					parametroinvenLocal.setnumero_decimales(parametroinven.getnumero_decimales());	
					parametroinvenLocal.setnumero_items_requisicion(parametroinven.getnumero_items_requisicion());	
					parametroinvenLocal.setcon_cuenta_contable(parametroinven.getcon_cuenta_contable());	
					parametroinvenLocal.setcon_cuenta_contable_linea(parametroinven.getcon_cuenta_contable_linea());	
					parametroinvenLocal.setcon_cuenta_banco(parametroinven.getcon_cuenta_banco());	
					parametroinvenLocal.setcon_copiar_producto(parametroinven.getcon_copiar_producto());	
					parametroinvenLocal.setcon_crear_producto_sucursal(parametroinven.getcon_crear_producto_sucursal());	
					parametroinvenLocal.setcon_crear_lista_precio_sucursal_bodega(parametroinven.getcon_crear_lista_precio_sucursal_bodega());	
					parametroinvenLocal.setcon_compras_aprobacion(parametroinven.getcon_compras_aprobacion());	
					parametroinvenLocal.setcon_envio_mail(parametroinven.getcon_envio_mail());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroinven.getIsDeleted()) {
				if(!existe) {
					parametroinvens.add(parametroinven);
				}
			} else {
				if(parametroinvenEncontrado!=null && permiteQuitar)  {
					parametroinvens.remove(parametroinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroInven parametroinven,List<ParametroInven> parametroinvens) throws Exception {
		try	{			
			for(ParametroInven parametroinvenLocal:parametroinvens) {
				if(parametroinvenLocal.getId().equals(parametroinven.getId())) {
					parametroinvenLocal.setIsSelected(parametroinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroInven(List<ParametroInven> parametroinvensAux) throws Exception {
		//this.parametroinvensAux=parametroinvensAux;
		
		for(ParametroInven parametroinvenAux:parametroinvensAux) {
			if(parametroinvenAux.getIsChanged()) {
				parametroinvenAux.setIsChanged(false);
			}		
			
			if(parametroinvenAux.getIsNew()) {
				parametroinvenAux.setIsNew(false);
			}	
			
			if(parametroinvenAux.getIsDeleted()) {
				parametroinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroInven(ParametroInven parametroinvenAux) throws Exception {
		//this.parametroinvenAux=parametroinvenAux;
		
			if(parametroinvenAux.getIsChanged()) {
				parametroinvenAux.setIsChanged(false);
			}		
			
			if(parametroinvenAux.getIsNew()) {
				parametroinvenAux.setIsNew(false);
			}	
			
			if(parametroinvenAux.getIsDeleted()) {
				parametroinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroInven parametroinvenAsignar,ParametroInven parametroinven) throws Exception {
		parametroinvenAsignar.setId(parametroinven.getId());	
		parametroinvenAsignar.setVersionRow(parametroinven.getVersionRow());	
		parametroinvenAsignar.setid_empresa(parametroinven.getid_empresa());
		parametroinvenAsignar.setempresa_descripcion(parametroinven.getempresa_descripcion());	
		parametroinvenAsignar.setsecuencial_pedido(parametroinven.getsecuencial_pedido());	
		parametroinvenAsignar.setnumero_serie(parametroinven.getnumero_serie());	
		parametroinvenAsignar.setnumero_decimales(parametroinven.getnumero_decimales());	
		parametroinvenAsignar.setnumero_items_requisicion(parametroinven.getnumero_items_requisicion());	
		parametroinvenAsignar.setcon_cuenta_contable(parametroinven.getcon_cuenta_contable());	
		parametroinvenAsignar.setcon_cuenta_contable_linea(parametroinven.getcon_cuenta_contable_linea());	
		parametroinvenAsignar.setcon_cuenta_banco(parametroinven.getcon_cuenta_banco());	
		parametroinvenAsignar.setcon_copiar_producto(parametroinven.getcon_copiar_producto());	
		parametroinvenAsignar.setcon_crear_producto_sucursal(parametroinven.getcon_crear_producto_sucursal());	
		parametroinvenAsignar.setcon_crear_lista_precio_sucursal_bodega(parametroinven.getcon_crear_lista_precio_sucursal_bodega());	
		parametroinvenAsignar.setcon_compras_aprobacion(parametroinven.getcon_compras_aprobacion());	
		parametroinvenAsignar.setcon_envio_mail(parametroinven.getcon_envio_mail());	
	}
	
	public static void inicializarParametroInven(ParametroInven parametroinven) throws Exception {
		try {
				parametroinven.setId(0L);	
					
				parametroinven.setid_empresa(-1L);	
				parametroinven.setsecuencial_pedido(0);	
				parametroinven.setnumero_serie(0);	
				parametroinven.setnumero_decimales(0);	
				parametroinven.setnumero_items_requisicion(0);	
				parametroinven.setcon_cuenta_contable(false);	
				parametroinven.setcon_cuenta_contable_linea(false);	
				parametroinven.setcon_cuenta_banco(false);	
				parametroinven.setcon_copiar_producto(false);	
				parametroinven.setcon_crear_producto_sucursal(false);	
				parametroinven.setcon_crear_lista_precio_sucursal_bodega(false);	
				parametroinven.setcon_compras_aprobacion(false);	
				parametroinven.setcon_envio_mail(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_SECUENCIALPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_NUMERODECIMALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_NUMEROITEMSREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCUENTACONTABLELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCOPIARPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCREARPRODUCTOSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCREARLISTAPRECIOSUCURSALBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONCOMPRASAPROBACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInvenConstantesFunciones.LABEL_CONENVIOMAIL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroInven(String sTipo,Row row,Workbook workbook,ParametroInven parametroinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinven.getsecuencial_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinven.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinven.getnumero_decimales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinven.getnumero_items_requisicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_cuenta_contable()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_cuenta_contable_linea()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_cuenta_banco()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_copiar_producto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_crear_producto_sucursal()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_crear_lista_precio_sucursal_bodega()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_compras_aprobacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroinven.getcon_envio_mail()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroInven() {
		return this.sFinalQueryParametroInven;
	}
	
	public void setsFinalQueryParametroInven(String sFinalQueryParametroInven) {
		this.sFinalQueryParametroInven= sFinalQueryParametroInven;
	}
	
	public Border resaltarSeleccionarParametroInven=null;
	
	public Border setResaltarSeleccionarParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroInven() {
		return this.resaltarSeleccionarParametroInven;
	}
	
	public void setResaltarSeleccionarParametroInven(Border borderResaltarSeleccionarParametroInven) {
		this.resaltarSeleccionarParametroInven= borderResaltarSeleccionarParametroInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroInven=null;
	public Boolean mostraridParametroInven=true;
	public Boolean activaridParametroInven=true;

	public Border resaltarid_empresaParametroInven=null;
	public Boolean mostrarid_empresaParametroInven=true;
	public Boolean activarid_empresaParametroInven=true;
	public Boolean cargarid_empresaParametroInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroInven=false;//ConEventDepend=true

	public Border resaltarsecuencial_pedidoParametroInven=null;
	public Boolean mostrarsecuencial_pedidoParametroInven=true;
	public Boolean activarsecuencial_pedidoParametroInven=true;

	public Border resaltarnumero_serieParametroInven=null;
	public Boolean mostrarnumero_serieParametroInven=true;
	public Boolean activarnumero_serieParametroInven=true;

	public Border resaltarnumero_decimalesParametroInven=null;
	public Boolean mostrarnumero_decimalesParametroInven=true;
	public Boolean activarnumero_decimalesParametroInven=true;

	public Border resaltarnumero_items_requisicionParametroInven=null;
	public Boolean mostrarnumero_items_requisicionParametroInven=true;
	public Boolean activarnumero_items_requisicionParametroInven=true;

	public Border resaltarcon_cuenta_contableParametroInven=null;
	public Boolean mostrarcon_cuenta_contableParametroInven=true;
	public Boolean activarcon_cuenta_contableParametroInven=true;

	public Border resaltarcon_cuenta_contable_lineaParametroInven=null;
	public Boolean mostrarcon_cuenta_contable_lineaParametroInven=true;
	public Boolean activarcon_cuenta_contable_lineaParametroInven=true;

	public Border resaltarcon_cuenta_bancoParametroInven=null;
	public Boolean mostrarcon_cuenta_bancoParametroInven=true;
	public Boolean activarcon_cuenta_bancoParametroInven=true;

	public Border resaltarcon_copiar_productoParametroInven=null;
	public Boolean mostrarcon_copiar_productoParametroInven=true;
	public Boolean activarcon_copiar_productoParametroInven=true;

	public Border resaltarcon_crear_producto_sucursalParametroInven=null;
	public Boolean mostrarcon_crear_producto_sucursalParametroInven=true;
	public Boolean activarcon_crear_producto_sucursalParametroInven=true;

	public Border resaltarcon_crear_lista_precio_sucursal_bodegaParametroInven=null;
	public Boolean mostrarcon_crear_lista_precio_sucursal_bodegaParametroInven=true;
	public Boolean activarcon_crear_lista_precio_sucursal_bodegaParametroInven=true;

	public Border resaltarcon_compras_aprobacionParametroInven=null;
	public Boolean mostrarcon_compras_aprobacionParametroInven=true;
	public Boolean activarcon_compras_aprobacionParametroInven=true;

	public Border resaltarcon_envio_mailParametroInven=null;
	public Boolean mostrarcon_envio_mailParametroInven=true;
	public Boolean activarcon_envio_mailParametroInven=true;

	
	

	public Border setResaltaridParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltaridParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroInven() {
		return this.resaltaridParametroInven;
	}

	public void setResaltaridParametroInven(Border borderResaltar) {
		this.resaltaridParametroInven= borderResaltar;
	}

	public Boolean getMostraridParametroInven() {
		return this.mostraridParametroInven;
	}

	public void setMostraridParametroInven(Boolean mostraridParametroInven) {
		this.mostraridParametroInven= mostraridParametroInven;
	}

	public Boolean getActivaridParametroInven() {
		return this.activaridParametroInven;
	}

	public void setActivaridParametroInven(Boolean activaridParametroInven) {
		this.activaridParametroInven= activaridParametroInven;
	}

	public Border setResaltarid_empresaParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroInven() {
		return this.resaltarid_empresaParametroInven;
	}

	public void setResaltarid_empresaParametroInven(Border borderResaltar) {
		this.resaltarid_empresaParametroInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroInven() {
		return this.mostrarid_empresaParametroInven;
	}

	public void setMostrarid_empresaParametroInven(Boolean mostrarid_empresaParametroInven) {
		this.mostrarid_empresaParametroInven= mostrarid_empresaParametroInven;
	}

	public Boolean getActivarid_empresaParametroInven() {
		return this.activarid_empresaParametroInven;
	}

	public void setActivarid_empresaParametroInven(Boolean activarid_empresaParametroInven) {
		this.activarid_empresaParametroInven= activarid_empresaParametroInven;
	}

	public Boolean getCargarid_empresaParametroInven() {
		return this.cargarid_empresaParametroInven;
	}

	public void setCargarid_empresaParametroInven(Boolean cargarid_empresaParametroInven) {
		this.cargarid_empresaParametroInven= cargarid_empresaParametroInven;
	}

	public Border setResaltarsecuencial_pedidoParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarsecuencial_pedidoParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_pedidoParametroInven() {
		return this.resaltarsecuencial_pedidoParametroInven;
	}

	public void setResaltarsecuencial_pedidoParametroInven(Border borderResaltar) {
		this.resaltarsecuencial_pedidoParametroInven= borderResaltar;
	}

	public Boolean getMostrarsecuencial_pedidoParametroInven() {
		return this.mostrarsecuencial_pedidoParametroInven;
	}

	public void setMostrarsecuencial_pedidoParametroInven(Boolean mostrarsecuencial_pedidoParametroInven) {
		this.mostrarsecuencial_pedidoParametroInven= mostrarsecuencial_pedidoParametroInven;
	}

	public Boolean getActivarsecuencial_pedidoParametroInven() {
		return this.activarsecuencial_pedidoParametroInven;
	}

	public void setActivarsecuencial_pedidoParametroInven(Boolean activarsecuencial_pedidoParametroInven) {
		this.activarsecuencial_pedidoParametroInven= activarsecuencial_pedidoParametroInven;
	}

	public Border setResaltarnumero_serieParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarnumero_serieParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieParametroInven() {
		return this.resaltarnumero_serieParametroInven;
	}

	public void setResaltarnumero_serieParametroInven(Border borderResaltar) {
		this.resaltarnumero_serieParametroInven= borderResaltar;
	}

	public Boolean getMostrarnumero_serieParametroInven() {
		return this.mostrarnumero_serieParametroInven;
	}

	public void setMostrarnumero_serieParametroInven(Boolean mostrarnumero_serieParametroInven) {
		this.mostrarnumero_serieParametroInven= mostrarnumero_serieParametroInven;
	}

	public Boolean getActivarnumero_serieParametroInven() {
		return this.activarnumero_serieParametroInven;
	}

	public void setActivarnumero_serieParametroInven(Boolean activarnumero_serieParametroInven) {
		this.activarnumero_serieParametroInven= activarnumero_serieParametroInven;
	}

	public Border setResaltarnumero_decimalesParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarnumero_decimalesParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_decimalesParametroInven() {
		return this.resaltarnumero_decimalesParametroInven;
	}

	public void setResaltarnumero_decimalesParametroInven(Border borderResaltar) {
		this.resaltarnumero_decimalesParametroInven= borderResaltar;
	}

	public Boolean getMostrarnumero_decimalesParametroInven() {
		return this.mostrarnumero_decimalesParametroInven;
	}

	public void setMostrarnumero_decimalesParametroInven(Boolean mostrarnumero_decimalesParametroInven) {
		this.mostrarnumero_decimalesParametroInven= mostrarnumero_decimalesParametroInven;
	}

	public Boolean getActivarnumero_decimalesParametroInven() {
		return this.activarnumero_decimalesParametroInven;
	}

	public void setActivarnumero_decimalesParametroInven(Boolean activarnumero_decimalesParametroInven) {
		this.activarnumero_decimalesParametroInven= activarnumero_decimalesParametroInven;
	}

	public Border setResaltarnumero_items_requisicionParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarnumero_items_requisicionParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_items_requisicionParametroInven() {
		return this.resaltarnumero_items_requisicionParametroInven;
	}

	public void setResaltarnumero_items_requisicionParametroInven(Border borderResaltar) {
		this.resaltarnumero_items_requisicionParametroInven= borderResaltar;
	}

	public Boolean getMostrarnumero_items_requisicionParametroInven() {
		return this.mostrarnumero_items_requisicionParametroInven;
	}

	public void setMostrarnumero_items_requisicionParametroInven(Boolean mostrarnumero_items_requisicionParametroInven) {
		this.mostrarnumero_items_requisicionParametroInven= mostrarnumero_items_requisicionParametroInven;
	}

	public Boolean getActivarnumero_items_requisicionParametroInven() {
		return this.activarnumero_items_requisicionParametroInven;
	}

	public void setActivarnumero_items_requisicionParametroInven(Boolean activarnumero_items_requisicionParametroInven) {
		this.activarnumero_items_requisicionParametroInven= activarnumero_items_requisicionParametroInven;
	}

	public Border setResaltarcon_cuenta_contableParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_cuenta_contableParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuenta_contableParametroInven() {
		return this.resaltarcon_cuenta_contableParametroInven;
	}

	public void setResaltarcon_cuenta_contableParametroInven(Border borderResaltar) {
		this.resaltarcon_cuenta_contableParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_cuenta_contableParametroInven() {
		return this.mostrarcon_cuenta_contableParametroInven;
	}

	public void setMostrarcon_cuenta_contableParametroInven(Boolean mostrarcon_cuenta_contableParametroInven) {
		this.mostrarcon_cuenta_contableParametroInven= mostrarcon_cuenta_contableParametroInven;
	}

	public Boolean getActivarcon_cuenta_contableParametroInven() {
		return this.activarcon_cuenta_contableParametroInven;
	}

	public void setActivarcon_cuenta_contableParametroInven(Boolean activarcon_cuenta_contableParametroInven) {
		this.activarcon_cuenta_contableParametroInven= activarcon_cuenta_contableParametroInven;
	}

	public Border setResaltarcon_cuenta_contable_lineaParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_cuenta_contable_lineaParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuenta_contable_lineaParametroInven() {
		return this.resaltarcon_cuenta_contable_lineaParametroInven;
	}

	public void setResaltarcon_cuenta_contable_lineaParametroInven(Border borderResaltar) {
		this.resaltarcon_cuenta_contable_lineaParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_cuenta_contable_lineaParametroInven() {
		return this.mostrarcon_cuenta_contable_lineaParametroInven;
	}

	public void setMostrarcon_cuenta_contable_lineaParametroInven(Boolean mostrarcon_cuenta_contable_lineaParametroInven) {
		this.mostrarcon_cuenta_contable_lineaParametroInven= mostrarcon_cuenta_contable_lineaParametroInven;
	}

	public Boolean getActivarcon_cuenta_contable_lineaParametroInven() {
		return this.activarcon_cuenta_contable_lineaParametroInven;
	}

	public void setActivarcon_cuenta_contable_lineaParametroInven(Boolean activarcon_cuenta_contable_lineaParametroInven) {
		this.activarcon_cuenta_contable_lineaParametroInven= activarcon_cuenta_contable_lineaParametroInven;
	}

	public Border setResaltarcon_cuenta_bancoParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_cuenta_bancoParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuenta_bancoParametroInven() {
		return this.resaltarcon_cuenta_bancoParametroInven;
	}

	public void setResaltarcon_cuenta_bancoParametroInven(Border borderResaltar) {
		this.resaltarcon_cuenta_bancoParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_cuenta_bancoParametroInven() {
		return this.mostrarcon_cuenta_bancoParametroInven;
	}

	public void setMostrarcon_cuenta_bancoParametroInven(Boolean mostrarcon_cuenta_bancoParametroInven) {
		this.mostrarcon_cuenta_bancoParametroInven= mostrarcon_cuenta_bancoParametroInven;
	}

	public Boolean getActivarcon_cuenta_bancoParametroInven() {
		return this.activarcon_cuenta_bancoParametroInven;
	}

	public void setActivarcon_cuenta_bancoParametroInven(Boolean activarcon_cuenta_bancoParametroInven) {
		this.activarcon_cuenta_bancoParametroInven= activarcon_cuenta_bancoParametroInven;
	}

	public Border setResaltarcon_copiar_productoParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_copiar_productoParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_copiar_productoParametroInven() {
		return this.resaltarcon_copiar_productoParametroInven;
	}

	public void setResaltarcon_copiar_productoParametroInven(Border borderResaltar) {
		this.resaltarcon_copiar_productoParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_copiar_productoParametroInven() {
		return this.mostrarcon_copiar_productoParametroInven;
	}

	public void setMostrarcon_copiar_productoParametroInven(Boolean mostrarcon_copiar_productoParametroInven) {
		this.mostrarcon_copiar_productoParametroInven= mostrarcon_copiar_productoParametroInven;
	}

	public Boolean getActivarcon_copiar_productoParametroInven() {
		return this.activarcon_copiar_productoParametroInven;
	}

	public void setActivarcon_copiar_productoParametroInven(Boolean activarcon_copiar_productoParametroInven) {
		this.activarcon_copiar_productoParametroInven= activarcon_copiar_productoParametroInven;
	}

	public Border setResaltarcon_crear_producto_sucursalParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_crear_producto_sucursalParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_crear_producto_sucursalParametroInven() {
		return this.resaltarcon_crear_producto_sucursalParametroInven;
	}

	public void setResaltarcon_crear_producto_sucursalParametroInven(Border borderResaltar) {
		this.resaltarcon_crear_producto_sucursalParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_crear_producto_sucursalParametroInven() {
		return this.mostrarcon_crear_producto_sucursalParametroInven;
	}

	public void setMostrarcon_crear_producto_sucursalParametroInven(Boolean mostrarcon_crear_producto_sucursalParametroInven) {
		this.mostrarcon_crear_producto_sucursalParametroInven= mostrarcon_crear_producto_sucursalParametroInven;
	}

	public Boolean getActivarcon_crear_producto_sucursalParametroInven() {
		return this.activarcon_crear_producto_sucursalParametroInven;
	}

	public void setActivarcon_crear_producto_sucursalParametroInven(Boolean activarcon_crear_producto_sucursalParametroInven) {
		this.activarcon_crear_producto_sucursalParametroInven= activarcon_crear_producto_sucursalParametroInven;
	}

	public Border setResaltarcon_crear_lista_precio_sucursal_bodegaParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_crear_lista_precio_sucursal_bodegaParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_crear_lista_precio_sucursal_bodegaParametroInven() {
		return this.resaltarcon_crear_lista_precio_sucursal_bodegaParametroInven;
	}

	public void setResaltarcon_crear_lista_precio_sucursal_bodegaParametroInven(Border borderResaltar) {
		this.resaltarcon_crear_lista_precio_sucursal_bodegaParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_crear_lista_precio_sucursal_bodegaParametroInven() {
		return this.mostrarcon_crear_lista_precio_sucursal_bodegaParametroInven;
	}

	public void setMostrarcon_crear_lista_precio_sucursal_bodegaParametroInven(Boolean mostrarcon_crear_lista_precio_sucursal_bodegaParametroInven) {
		this.mostrarcon_crear_lista_precio_sucursal_bodegaParametroInven= mostrarcon_crear_lista_precio_sucursal_bodegaParametroInven;
	}

	public Boolean getActivarcon_crear_lista_precio_sucursal_bodegaParametroInven() {
		return this.activarcon_crear_lista_precio_sucursal_bodegaParametroInven;
	}

	public void setActivarcon_crear_lista_precio_sucursal_bodegaParametroInven(Boolean activarcon_crear_lista_precio_sucursal_bodegaParametroInven) {
		this.activarcon_crear_lista_precio_sucursal_bodegaParametroInven= activarcon_crear_lista_precio_sucursal_bodegaParametroInven;
	}

	public Border setResaltarcon_compras_aprobacionParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_compras_aprobacionParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_compras_aprobacionParametroInven() {
		return this.resaltarcon_compras_aprobacionParametroInven;
	}

	public void setResaltarcon_compras_aprobacionParametroInven(Border borderResaltar) {
		this.resaltarcon_compras_aprobacionParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_compras_aprobacionParametroInven() {
		return this.mostrarcon_compras_aprobacionParametroInven;
	}

	public void setMostrarcon_compras_aprobacionParametroInven(Boolean mostrarcon_compras_aprobacionParametroInven) {
		this.mostrarcon_compras_aprobacionParametroInven= mostrarcon_compras_aprobacionParametroInven;
	}

	public Boolean getActivarcon_compras_aprobacionParametroInven() {
		return this.activarcon_compras_aprobacionParametroInven;
	}

	public void setActivarcon_compras_aprobacionParametroInven(Boolean activarcon_compras_aprobacionParametroInven) {
		this.activarcon_compras_aprobacionParametroInven= activarcon_compras_aprobacionParametroInven;
	}

	public Border setResaltarcon_envio_mailParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinvenBeanSwingJInternalFrame.jTtoolBarParametroInven.setBorder(borderResaltar);
		
		this.resaltarcon_envio_mailParametroInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_envio_mailParametroInven() {
		return this.resaltarcon_envio_mailParametroInven;
	}

	public void setResaltarcon_envio_mailParametroInven(Border borderResaltar) {
		this.resaltarcon_envio_mailParametroInven= borderResaltar;
	}

	public Boolean getMostrarcon_envio_mailParametroInven() {
		return this.mostrarcon_envio_mailParametroInven;
	}

	public void setMostrarcon_envio_mailParametroInven(Boolean mostrarcon_envio_mailParametroInven) {
		this.mostrarcon_envio_mailParametroInven= mostrarcon_envio_mailParametroInven;
	}

	public Boolean getActivarcon_envio_mailParametroInven() {
		return this.activarcon_envio_mailParametroInven;
	}

	public void setActivarcon_envio_mailParametroInven(Boolean activarcon_envio_mailParametroInven) {
		this.activarcon_envio_mailParametroInven= activarcon_envio_mailParametroInven;
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
		
		
		this.setMostraridParametroInven(esInicial);
		this.setMostrarid_empresaParametroInven(esInicial);
		this.setMostrarsecuencial_pedidoParametroInven(esInicial);
		this.setMostrarnumero_serieParametroInven(esInicial);
		this.setMostrarnumero_decimalesParametroInven(esInicial);
		this.setMostrarnumero_items_requisicionParametroInven(esInicial);
		this.setMostrarcon_cuenta_contableParametroInven(esInicial);
		this.setMostrarcon_cuenta_contable_lineaParametroInven(esInicial);
		this.setMostrarcon_cuenta_bancoParametroInven(esInicial);
		this.setMostrarcon_copiar_productoParametroInven(esInicial);
		this.setMostrarcon_crear_producto_sucursalParametroInven(esInicial);
		this.setMostrarcon_crear_lista_precio_sucursal_bodegaParametroInven(esInicial);
		this.setMostrarcon_compras_aprobacionParametroInven(esInicial);
		this.setMostrarcon_envio_mailParametroInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInvenConstantesFunciones.ID)) {
				this.setMostraridParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setMostrarsecuencial_pedidoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMERODECIMALES)) {
				this.setMostrarnumero_decimalesParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION)) {
				this.setMostrarnumero_items_requisicionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLE)) {
				this.setMostrarcon_cuenta_contableParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA)) {
				this.setMostrarcon_cuenta_contable_lineaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTABANCO)) {
				this.setMostrarcon_cuenta_bancoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO)) {
				this.setMostrarcon_copiar_productoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL)) {
				this.setMostrarcon_crear_producto_sucursalParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA)) {
				this.setMostrarcon_crear_lista_precio_sucursal_bodegaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION)) {
				this.setMostrarcon_compras_aprobacionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONENVIOMAIL)) {
				this.setMostrarcon_envio_mailParametroInven(esAsigna);
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
		
		
		this.setActivaridParametroInven(esInicial);
		this.setActivarid_empresaParametroInven(esInicial);
		this.setActivarsecuencial_pedidoParametroInven(esInicial);
		this.setActivarnumero_serieParametroInven(esInicial);
		this.setActivarnumero_decimalesParametroInven(esInicial);
		this.setActivarnumero_items_requisicionParametroInven(esInicial);
		this.setActivarcon_cuenta_contableParametroInven(esInicial);
		this.setActivarcon_cuenta_contable_lineaParametroInven(esInicial);
		this.setActivarcon_cuenta_bancoParametroInven(esInicial);
		this.setActivarcon_copiar_productoParametroInven(esInicial);
		this.setActivarcon_crear_producto_sucursalParametroInven(esInicial);
		this.setActivarcon_crear_lista_precio_sucursal_bodegaParametroInven(esInicial);
		this.setActivarcon_compras_aprobacionParametroInven(esInicial);
		this.setActivarcon_envio_mailParametroInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInvenConstantesFunciones.ID)) {
				this.setActivaridParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setActivarsecuencial_pedidoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMERODECIMALES)) {
				this.setActivarnumero_decimalesParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION)) {
				this.setActivarnumero_items_requisicionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLE)) {
				this.setActivarcon_cuenta_contableParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA)) {
				this.setActivarcon_cuenta_contable_lineaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTABANCO)) {
				this.setActivarcon_cuenta_bancoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO)) {
				this.setActivarcon_copiar_productoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL)) {
				this.setActivarcon_crear_producto_sucursalParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA)) {
				this.setActivarcon_crear_lista_precio_sucursal_bodegaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION)) {
				this.setActivarcon_compras_aprobacionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONENVIOMAIL)) {
				this.setActivarcon_envio_mailParametroInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroInven(esInicial);
		this.setResaltarid_empresaParametroInven(esInicial);
		this.setResaltarsecuencial_pedidoParametroInven(esInicial);
		this.setResaltarnumero_serieParametroInven(esInicial);
		this.setResaltarnumero_decimalesParametroInven(esInicial);
		this.setResaltarnumero_items_requisicionParametroInven(esInicial);
		this.setResaltarcon_cuenta_contableParametroInven(esInicial);
		this.setResaltarcon_cuenta_contable_lineaParametroInven(esInicial);
		this.setResaltarcon_cuenta_bancoParametroInven(esInicial);
		this.setResaltarcon_copiar_productoParametroInven(esInicial);
		this.setResaltarcon_crear_producto_sucursalParametroInven(esInicial);
		this.setResaltarcon_crear_lista_precio_sucursal_bodegaParametroInven(esInicial);
		this.setResaltarcon_compras_aprobacionParametroInven(esInicial);
		this.setResaltarcon_envio_mailParametroInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInvenConstantesFunciones.ID)) {
				this.setResaltaridParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setResaltarsecuencial_pedidoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMERODECIMALES)) {
				this.setResaltarnumero_decimalesParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION)) {
				this.setResaltarnumero_items_requisicionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLE)) {
				this.setResaltarcon_cuenta_contableParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA)) {
				this.setResaltarcon_cuenta_contable_lineaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCUENTABANCO)) {
				this.setResaltarcon_cuenta_bancoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO)) {
				this.setResaltarcon_copiar_productoParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL)) {
				this.setResaltarcon_crear_producto_sucursalParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA)) {
				this.setResaltarcon_crear_lista_precio_sucursal_bodegaParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION)) {
				this.setResaltarcon_compras_aprobacionParametroInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInvenConstantesFunciones.CONENVIOMAIL)) {
				this.setResaltarcon_envio_mailParametroInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroInven=true;

	public Boolean getMostrarFK_IdEmpresaParametroInven() {
		return this.mostrarFK_IdEmpresaParametroInven;
	}

	public void setMostrarFK_IdEmpresaParametroInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroInven=true;

	public Boolean getActivarFK_IdEmpresaParametroInven() {
		return this.activarFK_IdEmpresaParametroInven;
	}

	public void setActivarFK_IdEmpresaParametroInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroInven=null;

	public Border getResaltarFK_IdEmpresaParametroInven() {
		return this.resaltarFK_IdEmpresaParametroInven;
	}

	public void setResaltarFK_IdEmpresaParametroInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroInven(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInvenBeanSwingJInternalFrame parametroinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}