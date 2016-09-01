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


import com.bydan.erp.inventario.util.DetallePlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePlaneacionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePlaneacionCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



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
final public class DetallePlaneacionCompraConstantesFunciones extends DetallePlaneacionCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePlaneacionCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePlaneacionCompra"+DetallePlaneacionCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePlaneacionCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePlaneacionCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePlaneacionCompraConstantesFunciones.SCHEMA+"_"+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePlaneacionCompraConstantesFunciones.SCHEMA+"_"+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePlaneacionCompraConstantesFunciones.SCHEMA+"_"+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePlaneacionCompraConstantesFunciones.SCHEMA+"_"+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePlaneacionCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePlaneacionCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePlaneacionCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePlaneacionCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Planeacion Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Planeacion Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Planeacion Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePlaneacionCompra";
	public static final String OBJECTNAME="detalleplaneacioncompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_planeacion_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleplaneacioncompra from "+DetallePlaneacionCompraConstantesFunciones.SPERSISTENCENAME+" detalleplaneacioncompra";
	public static String QUERYSELECTNATIVE="select "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".version_row,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_planeacion_compra,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_linea,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_producto,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".dia_minimo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_minimo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".dia_maximo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_maximo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".salida,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_mensual,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".descripcion from "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+DetallePlaneacionCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePlaneacionCompraConstantesFuncionesAdditional detalleplaneacioncompraConstantesFuncionesAdditional=null;
	
	public DetallePlaneacionCompraConstantesFuncionesAdditional getDetallePlaneacionCompraConstantesFuncionesAdditional() {
		return this.detalleplaneacioncompraConstantesFuncionesAdditional;
	}
	
	public void setDetallePlaneacionCompraConstantesFuncionesAdditional(DetallePlaneacionCompraConstantesFuncionesAdditional detalleplaneacioncompraConstantesFuncionesAdditional) {
		try {
			this.detalleplaneacioncompraConstantesFuncionesAdditional=detalleplaneacioncompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDPLANEACIONCOMPRA= "id_planeacion_compra";
    public static final String IDLINEA= "id_linea";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String STOCK= "stock";
    public static final String DIAMINIMO= "dia_minimo";
    public static final String STOCKMINIMO= "stock_minimo";
    public static final String DIAMAXIMO= "dia_maximo";
    public static final String STOCKMAXIMO= "stock_maximo";
    public static final String SALIDA= "salida";
    public static final String STOCKMENSUAL= "stock_mensual";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDPLANEACIONCOMPRA= "Planeacion Compra";
		public static final String LABEL_IDPLANEACIONCOMPRA_LOWER= "Planeacion Compra";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_STOCK= "Stock";
		public static final String LABEL_STOCK_LOWER= "Stock";
    	public static final String LABEL_DIAMINIMO= "Dia Minimo";
		public static final String LABEL_DIAMINIMO_LOWER= "Dia Minimo";
    	public static final String LABEL_STOCKMINIMO= "Stock Minimo";
		public static final String LABEL_STOCKMINIMO_LOWER= "Stock Minimo";
    	public static final String LABEL_DIAMAXIMO= "Dia Maximo";
		public static final String LABEL_DIAMAXIMO_LOWER= "Dia Maximo";
    	public static final String LABEL_STOCKMAXIMO= "Stock Maximo";
		public static final String LABEL_STOCKMAXIMO_LOWER= "Stock Maximo";
    	public static final String LABEL_SALIDA= "Salida";
		public static final String LABEL_SALIDA_LOWER= "Salida";
    	public static final String LABEL_STOCKMENSUAL= "Stock Mensual";
		public static final String LABEL_STOCKMENSUAL_LOWER= "Stock Mensual";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetallePlaneacionCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDPLANEACIONCOMPRA;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDLINEA)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.STOCK)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.DIAMINIMO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMINIMO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMAXIMO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.SALIDA)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL;}
		if(sNombreColumna.equals(DetallePlaneacionCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetallePlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePlaneacionCompraDescripcion(DetallePlaneacionCompra detalleplaneacioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleplaneacioncompra !=null/* && detalleplaneacioncompra.getId()!=0*/) {
			if(detalleplaneacioncompra.getId()!=null) {
				sDescripcion=detalleplaneacioncompra.getId().toString();
			}//detalleplaneacioncompradetalleplaneacioncompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePlaneacionCompraDescripcionDetallado(DetallePlaneacionCompra detalleplaneacioncompra) {
		String sDescripcion="";
			
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.ID+"=";
		sDescripcion+=detalleplaneacioncompra.getId().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleplaneacioncompra.getVersionRow().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleplaneacioncompra.getid_empresa().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleplaneacioncompra.getid_sucursal().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleplaneacioncompra.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleplaneacioncompra.getid_periodo().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA+"=";
		sDescripcion+=detalleplaneacioncompra.getid_planeacion_compra().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDLINEA+"=";
		sDescripcion+=detalleplaneacioncompra.getid_linea().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleplaneacioncompra.getid_producto().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleplaneacioncompra.getid_unidad().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.STOCK+"=";
		sDescripcion+=detalleplaneacioncompra.getstock().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.DIAMINIMO+"=";
		sDescripcion+=detalleplaneacioncompra.getdia_minimo().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO+"=";
		sDescripcion+=detalleplaneacioncompra.getstock_minimo().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO+"=";
		sDescripcion+=detalleplaneacioncompra.getdia_maximo().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO+"=";
		sDescripcion+=detalleplaneacioncompra.getstock_maximo().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.SALIDA+"=";
		sDescripcion+=detalleplaneacioncompra.getsalida().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL+"=";
		sDescripcion+=detalleplaneacioncompra.getstock_mensual().toString()+",";
		sDescripcion+=DetallePlaneacionCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleplaneacioncompra.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePlaneacionCompraDescripcion(DetallePlaneacionCompra detalleplaneacioncompra,String sValor) throws Exception {			
		if(detalleplaneacioncompra !=null) {
			//detalleplaneacioncompradetalleplaneacioncompra.getId().toString();
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

	public static String getPlaneacionCompraDescripcion(PlaneacionCompra planeacioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(planeacioncompra!=null/*&&planeacioncompra.getId()>0*/) {
			sDescripcion=PlaneacionCompraConstantesFunciones.getPlaneacionCompraDescripcion(planeacioncompra);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdPlaneacionCompra")) {
			sNombreIndice="Tipo=  Por Planeacion Compra";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPlaneacionCompra(Long id_planeacion_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_planeacion_compra!=null) {sDetalleIndice+=" Codigo Unico De Planeacion Compra="+id_planeacion_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleplaneacioncompra.setdescripcion(detalleplaneacioncompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePlaneacionCompra detalleplaneacioncompra: detalleplaneacioncompras) {
			detalleplaneacioncompra.setdescripcion(detalleplaneacioncompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleplaneacioncompra.getConCambioAuxiliar()) {
			detalleplaneacioncompra.setIsDeleted(detalleplaneacioncompra.getIsDeletedAuxiliar());	
			detalleplaneacioncompra.setIsNew(detalleplaneacioncompra.getIsNewAuxiliar());	
			detalleplaneacioncompra.setIsChanged(detalleplaneacioncompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleplaneacioncompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleplaneacioncompra.setIsDeletedAuxiliar(false);	
			detalleplaneacioncompra.setIsNewAuxiliar(false);	
			detalleplaneacioncompra.setIsChangedAuxiliar(false);
			
			detalleplaneacioncompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePlaneacionCompra detalleplaneacioncompra : detalleplaneacioncompras) {
			if(conAsignarBase && detalleplaneacioncompra.getConCambioAuxiliar()) {
				detalleplaneacioncompra.setIsDeleted(detalleplaneacioncompra.getIsDeletedAuxiliar());	
				detalleplaneacioncompra.setIsNew(detalleplaneacioncompra.getIsNewAuxiliar());	
				detalleplaneacioncompra.setIsChanged(detalleplaneacioncompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleplaneacioncompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleplaneacioncompra.setIsDeletedAuxiliar(false);	
				detalleplaneacioncompra.setIsNewAuxiliar(false);	
				detalleplaneacioncompra.setIsChangedAuxiliar(false);
				
				detalleplaneacioncompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra,Boolean conEnteros) throws Exception  {
		detalleplaneacioncompra.setstock(0.0);
		detalleplaneacioncompra.setstock_minimo(0.0);
		detalleplaneacioncompra.setstock_maximo(0.0);
		detalleplaneacioncompra.setsalida(0.0);
		detalleplaneacioncompra.setstock_mensual(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleplaneacioncompra.setdia_minimo(0);
			detalleplaneacioncompra.setdia_maximo(0);
		}
	}		
	
	public static void InicializarValoresDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras,Boolean conEnteros) throws Exception  {
		
		for(DetallePlaneacionCompra detalleplaneacioncompra: detalleplaneacioncompras) {
			detalleplaneacioncompra.setstock(0.0);
			detalleplaneacioncompra.setstock_minimo(0.0);
			detalleplaneacioncompra.setstock_maximo(0.0);
			detalleplaneacioncompra.setsalida(0.0);
			detalleplaneacioncompra.setstock_mensual(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleplaneacioncompra.setdia_minimo(0);
				detalleplaneacioncompra.setdia_maximo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePlaneacionCompra(List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompra detalleplaneacioncompraAux) throws Exception  {
		DetallePlaneacionCompraConstantesFunciones.InicializarValoresDetallePlaneacionCompra(detalleplaneacioncompraAux,true);
		
		for(DetallePlaneacionCompra detalleplaneacioncompra: detalleplaneacioncompras) {
			if(detalleplaneacioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleplaneacioncompraAux.setstock(detalleplaneacioncompraAux.getstock()+detalleplaneacioncompra.getstock());			
			detalleplaneacioncompraAux.setdia_minimo(detalleplaneacioncompraAux.getdia_minimo()+detalleplaneacioncompra.getdia_minimo());			
			detalleplaneacioncompraAux.setstock_minimo(detalleplaneacioncompraAux.getstock_minimo()+detalleplaneacioncompra.getstock_minimo());			
			detalleplaneacioncompraAux.setdia_maximo(detalleplaneacioncompraAux.getdia_maximo()+detalleplaneacioncompra.getdia_maximo());			
			detalleplaneacioncompraAux.setstock_maximo(detalleplaneacioncompraAux.getstock_maximo()+detalleplaneacioncompra.getstock_maximo());			
			detalleplaneacioncompraAux.setsalida(detalleplaneacioncompraAux.getsalida()+detalleplaneacioncompra.getsalida());			
			detalleplaneacioncompraAux.setstock_mensual(detalleplaneacioncompraAux.getstock_mensual()+detalleplaneacioncompra.getstock_mensual());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePlaneacionCompraConstantesFunciones.getArrayColumnasGlobalesDetallePlaneacionCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePlaneacionCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePlaneacionCompraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompra detalleplaneacioncompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePlaneacionCompra detalleplaneacioncompraAux: detalleplaneacioncompras) {
			if(detalleplaneacioncompraAux!=null && detalleplaneacioncompra!=null) {
				if((detalleplaneacioncompraAux.getId()==null && detalleplaneacioncompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleplaneacioncompraAux.getId()!=null && detalleplaneacioncompra.getId()!=null){
					if(detalleplaneacioncompraAux.getId().equals(detalleplaneacioncompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePlaneacionCompra(List<DetallePlaneacionCompra> detalleplaneacioncompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double stockTotal=0.0;
		Double stock_minimoTotal=0.0;
		Double stock_maximoTotal=0.0;
		Double salidaTotal=0.0;
		Double stock_mensualTotal=0.0;
	
		for(DetallePlaneacionCompra detalleplaneacioncompra: detalleplaneacioncompras) {			
			if(detalleplaneacioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			stockTotal+=detalleplaneacioncompra.getstock();
			stock_minimoTotal+=detalleplaneacioncompra.getstock_minimo();
			stock_maximoTotal+=detalleplaneacioncompra.getstock_maximo();
			salidaTotal+=detalleplaneacioncompra.getsalida();
			stock_mensualTotal+=detalleplaneacioncompra.getstock_mensual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePlaneacionCompraConstantesFunciones.STOCK);
		datoGeneral.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK);
		datoGeneral.setdValorDouble(stockTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO);
		datoGeneral.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO);
		datoGeneral.setdValorDouble(stock_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO);
		datoGeneral.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO);
		datoGeneral.setdValorDouble(stock_maximoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePlaneacionCompraConstantesFunciones.SALIDA);
		datoGeneral.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA);
		datoGeneral.setdValorDouble(salidaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL);
		datoGeneral.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL);
		datoGeneral.setdValorDouble(stock_mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePlaneacionCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_ID, DetallePlaneacionCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_VERSIONROW, DetallePlaneacionCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA, DetallePlaneacionCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL, DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO, DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDPERIODO, DetallePlaneacionCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDPLANEACIONCOMPRA, DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDLINEA, DetallePlaneacionCompraConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDPRODUCTO, DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_IDUNIDAD, DetallePlaneacionCompraConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK, DetallePlaneacionCompraConstantesFunciones.STOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMINIMO, DetallePlaneacionCompraConstantesFunciones.DIAMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO, DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMAXIMO, DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO, DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA, DetallePlaneacionCompraConstantesFunciones.SALIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL, DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION, DetallePlaneacionCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePlaneacionCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.STOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.DIAMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.SALIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePlaneacionCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePlaneacionCompra() throws Exception  {
		return DetallePlaneacionCompraConstantesFunciones.getTiposSeleccionarDetallePlaneacionCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePlaneacionCompra(Boolean conFk) throws Exception  {
		return DetallePlaneacionCompraConstantesFunciones.getTiposSeleccionarDetallePlaneacionCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePlaneacionCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPLANEACIONCOMPRA);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPLANEACIONCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMINIMO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMAXIMO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetallePlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePlaneacionCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompraAux) throws Exception {
		
			detalleplaneacioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleplaneacioncompraAux.getEmpresa()));
			detalleplaneacioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleplaneacioncompraAux.getSucursal()));
			detalleplaneacioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleplaneacioncompraAux.getEjercicio()));
			detalleplaneacioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleplaneacioncompraAux.getPeriodo()));
			detalleplaneacioncompraAux.setplaneacioncompra_descripcion(PlaneacionCompraConstantesFunciones.getPlaneacionCompraDescripcion(detalleplaneacioncompraAux.getPlaneacionCompra()));
			detalleplaneacioncompraAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(detalleplaneacioncompraAux.getLinea()));
			detalleplaneacioncompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleplaneacioncompraAux.getProducto()));
			detalleplaneacioncompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleplaneacioncompraAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePlaneacionCompra(List<DetallePlaneacionCompra> detalleplaneacioncomprasTemp) throws Exception {
		for(DetallePlaneacionCompra detalleplaneacioncompraAux:detalleplaneacioncomprasTemp) {
			
			detalleplaneacioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleplaneacioncompraAux.getEmpresa()));
			detalleplaneacioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleplaneacioncompraAux.getSucursal()));
			detalleplaneacioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleplaneacioncompraAux.getEjercicio()));
			detalleplaneacioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleplaneacioncompraAux.getPeriodo()));
			detalleplaneacioncompraAux.setplaneacioncompra_descripcion(PlaneacionCompraConstantesFunciones.getPlaneacionCompraDescripcion(detalleplaneacioncompraAux.getPlaneacionCompra()));
			detalleplaneacioncompraAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(detalleplaneacioncompraAux.getLinea()));
			detalleplaneacioncompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleplaneacioncompraAux.getProducto()));
			detalleplaneacioncompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleplaneacioncompraAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(PlaneacionCompra.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
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
					if(clas.clas.equals(PlaneacionCompra.class)) {
						classes.add(new Classe(PlaneacionCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(PlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaneacionCompra.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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

					if(PlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaneacionCompra.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePlaneacionCompraConstantesFunciones.getClassesRelationshipsOfDetallePlaneacionCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePlaneacionCompraConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePlaneacionCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePlaneacionCompra detalleplaneacioncompra,List<DetallePlaneacionCompra> detalleplaneacioncompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePlaneacionCompra detalleplaneacioncompraEncontrado=null;
			
			for(DetallePlaneacionCompra detalleplaneacioncompraLocal:detalleplaneacioncompras) {
				if(detalleplaneacioncompraLocal.getId().equals(detalleplaneacioncompra.getId())) {
					detalleplaneacioncompraEncontrado=detalleplaneacioncompraLocal;
					
					detalleplaneacioncompraLocal.setIsChanged(detalleplaneacioncompra.getIsChanged());
					detalleplaneacioncompraLocal.setIsNew(detalleplaneacioncompra.getIsNew());
					detalleplaneacioncompraLocal.setIsDeleted(detalleplaneacioncompra.getIsDeleted());
					
					detalleplaneacioncompraLocal.setGeneralEntityOriginal(detalleplaneacioncompra.getGeneralEntityOriginal());
					
					detalleplaneacioncompraLocal.setId(detalleplaneacioncompra.getId());	
					detalleplaneacioncompraLocal.setVersionRow(detalleplaneacioncompra.getVersionRow());	
					detalleplaneacioncompraLocal.setid_empresa(detalleplaneacioncompra.getid_empresa());	
					detalleplaneacioncompraLocal.setid_sucursal(detalleplaneacioncompra.getid_sucursal());	
					detalleplaneacioncompraLocal.setid_ejercicio(detalleplaneacioncompra.getid_ejercicio());	
					detalleplaneacioncompraLocal.setid_periodo(detalleplaneacioncompra.getid_periodo());	
					detalleplaneacioncompraLocal.setid_planeacion_compra(detalleplaneacioncompra.getid_planeacion_compra());	
					detalleplaneacioncompraLocal.setid_linea(detalleplaneacioncompra.getid_linea());	
					detalleplaneacioncompraLocal.setid_producto(detalleplaneacioncompra.getid_producto());	
					detalleplaneacioncompraLocal.setid_unidad(detalleplaneacioncompra.getid_unidad());	
					detalleplaneacioncompraLocal.setstock(detalleplaneacioncompra.getstock());	
					detalleplaneacioncompraLocal.setdia_minimo(detalleplaneacioncompra.getdia_minimo());	
					detalleplaneacioncompraLocal.setstock_minimo(detalleplaneacioncompra.getstock_minimo());	
					detalleplaneacioncompraLocal.setdia_maximo(detalleplaneacioncompra.getdia_maximo());	
					detalleplaneacioncompraLocal.setstock_maximo(detalleplaneacioncompra.getstock_maximo());	
					detalleplaneacioncompraLocal.setsalida(detalleplaneacioncompra.getsalida());	
					detalleplaneacioncompraLocal.setstock_mensual(detalleplaneacioncompra.getstock_mensual());	
					detalleplaneacioncompraLocal.setdescripcion(detalleplaneacioncompra.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleplaneacioncompra.getIsDeleted()) {
				if(!existe) {
					detalleplaneacioncompras.add(detalleplaneacioncompra);
				}
			} else {
				if(detalleplaneacioncompraEncontrado!=null && permiteQuitar)  {
					detalleplaneacioncompras.remove(detalleplaneacioncompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePlaneacionCompra detalleplaneacioncompra,List<DetallePlaneacionCompra> detalleplaneacioncompras) throws Exception {
		try	{			
			for(DetallePlaneacionCompra detalleplaneacioncompraLocal:detalleplaneacioncompras) {
				if(detalleplaneacioncompraLocal.getId().equals(detalleplaneacioncompra.getId())) {
					detalleplaneacioncompraLocal.setIsSelected(detalleplaneacioncompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePlaneacionCompra(List<DetallePlaneacionCompra> detalleplaneacioncomprasAux) throws Exception {
		//this.detalleplaneacioncomprasAux=detalleplaneacioncomprasAux;
		
		for(DetallePlaneacionCompra detalleplaneacioncompraAux:detalleplaneacioncomprasAux) {
			if(detalleplaneacioncompraAux.getIsChanged()) {
				detalleplaneacioncompraAux.setIsChanged(false);
			}		
			
			if(detalleplaneacioncompraAux.getIsNew()) {
				detalleplaneacioncompraAux.setIsNew(false);
			}	
			
			if(detalleplaneacioncompraAux.getIsDeleted()) {
				detalleplaneacioncompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompraAux) throws Exception {
		//this.detalleplaneacioncompraAux=detalleplaneacioncompraAux;
		
			if(detalleplaneacioncompraAux.getIsChanged()) {
				detalleplaneacioncompraAux.setIsChanged(false);
			}		
			
			if(detalleplaneacioncompraAux.getIsNew()) {
				detalleplaneacioncompraAux.setIsNew(false);
			}	
			
			if(detalleplaneacioncompraAux.getIsDeleted()) {
				detalleplaneacioncompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePlaneacionCompra detalleplaneacioncompraAsignar,DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {
		detalleplaneacioncompraAsignar.setId(detalleplaneacioncompra.getId());	
		detalleplaneacioncompraAsignar.setVersionRow(detalleplaneacioncompra.getVersionRow());	
		detalleplaneacioncompraAsignar.setid_empresa(detalleplaneacioncompra.getid_empresa());
		detalleplaneacioncompraAsignar.setempresa_descripcion(detalleplaneacioncompra.getempresa_descripcion());	
		detalleplaneacioncompraAsignar.setid_sucursal(detalleplaneacioncompra.getid_sucursal());
		detalleplaneacioncompraAsignar.setsucursal_descripcion(detalleplaneacioncompra.getsucursal_descripcion());	
		detalleplaneacioncompraAsignar.setid_ejercicio(detalleplaneacioncompra.getid_ejercicio());
		detalleplaneacioncompraAsignar.setejercicio_descripcion(detalleplaneacioncompra.getejercicio_descripcion());	
		detalleplaneacioncompraAsignar.setid_periodo(detalleplaneacioncompra.getid_periodo());
		detalleplaneacioncompraAsignar.setperiodo_descripcion(detalleplaneacioncompra.getperiodo_descripcion());	
		detalleplaneacioncompraAsignar.setid_planeacion_compra(detalleplaneacioncompra.getid_planeacion_compra());
		detalleplaneacioncompraAsignar.setplaneacioncompra_descripcion(detalleplaneacioncompra.getplaneacioncompra_descripcion());	
		detalleplaneacioncompraAsignar.setid_linea(detalleplaneacioncompra.getid_linea());
		detalleplaneacioncompraAsignar.setlinea_descripcion(detalleplaneacioncompra.getlinea_descripcion());	
		detalleplaneacioncompraAsignar.setid_producto(detalleplaneacioncompra.getid_producto());
		detalleplaneacioncompraAsignar.setproducto_descripcion(detalleplaneacioncompra.getproducto_descripcion());	
		detalleplaneacioncompraAsignar.setid_unidad(detalleplaneacioncompra.getid_unidad());
		detalleplaneacioncompraAsignar.setunidad_descripcion(detalleplaneacioncompra.getunidad_descripcion());	
		detalleplaneacioncompraAsignar.setstock(detalleplaneacioncompra.getstock());	
		detalleplaneacioncompraAsignar.setdia_minimo(detalleplaneacioncompra.getdia_minimo());	
		detalleplaneacioncompraAsignar.setstock_minimo(detalleplaneacioncompra.getstock_minimo());	
		detalleplaneacioncompraAsignar.setdia_maximo(detalleplaneacioncompra.getdia_maximo());	
		detalleplaneacioncompraAsignar.setstock_maximo(detalleplaneacioncompra.getstock_maximo());	
		detalleplaneacioncompraAsignar.setsalida(detalleplaneacioncompra.getsalida());	
		detalleplaneacioncompraAsignar.setstock_mensual(detalleplaneacioncompra.getstock_mensual());	
		detalleplaneacioncompraAsignar.setdescripcion(detalleplaneacioncompra.getdescripcion());	
	}
	
	public static void inicializarDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {
		try {
				detalleplaneacioncompra.setId(0L);	
					
				detalleplaneacioncompra.setid_empresa(-1L);	
				detalleplaneacioncompra.setid_sucursal(-1L);	
				detalleplaneacioncompra.setid_ejercicio(-1L);	
				detalleplaneacioncompra.setid_periodo(-1L);	
				detalleplaneacioncompra.setid_planeacion_compra(-1L);	
				detalleplaneacioncompra.setid_linea(-1L);	
				detalleplaneacioncompra.setid_producto(-1L);	
				detalleplaneacioncompra.setid_unidad(-1L);	
				detalleplaneacioncompra.setstock(0.0);	
				detalleplaneacioncompra.setdia_minimo(0);	
				detalleplaneacioncompra.setstock_minimo(0.0);	
				detalleplaneacioncompra.setdia_maximo(0);	
				detalleplaneacioncompra.setstock_maximo(0.0);	
				detalleplaneacioncompra.setsalida(0.0);	
				detalleplaneacioncompra.setstock_mensual(0.0);	
				detalleplaneacioncompra.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePlaneacionCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPLANEACIONCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_DIAMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_SALIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_STOCKMENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePlaneacionCompra(String sTipo,Row row,Workbook workbook,DetallePlaneacionCompra detalleplaneacioncompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getplaneacioncompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getstock());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getdia_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getstock_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getdia_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getstock_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getsalida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getstock_mensual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleplaneacioncompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePlaneacionCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePlaneacionCompra() {
		return this.sFinalQueryDetallePlaneacionCompra;
	}
	
	public void setsFinalQueryDetallePlaneacionCompra(String sFinalQueryDetallePlaneacionCompra) {
		this.sFinalQueryDetallePlaneacionCompra= sFinalQueryDetallePlaneacionCompra;
	}
	
	public Border resaltarSeleccionarDetallePlaneacionCompra=null;
	
	public Border setResaltarSeleccionarDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePlaneacionCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePlaneacionCompra() {
		return this.resaltarSeleccionarDetallePlaneacionCompra;
	}
	
	public void setResaltarSeleccionarDetallePlaneacionCompra(Border borderResaltarSeleccionarDetallePlaneacionCompra) {
		this.resaltarSeleccionarDetallePlaneacionCompra= borderResaltarSeleccionarDetallePlaneacionCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePlaneacionCompra=null;
	public Boolean mostraridDetallePlaneacionCompra=true;
	public Boolean activaridDetallePlaneacionCompra=true;

	public Border resaltarid_empresaDetallePlaneacionCompra=null;
	public Boolean mostrarid_empresaDetallePlaneacionCompra=true;
	public Boolean activarid_empresaDetallePlaneacionCompra=true;
	public Boolean cargarid_empresaDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePlaneacionCompra=null;
	public Boolean mostrarid_sucursalDetallePlaneacionCompra=true;
	public Boolean activarid_sucursalDetallePlaneacionCompra=true;
	public Boolean cargarid_sucursalDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePlaneacionCompra=null;
	public Boolean mostrarid_ejercicioDetallePlaneacionCompra=true;
	public Boolean activarid_ejercicioDetallePlaneacionCompra=true;
	public Boolean cargarid_ejercicioDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePlaneacionCompra=null;
	public Boolean mostrarid_periodoDetallePlaneacionCompra=true;
	public Boolean activarid_periodoDetallePlaneacionCompra=true;
	public Boolean cargarid_periodoDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_planeacion_compraDetallePlaneacionCompra=null;
	public Boolean mostrarid_planeacion_compraDetallePlaneacionCompra=true;
	public Boolean activarid_planeacion_compraDetallePlaneacionCompra=true;
	public Boolean cargarid_planeacion_compraDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_planeacion_compraDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_lineaDetallePlaneacionCompra=null;
	public Boolean mostrarid_lineaDetallePlaneacionCompra=true;
	public Boolean activarid_lineaDetallePlaneacionCompra=true;
	public Boolean cargarid_lineaDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePlaneacionCompra=null;
	public Boolean mostrarid_productoDetallePlaneacionCompra=true;
	public Boolean activarid_productoDetallePlaneacionCompra=true;
	public Boolean cargarid_productoDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_unidadDetallePlaneacionCompra=null;
	public Boolean mostrarid_unidadDetallePlaneacionCompra=true;
	public Boolean activarid_unidadDetallePlaneacionCompra=true;
	public Boolean cargarid_unidadDetallePlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarstockDetallePlaneacionCompra=null;
	public Boolean mostrarstockDetallePlaneacionCompra=true;
	public Boolean activarstockDetallePlaneacionCompra=true;

	public Border resaltardia_minimoDetallePlaneacionCompra=null;
	public Boolean mostrardia_minimoDetallePlaneacionCompra=true;
	public Boolean activardia_minimoDetallePlaneacionCompra=true;

	public Border resaltarstock_minimoDetallePlaneacionCompra=null;
	public Boolean mostrarstock_minimoDetallePlaneacionCompra=true;
	public Boolean activarstock_minimoDetallePlaneacionCompra=true;

	public Border resaltardia_maximoDetallePlaneacionCompra=null;
	public Boolean mostrardia_maximoDetallePlaneacionCompra=true;
	public Boolean activardia_maximoDetallePlaneacionCompra=true;

	public Border resaltarstock_maximoDetallePlaneacionCompra=null;
	public Boolean mostrarstock_maximoDetallePlaneacionCompra=true;
	public Boolean activarstock_maximoDetallePlaneacionCompra=true;

	public Border resaltarsalidaDetallePlaneacionCompra=null;
	public Boolean mostrarsalidaDetallePlaneacionCompra=true;
	public Boolean activarsalidaDetallePlaneacionCompra=true;

	public Border resaltarstock_mensualDetallePlaneacionCompra=null;
	public Boolean mostrarstock_mensualDetallePlaneacionCompra=true;
	public Boolean activarstock_mensualDetallePlaneacionCompra=true;

	public Border resaltardescripcionDetallePlaneacionCompra=null;
	public Boolean mostrardescripcionDetallePlaneacionCompra=true;
	public Boolean activardescripcionDetallePlaneacionCompra=true;

	
	

	public Border setResaltaridDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltaridDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePlaneacionCompra() {
		return this.resaltaridDetallePlaneacionCompra;
	}

	public void setResaltaridDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltaridDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostraridDetallePlaneacionCompra() {
		return this.mostraridDetallePlaneacionCompra;
	}

	public void setMostraridDetallePlaneacionCompra(Boolean mostraridDetallePlaneacionCompra) {
		this.mostraridDetallePlaneacionCompra= mostraridDetallePlaneacionCompra;
	}

	public Boolean getActivaridDetallePlaneacionCompra() {
		return this.activaridDetallePlaneacionCompra;
	}

	public void setActivaridDetallePlaneacionCompra(Boolean activaridDetallePlaneacionCompra) {
		this.activaridDetallePlaneacionCompra= activaridDetallePlaneacionCompra;
	}

	public Border setResaltarid_empresaDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePlaneacionCompra() {
		return this.resaltarid_empresaDetallePlaneacionCompra;
	}

	public void setResaltarid_empresaDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_empresaDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePlaneacionCompra() {
		return this.mostrarid_empresaDetallePlaneacionCompra;
	}

	public void setMostrarid_empresaDetallePlaneacionCompra(Boolean mostrarid_empresaDetallePlaneacionCompra) {
		this.mostrarid_empresaDetallePlaneacionCompra= mostrarid_empresaDetallePlaneacionCompra;
	}

	public Boolean getActivarid_empresaDetallePlaneacionCompra() {
		return this.activarid_empresaDetallePlaneacionCompra;
	}

	public void setActivarid_empresaDetallePlaneacionCompra(Boolean activarid_empresaDetallePlaneacionCompra) {
		this.activarid_empresaDetallePlaneacionCompra= activarid_empresaDetallePlaneacionCompra;
	}

	public Boolean getCargarid_empresaDetallePlaneacionCompra() {
		return this.cargarid_empresaDetallePlaneacionCompra;
	}

	public void setCargarid_empresaDetallePlaneacionCompra(Boolean cargarid_empresaDetallePlaneacionCompra) {
		this.cargarid_empresaDetallePlaneacionCompra= cargarid_empresaDetallePlaneacionCompra;
	}

	public Border setResaltarid_sucursalDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePlaneacionCompra() {
		return this.resaltarid_sucursalDetallePlaneacionCompra;
	}

	public void setResaltarid_sucursalDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_sucursalDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePlaneacionCompra() {
		return this.mostrarid_sucursalDetallePlaneacionCompra;
	}

	public void setMostrarid_sucursalDetallePlaneacionCompra(Boolean mostrarid_sucursalDetallePlaneacionCompra) {
		this.mostrarid_sucursalDetallePlaneacionCompra= mostrarid_sucursalDetallePlaneacionCompra;
	}

	public Boolean getActivarid_sucursalDetallePlaneacionCompra() {
		return this.activarid_sucursalDetallePlaneacionCompra;
	}

	public void setActivarid_sucursalDetallePlaneacionCompra(Boolean activarid_sucursalDetallePlaneacionCompra) {
		this.activarid_sucursalDetallePlaneacionCompra= activarid_sucursalDetallePlaneacionCompra;
	}

	public Boolean getCargarid_sucursalDetallePlaneacionCompra() {
		return this.cargarid_sucursalDetallePlaneacionCompra;
	}

	public void setCargarid_sucursalDetallePlaneacionCompra(Boolean cargarid_sucursalDetallePlaneacionCompra) {
		this.cargarid_sucursalDetallePlaneacionCompra= cargarid_sucursalDetallePlaneacionCompra;
	}

	public Border setResaltarid_ejercicioDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePlaneacionCompra() {
		return this.resaltarid_ejercicioDetallePlaneacionCompra;
	}

	public void setResaltarid_ejercicioDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePlaneacionCompra() {
		return this.mostrarid_ejercicioDetallePlaneacionCompra;
	}

	public void setMostrarid_ejercicioDetallePlaneacionCompra(Boolean mostrarid_ejercicioDetallePlaneacionCompra) {
		this.mostrarid_ejercicioDetallePlaneacionCompra= mostrarid_ejercicioDetallePlaneacionCompra;
	}

	public Boolean getActivarid_ejercicioDetallePlaneacionCompra() {
		return this.activarid_ejercicioDetallePlaneacionCompra;
	}

	public void setActivarid_ejercicioDetallePlaneacionCompra(Boolean activarid_ejercicioDetallePlaneacionCompra) {
		this.activarid_ejercicioDetallePlaneacionCompra= activarid_ejercicioDetallePlaneacionCompra;
	}

	public Boolean getCargarid_ejercicioDetallePlaneacionCompra() {
		return this.cargarid_ejercicioDetallePlaneacionCompra;
	}

	public void setCargarid_ejercicioDetallePlaneacionCompra(Boolean cargarid_ejercicioDetallePlaneacionCompra) {
		this.cargarid_ejercicioDetallePlaneacionCompra= cargarid_ejercicioDetallePlaneacionCompra;
	}

	public Border setResaltarid_periodoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePlaneacionCompra() {
		return this.resaltarid_periodoDetallePlaneacionCompra;
	}

	public void setResaltarid_periodoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_periodoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePlaneacionCompra() {
		return this.mostrarid_periodoDetallePlaneacionCompra;
	}

	public void setMostrarid_periodoDetallePlaneacionCompra(Boolean mostrarid_periodoDetallePlaneacionCompra) {
		this.mostrarid_periodoDetallePlaneacionCompra= mostrarid_periodoDetallePlaneacionCompra;
	}

	public Boolean getActivarid_periodoDetallePlaneacionCompra() {
		return this.activarid_periodoDetallePlaneacionCompra;
	}

	public void setActivarid_periodoDetallePlaneacionCompra(Boolean activarid_periodoDetallePlaneacionCompra) {
		this.activarid_periodoDetallePlaneacionCompra= activarid_periodoDetallePlaneacionCompra;
	}

	public Boolean getCargarid_periodoDetallePlaneacionCompra() {
		return this.cargarid_periodoDetallePlaneacionCompra;
	}

	public void setCargarid_periodoDetallePlaneacionCompra(Boolean cargarid_periodoDetallePlaneacionCompra) {
		this.cargarid_periodoDetallePlaneacionCompra= cargarid_periodoDetallePlaneacionCompra;
	}

	public Border setResaltarid_planeacion_compraDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_planeacion_compraDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_planeacion_compraDetallePlaneacionCompra() {
		return this.resaltarid_planeacion_compraDetallePlaneacionCompra;
	}

	public void setResaltarid_planeacion_compraDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_planeacion_compraDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_planeacion_compraDetallePlaneacionCompra() {
		return this.mostrarid_planeacion_compraDetallePlaneacionCompra;
	}

	public void setMostrarid_planeacion_compraDetallePlaneacionCompra(Boolean mostrarid_planeacion_compraDetallePlaneacionCompra) {
		this.mostrarid_planeacion_compraDetallePlaneacionCompra= mostrarid_planeacion_compraDetallePlaneacionCompra;
	}

	public Boolean getActivarid_planeacion_compraDetallePlaneacionCompra() {
		return this.activarid_planeacion_compraDetallePlaneacionCompra;
	}

	public void setActivarid_planeacion_compraDetallePlaneacionCompra(Boolean activarid_planeacion_compraDetallePlaneacionCompra) {
		this.activarid_planeacion_compraDetallePlaneacionCompra= activarid_planeacion_compraDetallePlaneacionCompra;
	}

	public Boolean getCargarid_planeacion_compraDetallePlaneacionCompra() {
		return this.cargarid_planeacion_compraDetallePlaneacionCompra;
	}

	public void setCargarid_planeacion_compraDetallePlaneacionCompra(Boolean cargarid_planeacion_compraDetallePlaneacionCompra) {
		this.cargarid_planeacion_compraDetallePlaneacionCompra= cargarid_planeacion_compraDetallePlaneacionCompra;
	}

	public Border setResaltarid_lineaDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_lineaDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaDetallePlaneacionCompra() {
		return this.resaltarid_lineaDetallePlaneacionCompra;
	}

	public void setResaltarid_lineaDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_lineaDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_lineaDetallePlaneacionCompra() {
		return this.mostrarid_lineaDetallePlaneacionCompra;
	}

	public void setMostrarid_lineaDetallePlaneacionCompra(Boolean mostrarid_lineaDetallePlaneacionCompra) {
		this.mostrarid_lineaDetallePlaneacionCompra= mostrarid_lineaDetallePlaneacionCompra;
	}

	public Boolean getActivarid_lineaDetallePlaneacionCompra() {
		return this.activarid_lineaDetallePlaneacionCompra;
	}

	public void setActivarid_lineaDetallePlaneacionCompra(Boolean activarid_lineaDetallePlaneacionCompra) {
		this.activarid_lineaDetallePlaneacionCompra= activarid_lineaDetallePlaneacionCompra;
	}

	public Boolean getCargarid_lineaDetallePlaneacionCompra() {
		return this.cargarid_lineaDetallePlaneacionCompra;
	}

	public void setCargarid_lineaDetallePlaneacionCompra(Boolean cargarid_lineaDetallePlaneacionCompra) {
		this.cargarid_lineaDetallePlaneacionCompra= cargarid_lineaDetallePlaneacionCompra;
	}

	public Border setResaltarid_productoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePlaneacionCompra() {
		return this.resaltarid_productoDetallePlaneacionCompra;
	}

	public void setResaltarid_productoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_productoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePlaneacionCompra() {
		return this.mostrarid_productoDetallePlaneacionCompra;
	}

	public void setMostrarid_productoDetallePlaneacionCompra(Boolean mostrarid_productoDetallePlaneacionCompra) {
		this.mostrarid_productoDetallePlaneacionCompra= mostrarid_productoDetallePlaneacionCompra;
	}

	public Boolean getActivarid_productoDetallePlaneacionCompra() {
		return this.activarid_productoDetallePlaneacionCompra;
	}

	public void setActivarid_productoDetallePlaneacionCompra(Boolean activarid_productoDetallePlaneacionCompra) {
		this.activarid_productoDetallePlaneacionCompra= activarid_productoDetallePlaneacionCompra;
	}

	public Boolean getCargarid_productoDetallePlaneacionCompra() {
		return this.cargarid_productoDetallePlaneacionCompra;
	}

	public void setCargarid_productoDetallePlaneacionCompra(Boolean cargarid_productoDetallePlaneacionCompra) {
		this.cargarid_productoDetallePlaneacionCompra= cargarid_productoDetallePlaneacionCompra;
	}

	public Border setResaltarid_unidadDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePlaneacionCompra() {
		return this.resaltarid_unidadDetallePlaneacionCompra;
	}

	public void setResaltarid_unidadDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarid_unidadDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePlaneacionCompra() {
		return this.mostrarid_unidadDetallePlaneacionCompra;
	}

	public void setMostrarid_unidadDetallePlaneacionCompra(Boolean mostrarid_unidadDetallePlaneacionCompra) {
		this.mostrarid_unidadDetallePlaneacionCompra= mostrarid_unidadDetallePlaneacionCompra;
	}

	public Boolean getActivarid_unidadDetallePlaneacionCompra() {
		return this.activarid_unidadDetallePlaneacionCompra;
	}

	public void setActivarid_unidadDetallePlaneacionCompra(Boolean activarid_unidadDetallePlaneacionCompra) {
		this.activarid_unidadDetallePlaneacionCompra= activarid_unidadDetallePlaneacionCompra;
	}

	public Boolean getCargarid_unidadDetallePlaneacionCompra() {
		return this.cargarid_unidadDetallePlaneacionCompra;
	}

	public void setCargarid_unidadDetallePlaneacionCompra(Boolean cargarid_unidadDetallePlaneacionCompra) {
		this.cargarid_unidadDetallePlaneacionCompra= cargarid_unidadDetallePlaneacionCompra;
	}

	public Border setResaltarstockDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarstockDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstockDetallePlaneacionCompra() {
		return this.resaltarstockDetallePlaneacionCompra;
	}

	public void setResaltarstockDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarstockDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarstockDetallePlaneacionCompra() {
		return this.mostrarstockDetallePlaneacionCompra;
	}

	public void setMostrarstockDetallePlaneacionCompra(Boolean mostrarstockDetallePlaneacionCompra) {
		this.mostrarstockDetallePlaneacionCompra= mostrarstockDetallePlaneacionCompra;
	}

	public Boolean getActivarstockDetallePlaneacionCompra() {
		return this.activarstockDetallePlaneacionCompra;
	}

	public void setActivarstockDetallePlaneacionCompra(Boolean activarstockDetallePlaneacionCompra) {
		this.activarstockDetallePlaneacionCompra= activarstockDetallePlaneacionCompra;
	}

	public Border setResaltardia_minimoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardia_minimoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_minimoDetallePlaneacionCompra() {
		return this.resaltardia_minimoDetallePlaneacionCompra;
	}

	public void setResaltardia_minimoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltardia_minimoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardia_minimoDetallePlaneacionCompra() {
		return this.mostrardia_minimoDetallePlaneacionCompra;
	}

	public void setMostrardia_minimoDetallePlaneacionCompra(Boolean mostrardia_minimoDetallePlaneacionCompra) {
		this.mostrardia_minimoDetallePlaneacionCompra= mostrardia_minimoDetallePlaneacionCompra;
	}

	public Boolean getActivardia_minimoDetallePlaneacionCompra() {
		return this.activardia_minimoDetallePlaneacionCompra;
	}

	public void setActivardia_minimoDetallePlaneacionCompra(Boolean activardia_minimoDetallePlaneacionCompra) {
		this.activardia_minimoDetallePlaneacionCompra= activardia_minimoDetallePlaneacionCompra;
	}

	public Border setResaltarstock_minimoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarstock_minimoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_minimoDetallePlaneacionCompra() {
		return this.resaltarstock_minimoDetallePlaneacionCompra;
	}

	public void setResaltarstock_minimoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarstock_minimoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarstock_minimoDetallePlaneacionCompra() {
		return this.mostrarstock_minimoDetallePlaneacionCompra;
	}

	public void setMostrarstock_minimoDetallePlaneacionCompra(Boolean mostrarstock_minimoDetallePlaneacionCompra) {
		this.mostrarstock_minimoDetallePlaneacionCompra= mostrarstock_minimoDetallePlaneacionCompra;
	}

	public Boolean getActivarstock_minimoDetallePlaneacionCompra() {
		return this.activarstock_minimoDetallePlaneacionCompra;
	}

	public void setActivarstock_minimoDetallePlaneacionCompra(Boolean activarstock_minimoDetallePlaneacionCompra) {
		this.activarstock_minimoDetallePlaneacionCompra= activarstock_minimoDetallePlaneacionCompra;
	}

	public Border setResaltardia_maximoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardia_maximoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_maximoDetallePlaneacionCompra() {
		return this.resaltardia_maximoDetallePlaneacionCompra;
	}

	public void setResaltardia_maximoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltardia_maximoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardia_maximoDetallePlaneacionCompra() {
		return this.mostrardia_maximoDetallePlaneacionCompra;
	}

	public void setMostrardia_maximoDetallePlaneacionCompra(Boolean mostrardia_maximoDetallePlaneacionCompra) {
		this.mostrardia_maximoDetallePlaneacionCompra= mostrardia_maximoDetallePlaneacionCompra;
	}

	public Boolean getActivardia_maximoDetallePlaneacionCompra() {
		return this.activardia_maximoDetallePlaneacionCompra;
	}

	public void setActivardia_maximoDetallePlaneacionCompra(Boolean activardia_maximoDetallePlaneacionCompra) {
		this.activardia_maximoDetallePlaneacionCompra= activardia_maximoDetallePlaneacionCompra;
	}

	public Border setResaltarstock_maximoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarstock_maximoDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_maximoDetallePlaneacionCompra() {
		return this.resaltarstock_maximoDetallePlaneacionCompra;
	}

	public void setResaltarstock_maximoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarstock_maximoDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarstock_maximoDetallePlaneacionCompra() {
		return this.mostrarstock_maximoDetallePlaneacionCompra;
	}

	public void setMostrarstock_maximoDetallePlaneacionCompra(Boolean mostrarstock_maximoDetallePlaneacionCompra) {
		this.mostrarstock_maximoDetallePlaneacionCompra= mostrarstock_maximoDetallePlaneacionCompra;
	}

	public Boolean getActivarstock_maximoDetallePlaneacionCompra() {
		return this.activarstock_maximoDetallePlaneacionCompra;
	}

	public void setActivarstock_maximoDetallePlaneacionCompra(Boolean activarstock_maximoDetallePlaneacionCompra) {
		this.activarstock_maximoDetallePlaneacionCompra= activarstock_maximoDetallePlaneacionCompra;
	}

	public Border setResaltarsalidaDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarsalidaDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsalidaDetallePlaneacionCompra() {
		return this.resaltarsalidaDetallePlaneacionCompra;
	}

	public void setResaltarsalidaDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarsalidaDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarsalidaDetallePlaneacionCompra() {
		return this.mostrarsalidaDetallePlaneacionCompra;
	}

	public void setMostrarsalidaDetallePlaneacionCompra(Boolean mostrarsalidaDetallePlaneacionCompra) {
		this.mostrarsalidaDetallePlaneacionCompra= mostrarsalidaDetallePlaneacionCompra;
	}

	public Boolean getActivarsalidaDetallePlaneacionCompra() {
		return this.activarsalidaDetallePlaneacionCompra;
	}

	public void setActivarsalidaDetallePlaneacionCompra(Boolean activarsalidaDetallePlaneacionCompra) {
		this.activarsalidaDetallePlaneacionCompra= activarsalidaDetallePlaneacionCompra;
	}

	public Border setResaltarstock_mensualDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarstock_mensualDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_mensualDetallePlaneacionCompra() {
		return this.resaltarstock_mensualDetallePlaneacionCompra;
	}

	public void setResaltarstock_mensualDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarstock_mensualDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarstock_mensualDetallePlaneacionCompra() {
		return this.mostrarstock_mensualDetallePlaneacionCompra;
	}

	public void setMostrarstock_mensualDetallePlaneacionCompra(Boolean mostrarstock_mensualDetallePlaneacionCompra) {
		this.mostrarstock_mensualDetallePlaneacionCompra= mostrarstock_mensualDetallePlaneacionCompra;
	}

	public Boolean getActivarstock_mensualDetallePlaneacionCompra() {
		return this.activarstock_mensualDetallePlaneacionCompra;
	}

	public void setActivarstock_mensualDetallePlaneacionCompra(Boolean activarstock_mensualDetallePlaneacionCompra) {
		this.activarstock_mensualDetallePlaneacionCompra= activarstock_mensualDetallePlaneacionCompra;
	}

	public Border setResaltardescripcionDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleplaneacioncompraBeanSwingJInternalFrame.jTtoolBarDetallePlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionDetallePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetallePlaneacionCompra() {
		return this.resaltardescripcionDetallePlaneacionCompra;
	}

	public void setResaltardescripcionDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltardescripcionDetallePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionDetallePlaneacionCompra() {
		return this.mostrardescripcionDetallePlaneacionCompra;
	}

	public void setMostrardescripcionDetallePlaneacionCompra(Boolean mostrardescripcionDetallePlaneacionCompra) {
		this.mostrardescripcionDetallePlaneacionCompra= mostrardescripcionDetallePlaneacionCompra;
	}

	public Boolean getActivardescripcionDetallePlaneacionCompra() {
		return this.activardescripcionDetallePlaneacionCompra;
	}

	public void setActivardescripcionDetallePlaneacionCompra(Boolean activardescripcionDetallePlaneacionCompra) {
		this.activardescripcionDetallePlaneacionCompra= activardescripcionDetallePlaneacionCompra;
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
		
		
		this.setMostraridDetallePlaneacionCompra(esInicial);
		this.setMostrarid_empresaDetallePlaneacionCompra(esInicial);
		this.setMostrarid_sucursalDetallePlaneacionCompra(esInicial);
		this.setMostrarid_ejercicioDetallePlaneacionCompra(esInicial);
		this.setMostrarid_periodoDetallePlaneacionCompra(esInicial);
		this.setMostrarid_planeacion_compraDetallePlaneacionCompra(esInicial);
		this.setMostrarid_lineaDetallePlaneacionCompra(esInicial);
		this.setMostrarid_productoDetallePlaneacionCompra(esInicial);
		this.setMostrarid_unidadDetallePlaneacionCompra(esInicial);
		this.setMostrarstockDetallePlaneacionCompra(esInicial);
		this.setMostrardia_minimoDetallePlaneacionCompra(esInicial);
		this.setMostrarstock_minimoDetallePlaneacionCompra(esInicial);
		this.setMostrardia_maximoDetallePlaneacionCompra(esInicial);
		this.setMostrarstock_maximoDetallePlaneacionCompra(esInicial);
		this.setMostrarsalidaDetallePlaneacionCompra(esInicial);
		this.setMostrarstock_mensualDetallePlaneacionCompra(esInicial);
		this.setMostrardescripcionDetallePlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.ID)) {
				this.setMostraridDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA)) {
				this.setMostrarid_planeacion_compraDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCK)) {
				this.setMostrarstockDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMINIMO)) {
				this.setMostrardia_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO)) {
				this.setMostrarstock_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO)) {
				this.setMostrardia_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO)) {
				this.setMostrarstock_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.SALIDA)) {
				this.setMostrarsalidaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL)) {
				this.setMostrarstock_mensualDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetallePlaneacionCompra(esAsigna);
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
		
		
		this.setActivaridDetallePlaneacionCompra(esInicial);
		this.setActivarid_empresaDetallePlaneacionCompra(esInicial);
		this.setActivarid_sucursalDetallePlaneacionCompra(esInicial);
		this.setActivarid_ejercicioDetallePlaneacionCompra(esInicial);
		this.setActivarid_periodoDetallePlaneacionCompra(esInicial);
		this.setActivarid_planeacion_compraDetallePlaneacionCompra(esInicial);
		this.setActivarid_lineaDetallePlaneacionCompra(esInicial);
		this.setActivarid_productoDetallePlaneacionCompra(esInicial);
		this.setActivarid_unidadDetallePlaneacionCompra(esInicial);
		this.setActivarstockDetallePlaneacionCompra(esInicial);
		this.setActivardia_minimoDetallePlaneacionCompra(esInicial);
		this.setActivarstock_minimoDetallePlaneacionCompra(esInicial);
		this.setActivardia_maximoDetallePlaneacionCompra(esInicial);
		this.setActivarstock_maximoDetallePlaneacionCompra(esInicial);
		this.setActivarsalidaDetallePlaneacionCompra(esInicial);
		this.setActivarstock_mensualDetallePlaneacionCompra(esInicial);
		this.setActivardescripcionDetallePlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.ID)) {
				this.setActivaridDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA)) {
				this.setActivarid_planeacion_compraDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCK)) {
				this.setActivarstockDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMINIMO)) {
				this.setActivardia_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO)) {
				this.setActivarstock_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO)) {
				this.setActivardia_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO)) {
				this.setActivarstock_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.SALIDA)) {
				this.setActivarsalidaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL)) {
				this.setActivarstock_mensualDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetallePlaneacionCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePlaneacionCompra(esInicial);
		this.setResaltarid_empresaDetallePlaneacionCompra(esInicial);
		this.setResaltarid_sucursalDetallePlaneacionCompra(esInicial);
		this.setResaltarid_ejercicioDetallePlaneacionCompra(esInicial);
		this.setResaltarid_periodoDetallePlaneacionCompra(esInicial);
		this.setResaltarid_planeacion_compraDetallePlaneacionCompra(esInicial);
		this.setResaltarid_lineaDetallePlaneacionCompra(esInicial);
		this.setResaltarid_productoDetallePlaneacionCompra(esInicial);
		this.setResaltarid_unidadDetallePlaneacionCompra(esInicial);
		this.setResaltarstockDetallePlaneacionCompra(esInicial);
		this.setResaltardia_minimoDetallePlaneacionCompra(esInicial);
		this.setResaltarstock_minimoDetallePlaneacionCompra(esInicial);
		this.setResaltardia_maximoDetallePlaneacionCompra(esInicial);
		this.setResaltarstock_maximoDetallePlaneacionCompra(esInicial);
		this.setResaltarsalidaDetallePlaneacionCompra(esInicial);
		this.setResaltarstock_mensualDetallePlaneacionCompra(esInicial);
		this.setResaltardescripcionDetallePlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.ID)) {
				this.setResaltaridDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA)) {
				this.setResaltarid_planeacion_compraDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCK)) {
				this.setResaltarstockDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMINIMO)) {
				this.setResaltardia_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO)) {
				this.setResaltarstock_minimoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO)) {
				this.setResaltardia_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO)) {
				this.setResaltarstock_maximoDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.SALIDA)) {
				this.setResaltarsalidaDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL)) {
				this.setResaltarstock_mensualDetallePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePlaneacionCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetallePlaneacionCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdEjercicioDetallePlaneacionCompra() {
		return this.mostrarFK_IdEjercicioDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdEjercicioDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdEmpresaDetallePlaneacionCompra() {
		return this.mostrarFK_IdEmpresaDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdEmpresaDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdLineaDetallePlaneacionCompra() {
		return this.mostrarFK_IdLineaDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdLineaDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdPeriodoDetallePlaneacionCompra() {
		return this.mostrarFK_IdPeriodoDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdPeriodoDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPlaneacionCompraDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdPlaneacionCompraDetallePlaneacionCompra() {
		return this.mostrarFK_IdPlaneacionCompraDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdPlaneacionCompraDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPlaneacionCompraDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdProductoDetallePlaneacionCompra() {
		return this.mostrarFK_IdProductoDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdProductoDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdSucursalDetallePlaneacionCompra() {
		return this.mostrarFK_IdSucursalDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdSucursalDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePlaneacionCompra=true;

	public Boolean getMostrarFK_IdUnidadDetallePlaneacionCompra() {
		return this.mostrarFK_IdUnidadDetallePlaneacionCompra;
	}

	public void setMostrarFK_IdUnidadDetallePlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePlaneacionCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdEjercicioDetallePlaneacionCompra() {
		return this.activarFK_IdEjercicioDetallePlaneacionCompra;
	}

	public void setActivarFK_IdEjercicioDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdEmpresaDetallePlaneacionCompra() {
		return this.activarFK_IdEmpresaDetallePlaneacionCompra;
	}

	public void setActivarFK_IdEmpresaDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdLineaDetallePlaneacionCompra() {
		return this.activarFK_IdLineaDetallePlaneacionCompra;
	}

	public void setActivarFK_IdLineaDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdLineaDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdPeriodoDetallePlaneacionCompra() {
		return this.activarFK_IdPeriodoDetallePlaneacionCompra;
	}

	public void setActivarFK_IdPeriodoDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPlaneacionCompraDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdPlaneacionCompraDetallePlaneacionCompra() {
		return this.activarFK_IdPlaneacionCompraDetallePlaneacionCompra;
	}

	public void setActivarFK_IdPlaneacionCompraDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPlaneacionCompraDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdProductoDetallePlaneacionCompra() {
		return this.activarFK_IdProductoDetallePlaneacionCompra;
	}

	public void setActivarFK_IdProductoDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdSucursalDetallePlaneacionCompra() {
		return this.activarFK_IdSucursalDetallePlaneacionCompra;
	}

	public void setActivarFK_IdSucursalDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePlaneacionCompra=true;

	public Boolean getActivarFK_IdUnidadDetallePlaneacionCompra() {
		return this.activarFK_IdUnidadDetallePlaneacionCompra;
	}

	public void setActivarFK_IdUnidadDetallePlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePlaneacionCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdEjercicioDetallePlaneacionCompra() {
		return this.resaltarFK_IdEjercicioDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdEjercicioDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdEmpresaDetallePlaneacionCompra() {
		return this.resaltarFK_IdEmpresaDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdEmpresaDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdLineaDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdLineaDetallePlaneacionCompra() {
		return this.resaltarFK_IdLineaDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdLineaDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdLineaDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdLineaDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdPeriodoDetallePlaneacionCompra() {
		return this.resaltarFK_IdPeriodoDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdPeriodoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdPlaneacionCompraDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdPlaneacionCompraDetallePlaneacionCompra() {
		return this.resaltarFK_IdPlaneacionCompraDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdPlaneacionCompraDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdPlaneacionCompraDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdPlaneacionCompraDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPlaneacionCompraDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdProductoDetallePlaneacionCompra() {
		return this.resaltarFK_IdProductoDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdProductoDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdSucursalDetallePlaneacionCompra() {
		return this.resaltarFK_IdSucursalDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdSucursalDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePlaneacionCompra=null;

	public Border getResaltarFK_IdUnidadDetallePlaneacionCompra() {
		return this.resaltarFK_IdUnidadDetallePlaneacionCompra;
	}

	public void setResaltarFK_IdUnidadDetallePlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePlaneacionCompraBeanSwingJInternalFrame detalleplaneacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePlaneacionCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}