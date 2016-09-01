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


import com.bydan.erp.facturacion.util.report.VentasGeneralesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasGeneralesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasGeneralesParameterGeneral;

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
final public class VentasGeneralesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasGenerales";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasGenerales"+VentasGeneralesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasGeneralesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasGeneralesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasGeneralesConstantesFunciones.SCHEMA+"_"+VentasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasGeneralesConstantesFunciones.SCHEMA+"_"+VentasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasGeneralesConstantesFunciones.SCHEMA+"_"+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasGeneralesConstantesFunciones.SCHEMA+"_"+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasGeneralesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasGeneralesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Generaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Generales";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Generales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasGenerales";
	public static final String OBJECTNAME="ventasgenerales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_generales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventasgenerales from "+VentasGeneralesConstantesFunciones.SPERSISTENCENAME+" ventasgenerales";
	public static String QUERYSELECTNATIVE="select "+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".id,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".version_row,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".id_empresa,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".nombre_producto,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".monto,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".codigo_producto,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".notas_credito,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".venta_neta,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".porcentaje,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".acumulado,"+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME+".tipo from "+VentasGeneralesConstantesFunciones.SCHEMA+"."+VentasGeneralesConstantesFunciones.TABLENAME;//+" as "+VentasGeneralesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String MONTO= "monto";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOTASCREDITO= "notas_credito";
    public static final String VENTANETA= "venta_neta";
    public static final String PORCENTAJE= "porcentaje";
    public static final String ACUMULADO= "acumulado";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOTASCREDITO= "Notas Credito";
		public static final String LABEL_NOTASCREDITO_LOWER= "Notas Credito";
    	public static final String LABEL_VENTANETA= "Venta Neta";
		public static final String LABEL_VENTANETA_LOWER= "Venta Neta";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_ACUMULADO= "Acumulado";
		public static final String LABEL_ACUMULADO_LOWER= "Acumulado";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasGeneralesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.MONTO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.NOTASCREDITO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.VENTANETA)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_VENTANETA;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.PORCENTAJE)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.ACUMULADO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_ACUMULADO;}
		if(sNombreColumna.equals(VentasGeneralesConstantesFunciones.TIPO)) {sLabelColumna=VentasGeneralesConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasGeneralesDescripcion(VentasGenerales ventasgenerales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventasgenerales !=null/* && ventasgenerales.getId()!=0*/) {
			sDescripcion=ventasgenerales.getfecha_emision_hasta().toString();//ventasgeneralesventasgenerales.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasGeneralesDescripcionDetallado(VentasGenerales ventasgenerales) {
		String sDescripcion="";
			
		sDescripcion+=VentasGeneralesConstantesFunciones.ID+"=";
		sDescripcion+=ventasgenerales.getId().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventasgenerales.getVersionRow().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventasgenerales.getid_empresa().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventasgenerales.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventasgenerales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=ventasgenerales.getnombre_producto()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.MONTO+"=";
		sDescripcion+=ventasgenerales.getmonto().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=ventasgenerales.getcodigo_producto()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.NOTASCREDITO+"=";
		sDescripcion+=ventasgenerales.getnotas_credito().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.VENTANETA+"=";
		sDescripcion+=ventasgenerales.getventa_neta().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=ventasgenerales.getporcentaje().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.ACUMULADO+"=";
		sDescripcion+=ventasgenerales.getacumulado().toString()+",";
		sDescripcion+=VentasGeneralesConstantesFunciones.TIPO+"=";
		sDescripcion+=ventasgenerales.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasGeneralesDescripcion(VentasGenerales ventasgenerales,String sValor) throws Exception {			
		if(ventasgenerales !=null) {
			//ventasgeneralesventasgenerales.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaVentasGenerales")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasGenerales(Date fecha_emision_desde,Date fecha_emision_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosVentasGenerales(VentasGenerales ventasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasgenerales.setnombre_producto(ventasgenerales.getnombre_producto().trim());
		ventasgenerales.setcodigo_producto(ventasgenerales.getcodigo_producto().trim());
		ventasgenerales.settipo(ventasgenerales.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasGeneraless(List<VentasGenerales> ventasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasGenerales ventasgenerales: ventasgeneraless) {
			ventasgenerales.setnombre_producto(ventasgenerales.getnombre_producto().trim());
			ventasgenerales.setcodigo_producto(ventasgenerales.getcodigo_producto().trim());
			ventasgenerales.settipo(ventasgenerales.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasGenerales(VentasGenerales ventasgenerales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventasgenerales.getConCambioAuxiliar()) {
			ventasgenerales.setIsDeleted(ventasgenerales.getIsDeletedAuxiliar());	
			ventasgenerales.setIsNew(ventasgenerales.getIsNewAuxiliar());	
			ventasgenerales.setIsChanged(ventasgenerales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventasgenerales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventasgenerales.setIsDeletedAuxiliar(false);	
			ventasgenerales.setIsNewAuxiliar(false);	
			ventasgenerales.setIsChangedAuxiliar(false);
			
			ventasgenerales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasGeneraless(List<VentasGenerales> ventasgeneraless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasGenerales ventasgenerales : ventasgeneraless) {
			if(conAsignarBase && ventasgenerales.getConCambioAuxiliar()) {
				ventasgenerales.setIsDeleted(ventasgenerales.getIsDeletedAuxiliar());	
				ventasgenerales.setIsNew(ventasgenerales.getIsNewAuxiliar());	
				ventasgenerales.setIsChanged(ventasgenerales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventasgenerales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventasgenerales.setIsDeletedAuxiliar(false);	
				ventasgenerales.setIsNewAuxiliar(false);	
				ventasgenerales.setIsChangedAuxiliar(false);
				
				ventasgenerales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasGenerales(VentasGenerales ventasgenerales,Boolean conEnteros) throws Exception  {
		ventasgenerales.setmonto(0.0);
		ventasgenerales.setnotas_credito(0.0);
		ventasgenerales.setventa_neta(0.0);
		ventasgenerales.setporcentaje(0.0);
		ventasgenerales.setacumulado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasGeneraless(List<VentasGenerales> ventasgeneraless,Boolean conEnteros) throws Exception  {
		
		for(VentasGenerales ventasgenerales: ventasgeneraless) {
			ventasgenerales.setmonto(0.0);
			ventasgenerales.setnotas_credito(0.0);
			ventasgenerales.setventa_neta(0.0);
			ventasgenerales.setporcentaje(0.0);
			ventasgenerales.setacumulado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasGenerales(List<VentasGenerales> ventasgeneraless,VentasGenerales ventasgeneralesAux) throws Exception  {
		VentasGeneralesConstantesFunciones.InicializarValoresVentasGenerales(ventasgeneralesAux,true);
		
		for(VentasGenerales ventasgenerales: ventasgeneraless) {
			if(ventasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventasgeneralesAux.setmonto(ventasgeneralesAux.getmonto()+ventasgenerales.getmonto());			
			ventasgeneralesAux.setnotas_credito(ventasgeneralesAux.getnotas_credito()+ventasgenerales.getnotas_credito());			
			ventasgeneralesAux.setventa_neta(ventasgeneralesAux.getventa_neta()+ventasgenerales.getventa_neta());			
			ventasgeneralesAux.setporcentaje(ventasgeneralesAux.getporcentaje()+ventasgenerales.getporcentaje());			
			ventasgeneralesAux.setacumulado(ventasgeneralesAux.getacumulado()+ventasgenerales.getacumulado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasGeneralesConstantesFunciones.getArrayColumnasGlobalesVentasGenerales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasGenerales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasGeneralesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasGeneralesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasGenerales> ventasgeneraless,VentasGenerales ventasgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasGenerales ventasgeneralesAux: ventasgeneraless) {
			if(ventasgeneralesAux!=null && ventasgenerales!=null) {
				if((ventasgeneralesAux.getId()==null && ventasgenerales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventasgeneralesAux.getId()!=null && ventasgenerales.getId()!=null){
					if(ventasgeneralesAux.getId().equals(ventasgenerales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasGenerales(List<VentasGenerales> ventasgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasGenerales ventasgenerales: ventasgeneraless) {			
			if(ventasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=ventasgenerales.getmonto();
			notas_creditoTotal+=ventasgenerales.getnotas_credito();
			venta_netaTotal+=ventasgenerales.getventa_neta();
			porcentajeTotal+=ventasgenerales.getporcentaje();
			acumuladoTotal+=ventasgenerales.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasGenerales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_ID, VentasGeneralesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_VERSIONROW, VentasGeneralesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_NOMBREPRODUCTO, VentasGeneralesConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_MONTO, VentasGeneralesConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_CODIGOPRODUCTO, VentasGeneralesConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO, VentasGeneralesConstantesFunciones.NOTASCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_VENTANETA, VentasGeneralesConstantesFunciones.VENTANETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE, VentasGeneralesConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_ACUMULADO, VentasGeneralesConstantesFunciones.ACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasGeneralesConstantesFunciones.LABEL_TIPO, VentasGeneralesConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasGenerales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.NOTASCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.VENTANETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.ACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasGeneralesConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasGenerales() throws Exception  {
		return VentasGeneralesConstantesFunciones.getTiposSeleccionarVentasGenerales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasGenerales(Boolean conFk) throws Exception  {
		return VentasGeneralesConstantesFunciones.getTiposSeleccionarVentasGenerales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasGenerales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_VENTANETA);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_VENTANETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_ACUMULADO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_ACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasGeneralesConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasGenerales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasGenerales(VentasGenerales ventasgeneralesAux) throws Exception {
		
			ventasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasgeneralesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasGenerales(List<VentasGenerales> ventasgeneralessTemp) throws Exception {
		for(VentasGenerales ventasgeneralesAux:ventasgeneralessTemp) {
			
			ventasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasgeneralesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasGeneralesConstantesFunciones.getClassesRelationshipsOfVentasGenerales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasGeneralesConstantesFunciones.getClassesRelationshipsFromStringsOfVentasGenerales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasGenerales ventasgenerales,List<VentasGenerales> ventasgeneraless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasGenerales ventasgenerales,List<VentasGenerales> ventasgeneraless) throws Exception {
		try	{			
			for(VentasGenerales ventasgeneralesLocal:ventasgeneraless) {
				if(ventasgeneralesLocal.getId().equals(ventasgenerales.getId())) {
					ventasgeneralesLocal.setIsSelected(ventasgenerales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasGenerales(List<VentasGenerales> ventasgeneralessAux) throws Exception {
		//this.ventasgeneralessAux=ventasgeneralessAux;
		
		for(VentasGenerales ventasgeneralesAux:ventasgeneralessAux) {
			if(ventasgeneralesAux.getIsChanged()) {
				ventasgeneralesAux.setIsChanged(false);
			}		
			
			if(ventasgeneralesAux.getIsNew()) {
				ventasgeneralesAux.setIsNew(false);
			}	
			
			if(ventasgeneralesAux.getIsDeleted()) {
				ventasgeneralesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasGenerales(VentasGenerales ventasgeneralesAux) throws Exception {
		//this.ventasgeneralesAux=ventasgeneralesAux;
		
			if(ventasgeneralesAux.getIsChanged()) {
				ventasgeneralesAux.setIsChanged(false);
			}		
			
			if(ventasgeneralesAux.getIsNew()) {
				ventasgeneralesAux.setIsNew(false);
			}	
			
			if(ventasgeneralesAux.getIsDeleted()) {
				ventasgeneralesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasGenerales ventasgeneralesAsignar,VentasGenerales ventasgenerales) throws Exception {
		ventasgeneralesAsignar.setId(ventasgenerales.getId());	
		ventasgeneralesAsignar.setVersionRow(ventasgenerales.getVersionRow());	
		ventasgeneralesAsignar.setnombre_producto(ventasgenerales.getnombre_producto());	
		ventasgeneralesAsignar.setmonto(ventasgenerales.getmonto());	
		ventasgeneralesAsignar.setcodigo_producto(ventasgenerales.getcodigo_producto());	
		ventasgeneralesAsignar.setnotas_credito(ventasgenerales.getnotas_credito());	
		ventasgeneralesAsignar.setventa_neta(ventasgenerales.getventa_neta());	
		ventasgeneralesAsignar.setporcentaje(ventasgenerales.getporcentaje());	
		ventasgeneralesAsignar.setacumulado(ventasgenerales.getacumulado());	
		ventasgeneralesAsignar.settipo(ventasgenerales.gettipo());	
	}
	
	public static void inicializarVentasGenerales(VentasGenerales ventasgenerales) throws Exception {
		try {
				ventasgenerales.setId(0L);	
					
				ventasgenerales.setnombre_producto("");	
				ventasgenerales.setmonto(0.0);	
				ventasgenerales.setcodigo_producto("");	
				ventasgenerales.setnotas_credito(0.0);	
				ventasgenerales.setventa_neta(0.0);	
				ventasgenerales.setporcentaje(0.0);	
				ventasgenerales.setacumulado(0.0);	
				ventasgenerales.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasGenerales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_VENTANETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_ACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasGeneralesConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasGenerales(String sTipo,Row row,Workbook workbook,VentasGenerales ventasgenerales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getnotas_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getventa_neta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.getacumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasgenerales.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasGenerales="";
	
	public String getsFinalQueryVentasGenerales() {
		return this.sFinalQueryVentasGenerales;
	}
	
	public void setsFinalQueryVentasGenerales(String sFinalQueryVentasGenerales) {
		this.sFinalQueryVentasGenerales= sFinalQueryVentasGenerales;
	}
	
	public Border resaltarSeleccionarVentasGenerales=null;
	
	public Border setResaltarSeleccionarVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasGenerales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasGenerales() {
		return this.resaltarSeleccionarVentasGenerales;
	}
	
	public void setResaltarSeleccionarVentasGenerales(Border borderResaltarSeleccionarVentasGenerales) {
		this.resaltarSeleccionarVentasGenerales= borderResaltarSeleccionarVentasGenerales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasGenerales=null;
	public Boolean mostraridVentasGenerales=true;
	public Boolean activaridVentasGenerales=true;

	public Border resaltarid_empresaVentasGenerales=null;
	public Boolean mostrarid_empresaVentasGenerales=true;
	public Boolean activarid_empresaVentasGenerales=true;
	public Boolean cargarid_empresaVentasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasGenerales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasGenerales=null;
	public Boolean mostrarfecha_emision_desdeVentasGenerales=true;
	public Boolean activarfecha_emision_desdeVentasGenerales=true;

	public Border resaltarfecha_emision_hastaVentasGenerales=null;
	public Boolean mostrarfecha_emision_hastaVentasGenerales=true;
	public Boolean activarfecha_emision_hastaVentasGenerales=true;

	public Border resaltarnombre_productoVentasGenerales=null;
	public Boolean mostrarnombre_productoVentasGenerales=true;
	public Boolean activarnombre_productoVentasGenerales=true;

	public Border resaltarmontoVentasGenerales=null;
	public Boolean mostrarmontoVentasGenerales=true;
	public Boolean activarmontoVentasGenerales=true;

	public Border resaltarcodigo_productoVentasGenerales=null;
	public Boolean mostrarcodigo_productoVentasGenerales=true;
	public Boolean activarcodigo_productoVentasGenerales=true;

	public Border resaltarnotas_creditoVentasGenerales=null;
	public Boolean mostrarnotas_creditoVentasGenerales=true;
	public Boolean activarnotas_creditoVentasGenerales=true;

	public Border resaltarventa_netaVentasGenerales=null;
	public Boolean mostrarventa_netaVentasGenerales=true;
	public Boolean activarventa_netaVentasGenerales=true;

	public Border resaltarporcentajeVentasGenerales=null;
	public Boolean mostrarporcentajeVentasGenerales=true;
	public Boolean activarporcentajeVentasGenerales=true;

	public Border resaltaracumuladoVentasGenerales=null;
	public Boolean mostraracumuladoVentasGenerales=true;
	public Boolean activaracumuladoVentasGenerales=true;

	public Border resaltartipoVentasGenerales=null;
	public Boolean mostrartipoVentasGenerales=true;
	public Boolean activartipoVentasGenerales=true;

	
	

	public Border setResaltaridVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltaridVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasGenerales() {
		return this.resaltaridVentasGenerales;
	}

	public void setResaltaridVentasGenerales(Border borderResaltar) {
		this.resaltaridVentasGenerales= borderResaltar;
	}

	public Boolean getMostraridVentasGenerales() {
		return this.mostraridVentasGenerales;
	}

	public void setMostraridVentasGenerales(Boolean mostraridVentasGenerales) {
		this.mostraridVentasGenerales= mostraridVentasGenerales;
	}

	public Boolean getActivaridVentasGenerales() {
		return this.activaridVentasGenerales;
	}

	public void setActivaridVentasGenerales(Boolean activaridVentasGenerales) {
		this.activaridVentasGenerales= activaridVentasGenerales;
	}

	public Border setResaltarid_empresaVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasGenerales() {
		return this.resaltarid_empresaVentasGenerales;
	}

	public void setResaltarid_empresaVentasGenerales(Border borderResaltar) {
		this.resaltarid_empresaVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasGenerales() {
		return this.mostrarid_empresaVentasGenerales;
	}

	public void setMostrarid_empresaVentasGenerales(Boolean mostrarid_empresaVentasGenerales) {
		this.mostrarid_empresaVentasGenerales= mostrarid_empresaVentasGenerales;
	}

	public Boolean getActivarid_empresaVentasGenerales() {
		return this.activarid_empresaVentasGenerales;
	}

	public void setActivarid_empresaVentasGenerales(Boolean activarid_empresaVentasGenerales) {
		this.activarid_empresaVentasGenerales= activarid_empresaVentasGenerales;
	}

	public Boolean getCargarid_empresaVentasGenerales() {
		return this.cargarid_empresaVentasGenerales;
	}

	public void setCargarid_empresaVentasGenerales(Boolean cargarid_empresaVentasGenerales) {
		this.cargarid_empresaVentasGenerales= cargarid_empresaVentasGenerales;
	}

	public Border setResaltarfecha_emision_desdeVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasGenerales() {
		return this.resaltarfecha_emision_desdeVentasGenerales;
	}

	public void setResaltarfecha_emision_desdeVentasGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasGenerales() {
		return this.mostrarfecha_emision_desdeVentasGenerales;
	}

	public void setMostrarfecha_emision_desdeVentasGenerales(Boolean mostrarfecha_emision_desdeVentasGenerales) {
		this.mostrarfecha_emision_desdeVentasGenerales= mostrarfecha_emision_desdeVentasGenerales;
	}

	public Boolean getActivarfecha_emision_desdeVentasGenerales() {
		return this.activarfecha_emision_desdeVentasGenerales;
	}

	public void setActivarfecha_emision_desdeVentasGenerales(Boolean activarfecha_emision_desdeVentasGenerales) {
		this.activarfecha_emision_desdeVentasGenerales= activarfecha_emision_desdeVentasGenerales;
	}

	public Border setResaltarfecha_emision_hastaVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasGenerales() {
		return this.resaltarfecha_emision_hastaVentasGenerales;
	}

	public void setResaltarfecha_emision_hastaVentasGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasGenerales() {
		return this.mostrarfecha_emision_hastaVentasGenerales;
	}

	public void setMostrarfecha_emision_hastaVentasGenerales(Boolean mostrarfecha_emision_hastaVentasGenerales) {
		this.mostrarfecha_emision_hastaVentasGenerales= mostrarfecha_emision_hastaVentasGenerales;
	}

	public Boolean getActivarfecha_emision_hastaVentasGenerales() {
		return this.activarfecha_emision_hastaVentasGenerales;
	}

	public void setActivarfecha_emision_hastaVentasGenerales(Boolean activarfecha_emision_hastaVentasGenerales) {
		this.activarfecha_emision_hastaVentasGenerales= activarfecha_emision_hastaVentasGenerales;
	}

	public Border setResaltarnombre_productoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_productoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoVentasGenerales() {
		return this.resaltarnombre_productoVentasGenerales;
	}

	public void setResaltarnombre_productoVentasGenerales(Border borderResaltar) {
		this.resaltarnombre_productoVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_productoVentasGenerales() {
		return this.mostrarnombre_productoVentasGenerales;
	}

	public void setMostrarnombre_productoVentasGenerales(Boolean mostrarnombre_productoVentasGenerales) {
		this.mostrarnombre_productoVentasGenerales= mostrarnombre_productoVentasGenerales;
	}

	public Boolean getActivarnombre_productoVentasGenerales() {
		return this.activarnombre_productoVentasGenerales;
	}

	public void setActivarnombre_productoVentasGenerales(Boolean activarnombre_productoVentasGenerales) {
		this.activarnombre_productoVentasGenerales= activarnombre_productoVentasGenerales;
	}

	public Border setResaltarmontoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarmontoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoVentasGenerales() {
		return this.resaltarmontoVentasGenerales;
	}

	public void setResaltarmontoVentasGenerales(Border borderResaltar) {
		this.resaltarmontoVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarmontoVentasGenerales() {
		return this.mostrarmontoVentasGenerales;
	}

	public void setMostrarmontoVentasGenerales(Boolean mostrarmontoVentasGenerales) {
		this.mostrarmontoVentasGenerales= mostrarmontoVentasGenerales;
	}

	public Boolean getActivarmontoVentasGenerales() {
		return this.activarmontoVentasGenerales;
	}

	public void setActivarmontoVentasGenerales(Boolean activarmontoVentasGenerales) {
		this.activarmontoVentasGenerales= activarmontoVentasGenerales;
	}

	public Border setResaltarcodigo_productoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoVentasGenerales() {
		return this.resaltarcodigo_productoVentasGenerales;
	}

	public void setResaltarcodigo_productoVentasGenerales(Border borderResaltar) {
		this.resaltarcodigo_productoVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoVentasGenerales() {
		return this.mostrarcodigo_productoVentasGenerales;
	}

	public void setMostrarcodigo_productoVentasGenerales(Boolean mostrarcodigo_productoVentasGenerales) {
		this.mostrarcodigo_productoVentasGenerales= mostrarcodigo_productoVentasGenerales;
	}

	public Boolean getActivarcodigo_productoVentasGenerales() {
		return this.activarcodigo_productoVentasGenerales;
	}

	public void setActivarcodigo_productoVentasGenerales(Boolean activarcodigo_productoVentasGenerales) {
		this.activarcodigo_productoVentasGenerales= activarcodigo_productoVentasGenerales;
	}

	public Border setResaltarnotas_creditoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarnotas_creditoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnotas_creditoVentasGenerales() {
		return this.resaltarnotas_creditoVentasGenerales;
	}

	public void setResaltarnotas_creditoVentasGenerales(Border borderResaltar) {
		this.resaltarnotas_creditoVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarnotas_creditoVentasGenerales() {
		return this.mostrarnotas_creditoVentasGenerales;
	}

	public void setMostrarnotas_creditoVentasGenerales(Boolean mostrarnotas_creditoVentasGenerales) {
		this.mostrarnotas_creditoVentasGenerales= mostrarnotas_creditoVentasGenerales;
	}

	public Boolean getActivarnotas_creditoVentasGenerales() {
		return this.activarnotas_creditoVentasGenerales;
	}

	public void setActivarnotas_creditoVentasGenerales(Boolean activarnotas_creditoVentasGenerales) {
		this.activarnotas_creditoVentasGenerales= activarnotas_creditoVentasGenerales;
	}

	public Border setResaltarventa_netaVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarventa_netaVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarventa_netaVentasGenerales() {
		return this.resaltarventa_netaVentasGenerales;
	}

	public void setResaltarventa_netaVentasGenerales(Border borderResaltar) {
		this.resaltarventa_netaVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarventa_netaVentasGenerales() {
		return this.mostrarventa_netaVentasGenerales;
	}

	public void setMostrarventa_netaVentasGenerales(Boolean mostrarventa_netaVentasGenerales) {
		this.mostrarventa_netaVentasGenerales= mostrarventa_netaVentasGenerales;
	}

	public Boolean getActivarventa_netaVentasGenerales() {
		return this.activarventa_netaVentasGenerales;
	}

	public void setActivarventa_netaVentasGenerales(Boolean activarventa_netaVentasGenerales) {
		this.activarventa_netaVentasGenerales= activarventa_netaVentasGenerales;
	}

	public Border setResaltarporcentajeVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltarporcentajeVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeVentasGenerales() {
		return this.resaltarporcentajeVentasGenerales;
	}

	public void setResaltarporcentajeVentasGenerales(Border borderResaltar) {
		this.resaltarporcentajeVentasGenerales= borderResaltar;
	}

	public Boolean getMostrarporcentajeVentasGenerales() {
		return this.mostrarporcentajeVentasGenerales;
	}

	public void setMostrarporcentajeVentasGenerales(Boolean mostrarporcentajeVentasGenerales) {
		this.mostrarporcentajeVentasGenerales= mostrarporcentajeVentasGenerales;
	}

	public Boolean getActivarporcentajeVentasGenerales() {
		return this.activarporcentajeVentasGenerales;
	}

	public void setActivarporcentajeVentasGenerales(Boolean activarporcentajeVentasGenerales) {
		this.activarporcentajeVentasGenerales= activarporcentajeVentasGenerales;
	}

	public Border setResaltaracumuladoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltaracumuladoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracumuladoVentasGenerales() {
		return this.resaltaracumuladoVentasGenerales;
	}

	public void setResaltaracumuladoVentasGenerales(Border borderResaltar) {
		this.resaltaracumuladoVentasGenerales= borderResaltar;
	}

	public Boolean getMostraracumuladoVentasGenerales() {
		return this.mostraracumuladoVentasGenerales;
	}

	public void setMostraracumuladoVentasGenerales(Boolean mostraracumuladoVentasGenerales) {
		this.mostraracumuladoVentasGenerales= mostraracumuladoVentasGenerales;
	}

	public Boolean getActivaracumuladoVentasGenerales() {
		return this.activaracumuladoVentasGenerales;
	}

	public void setActivaracumuladoVentasGenerales(Boolean activaracumuladoVentasGenerales) {
		this.activaracumuladoVentasGenerales= activaracumuladoVentasGenerales;
	}

	public Border setResaltartipoVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasgeneralesBeanSwingJInternalFrame.jTtoolBarVentasGenerales.setBorder(borderResaltar);
		
		this.resaltartipoVentasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoVentasGenerales() {
		return this.resaltartipoVentasGenerales;
	}

	public void setResaltartipoVentasGenerales(Border borderResaltar) {
		this.resaltartipoVentasGenerales= borderResaltar;
	}

	public Boolean getMostrartipoVentasGenerales() {
		return this.mostrartipoVentasGenerales;
	}

	public void setMostrartipoVentasGenerales(Boolean mostrartipoVentasGenerales) {
		this.mostrartipoVentasGenerales= mostrartipoVentasGenerales;
	}

	public Boolean getActivartipoVentasGenerales() {
		return this.activartipoVentasGenerales;
	}

	public void setActivartipoVentasGenerales(Boolean activartipoVentasGenerales) {
		this.activartipoVentasGenerales= activartipoVentasGenerales;
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
		
		
		this.setMostraridVentasGenerales(esInicial);
		this.setMostrarid_empresaVentasGenerales(esInicial);
		this.setMostrarfecha_emision_desdeVentasGenerales(esInicial);
		this.setMostrarfecha_emision_hastaVentasGenerales(esInicial);
		this.setMostrarnombre_productoVentasGenerales(esInicial);
		this.setMostrarmontoVentasGenerales(esInicial);
		this.setMostrarcodigo_productoVentasGenerales(esInicial);
		this.setMostrarnotas_creditoVentasGenerales(esInicial);
		this.setMostrarventa_netaVentasGenerales(esInicial);
		this.setMostrarporcentajeVentasGenerales(esInicial);
		this.setMostraracumuladoVentasGenerales(esInicial);
		this.setMostrartipoVentasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ID)) {
				this.setMostraridVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.MONTO)) {
				this.setMostrarmontoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOTASCREDITO)) {
				this.setMostrarnotas_creditoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.VENTANETA)) {
				this.setMostrarventa_netaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ACUMULADO)) {
				this.setMostraracumuladoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.TIPO)) {
				this.setMostrartipoVentasGenerales(esAsigna);
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
		
		
		this.setActivaridVentasGenerales(esInicial);
		this.setActivarid_empresaVentasGenerales(esInicial);
		this.setActivarfecha_emision_desdeVentasGenerales(esInicial);
		this.setActivarfecha_emision_hastaVentasGenerales(esInicial);
		this.setActivarnombre_productoVentasGenerales(esInicial);
		this.setActivarmontoVentasGenerales(esInicial);
		this.setActivarcodigo_productoVentasGenerales(esInicial);
		this.setActivarnotas_creditoVentasGenerales(esInicial);
		this.setActivarventa_netaVentasGenerales(esInicial);
		this.setActivarporcentajeVentasGenerales(esInicial);
		this.setActivaracumuladoVentasGenerales(esInicial);
		this.setActivartipoVentasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ID)) {
				this.setActivaridVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.MONTO)) {
				this.setActivarmontoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOTASCREDITO)) {
				this.setActivarnotas_creditoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.VENTANETA)) {
				this.setActivarventa_netaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ACUMULADO)) {
				this.setActivaracumuladoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.TIPO)) {
				this.setActivartipoVentasGenerales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasGenerales(esInicial);
		this.setResaltarid_empresaVentasGenerales(esInicial);
		this.setResaltarfecha_emision_desdeVentasGenerales(esInicial);
		this.setResaltarfecha_emision_hastaVentasGenerales(esInicial);
		this.setResaltarnombre_productoVentasGenerales(esInicial);
		this.setResaltarmontoVentasGenerales(esInicial);
		this.setResaltarcodigo_productoVentasGenerales(esInicial);
		this.setResaltarnotas_creditoVentasGenerales(esInicial);
		this.setResaltarventa_netaVentasGenerales(esInicial);
		this.setResaltarporcentajeVentasGenerales(esInicial);
		this.setResaltaracumuladoVentasGenerales(esInicial);
		this.setResaltartipoVentasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ID)) {
				this.setResaltaridVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.MONTO)) {
				this.setResaltarmontoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.NOTASCREDITO)) {
				this.setResaltarnotas_creditoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.VENTANETA)) {
				this.setResaltarventa_netaVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.ACUMULADO)) {
				this.setResaltaracumuladoVentasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasGeneralesConstantesFunciones.TIPO)) {
				this.setResaltartipoVentasGenerales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasGeneralesVentasGenerales=true;

	public Boolean getMostrarBusquedaVentasGeneralesVentasGenerales() {
		return this.mostrarBusquedaVentasGeneralesVentasGenerales;
	}

	public void setMostrarBusquedaVentasGeneralesVentasGenerales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasGeneralesVentasGenerales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasGeneralesVentasGenerales=true;

	public Boolean getActivarBusquedaVentasGeneralesVentasGenerales() {
		return this.activarBusquedaVentasGeneralesVentasGenerales;
	}

	public void setActivarBusquedaVentasGeneralesVentasGenerales(Boolean habilitarResaltar) {
		this.activarBusquedaVentasGeneralesVentasGenerales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasGeneralesVentasGenerales=null;

	public Border getResaltarBusquedaVentasGeneralesVentasGenerales() {
		return this.resaltarBusquedaVentasGeneralesVentasGenerales;
	}

	public void setResaltarBusquedaVentasGeneralesVentasGenerales(Border borderResaltar) {
		this.resaltarBusquedaVentasGeneralesVentasGenerales= borderResaltar;
	}

	public void setResaltarBusquedaVentasGeneralesVentasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasGeneralesBeanSwingJInternalFrame ventasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasGeneralesVentasGenerales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}