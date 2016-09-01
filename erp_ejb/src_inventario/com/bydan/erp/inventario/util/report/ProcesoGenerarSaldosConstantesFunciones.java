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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoGenerarSaldosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoGenerarSaldos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoGenerarSaldos"+ProcesoGenerarSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoGenerarSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoGenerarSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGenerarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGenerarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"_"+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGenerarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGenerarSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGenerarSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoGenerarSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoGenerarSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoGenerarSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoGenerarSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Generar Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Generar Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Generar Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoGenerarSaldos";
	public static final String OBJECTNAME="procesogenerarsaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_generar_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesogenerarsaldos from "+ProcesoGenerarSaldosConstantesFunciones.SPERSISTENCENAME+" procesogenerarsaldos";
	public static String QUERYSELECTNATIVE="select "+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".version_row,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id_periodo,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".numero_comprobante,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".fecha,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".nombre_bodega,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".nombre_producto,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".cantidad,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".costo_unitario,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".costo_total,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".nombre_bodega_enviar,"+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME+".total from "+ProcesoGenerarSaldosConstantesFunciones.SCHEMA+"."+ProcesoGenerarSaldosConstantesFunciones.TABLENAME;//+" as "+ProcesoGenerarSaldosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String NOMBREBODEGAENVIAR= "nombre_bodega_enviar";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_NOMBREBODEGAENVIAR= "Nombre Bodega Enviar";
		public static final String LABEL_NOMBREBODEGAENVIAR_LOWER= "Nombre Bodega Enviar";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNOMBRE_BODEGA_ENVIAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA_ENVIAR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getProcesoGenerarSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.FECHA)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.CANTIDAD)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR;}
		if(sNombreColumna.equals(ProcesoGenerarSaldosConstantesFunciones.TOTAL)) {sLabelColumna=ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoGenerarSaldosDescripcion(ProcesoGenerarSaldos procesogenerarsaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesogenerarsaldos !=null/* && procesogenerarsaldos.getId()!=0*/) {
			if(procesogenerarsaldos.getId()!=null) {
				sDescripcion=procesogenerarsaldos.getId().toString();
			}//procesogenerarsaldosprocesogenerarsaldos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoGenerarSaldosDescripcionDetallado(ProcesoGenerarSaldos procesogenerarsaldos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.ID+"=";
		sDescripcion+=procesogenerarsaldos.getId().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesogenerarsaldos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesogenerarsaldos.getid_empresa().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesogenerarsaldos.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesogenerarsaldos.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=procesogenerarsaldos.getid_periodo().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=procesogenerarsaldos.getnombre_sucursal()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=procesogenerarsaldos.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=procesogenerarsaldos.getnumero_comprobante()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.FECHA+"=";
		sDescripcion+=procesogenerarsaldos.getfecha().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=procesogenerarsaldos.getnombre_bodega()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=procesogenerarsaldos.getnombre_producto()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=procesogenerarsaldos.getcantidad().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=procesogenerarsaldos.getcosto_unitario().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=procesogenerarsaldos.getcosto_total().toString()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR+"=";
		sDescripcion+=procesogenerarsaldos.getnombre_bodega_enviar()+",";
		sDescripcion+=ProcesoGenerarSaldosConstantesFunciones.TOTAL+"=";
		sDescripcion+=procesogenerarsaldos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoGenerarSaldosDescripcion(ProcesoGenerarSaldos procesogenerarsaldos,String sValor) throws Exception {			
		if(procesogenerarsaldos !=null) {
			//procesogenerarsaldosprocesogenerarsaldos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoGenerarSaldos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoGenerarSaldos(Long id_ejercicio,Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesogenerarsaldos.setnombre_sucursal(procesogenerarsaldos.getnombre_sucursal().trim());
		procesogenerarsaldos.setnumero_comprobante(procesogenerarsaldos.getnumero_comprobante().trim());
		procesogenerarsaldos.setnombre_bodega(procesogenerarsaldos.getnombre_bodega().trim());
		procesogenerarsaldos.setnombre_producto(procesogenerarsaldos.getnombre_producto().trim());
		procesogenerarsaldos.setnombre_bodega_enviar(procesogenerarsaldos.getnombre_bodega_enviar().trim());
	}
	
	public static void quitarEspaciosProcesoGenerarSaldoss(List<ProcesoGenerarSaldos> procesogenerarsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoGenerarSaldos procesogenerarsaldos: procesogenerarsaldoss) {
			procesogenerarsaldos.setnombre_sucursal(procesogenerarsaldos.getnombre_sucursal().trim());
			procesogenerarsaldos.setnumero_comprobante(procesogenerarsaldos.getnumero_comprobante().trim());
			procesogenerarsaldos.setnombre_bodega(procesogenerarsaldos.getnombre_bodega().trim());
			procesogenerarsaldos.setnombre_producto(procesogenerarsaldos.getnombre_producto().trim());
			procesogenerarsaldos.setnombre_bodega_enviar(procesogenerarsaldos.getnombre_bodega_enviar().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesogenerarsaldos.getConCambioAuxiliar()) {
			procesogenerarsaldos.setIsDeleted(procesogenerarsaldos.getIsDeletedAuxiliar());	
			procesogenerarsaldos.setIsNew(procesogenerarsaldos.getIsNewAuxiliar());	
			procesogenerarsaldos.setIsChanged(procesogenerarsaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesogenerarsaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesogenerarsaldos.setIsDeletedAuxiliar(false);	
			procesogenerarsaldos.setIsNewAuxiliar(false);	
			procesogenerarsaldos.setIsChangedAuxiliar(false);
			
			procesogenerarsaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGenerarSaldoss(List<ProcesoGenerarSaldos> procesogenerarsaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoGenerarSaldos procesogenerarsaldos : procesogenerarsaldoss) {
			if(conAsignarBase && procesogenerarsaldos.getConCambioAuxiliar()) {
				procesogenerarsaldos.setIsDeleted(procesogenerarsaldos.getIsDeletedAuxiliar());	
				procesogenerarsaldos.setIsNew(procesogenerarsaldos.getIsNewAuxiliar());	
				procesogenerarsaldos.setIsChanged(procesogenerarsaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesogenerarsaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesogenerarsaldos.setIsDeletedAuxiliar(false);	
				procesogenerarsaldos.setIsNewAuxiliar(false);	
				procesogenerarsaldos.setIsChangedAuxiliar(false);
				
				procesogenerarsaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldos,Boolean conEnteros) throws Exception  {
		procesogenerarsaldos.setcosto_unitario(0.0);
		procesogenerarsaldos.setcosto_total(0.0);
		procesogenerarsaldos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			procesogenerarsaldos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProcesoGenerarSaldoss(List<ProcesoGenerarSaldos> procesogenerarsaldoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoGenerarSaldos procesogenerarsaldos: procesogenerarsaldoss) {
			procesogenerarsaldos.setcosto_unitario(0.0);
			procesogenerarsaldos.setcosto_total(0.0);
			procesogenerarsaldos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				procesogenerarsaldos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoGenerarSaldos(List<ProcesoGenerarSaldos> procesogenerarsaldoss,ProcesoGenerarSaldos procesogenerarsaldosAux) throws Exception  {
		ProcesoGenerarSaldosConstantesFunciones.InicializarValoresProcesoGenerarSaldos(procesogenerarsaldosAux,true);
		
		for(ProcesoGenerarSaldos procesogenerarsaldos: procesogenerarsaldoss) {
			if(procesogenerarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesogenerarsaldosAux.setcantidad(procesogenerarsaldosAux.getcantidad()+procesogenerarsaldos.getcantidad());			
			procesogenerarsaldosAux.setcosto_unitario(procesogenerarsaldosAux.getcosto_unitario()+procesogenerarsaldos.getcosto_unitario());			
			procesogenerarsaldosAux.setcosto_total(procesogenerarsaldosAux.getcosto_total()+procesogenerarsaldos.getcosto_total());			
			procesogenerarsaldosAux.settotal(procesogenerarsaldosAux.gettotal()+procesogenerarsaldos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGenerarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoGenerarSaldosConstantesFunciones.getArrayColumnasGlobalesProcesoGenerarSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGenerarSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoGenerarSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoGenerarSaldos> procesogenerarsaldoss,ProcesoGenerarSaldos procesogenerarsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoGenerarSaldos procesogenerarsaldosAux: procesogenerarsaldoss) {
			if(procesogenerarsaldosAux!=null && procesogenerarsaldos!=null) {
				if((procesogenerarsaldosAux.getId()==null && procesogenerarsaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesogenerarsaldosAux.getId()!=null && procesogenerarsaldos.getId()!=null){
					if(procesogenerarsaldosAux.getId().equals(procesogenerarsaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoGenerarSaldos(List<ProcesoGenerarSaldos> procesogenerarsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(ProcesoGenerarSaldos procesogenerarsaldos: procesogenerarsaldoss) {			
			if(procesogenerarsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=procesogenerarsaldos.getcosto_unitario();
			costo_totalTotal+=procesogenerarsaldos.getcosto_total();
			totalTotal+=procesogenerarsaldos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoGenerarSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_ID, ProcesoGenerarSaldosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_VERSIONROW, ProcesoGenerarSaldosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBRESUCURSAL, ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_NUMEROCOMPROBANTE, ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_FECHA, ProcesoGenerarSaldosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGA, ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREPRODUCTO, ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_CANTIDAD, ProcesoGenerarSaldosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO, ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL, ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR, ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL, ProcesoGenerarSaldosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoGenerarSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoGenerarSaldosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGenerarSaldos() throws Exception  {
		return ProcesoGenerarSaldosConstantesFunciones.getTiposSeleccionarProcesoGenerarSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGenerarSaldos(Boolean conFk) throws Exception  {
		return ProcesoGenerarSaldosConstantesFunciones.getTiposSeleccionarProcesoGenerarSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGenerarSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoGenerarSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldosAux) throws Exception {
		
			procesogenerarsaldosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesogenerarsaldosAux.getEmpresa()));
			procesogenerarsaldosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesogenerarsaldosAux.getSucursal()));
			procesogenerarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesogenerarsaldosAux.getEjercicio()));
			procesogenerarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesogenerarsaldosAux.getPeriodo()));
			procesogenerarsaldosAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(procesogenerarsaldosAux.getTipoTransaccionModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGenerarSaldos(List<ProcesoGenerarSaldos> procesogenerarsaldossTemp) throws Exception {
		for(ProcesoGenerarSaldos procesogenerarsaldosAux:procesogenerarsaldossTemp) {
			
			procesogenerarsaldosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesogenerarsaldosAux.getEmpresa()));
			procesogenerarsaldosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesogenerarsaldosAux.getSucursal()));
			procesogenerarsaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesogenerarsaldosAux.getEjercicio()));
			procesogenerarsaldosAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesogenerarsaldosAux.getPeriodo()));
			procesogenerarsaldosAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(procesogenerarsaldosAux.getTipoTransaccionModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoGenerarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoGenerarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGenerarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGenerarSaldosConstantesFunciones.getClassesRelationshipsOfProcesoGenerarSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGenerarSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGenerarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGenerarSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoGenerarSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGenerarSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoGenerarSaldos procesogenerarsaldos,List<ProcesoGenerarSaldos> procesogenerarsaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoGenerarSaldos procesogenerarsaldos,List<ProcesoGenerarSaldos> procesogenerarsaldoss) throws Exception {
		try	{			
			for(ProcesoGenerarSaldos procesogenerarsaldosLocal:procesogenerarsaldoss) {
				if(procesogenerarsaldosLocal.getId().equals(procesogenerarsaldos.getId())) {
					procesogenerarsaldosLocal.setIsSelected(procesogenerarsaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoGenerarSaldos(List<ProcesoGenerarSaldos> procesogenerarsaldossAux) throws Exception {
		//this.procesogenerarsaldossAux=procesogenerarsaldossAux;
		
		for(ProcesoGenerarSaldos procesogenerarsaldosAux:procesogenerarsaldossAux) {
			if(procesogenerarsaldosAux.getIsChanged()) {
				procesogenerarsaldosAux.setIsChanged(false);
			}		
			
			if(procesogenerarsaldosAux.getIsNew()) {
				procesogenerarsaldosAux.setIsNew(false);
			}	
			
			if(procesogenerarsaldosAux.getIsDeleted()) {
				procesogenerarsaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldosAux) throws Exception {
		//this.procesogenerarsaldosAux=procesogenerarsaldosAux;
		
			if(procesogenerarsaldosAux.getIsChanged()) {
				procesogenerarsaldosAux.setIsChanged(false);
			}		
			
			if(procesogenerarsaldosAux.getIsNew()) {
				procesogenerarsaldosAux.setIsNew(false);
			}	
			
			if(procesogenerarsaldosAux.getIsDeleted()) {
				procesogenerarsaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoGenerarSaldos procesogenerarsaldosAsignar,ProcesoGenerarSaldos procesogenerarsaldos) throws Exception {
		procesogenerarsaldosAsignar.setId(procesogenerarsaldos.getId());	
		procesogenerarsaldosAsignar.setVersionRow(procesogenerarsaldos.getVersionRow());	
		procesogenerarsaldosAsignar.setnombre_sucursal(procesogenerarsaldos.getnombre_sucursal());	
		procesogenerarsaldosAsignar.setid_tipo_transaccion_modulo(procesogenerarsaldos.getid_tipo_transaccion_modulo());
		procesogenerarsaldosAsignar.settipotransaccionmodulo_descripcion(procesogenerarsaldos.gettipotransaccionmodulo_descripcion());	
		procesogenerarsaldosAsignar.setnumero_comprobante(procesogenerarsaldos.getnumero_comprobante());	
		procesogenerarsaldosAsignar.setfecha(procesogenerarsaldos.getfecha());	
		procesogenerarsaldosAsignar.setnombre_bodega(procesogenerarsaldos.getnombre_bodega());	
		procesogenerarsaldosAsignar.setnombre_producto(procesogenerarsaldos.getnombre_producto());	
		procesogenerarsaldosAsignar.setcantidad(procesogenerarsaldos.getcantidad());	
		procesogenerarsaldosAsignar.setcosto_unitario(procesogenerarsaldos.getcosto_unitario());	
		procesogenerarsaldosAsignar.setcosto_total(procesogenerarsaldos.getcosto_total());	
		procesogenerarsaldosAsignar.setnombre_bodega_enviar(procesogenerarsaldos.getnombre_bodega_enviar());	
		procesogenerarsaldosAsignar.settotal(procesogenerarsaldos.gettotal());	
	}
	
	public static void inicializarProcesoGenerarSaldos(ProcesoGenerarSaldos procesogenerarsaldos) throws Exception {
		try {
				procesogenerarsaldos.setId(0L);	
					
				procesogenerarsaldos.setnombre_sucursal("");	
				procesogenerarsaldos.setid_tipo_transaccion_modulo(-1L);	
				procesogenerarsaldos.setnumero_comprobante("");	
				procesogenerarsaldos.setfecha(new Date());	
				procesogenerarsaldos.setnombre_bodega("");	
				procesogenerarsaldos.setnombre_producto("");	
				procesogenerarsaldos.setcantidad(0);	
				procesogenerarsaldos.setcosto_unitario(0.0);	
				procesogenerarsaldos.setcosto_total(0.0);	
				procesogenerarsaldos.setnombre_bodega_enviar("");	
				procesogenerarsaldos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoGenerarSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGenerarSaldosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoGenerarSaldos(String sTipo,Row row,Workbook workbook,ProcesoGenerarSaldos procesogenerarsaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.getnombre_bodega_enviar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogenerarsaldos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoGenerarSaldos="";
	
	public String getsFinalQueryProcesoGenerarSaldos() {
		return this.sFinalQueryProcesoGenerarSaldos;
	}
	
	public void setsFinalQueryProcesoGenerarSaldos(String sFinalQueryProcesoGenerarSaldos) {
		this.sFinalQueryProcesoGenerarSaldos= sFinalQueryProcesoGenerarSaldos;
	}
	
	public Border resaltarSeleccionarProcesoGenerarSaldos=null;
	
	public Border setResaltarSeleccionarProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoGenerarSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoGenerarSaldos() {
		return this.resaltarSeleccionarProcesoGenerarSaldos;
	}
	
	public void setResaltarSeleccionarProcesoGenerarSaldos(Border borderResaltarSeleccionarProcesoGenerarSaldos) {
		this.resaltarSeleccionarProcesoGenerarSaldos= borderResaltarSeleccionarProcesoGenerarSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoGenerarSaldos=null;
	public Boolean mostraridProcesoGenerarSaldos=true;
	public Boolean activaridProcesoGenerarSaldos=true;

	public Border resaltarid_empresaProcesoGenerarSaldos=null;
	public Boolean mostrarid_empresaProcesoGenerarSaldos=true;
	public Boolean activarid_empresaProcesoGenerarSaldos=true;
	public Boolean cargarid_empresaProcesoGenerarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoGenerarSaldos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoGenerarSaldos=null;
	public Boolean mostrarid_sucursalProcesoGenerarSaldos=true;
	public Boolean activarid_sucursalProcesoGenerarSaldos=true;
	public Boolean cargarid_sucursalProcesoGenerarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoGenerarSaldos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioProcesoGenerarSaldos=null;
	public Boolean mostrarid_ejercicioProcesoGenerarSaldos=true;
	public Boolean activarid_ejercicioProcesoGenerarSaldos=true;
	public Boolean cargarid_ejercicioProcesoGenerarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoGenerarSaldos=false;//ConEventDepend=true

	public Border resaltarid_periodoProcesoGenerarSaldos=null;
	public Boolean mostrarid_periodoProcesoGenerarSaldos=true;
	public Boolean activarid_periodoProcesoGenerarSaldos=true;
	public Boolean cargarid_periodoProcesoGenerarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoProcesoGenerarSaldos=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProcesoGenerarSaldos=null;
	public Boolean mostrarnombre_sucursalProcesoGenerarSaldos=true;
	public Boolean activarnombre_sucursalProcesoGenerarSaldos=true;

	public Border resaltarid_tipo_transaccion_moduloProcesoGenerarSaldos=null;
	public Boolean mostrarid_tipo_transaccion_moduloProcesoGenerarSaldos=true;
	public Boolean activarid_tipo_transaccion_moduloProcesoGenerarSaldos=true;
	public Boolean cargarid_tipo_transaccion_moduloProcesoGenerarSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloProcesoGenerarSaldos=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteProcesoGenerarSaldos=null;
	public Boolean mostrarnumero_comprobanteProcesoGenerarSaldos=true;
	public Boolean activarnumero_comprobanteProcesoGenerarSaldos=true;

	public Border resaltarfechaProcesoGenerarSaldos=null;
	public Boolean mostrarfechaProcesoGenerarSaldos=true;
	public Boolean activarfechaProcesoGenerarSaldos=true;

	public Border resaltarnombre_bodegaProcesoGenerarSaldos=null;
	public Boolean mostrarnombre_bodegaProcesoGenerarSaldos=true;
	public Boolean activarnombre_bodegaProcesoGenerarSaldos=true;

	public Border resaltarnombre_productoProcesoGenerarSaldos=null;
	public Boolean mostrarnombre_productoProcesoGenerarSaldos=true;
	public Boolean activarnombre_productoProcesoGenerarSaldos=true;

	public Border resaltarcantidadProcesoGenerarSaldos=null;
	public Boolean mostrarcantidadProcesoGenerarSaldos=true;
	public Boolean activarcantidadProcesoGenerarSaldos=true;

	public Border resaltarcosto_unitarioProcesoGenerarSaldos=null;
	public Boolean mostrarcosto_unitarioProcesoGenerarSaldos=true;
	public Boolean activarcosto_unitarioProcesoGenerarSaldos=true;

	public Border resaltarcosto_totalProcesoGenerarSaldos=null;
	public Boolean mostrarcosto_totalProcesoGenerarSaldos=true;
	public Boolean activarcosto_totalProcesoGenerarSaldos=true;

	public Border resaltarnombre_bodega_enviarProcesoGenerarSaldos=null;
	public Boolean mostrarnombre_bodega_enviarProcesoGenerarSaldos=true;
	public Boolean activarnombre_bodega_enviarProcesoGenerarSaldos=true;

	public Border resaltartotalProcesoGenerarSaldos=null;
	public Boolean mostrartotalProcesoGenerarSaldos=true;
	public Boolean activartotalProcesoGenerarSaldos=true;

	
	

	public Border setResaltaridProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltaridProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoGenerarSaldos() {
		return this.resaltaridProcesoGenerarSaldos;
	}

	public void setResaltaridProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltaridProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostraridProcesoGenerarSaldos() {
		return this.mostraridProcesoGenerarSaldos;
	}

	public void setMostraridProcesoGenerarSaldos(Boolean mostraridProcesoGenerarSaldos) {
		this.mostraridProcesoGenerarSaldos= mostraridProcesoGenerarSaldos;
	}

	public Boolean getActivaridProcesoGenerarSaldos() {
		return this.activaridProcesoGenerarSaldos;
	}

	public void setActivaridProcesoGenerarSaldos(Boolean activaridProcesoGenerarSaldos) {
		this.activaridProcesoGenerarSaldos= activaridProcesoGenerarSaldos;
	}

	public Border setResaltarid_empresaProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoGenerarSaldos() {
		return this.resaltarid_empresaProcesoGenerarSaldos;
	}

	public void setResaltarid_empresaProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarid_empresaProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoGenerarSaldos() {
		return this.mostrarid_empresaProcesoGenerarSaldos;
	}

	public void setMostrarid_empresaProcesoGenerarSaldos(Boolean mostrarid_empresaProcesoGenerarSaldos) {
		this.mostrarid_empresaProcesoGenerarSaldos= mostrarid_empresaProcesoGenerarSaldos;
	}

	public Boolean getActivarid_empresaProcesoGenerarSaldos() {
		return this.activarid_empresaProcesoGenerarSaldos;
	}

	public void setActivarid_empresaProcesoGenerarSaldos(Boolean activarid_empresaProcesoGenerarSaldos) {
		this.activarid_empresaProcesoGenerarSaldos= activarid_empresaProcesoGenerarSaldos;
	}

	public Boolean getCargarid_empresaProcesoGenerarSaldos() {
		return this.cargarid_empresaProcesoGenerarSaldos;
	}

	public void setCargarid_empresaProcesoGenerarSaldos(Boolean cargarid_empresaProcesoGenerarSaldos) {
		this.cargarid_empresaProcesoGenerarSaldos= cargarid_empresaProcesoGenerarSaldos;
	}

	public Border setResaltarid_sucursalProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoGenerarSaldos() {
		return this.resaltarid_sucursalProcesoGenerarSaldos;
	}

	public void setResaltarid_sucursalProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarid_sucursalProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoGenerarSaldos() {
		return this.mostrarid_sucursalProcesoGenerarSaldos;
	}

	public void setMostrarid_sucursalProcesoGenerarSaldos(Boolean mostrarid_sucursalProcesoGenerarSaldos) {
		this.mostrarid_sucursalProcesoGenerarSaldos= mostrarid_sucursalProcesoGenerarSaldos;
	}

	public Boolean getActivarid_sucursalProcesoGenerarSaldos() {
		return this.activarid_sucursalProcesoGenerarSaldos;
	}

	public void setActivarid_sucursalProcesoGenerarSaldos(Boolean activarid_sucursalProcesoGenerarSaldos) {
		this.activarid_sucursalProcesoGenerarSaldos= activarid_sucursalProcesoGenerarSaldos;
	}

	public Boolean getCargarid_sucursalProcesoGenerarSaldos() {
		return this.cargarid_sucursalProcesoGenerarSaldos;
	}

	public void setCargarid_sucursalProcesoGenerarSaldos(Boolean cargarid_sucursalProcesoGenerarSaldos) {
		this.cargarid_sucursalProcesoGenerarSaldos= cargarid_sucursalProcesoGenerarSaldos;
	}

	public Border setResaltarid_ejercicioProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoGenerarSaldos() {
		return this.resaltarid_ejercicioProcesoGenerarSaldos;
	}

	public void setResaltarid_ejercicioProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoGenerarSaldos() {
		return this.mostrarid_ejercicioProcesoGenerarSaldos;
	}

	public void setMostrarid_ejercicioProcesoGenerarSaldos(Boolean mostrarid_ejercicioProcesoGenerarSaldos) {
		this.mostrarid_ejercicioProcesoGenerarSaldos= mostrarid_ejercicioProcesoGenerarSaldos;
	}

	public Boolean getActivarid_ejercicioProcesoGenerarSaldos() {
		return this.activarid_ejercicioProcesoGenerarSaldos;
	}

	public void setActivarid_ejercicioProcesoGenerarSaldos(Boolean activarid_ejercicioProcesoGenerarSaldos) {
		this.activarid_ejercicioProcesoGenerarSaldos= activarid_ejercicioProcesoGenerarSaldos;
	}

	public Boolean getCargarid_ejercicioProcesoGenerarSaldos() {
		return this.cargarid_ejercicioProcesoGenerarSaldos;
	}

	public void setCargarid_ejercicioProcesoGenerarSaldos(Boolean cargarid_ejercicioProcesoGenerarSaldos) {
		this.cargarid_ejercicioProcesoGenerarSaldos= cargarid_ejercicioProcesoGenerarSaldos;
	}

	public Border setResaltarid_periodoProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_periodoProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoProcesoGenerarSaldos() {
		return this.resaltarid_periodoProcesoGenerarSaldos;
	}

	public void setResaltarid_periodoProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarid_periodoProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_periodoProcesoGenerarSaldos() {
		return this.mostrarid_periodoProcesoGenerarSaldos;
	}

	public void setMostrarid_periodoProcesoGenerarSaldos(Boolean mostrarid_periodoProcesoGenerarSaldos) {
		this.mostrarid_periodoProcesoGenerarSaldos= mostrarid_periodoProcesoGenerarSaldos;
	}

	public Boolean getActivarid_periodoProcesoGenerarSaldos() {
		return this.activarid_periodoProcesoGenerarSaldos;
	}

	public void setActivarid_periodoProcesoGenerarSaldos(Boolean activarid_periodoProcesoGenerarSaldos) {
		this.activarid_periodoProcesoGenerarSaldos= activarid_periodoProcesoGenerarSaldos;
	}

	public Boolean getCargarid_periodoProcesoGenerarSaldos() {
		return this.cargarid_periodoProcesoGenerarSaldos;
	}

	public void setCargarid_periodoProcesoGenerarSaldos(Boolean cargarid_periodoProcesoGenerarSaldos) {
		this.cargarid_periodoProcesoGenerarSaldos= cargarid_periodoProcesoGenerarSaldos;
	}

	public Border setResaltarnombre_sucursalProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProcesoGenerarSaldos() {
		return this.resaltarnombre_sucursalProcesoGenerarSaldos;
	}

	public void setResaltarnombre_sucursalProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarnombre_sucursalProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProcesoGenerarSaldos() {
		return this.mostrarnombre_sucursalProcesoGenerarSaldos;
	}

	public void setMostrarnombre_sucursalProcesoGenerarSaldos(Boolean mostrarnombre_sucursalProcesoGenerarSaldos) {
		this.mostrarnombre_sucursalProcesoGenerarSaldos= mostrarnombre_sucursalProcesoGenerarSaldos;
	}

	public Boolean getActivarnombre_sucursalProcesoGenerarSaldos() {
		return this.activarnombre_sucursalProcesoGenerarSaldos;
	}

	public void setActivarnombre_sucursalProcesoGenerarSaldos(Boolean activarnombre_sucursalProcesoGenerarSaldos) {
		this.activarnombre_sucursalProcesoGenerarSaldos= activarnombre_sucursalProcesoGenerarSaldos;
	}

	public Border setResaltarid_tipo_transaccion_moduloProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloProcesoGenerarSaldos() {
		return this.resaltarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public void setResaltarid_tipo_transaccion_moduloProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloProcesoGenerarSaldos() {
		return this.mostrarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public void setMostrarid_tipo_transaccion_moduloProcesoGenerarSaldos(Boolean mostrarid_tipo_transaccion_moduloProcesoGenerarSaldos) {
		this.mostrarid_tipo_transaccion_moduloProcesoGenerarSaldos= mostrarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public Boolean getActivarid_tipo_transaccion_moduloProcesoGenerarSaldos() {
		return this.activarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public void setActivarid_tipo_transaccion_moduloProcesoGenerarSaldos(Boolean activarid_tipo_transaccion_moduloProcesoGenerarSaldos) {
		this.activarid_tipo_transaccion_moduloProcesoGenerarSaldos= activarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public Boolean getCargarid_tipo_transaccion_moduloProcesoGenerarSaldos() {
		return this.cargarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public void setCargarid_tipo_transaccion_moduloProcesoGenerarSaldos(Boolean cargarid_tipo_transaccion_moduloProcesoGenerarSaldos) {
		this.cargarid_tipo_transaccion_moduloProcesoGenerarSaldos= cargarid_tipo_transaccion_moduloProcesoGenerarSaldos;
	}

	public Border setResaltarnumero_comprobanteProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteProcesoGenerarSaldos() {
		return this.resaltarnumero_comprobanteProcesoGenerarSaldos;
	}

	public void setResaltarnumero_comprobanteProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarnumero_comprobanteProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteProcesoGenerarSaldos() {
		return this.mostrarnumero_comprobanteProcesoGenerarSaldos;
	}

	public void setMostrarnumero_comprobanteProcesoGenerarSaldos(Boolean mostrarnumero_comprobanteProcesoGenerarSaldos) {
		this.mostrarnumero_comprobanteProcesoGenerarSaldos= mostrarnumero_comprobanteProcesoGenerarSaldos;
	}

	public Boolean getActivarnumero_comprobanteProcesoGenerarSaldos() {
		return this.activarnumero_comprobanteProcesoGenerarSaldos;
	}

	public void setActivarnumero_comprobanteProcesoGenerarSaldos(Boolean activarnumero_comprobanteProcesoGenerarSaldos) {
		this.activarnumero_comprobanteProcesoGenerarSaldos= activarnumero_comprobanteProcesoGenerarSaldos;
	}

	public Border setResaltarfechaProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoGenerarSaldos() {
		return this.resaltarfechaProcesoGenerarSaldos;
	}

	public void setResaltarfechaProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarfechaProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoGenerarSaldos() {
		return this.mostrarfechaProcesoGenerarSaldos;
	}

	public void setMostrarfechaProcesoGenerarSaldos(Boolean mostrarfechaProcesoGenerarSaldos) {
		this.mostrarfechaProcesoGenerarSaldos= mostrarfechaProcesoGenerarSaldos;
	}

	public Boolean getActivarfechaProcesoGenerarSaldos() {
		return this.activarfechaProcesoGenerarSaldos;
	}

	public void setActivarfechaProcesoGenerarSaldos(Boolean activarfechaProcesoGenerarSaldos) {
		this.activarfechaProcesoGenerarSaldos= activarfechaProcesoGenerarSaldos;
	}

	public Border setResaltarnombre_bodegaProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProcesoGenerarSaldos() {
		return this.resaltarnombre_bodegaProcesoGenerarSaldos;
	}

	public void setResaltarnombre_bodegaProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarnombre_bodegaProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProcesoGenerarSaldos() {
		return this.mostrarnombre_bodegaProcesoGenerarSaldos;
	}

	public void setMostrarnombre_bodegaProcesoGenerarSaldos(Boolean mostrarnombre_bodegaProcesoGenerarSaldos) {
		this.mostrarnombre_bodegaProcesoGenerarSaldos= mostrarnombre_bodegaProcesoGenerarSaldos;
	}

	public Boolean getActivarnombre_bodegaProcesoGenerarSaldos() {
		return this.activarnombre_bodegaProcesoGenerarSaldos;
	}

	public void setActivarnombre_bodegaProcesoGenerarSaldos(Boolean activarnombre_bodegaProcesoGenerarSaldos) {
		this.activarnombre_bodegaProcesoGenerarSaldos= activarnombre_bodegaProcesoGenerarSaldos;
	}

	public Border setResaltarnombre_productoProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProcesoGenerarSaldos() {
		return this.resaltarnombre_productoProcesoGenerarSaldos;
	}

	public void setResaltarnombre_productoProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarnombre_productoProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProcesoGenerarSaldos() {
		return this.mostrarnombre_productoProcesoGenerarSaldos;
	}

	public void setMostrarnombre_productoProcesoGenerarSaldos(Boolean mostrarnombre_productoProcesoGenerarSaldos) {
		this.mostrarnombre_productoProcesoGenerarSaldos= mostrarnombre_productoProcesoGenerarSaldos;
	}

	public Boolean getActivarnombre_productoProcesoGenerarSaldos() {
		return this.activarnombre_productoProcesoGenerarSaldos;
	}

	public void setActivarnombre_productoProcesoGenerarSaldos(Boolean activarnombre_productoProcesoGenerarSaldos) {
		this.activarnombre_productoProcesoGenerarSaldos= activarnombre_productoProcesoGenerarSaldos;
	}

	public Border setResaltarcantidadProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarcantidadProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProcesoGenerarSaldos() {
		return this.resaltarcantidadProcesoGenerarSaldos;
	}

	public void setResaltarcantidadProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarcantidadProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarcantidadProcesoGenerarSaldos() {
		return this.mostrarcantidadProcesoGenerarSaldos;
	}

	public void setMostrarcantidadProcesoGenerarSaldos(Boolean mostrarcantidadProcesoGenerarSaldos) {
		this.mostrarcantidadProcesoGenerarSaldos= mostrarcantidadProcesoGenerarSaldos;
	}

	public Boolean getActivarcantidadProcesoGenerarSaldos() {
		return this.activarcantidadProcesoGenerarSaldos;
	}

	public void setActivarcantidadProcesoGenerarSaldos(Boolean activarcantidadProcesoGenerarSaldos) {
		this.activarcantidadProcesoGenerarSaldos= activarcantidadProcesoGenerarSaldos;
	}

	public Border setResaltarcosto_unitarioProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioProcesoGenerarSaldos() {
		return this.resaltarcosto_unitarioProcesoGenerarSaldos;
	}

	public void setResaltarcosto_unitarioProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarcosto_unitarioProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioProcesoGenerarSaldos() {
		return this.mostrarcosto_unitarioProcesoGenerarSaldos;
	}

	public void setMostrarcosto_unitarioProcesoGenerarSaldos(Boolean mostrarcosto_unitarioProcesoGenerarSaldos) {
		this.mostrarcosto_unitarioProcesoGenerarSaldos= mostrarcosto_unitarioProcesoGenerarSaldos;
	}

	public Boolean getActivarcosto_unitarioProcesoGenerarSaldos() {
		return this.activarcosto_unitarioProcesoGenerarSaldos;
	}

	public void setActivarcosto_unitarioProcesoGenerarSaldos(Boolean activarcosto_unitarioProcesoGenerarSaldos) {
		this.activarcosto_unitarioProcesoGenerarSaldos= activarcosto_unitarioProcesoGenerarSaldos;
	}

	public Border setResaltarcosto_totalProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProcesoGenerarSaldos() {
		return this.resaltarcosto_totalProcesoGenerarSaldos;
	}

	public void setResaltarcosto_totalProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarcosto_totalProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProcesoGenerarSaldos() {
		return this.mostrarcosto_totalProcesoGenerarSaldos;
	}

	public void setMostrarcosto_totalProcesoGenerarSaldos(Boolean mostrarcosto_totalProcesoGenerarSaldos) {
		this.mostrarcosto_totalProcesoGenerarSaldos= mostrarcosto_totalProcesoGenerarSaldos;
	}

	public Boolean getActivarcosto_totalProcesoGenerarSaldos() {
		return this.activarcosto_totalProcesoGenerarSaldos;
	}

	public void setActivarcosto_totalProcesoGenerarSaldos(Boolean activarcosto_totalProcesoGenerarSaldos) {
		this.activarcosto_totalProcesoGenerarSaldos= activarcosto_totalProcesoGenerarSaldos;
	}

	public Border setResaltarnombre_bodega_enviarProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodega_enviarProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodega_enviarProcesoGenerarSaldos() {
		return this.resaltarnombre_bodega_enviarProcesoGenerarSaldos;
	}

	public void setResaltarnombre_bodega_enviarProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarnombre_bodega_enviarProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodega_enviarProcesoGenerarSaldos() {
		return this.mostrarnombre_bodega_enviarProcesoGenerarSaldos;
	}

	public void setMostrarnombre_bodega_enviarProcesoGenerarSaldos(Boolean mostrarnombre_bodega_enviarProcesoGenerarSaldos) {
		this.mostrarnombre_bodega_enviarProcesoGenerarSaldos= mostrarnombre_bodega_enviarProcesoGenerarSaldos;
	}

	public Boolean getActivarnombre_bodega_enviarProcesoGenerarSaldos() {
		return this.activarnombre_bodega_enviarProcesoGenerarSaldos;
	}

	public void setActivarnombre_bodega_enviarProcesoGenerarSaldos(Boolean activarnombre_bodega_enviarProcesoGenerarSaldos) {
		this.activarnombre_bodega_enviarProcesoGenerarSaldos= activarnombre_bodega_enviarProcesoGenerarSaldos;
	}

	public Border setResaltartotalProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarsaldosBeanSwingJInternalFrame.jTtoolBarProcesoGenerarSaldos.setBorder(borderResaltar);
		
		this.resaltartotalProcesoGenerarSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalProcesoGenerarSaldos() {
		return this.resaltartotalProcesoGenerarSaldos;
	}

	public void setResaltartotalProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltartotalProcesoGenerarSaldos= borderResaltar;
	}

	public Boolean getMostrartotalProcesoGenerarSaldos() {
		return this.mostrartotalProcesoGenerarSaldos;
	}

	public void setMostrartotalProcesoGenerarSaldos(Boolean mostrartotalProcesoGenerarSaldos) {
		this.mostrartotalProcesoGenerarSaldos= mostrartotalProcesoGenerarSaldos;
	}

	public Boolean getActivartotalProcesoGenerarSaldos() {
		return this.activartotalProcesoGenerarSaldos;
	}

	public void setActivartotalProcesoGenerarSaldos(Boolean activartotalProcesoGenerarSaldos) {
		this.activartotalProcesoGenerarSaldos= activartotalProcesoGenerarSaldos;
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
		
		
		this.setMostraridProcesoGenerarSaldos(esInicial);
		this.setMostrarid_empresaProcesoGenerarSaldos(esInicial);
		this.setMostrarid_sucursalProcesoGenerarSaldos(esInicial);
		this.setMostrarid_ejercicioProcesoGenerarSaldos(esInicial);
		this.setMostrarid_periodoProcesoGenerarSaldos(esInicial);
		this.setMostrarnombre_sucursalProcesoGenerarSaldos(esInicial);
		this.setMostrarid_tipo_transaccion_moduloProcesoGenerarSaldos(esInicial);
		this.setMostrarnumero_comprobanteProcesoGenerarSaldos(esInicial);
		this.setMostrarfechaProcesoGenerarSaldos(esInicial);
		this.setMostrarnombre_bodegaProcesoGenerarSaldos(esInicial);
		this.setMostrarnombre_productoProcesoGenerarSaldos(esInicial);
		this.setMostrarcantidadProcesoGenerarSaldos(esInicial);
		this.setMostrarcosto_unitarioProcesoGenerarSaldos(esInicial);
		this.setMostrarcosto_totalProcesoGenerarSaldos(esInicial);
		this.setMostrarnombre_bodega_enviarProcesoGenerarSaldos(esInicial);
		this.setMostrartotalProcesoGenerarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.ID)) {
				this.setMostraridProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setMostrarnombre_bodega_enviarProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.TOTAL)) {
				this.setMostrartotalProcesoGenerarSaldos(esAsigna);
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
		
		
		this.setActivaridProcesoGenerarSaldos(esInicial);
		this.setActivarid_empresaProcesoGenerarSaldos(esInicial);
		this.setActivarid_sucursalProcesoGenerarSaldos(esInicial);
		this.setActivarid_ejercicioProcesoGenerarSaldos(esInicial);
		this.setActivarid_periodoProcesoGenerarSaldos(esInicial);
		this.setActivarnombre_sucursalProcesoGenerarSaldos(esInicial);
		this.setActivarid_tipo_transaccion_moduloProcesoGenerarSaldos(esInicial);
		this.setActivarnumero_comprobanteProcesoGenerarSaldos(esInicial);
		this.setActivarfechaProcesoGenerarSaldos(esInicial);
		this.setActivarnombre_bodegaProcesoGenerarSaldos(esInicial);
		this.setActivarnombre_productoProcesoGenerarSaldos(esInicial);
		this.setActivarcantidadProcesoGenerarSaldos(esInicial);
		this.setActivarcosto_unitarioProcesoGenerarSaldos(esInicial);
		this.setActivarcosto_totalProcesoGenerarSaldos(esInicial);
		this.setActivarnombre_bodega_enviarProcesoGenerarSaldos(esInicial);
		this.setActivartotalProcesoGenerarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.ID)) {
				this.setActivaridProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setActivarnombre_bodega_enviarProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.TOTAL)) {
				this.setActivartotalProcesoGenerarSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoGenerarSaldos(esInicial);
		this.setResaltarid_empresaProcesoGenerarSaldos(esInicial);
		this.setResaltarid_sucursalProcesoGenerarSaldos(esInicial);
		this.setResaltarid_ejercicioProcesoGenerarSaldos(esInicial);
		this.setResaltarid_periodoProcesoGenerarSaldos(esInicial);
		this.setResaltarnombre_sucursalProcesoGenerarSaldos(esInicial);
		this.setResaltarid_tipo_transaccion_moduloProcesoGenerarSaldos(esInicial);
		this.setResaltarnumero_comprobanteProcesoGenerarSaldos(esInicial);
		this.setResaltarfechaProcesoGenerarSaldos(esInicial);
		this.setResaltarnombre_bodegaProcesoGenerarSaldos(esInicial);
		this.setResaltarnombre_productoProcesoGenerarSaldos(esInicial);
		this.setResaltarcantidadProcesoGenerarSaldos(esInicial);
		this.setResaltarcosto_unitarioProcesoGenerarSaldos(esInicial);
		this.setResaltarcosto_totalProcesoGenerarSaldos(esInicial);
		this.setResaltarnombre_bodega_enviarProcesoGenerarSaldos(esInicial);
		this.setResaltartotalProcesoGenerarSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.ID)) {
				this.setResaltaridProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setResaltarnombre_bodega_enviarProcesoGenerarSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGenerarSaldosConstantesFunciones.TOTAL)) {
				this.setResaltartotalProcesoGenerarSaldos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos=true;

	public Boolean getMostrarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos() {
		return this.mostrarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos;
	}

	public void setMostrarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos=true;

	public Boolean getActivarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos() {
		return this.activarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos;
	}

	public void setActivarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos=null;

	public Border getResaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos() {
		return this.resaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos;
	}

	public void setResaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos(Border borderResaltar) {
		this.resaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGenerarSaldosBeanSwingJInternalFrame procesogenerarsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoGenerarSaldosProcesoGenerarSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}