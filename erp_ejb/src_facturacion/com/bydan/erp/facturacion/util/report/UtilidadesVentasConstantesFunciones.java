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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.UtilidadesVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.UtilidadesVentasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.UtilidadesVentasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UtilidadesVentasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="UtilidadesVentas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UtilidadesVentas"+UtilidadesVentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UtilidadesVentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UtilidadesVentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UtilidadesVentasConstantesFunciones.SCHEMA+"_"+UtilidadesVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadesVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UtilidadesVentasConstantesFunciones.SCHEMA+"_"+UtilidadesVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UtilidadesVentasConstantesFunciones.SCHEMA+"_"+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadesVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UtilidadesVentasConstantesFunciones.SCHEMA+"_"+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadesVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadesVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadesVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UtilidadesVentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UtilidadesVentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UtilidadesVentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UtilidadesVentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Utilidades Ventases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Utilidades Ventas";
	public static final String SCLASSWEBTITULO_LOWER="Utilidades Ventas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UtilidadesVentas";
	public static final String OBJECTNAME="utilidadesventas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="utilidades_ventas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select utilidadesventas from "+UtilidadesVentasConstantesFunciones.SPERSISTENCENAME+" utilidadesventas";
	public static String QUERYSELECTNATIVE="select "+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".id,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".version_row,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".id_sucursal,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".nombre_tipo_factura,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".fecha_emision,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".numero_documento,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".tipo,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".venta,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".costo,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".utilidad,"+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME+".porcentaje from "+UtilidadesVentasConstantesFunciones.SCHEMA+"."+UtilidadesVentasConstantesFunciones.TABLENAME;//+" as "+UtilidadesVentasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBRETIPOFACTURA= "nombre_tipo_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String TIPO= "tipo";
    public static final String VENTA= "venta";
    public static final String COSTO= "costo";
    public static final String UTILIDAD= "utilidad";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBRETIPOFACTURA= "Nombre Tipo Factura";
		public static final String LABEL_NOMBRETIPOFACTURA_LOWER= "Nombre Tipo Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
    	public static final String LABEL_VENTA= "Venta";
		public static final String LABEL_VENTA_LOWER= "Venta";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_UTILIDAD= "Utilad";
		public static final String LABEL_UTILIDAD_LOWER= "Utilidad";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getUtilidadesVentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_NOMBRETIPOFACTURA;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.FECHAEMISION)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.TIPO)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_TIPO;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.VENTA)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_VENTA;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.COSTO)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.UTILIDAD)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD;}
		if(sNombreColumna.equals(UtilidadesVentasConstantesFunciones.PORCENTAJE)) {sLabelColumna=UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getUtilidadesVentasDescripcion(UtilidadesVentas utilidadesventas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(utilidadesventas !=null/* && utilidadesventas.getId()!=0*/) {
			sDescripcion=utilidadesventas.getfecha_emision_desde().toString();//utilidadesventasutilidadesventas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUtilidadesVentasDescripcionDetallado(UtilidadesVentas utilidadesventas) {
		String sDescripcion="";
			
		sDescripcion+=UtilidadesVentasConstantesFunciones.ID+"=";
		sDescripcion+=utilidadesventas.getId().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=utilidadesventas.getVersionRow().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=utilidadesventas.getid_empresa().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=utilidadesventas.getid_sucursal().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=utilidadesventas.getfecha_emision_desde().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=utilidadesventas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=utilidadesventas.getnombre_completo_cliente()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA+"=";
		sDescripcion+=utilidadesventas.getnombre_tipo_factura()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=utilidadesventas.getfecha_emision().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=utilidadesventas.getnumero_documento()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.TIPO+"=";
		sDescripcion+=utilidadesventas.gettipo()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.VENTA+"=";
		sDescripcion+=utilidadesventas.getventa().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.COSTO+"=";
		sDescripcion+=utilidadesventas.getcosto().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.UTILIDAD+"=";
		sDescripcion+=utilidadesventas.getutilidad().toString()+",";
		sDescripcion+=UtilidadesVentasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=utilidadesventas.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUtilidadesVentasDescripcion(UtilidadesVentas utilidadesventas,String sValor) throws Exception {			
		if(utilidadesventas !=null) {
			//utilidadesventasutilidadesventas.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaUtilidadesVentas")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaUtilidadesVentas(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUtilidadesVentas(UtilidadesVentas utilidadesventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		utilidadesventas.setnombre_completo_cliente(utilidadesventas.getnombre_completo_cliente().trim());
		utilidadesventas.setnombre_tipo_factura(utilidadesventas.getnombre_tipo_factura().trim());
		utilidadesventas.setnumero_documento(utilidadesventas.getnumero_documento().trim());
		utilidadesventas.settipo(utilidadesventas.gettipo().trim());
	}
	
	public static void quitarEspaciosUtilidadesVentass(List<UtilidadesVentas> utilidadesventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {
			utilidadesventas.setnombre_completo_cliente(utilidadesventas.getnombre_completo_cliente().trim());
			utilidadesventas.setnombre_tipo_factura(utilidadesventas.getnombre_tipo_factura().trim());
			utilidadesventas.setnumero_documento(utilidadesventas.getnumero_documento().trim());
			utilidadesventas.settipo(utilidadesventas.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadesVentas(UtilidadesVentas utilidadesventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && utilidadesventas.getConCambioAuxiliar()) {
			utilidadesventas.setIsDeleted(utilidadesventas.getIsDeletedAuxiliar());	
			utilidadesventas.setIsNew(utilidadesventas.getIsNewAuxiliar());	
			utilidadesventas.setIsChanged(utilidadesventas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			utilidadesventas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			utilidadesventas.setIsDeletedAuxiliar(false);	
			utilidadesventas.setIsNewAuxiliar(false);	
			utilidadesventas.setIsChangedAuxiliar(false);
			
			utilidadesventas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadesVentass(List<UtilidadesVentas> utilidadesventass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UtilidadesVentas utilidadesventas : utilidadesventass) {
			if(conAsignarBase && utilidadesventas.getConCambioAuxiliar()) {
				utilidadesventas.setIsDeleted(utilidadesventas.getIsDeletedAuxiliar());	
				utilidadesventas.setIsNew(utilidadesventas.getIsNewAuxiliar());	
				utilidadesventas.setIsChanged(utilidadesventas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				utilidadesventas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				utilidadesventas.setIsDeletedAuxiliar(false);	
				utilidadesventas.setIsNewAuxiliar(false);	
				utilidadesventas.setIsChangedAuxiliar(false);
				
				utilidadesventas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUtilidadesVentas(UtilidadesVentas utilidadesventas,Boolean conEnteros) throws Exception  {
		utilidadesventas.setventa(0.0);
		utilidadesventas.setcosto(0.0);
		utilidadesventas.setutilidad(0.0);
		utilidadesventas.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUtilidadesVentass(List<UtilidadesVentas> utilidadesventass,Boolean conEnteros) throws Exception  {
		
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {
			utilidadesventas.setventa(0.0);
			utilidadesventas.setcosto(0.0);
			utilidadesventas.setutilidad(0.0);
			utilidadesventas.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUtilidadesVentas(List<UtilidadesVentas> utilidadesventass,UtilidadesVentas utilidadesventasAux) throws Exception  {
		UtilidadesVentasConstantesFunciones.InicializarValoresUtilidadesVentas(utilidadesventasAux,true);
		
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {
			if(utilidadesventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			utilidadesventasAux.setventa(utilidadesventasAux.getventa()+utilidadesventas.getventa());			
			utilidadesventasAux.setcosto(utilidadesventasAux.getcosto()+utilidadesventas.getcosto());			
			utilidadesventasAux.setutilidad(utilidadesventasAux.getutilidad()+utilidadesventas.getutilidad());			
			utilidadesventasAux.setporcentaje(utilidadesventasAux.getporcentaje()+utilidadesventas.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadesVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UtilidadesVentasConstantesFunciones.getArrayColumnasGlobalesUtilidadesVentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadesVentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadesVentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadesVentasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadesVentasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadesVentasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUtilidadesVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UtilidadesVentas> utilidadesventass,UtilidadesVentas utilidadesventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UtilidadesVentas utilidadesventasAux: utilidadesventass) {
			if(utilidadesventasAux!=null && utilidadesventas!=null) {
				if((utilidadesventasAux.getId()==null && utilidadesventas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(utilidadesventasAux.getId()!=null && utilidadesventas.getId()!=null){
					if(utilidadesventasAux.getId().equals(utilidadesventas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUtilidadesVentas(List<UtilidadesVentas> utilidadesventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ventaTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {			
			if(utilidadesventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventaTotal+=utilidadesventas.getventa();
			costoTotal+=utilidadesventas.getcosto();
			utilidadTotal+=utilidadesventas.getutilidad();
			porcentajeTotal+=utilidadesventas.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.VENTA);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_VENTA);
		datoGeneral.setdValorDouble(ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUtilidadesVentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_ID, UtilidadesVentasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_VERSIONROW, UtilidadesVentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_NOMBRETIPOFACTURA, UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISION, UtilidadesVentasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_NUMERODOCUMENTO, UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_TIPO, UtilidadesVentasConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_VENTA, UtilidadesVentasConstantesFunciones.VENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_COSTO, UtilidadesVentasConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD, UtilidadesVentasConstantesFunciones.UTILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE, UtilidadesVentasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUtilidadesVentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.VENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.UTILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadesVentasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadesVentas() throws Exception  {
		return UtilidadesVentasConstantesFunciones.getTiposSeleccionarUtilidadesVentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadesVentas(Boolean conFk) throws Exception  {
		return UtilidadesVentasConstantesFunciones.getTiposSeleccionarUtilidadesVentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadesVentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_VENTA);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_VENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUtilidadesVentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadesVentas(UtilidadesVentas utilidadesventasAux) throws Exception {
		
			utilidadesventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadesventasAux.getEmpresa()));
			utilidadesventasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadesventasAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadesVentas(List<UtilidadesVentas> utilidadesventassTemp) throws Exception {
		for(UtilidadesVentas utilidadesventasAux:utilidadesventassTemp) {
			
			utilidadesventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadesventasAux.getEmpresa()));
			utilidadesventasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadesventasAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadesVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUtilidadesVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadesVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadesVentasConstantesFunciones.getClassesRelationshipsOfUtilidadesVentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadesVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadesVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadesVentasConstantesFunciones.getClassesRelationshipsFromStringsOfUtilidadesVentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadesVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UtilidadesVentas utilidadesventas,List<UtilidadesVentas> utilidadesventass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(UtilidadesVentas utilidadesventas,List<UtilidadesVentas> utilidadesventass) throws Exception {
		try	{			
			for(UtilidadesVentas utilidadesventasLocal:utilidadesventass) {
				if(utilidadesventasLocal.getId().equals(utilidadesventas.getId())) {
					utilidadesventasLocal.setIsSelected(utilidadesventas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUtilidadesVentas(List<UtilidadesVentas> utilidadesventassAux) throws Exception {
		//this.utilidadesventassAux=utilidadesventassAux;
		
		for(UtilidadesVentas utilidadesventasAux:utilidadesventassAux) {
			if(utilidadesventasAux.getIsChanged()) {
				utilidadesventasAux.setIsChanged(false);
			}		
			
			if(utilidadesventasAux.getIsNew()) {
				utilidadesventasAux.setIsNew(false);
			}	
			
			if(utilidadesventasAux.getIsDeleted()) {
				utilidadesventasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUtilidadesVentas(UtilidadesVentas utilidadesventasAux) throws Exception {
		//this.utilidadesventasAux=utilidadesventasAux;
		
			if(utilidadesventasAux.getIsChanged()) {
				utilidadesventasAux.setIsChanged(false);
			}		
			
			if(utilidadesventasAux.getIsNew()) {
				utilidadesventasAux.setIsNew(false);
			}	
			
			if(utilidadesventasAux.getIsDeleted()) {
				utilidadesventasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UtilidadesVentas utilidadesventasAsignar,UtilidadesVentas utilidadesventas) throws Exception {
		utilidadesventasAsignar.setId(utilidadesventas.getId());	
		utilidadesventasAsignar.setVersionRow(utilidadesventas.getVersionRow());	
		utilidadesventasAsignar.setnombre_completo_cliente(utilidadesventas.getnombre_completo_cliente());	
		utilidadesventasAsignar.setnombre_tipo_factura(utilidadesventas.getnombre_tipo_factura());	
		utilidadesventasAsignar.setfecha_emision(utilidadesventas.getfecha_emision());	
		utilidadesventasAsignar.setnumero_documento(utilidadesventas.getnumero_documento());	
		utilidadesventasAsignar.settipo(utilidadesventas.gettipo());	
		utilidadesventasAsignar.setventa(utilidadesventas.getventa());	
		utilidadesventasAsignar.setcosto(utilidadesventas.getcosto());	
		utilidadesventasAsignar.setutilidad(utilidadesventas.getutilidad());	
		utilidadesventasAsignar.setporcentaje(utilidadesventas.getporcentaje());	
	}
	
	public static void inicializarUtilidadesVentas(UtilidadesVentas utilidadesventas) throws Exception {
		try {
				utilidadesventas.setId(0L);	
					
				utilidadesventas.setnombre_completo_cliente("");	
				utilidadesventas.setnombre_tipo_factura("");	
				utilidadesventas.setfecha_emision(new Date());	
				utilidadesventas.setnumero_documento("");	
				utilidadesventas.settipo("");	
				utilidadesventas.setventa(0.0);	
				utilidadesventas.setcosto(0.0);	
				utilidadesventas.setutilidad(0.0);	
				utilidadesventas.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUtilidadesVentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_VENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUtilidadesVentas(String sTipo,Row row,Workbook workbook,UtilidadesVentas utilidadesventas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getnombre_tipo_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getventa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getutilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadesventas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUtilidadesVentas="";
	
	public String getsFinalQueryUtilidadesVentas() {
		return this.sFinalQueryUtilidadesVentas;
	}
	
	public void setsFinalQueryUtilidadesVentas(String sFinalQueryUtilidadesVentas) {
		this.sFinalQueryUtilidadesVentas= sFinalQueryUtilidadesVentas;
	}
	
	public Border resaltarSeleccionarUtilidadesVentas=null;
	
	public Border setResaltarSeleccionarUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUtilidadesVentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUtilidadesVentas() {
		return this.resaltarSeleccionarUtilidadesVentas;
	}
	
	public void setResaltarSeleccionarUtilidadesVentas(Border borderResaltarSeleccionarUtilidadesVentas) {
		this.resaltarSeleccionarUtilidadesVentas= borderResaltarSeleccionarUtilidadesVentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUtilidadesVentas=null;
	public Boolean mostraridUtilidadesVentas=true;
	public Boolean activaridUtilidadesVentas=true;

	public Border resaltarid_empresaUtilidadesVentas=null;
	public Boolean mostrarid_empresaUtilidadesVentas=true;
	public Boolean activarid_empresaUtilidadesVentas=true;
	public Boolean cargarid_empresaUtilidadesVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUtilidadesVentas=false;//ConEventDepend=true

	public Border resaltarid_sucursalUtilidadesVentas=null;
	public Boolean mostrarid_sucursalUtilidadesVentas=true;
	public Boolean activarid_sucursalUtilidadesVentas=true;
	public Boolean cargarid_sucursalUtilidadesVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalUtilidadesVentas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeUtilidadesVentas=null;
	public Boolean mostrarfecha_emision_desdeUtilidadesVentas=true;
	public Boolean activarfecha_emision_desdeUtilidadesVentas=true;

	public Border resaltarfecha_emision_hastaUtilidadesVentas=null;
	public Boolean mostrarfecha_emision_hastaUtilidadesVentas=true;
	public Boolean activarfecha_emision_hastaUtilidadesVentas=true;

	public Border resaltarnombre_completo_clienteUtilidadesVentas=null;
	public Boolean mostrarnombre_completo_clienteUtilidadesVentas=true;
	public Boolean activarnombre_completo_clienteUtilidadesVentas=true;

	public Border resaltarnombre_tipo_facturaUtilidadesVentas=null;
	public Boolean mostrarnombre_tipo_facturaUtilidadesVentas=true;
	public Boolean activarnombre_tipo_facturaUtilidadesVentas=true;

	public Border resaltarfecha_emisionUtilidadesVentas=null;
	public Boolean mostrarfecha_emisionUtilidadesVentas=true;
	public Boolean activarfecha_emisionUtilidadesVentas=true;

	public Border resaltarnumero_documentoUtilidadesVentas=null;
	public Boolean mostrarnumero_documentoUtilidadesVentas=true;
	public Boolean activarnumero_documentoUtilidadesVentas=true;

	public Border resaltartipoUtilidadesVentas=null;
	public Boolean mostrartipoUtilidadesVentas=true;
	public Boolean activartipoUtilidadesVentas=true;

	public Border resaltarventaUtilidadesVentas=null;
	public Boolean mostrarventaUtilidadesVentas=true;
	public Boolean activarventaUtilidadesVentas=true;

	public Border resaltarcostoUtilidadesVentas=null;
	public Boolean mostrarcostoUtilidadesVentas=true;
	public Boolean activarcostoUtilidadesVentas=true;

	public Border resaltarutilidadUtilidadesVentas=null;
	public Boolean mostrarutilidadUtilidadesVentas=true;
	public Boolean activarutilidadUtilidadesVentas=true;

	public Border resaltarporcentajeUtilidadesVentas=null;
	public Boolean mostrarporcentajeUtilidadesVentas=true;
	public Boolean activarporcentajeUtilidadesVentas=true;

	
	

	public Border setResaltaridUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltaridUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUtilidadesVentas() {
		return this.resaltaridUtilidadesVentas;
	}

	public void setResaltaridUtilidadesVentas(Border borderResaltar) {
		this.resaltaridUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostraridUtilidadesVentas() {
		return this.mostraridUtilidadesVentas;
	}

	public void setMostraridUtilidadesVentas(Boolean mostraridUtilidadesVentas) {
		this.mostraridUtilidadesVentas= mostraridUtilidadesVentas;
	}

	public Boolean getActivaridUtilidadesVentas() {
		return this.activaridUtilidadesVentas;
	}

	public void setActivaridUtilidadesVentas(Boolean activaridUtilidadesVentas) {
		this.activaridUtilidadesVentas= activaridUtilidadesVentas;
	}

	public Border setResaltarid_empresaUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUtilidadesVentas() {
		return this.resaltarid_empresaUtilidadesVentas;
	}

	public void setResaltarid_empresaUtilidadesVentas(Border borderResaltar) {
		this.resaltarid_empresaUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaUtilidadesVentas() {
		return this.mostrarid_empresaUtilidadesVentas;
	}

	public void setMostrarid_empresaUtilidadesVentas(Boolean mostrarid_empresaUtilidadesVentas) {
		this.mostrarid_empresaUtilidadesVentas= mostrarid_empresaUtilidadesVentas;
	}

	public Boolean getActivarid_empresaUtilidadesVentas() {
		return this.activarid_empresaUtilidadesVentas;
	}

	public void setActivarid_empresaUtilidadesVentas(Boolean activarid_empresaUtilidadesVentas) {
		this.activarid_empresaUtilidadesVentas= activarid_empresaUtilidadesVentas;
	}

	public Boolean getCargarid_empresaUtilidadesVentas() {
		return this.cargarid_empresaUtilidadesVentas;
	}

	public void setCargarid_empresaUtilidadesVentas(Boolean cargarid_empresaUtilidadesVentas) {
		this.cargarid_empresaUtilidadesVentas= cargarid_empresaUtilidadesVentas;
	}

	public Border setResaltarid_sucursalUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalUtilidadesVentas() {
		return this.resaltarid_sucursalUtilidadesVentas;
	}

	public void setResaltarid_sucursalUtilidadesVentas(Border borderResaltar) {
		this.resaltarid_sucursalUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalUtilidadesVentas() {
		return this.mostrarid_sucursalUtilidadesVentas;
	}

	public void setMostrarid_sucursalUtilidadesVentas(Boolean mostrarid_sucursalUtilidadesVentas) {
		this.mostrarid_sucursalUtilidadesVentas= mostrarid_sucursalUtilidadesVentas;
	}

	public Boolean getActivarid_sucursalUtilidadesVentas() {
		return this.activarid_sucursalUtilidadesVentas;
	}

	public void setActivarid_sucursalUtilidadesVentas(Boolean activarid_sucursalUtilidadesVentas) {
		this.activarid_sucursalUtilidadesVentas= activarid_sucursalUtilidadesVentas;
	}

	public Boolean getCargarid_sucursalUtilidadesVentas() {
		return this.cargarid_sucursalUtilidadesVentas;
	}

	public void setCargarid_sucursalUtilidadesVentas(Boolean cargarid_sucursalUtilidadesVentas) {
		this.cargarid_sucursalUtilidadesVentas= cargarid_sucursalUtilidadesVentas;
	}

	public Border setResaltarfecha_emision_desdeUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeUtilidadesVentas() {
		return this.resaltarfecha_emision_desdeUtilidadesVentas;
	}

	public void setResaltarfecha_emision_desdeUtilidadesVentas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeUtilidadesVentas() {
		return this.mostrarfecha_emision_desdeUtilidadesVentas;
	}

	public void setMostrarfecha_emision_desdeUtilidadesVentas(Boolean mostrarfecha_emision_desdeUtilidadesVentas) {
		this.mostrarfecha_emision_desdeUtilidadesVentas= mostrarfecha_emision_desdeUtilidadesVentas;
	}

	public Boolean getActivarfecha_emision_desdeUtilidadesVentas() {
		return this.activarfecha_emision_desdeUtilidadesVentas;
	}

	public void setActivarfecha_emision_desdeUtilidadesVentas(Boolean activarfecha_emision_desdeUtilidadesVentas) {
		this.activarfecha_emision_desdeUtilidadesVentas= activarfecha_emision_desdeUtilidadesVentas;
	}

	public Border setResaltarfecha_emision_hastaUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaUtilidadesVentas() {
		return this.resaltarfecha_emision_hastaUtilidadesVentas;
	}

	public void setResaltarfecha_emision_hastaUtilidadesVentas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaUtilidadesVentas() {
		return this.mostrarfecha_emision_hastaUtilidadesVentas;
	}

	public void setMostrarfecha_emision_hastaUtilidadesVentas(Boolean mostrarfecha_emision_hastaUtilidadesVentas) {
		this.mostrarfecha_emision_hastaUtilidadesVentas= mostrarfecha_emision_hastaUtilidadesVentas;
	}

	public Boolean getActivarfecha_emision_hastaUtilidadesVentas() {
		return this.activarfecha_emision_hastaUtilidadesVentas;
	}

	public void setActivarfecha_emision_hastaUtilidadesVentas(Boolean activarfecha_emision_hastaUtilidadesVentas) {
		this.activarfecha_emision_hastaUtilidadesVentas= activarfecha_emision_hastaUtilidadesVentas;
	}

	public Border setResaltarnombre_completo_clienteUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteUtilidadesVentas() {
		return this.resaltarnombre_completo_clienteUtilidadesVentas;
	}

	public void setResaltarnombre_completo_clienteUtilidadesVentas(Border borderResaltar) {
		this.resaltarnombre_completo_clienteUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteUtilidadesVentas() {
		return this.mostrarnombre_completo_clienteUtilidadesVentas;
	}

	public void setMostrarnombre_completo_clienteUtilidadesVentas(Boolean mostrarnombre_completo_clienteUtilidadesVentas) {
		this.mostrarnombre_completo_clienteUtilidadesVentas= mostrarnombre_completo_clienteUtilidadesVentas;
	}

	public Boolean getActivarnombre_completo_clienteUtilidadesVentas() {
		return this.activarnombre_completo_clienteUtilidadesVentas;
	}

	public void setActivarnombre_completo_clienteUtilidadesVentas(Boolean activarnombre_completo_clienteUtilidadesVentas) {
		this.activarnombre_completo_clienteUtilidadesVentas= activarnombre_completo_clienteUtilidadesVentas;
	}

	public Border setResaltarnombre_tipo_facturaUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_facturaUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_facturaUtilidadesVentas() {
		return this.resaltarnombre_tipo_facturaUtilidadesVentas;
	}

	public void setResaltarnombre_tipo_facturaUtilidadesVentas(Border borderResaltar) {
		this.resaltarnombre_tipo_facturaUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_facturaUtilidadesVentas() {
		return this.mostrarnombre_tipo_facturaUtilidadesVentas;
	}

	public void setMostrarnombre_tipo_facturaUtilidadesVentas(Boolean mostrarnombre_tipo_facturaUtilidadesVentas) {
		this.mostrarnombre_tipo_facturaUtilidadesVentas= mostrarnombre_tipo_facturaUtilidadesVentas;
	}

	public Boolean getActivarnombre_tipo_facturaUtilidadesVentas() {
		return this.activarnombre_tipo_facturaUtilidadesVentas;
	}

	public void setActivarnombre_tipo_facturaUtilidadesVentas(Boolean activarnombre_tipo_facturaUtilidadesVentas) {
		this.activarnombre_tipo_facturaUtilidadesVentas= activarnombre_tipo_facturaUtilidadesVentas;
	}

	public Border setResaltarfecha_emisionUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionUtilidadesVentas() {
		return this.resaltarfecha_emisionUtilidadesVentas;
	}

	public void setResaltarfecha_emisionUtilidadesVentas(Border borderResaltar) {
		this.resaltarfecha_emisionUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionUtilidadesVentas() {
		return this.mostrarfecha_emisionUtilidadesVentas;
	}

	public void setMostrarfecha_emisionUtilidadesVentas(Boolean mostrarfecha_emisionUtilidadesVentas) {
		this.mostrarfecha_emisionUtilidadesVentas= mostrarfecha_emisionUtilidadesVentas;
	}

	public Boolean getActivarfecha_emisionUtilidadesVentas() {
		return this.activarfecha_emisionUtilidadesVentas;
	}

	public void setActivarfecha_emisionUtilidadesVentas(Boolean activarfecha_emisionUtilidadesVentas) {
		this.activarfecha_emisionUtilidadesVentas= activarfecha_emisionUtilidadesVentas;
	}

	public Border setResaltarnumero_documentoUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoUtilidadesVentas() {
		return this.resaltarnumero_documentoUtilidadesVentas;
	}

	public void setResaltarnumero_documentoUtilidadesVentas(Border borderResaltar) {
		this.resaltarnumero_documentoUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoUtilidadesVentas() {
		return this.mostrarnumero_documentoUtilidadesVentas;
	}

	public void setMostrarnumero_documentoUtilidadesVentas(Boolean mostrarnumero_documentoUtilidadesVentas) {
		this.mostrarnumero_documentoUtilidadesVentas= mostrarnumero_documentoUtilidadesVentas;
	}

	public Boolean getActivarnumero_documentoUtilidadesVentas() {
		return this.activarnumero_documentoUtilidadesVentas;
	}

	public void setActivarnumero_documentoUtilidadesVentas(Boolean activarnumero_documentoUtilidadesVentas) {
		this.activarnumero_documentoUtilidadesVentas= activarnumero_documentoUtilidadesVentas;
	}

	public Border setResaltartipoUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltartipoUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoUtilidadesVentas() {
		return this.resaltartipoUtilidadesVentas;
	}

	public void setResaltartipoUtilidadesVentas(Border borderResaltar) {
		this.resaltartipoUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrartipoUtilidadesVentas() {
		return this.mostrartipoUtilidadesVentas;
	}

	public void setMostrartipoUtilidadesVentas(Boolean mostrartipoUtilidadesVentas) {
		this.mostrartipoUtilidadesVentas= mostrartipoUtilidadesVentas;
	}

	public Boolean getActivartipoUtilidadesVentas() {
		return this.activartipoUtilidadesVentas;
	}

	public void setActivartipoUtilidadesVentas(Boolean activartipoUtilidadesVentas) {
		this.activartipoUtilidadesVentas= activartipoUtilidadesVentas;
	}

	public Border setResaltarventaUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarventaUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarventaUtilidadesVentas() {
		return this.resaltarventaUtilidadesVentas;
	}

	public void setResaltarventaUtilidadesVentas(Border borderResaltar) {
		this.resaltarventaUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarventaUtilidadesVentas() {
		return this.mostrarventaUtilidadesVentas;
	}

	public void setMostrarventaUtilidadesVentas(Boolean mostrarventaUtilidadesVentas) {
		this.mostrarventaUtilidadesVentas= mostrarventaUtilidadesVentas;
	}

	public Boolean getActivarventaUtilidadesVentas() {
		return this.activarventaUtilidadesVentas;
	}

	public void setActivarventaUtilidadesVentas(Boolean activarventaUtilidadesVentas) {
		this.activarventaUtilidadesVentas= activarventaUtilidadesVentas;
	}

	public Border setResaltarcostoUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarcostoUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoUtilidadesVentas() {
		return this.resaltarcostoUtilidadesVentas;
	}

	public void setResaltarcostoUtilidadesVentas(Border borderResaltar) {
		this.resaltarcostoUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarcostoUtilidadesVentas() {
		return this.mostrarcostoUtilidadesVentas;
	}

	public void setMostrarcostoUtilidadesVentas(Boolean mostrarcostoUtilidadesVentas) {
		this.mostrarcostoUtilidadesVentas= mostrarcostoUtilidadesVentas;
	}

	public Boolean getActivarcostoUtilidadesVentas() {
		return this.activarcostoUtilidadesVentas;
	}

	public void setActivarcostoUtilidadesVentas(Boolean activarcostoUtilidadesVentas) {
		this.activarcostoUtilidadesVentas= activarcostoUtilidadesVentas;
	}

	public Border setResaltarutilidadUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarutilidadUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidadUtilidadesVentas() {
		return this.resaltarutilidadUtilidadesVentas;
	}

	public void setResaltarutilidadUtilidadesVentas(Border borderResaltar) {
		this.resaltarutilidadUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarutilidadUtilidadesVentas() {
		return this.mostrarutilidadUtilidadesVentas;
	}

	public void setMostrarutilidadUtilidadesVentas(Boolean mostrarutilidadUtilidadesVentas) {
		this.mostrarutilidadUtilidadesVentas= mostrarutilidadUtilidadesVentas;
	}

	public Boolean getActivarutilidadUtilidadesVentas() {
		return this.activarutilidadUtilidadesVentas;
	}

	public void setActivarutilidadUtilidadesVentas(Boolean activarutilidadUtilidadesVentas) {
		this.activarutilidadUtilidadesVentas= activarutilidadUtilidadesVentas;
	}

	public Border setResaltarporcentajeUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadesventasBeanSwingJInternalFrame.jTtoolBarUtilidadesVentas.setBorder(borderResaltar);
		
		this.resaltarporcentajeUtilidadesVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeUtilidadesVentas() {
		return this.resaltarporcentajeUtilidadesVentas;
	}

	public void setResaltarporcentajeUtilidadesVentas(Border borderResaltar) {
		this.resaltarporcentajeUtilidadesVentas= borderResaltar;
	}

	public Boolean getMostrarporcentajeUtilidadesVentas() {
		return this.mostrarporcentajeUtilidadesVentas;
	}

	public void setMostrarporcentajeUtilidadesVentas(Boolean mostrarporcentajeUtilidadesVentas) {
		this.mostrarporcentajeUtilidadesVentas= mostrarporcentajeUtilidadesVentas;
	}

	public Boolean getActivarporcentajeUtilidadesVentas() {
		return this.activarporcentajeUtilidadesVentas;
	}

	public void setActivarporcentajeUtilidadesVentas(Boolean activarporcentajeUtilidadesVentas) {
		this.activarporcentajeUtilidadesVentas= activarporcentajeUtilidadesVentas;
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
		
		
		this.setMostraridUtilidadesVentas(esInicial);
		this.setMostrarid_empresaUtilidadesVentas(esInicial);
		this.setMostrarid_sucursalUtilidadesVentas(esInicial);
		this.setMostrarfecha_emision_desdeUtilidadesVentas(esInicial);
		this.setMostrarfecha_emision_hastaUtilidadesVentas(esInicial);
		this.setMostrarnombre_completo_clienteUtilidadesVentas(esInicial);
		this.setMostrarnombre_tipo_facturaUtilidadesVentas(esInicial);
		this.setMostrarfecha_emisionUtilidadesVentas(esInicial);
		this.setMostrarnumero_documentoUtilidadesVentas(esInicial);
		this.setMostrartipoUtilidadesVentas(esInicial);
		this.setMostrarventaUtilidadesVentas(esInicial);
		this.setMostrarcostoUtilidadesVentas(esInicial);
		this.setMostrarutilidadUtilidadesVentas(esInicial);
		this.setMostrarporcentajeUtilidadesVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.ID)) {
				this.setMostraridUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setMostrarnombre_tipo_facturaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.TIPO)) {
				this.setMostrartipoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.VENTA)) {
				this.setMostrarventaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.COSTO)) {
				this.setMostrarcostoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.UTILIDAD)) {
				this.setMostrarutilidadUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeUtilidadesVentas(esAsigna);
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
		
		
		this.setActivaridUtilidadesVentas(esInicial);
		this.setActivarid_empresaUtilidadesVentas(esInicial);
		this.setActivarid_sucursalUtilidadesVentas(esInicial);
		this.setActivarfecha_emision_desdeUtilidadesVentas(esInicial);
		this.setActivarfecha_emision_hastaUtilidadesVentas(esInicial);
		this.setActivarnombre_completo_clienteUtilidadesVentas(esInicial);
		this.setActivarnombre_tipo_facturaUtilidadesVentas(esInicial);
		this.setActivarfecha_emisionUtilidadesVentas(esInicial);
		this.setActivarnumero_documentoUtilidadesVentas(esInicial);
		this.setActivartipoUtilidadesVentas(esInicial);
		this.setActivarventaUtilidadesVentas(esInicial);
		this.setActivarcostoUtilidadesVentas(esInicial);
		this.setActivarutilidadUtilidadesVentas(esInicial);
		this.setActivarporcentajeUtilidadesVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.ID)) {
				this.setActivaridUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setActivarnombre_tipo_facturaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.TIPO)) {
				this.setActivartipoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.VENTA)) {
				this.setActivarventaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.COSTO)) {
				this.setActivarcostoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.UTILIDAD)) {
				this.setActivarutilidadUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeUtilidadesVentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUtilidadesVentas(esInicial);
		this.setResaltarid_empresaUtilidadesVentas(esInicial);
		this.setResaltarid_sucursalUtilidadesVentas(esInicial);
		this.setResaltarfecha_emision_desdeUtilidadesVentas(esInicial);
		this.setResaltarfecha_emision_hastaUtilidadesVentas(esInicial);
		this.setResaltarnombre_completo_clienteUtilidadesVentas(esInicial);
		this.setResaltarnombre_tipo_facturaUtilidadesVentas(esInicial);
		this.setResaltarfecha_emisionUtilidadesVentas(esInicial);
		this.setResaltarnumero_documentoUtilidadesVentas(esInicial);
		this.setResaltartipoUtilidadesVentas(esInicial);
		this.setResaltarventaUtilidadesVentas(esInicial);
		this.setResaltarcostoUtilidadesVentas(esInicial);
		this.setResaltarutilidadUtilidadesVentas(esInicial);
		this.setResaltarporcentajeUtilidadesVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.ID)) {
				this.setResaltaridUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setResaltarnombre_tipo_facturaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.TIPO)) {
				this.setResaltartipoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.VENTA)) {
				this.setResaltarventaUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.COSTO)) {
				this.setResaltarcostoUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.UTILIDAD)) {
				this.setResaltarutilidadUtilidadesVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadesVentasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeUtilidadesVentas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaUtilidadesVentasUtilidadesVentas=true;

	public Boolean getMostrarBusquedaUtilidadesVentasUtilidadesVentas() {
		return this.mostrarBusquedaUtilidadesVentasUtilidadesVentas;
	}

	public void setMostrarBusquedaUtilidadesVentasUtilidadesVentas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaUtilidadesVentasUtilidadesVentas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaUtilidadesVentasUtilidadesVentas=true;

	public Boolean getActivarBusquedaUtilidadesVentasUtilidadesVentas() {
		return this.activarBusquedaUtilidadesVentasUtilidadesVentas;
	}

	public void setActivarBusquedaUtilidadesVentasUtilidadesVentas(Boolean habilitarResaltar) {
		this.activarBusquedaUtilidadesVentasUtilidadesVentas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaUtilidadesVentasUtilidadesVentas=null;

	public Border getResaltarBusquedaUtilidadesVentasUtilidadesVentas() {
		return this.resaltarBusquedaUtilidadesVentasUtilidadesVentas;
	}

	public void setResaltarBusquedaUtilidadesVentasUtilidadesVentas(Border borderResaltar) {
		this.resaltarBusquedaUtilidadesVentasUtilidadesVentas= borderResaltar;
	}

	public void setResaltarBusquedaUtilidadesVentasUtilidadesVentas(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadesVentasBeanSwingJInternalFrame utilidadesventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaUtilidadesVentasUtilidadesVentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}