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


import com.bydan.erp.facturacion.util.report.VentasResumidosVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasResumidosVentasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasResumidosVentasParameterGeneral;

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
final public class VentasResumidosVentasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasResumidosVentas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasResumidosVentas"+VentasResumidosVentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasResumidosVentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasResumidosVentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasResumidosVentasConstantesFunciones.SCHEMA+"_"+VentasResumidosVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidosVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasResumidosVentasConstantesFunciones.SCHEMA+"_"+VentasResumidosVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasResumidosVentasConstantesFunciones.SCHEMA+"_"+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidosVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasResumidosVentasConstantesFunciones.SCHEMA+"_"+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidosVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidosVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasResumidosVentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasResumidosVentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasResumidosVentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasResumidosVentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Resumidos Ventases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Resumidos Ventas";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Resumidos Ventas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasResumidosVentas";
	public static final String OBJECTNAME="ventasresumidosventas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_resumidos_ventas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventasresumidosventas from "+VentasResumidosVentasConstantesFunciones.SPERSISTENCENAME+" ventasresumidosventas";
	public static String QUERYSELECTNATIVE="select "+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".id,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".version_row,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".id_empresa,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".dia,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".total_iva,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".total_sin_iva,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".total_flete,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".iva,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".nombre_anio,"+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME+".nombre_mes from "+VentasResumidosVentasConstantesFunciones.SCHEMA+"."+VentasResumidosVentasConstantesFunciones.TABLENAME;//+" as "+VentasResumidosVentasConstantesFunciones.TABLENAME;
	
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
    public static final String DIA= "dia";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALFLETE= "total_flete";
    public static final String IVA= "iva";
    public static final String NOMBREANIO= "nombre_anio";
    public static final String NOMBREMES= "nombre_mes";
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
    	public static final String LABEL_DIA= "Dia";
		public static final String LABEL_DIA_LOWER= "Dia";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_TOTALFLETE= "Total Flete";
		public static final String LABEL_TOTALFLETE_LOWER= "Total Flete";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_NOMBREANIO= "Nombre Anio";
		public static final String LABEL_NOMBREANIO_LOWER= "Nombre Anio";
    	public static final String LABEL_NOMBREMES= "Nombre Mes";
		public static final String LABEL_NOMBREMES_LOWER= "Nombre Mes";
	
		
		
		
		
		
	public static final String SREGEXDIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNOMBRE_ANIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ANIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MES=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasResumidosVentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.DIA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_DIA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.TOTALIVA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.TOTALSINIVA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.TOTALFLETE)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.IVA)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.NOMBREANIO)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_NOMBREANIO;}
		if(sNombreColumna.equals(VentasResumidosVentasConstantesFunciones.NOMBREMES)) {sLabelColumna=VentasResumidosVentasConstantesFunciones.LABEL_NOMBREMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasResumidosVentasDescripcion(VentasResumidosVentas ventasresumidosventas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventasresumidosventas !=null/* && ventasresumidosventas.getId()!=0*/) {
			sDescripcion=ventasresumidosventas.getfecha_emision_hasta().toString();//ventasresumidosventasventasresumidosventas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasResumidosVentasDescripcionDetallado(VentasResumidosVentas ventasresumidosventas) {
		String sDescripcion="";
			
		sDescripcion+=VentasResumidosVentasConstantesFunciones.ID+"=";
		sDescripcion+=ventasresumidosventas.getId().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventasresumidosventas.getVersionRow().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventasresumidosventas.getid_empresa().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventasresumidosventas.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventasresumidosventas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.DIA+"=";
		sDescripcion+=ventasresumidosventas.getdia()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=ventasresumidosventas.gettotal_iva().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=ventasresumidosventas.gettotal_sin_iva().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.TOTALFLETE+"=";
		sDescripcion+=ventasresumidosventas.gettotal_flete().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.IVA+"=";
		sDescripcion+=ventasresumidosventas.getiva().toString()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.NOMBREANIO+"=";
		sDescripcion+=ventasresumidosventas.getnombre_anio()+",";
		sDescripcion+=VentasResumidosVentasConstantesFunciones.NOMBREMES+"=";
		sDescripcion+=ventasresumidosventas.getnombre_mes()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasResumidosVentasDescripcion(VentasResumidosVentas ventasresumidosventas,String sValor) throws Exception {			
		if(ventasresumidosventas !=null) {
			//ventasresumidosventasventasresumidosventas.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaVentasResumidosVentas")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasResumidosVentas(Date fecha_emision_desde,Date fecha_emision_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosVentasResumidosVentas(VentasResumidosVentas ventasresumidosventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidosventas.setdia(ventasresumidosventas.getdia().trim());
		ventasresumidosventas.setnombre_anio(ventasresumidosventas.getnombre_anio().trim());
		ventasresumidosventas.setnombre_mes(ventasresumidosventas.getnombre_mes().trim());
	}
	
	public static void quitarEspaciosVentasResumidosVentass(List<VentasResumidosVentas> ventasresumidosventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {
			ventasresumidosventas.setdia(ventasresumidosventas.getdia().trim());
			ventasresumidosventas.setnombre_anio(ventasresumidosventas.getnombre_anio().trim());
			ventasresumidosventas.setnombre_mes(ventasresumidosventas.getnombre_mes().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidosVentas(VentasResumidosVentas ventasresumidosventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventasresumidosventas.getConCambioAuxiliar()) {
			ventasresumidosventas.setIsDeleted(ventasresumidosventas.getIsDeletedAuxiliar());	
			ventasresumidosventas.setIsNew(ventasresumidosventas.getIsNewAuxiliar());	
			ventasresumidosventas.setIsChanged(ventasresumidosventas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventasresumidosventas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventasresumidosventas.setIsDeletedAuxiliar(false);	
			ventasresumidosventas.setIsNewAuxiliar(false);	
			ventasresumidosventas.setIsChangedAuxiliar(false);
			
			ventasresumidosventas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidosVentass(List<VentasResumidosVentas> ventasresumidosventass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasResumidosVentas ventasresumidosventas : ventasresumidosventass) {
			if(conAsignarBase && ventasresumidosventas.getConCambioAuxiliar()) {
				ventasresumidosventas.setIsDeleted(ventasresumidosventas.getIsDeletedAuxiliar());	
				ventasresumidosventas.setIsNew(ventasresumidosventas.getIsNewAuxiliar());	
				ventasresumidosventas.setIsChanged(ventasresumidosventas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventasresumidosventas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventasresumidosventas.setIsDeletedAuxiliar(false);	
				ventasresumidosventas.setIsNewAuxiliar(false);	
				ventasresumidosventas.setIsChangedAuxiliar(false);
				
				ventasresumidosventas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasResumidosVentas(VentasResumidosVentas ventasresumidosventas,Boolean conEnteros) throws Exception  {
		ventasresumidosventas.settotal_iva(0.0);
		ventasresumidosventas.settotal_sin_iva(0.0);
		ventasresumidosventas.settotal_flete(0.0);
		ventasresumidosventas.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasResumidosVentass(List<VentasResumidosVentas> ventasresumidosventass,Boolean conEnteros) throws Exception  {
		
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {
			ventasresumidosventas.settotal_iva(0.0);
			ventasresumidosventas.settotal_sin_iva(0.0);
			ventasresumidosventas.settotal_flete(0.0);
			ventasresumidosventas.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasResumidosVentas(List<VentasResumidosVentas> ventasresumidosventass,VentasResumidosVentas ventasresumidosventasAux) throws Exception  {
		VentasResumidosVentasConstantesFunciones.InicializarValoresVentasResumidosVentas(ventasresumidosventasAux,true);
		
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {
			if(ventasresumidosventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventasresumidosventasAux.settotal_iva(ventasresumidosventasAux.gettotal_iva()+ventasresumidosventas.gettotal_iva());			
			ventasresumidosventasAux.settotal_sin_iva(ventasresumidosventasAux.gettotal_sin_iva()+ventasresumidosventas.gettotal_sin_iva());			
			ventasresumidosventasAux.settotal_flete(ventasresumidosventasAux.gettotal_flete()+ventasresumidosventas.gettotal_flete());			
			ventasresumidosventasAux.setiva(ventasresumidosventasAux.getiva()+ventasresumidosventas.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidosVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasResumidosVentasConstantesFunciones.getArrayColumnasGlobalesVentasResumidosVentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidosVentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasResumidosVentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasResumidosVentasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasResumidosVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidosVentas> ventasresumidosventass,VentasResumidosVentas ventasresumidosventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidosVentas ventasresumidosventasAux: ventasresumidosventass) {
			if(ventasresumidosventasAux!=null && ventasresumidosventas!=null) {
				if((ventasresumidosventasAux.getId()==null && ventasresumidosventas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventasresumidosventasAux.getId()!=null && ventasresumidosventas.getId()!=null){
					if(ventasresumidosventasAux.getId().equals(ventasresumidosventas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidosVentas(List<VentasResumidosVentas> ventasresumidosventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_fleteTotal=0.0;
		Double ivaTotal=0.0;
	
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {			
			if(ventasresumidosventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=ventasresumidosventas.gettotal_iva();
			total_sin_ivaTotal+=ventasresumidosventas.gettotal_sin_iva();
			total_fleteTotal+=ventasresumidosventas.gettotal_flete();
			ivaTotal+=ventasresumidosventas.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALFLETE);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE);
		datoGeneral.setdValorDouble(total_fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasResumidosVentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_ID, VentasResumidosVentasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_VERSIONROW, VentasResumidosVentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_DIA, VentasResumidosVentasConstantesFunciones.DIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA, VentasResumidosVentasConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA, VentasResumidosVentasConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE, VentasResumidosVentasConstantesFunciones.TOTALFLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_IVA, VentasResumidosVentasConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_NOMBREANIO, VentasResumidosVentasConstantesFunciones.NOMBREANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosVentasConstantesFunciones.LABEL_NOMBREMES, VentasResumidosVentasConstantesFunciones.NOMBREMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasResumidosVentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.DIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.TOTALFLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.NOMBREANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosVentasConstantesFunciones.NOMBREMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidosVentas() throws Exception  {
		return VentasResumidosVentasConstantesFunciones.getTiposSeleccionarVentasResumidosVentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidosVentas(Boolean conFk) throws Exception  {
		return VentasResumidosVentasConstantesFunciones.getTiposSeleccionarVentasResumidosVentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidosVentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_DIA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_DIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREANIO);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREMES);
			reporte.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasResumidosVentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidosVentas(VentasResumidosVentas ventasresumidosventasAux) throws Exception {
		
			ventasresumidosventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidosventasAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidosVentas(List<VentasResumidosVentas> ventasresumidosventassTemp) throws Exception {
		for(VentasResumidosVentas ventasresumidosventasAux:ventasresumidosventassTemp) {
			
			ventasresumidosventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidosventasAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasResumidosVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasResumidosVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidosVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidosVentasConstantesFunciones.getClassesRelationshipsOfVentasResumidosVentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidosVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidosVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidosVentasConstantesFunciones.getClassesRelationshipsFromStringsOfVentasResumidosVentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidosVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasResumidosVentas ventasresumidosventas,List<VentasResumidosVentas> ventasresumidosventass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasResumidosVentas ventasresumidosventas,List<VentasResumidosVentas> ventasresumidosventass) throws Exception {
		try	{			
			for(VentasResumidosVentas ventasresumidosventasLocal:ventasresumidosventass) {
				if(ventasresumidosventasLocal.getId().equals(ventasresumidosventas.getId())) {
					ventasresumidosventasLocal.setIsSelected(ventasresumidosventas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasResumidosVentas(List<VentasResumidosVentas> ventasresumidosventassAux) throws Exception {
		//this.ventasresumidosventassAux=ventasresumidosventassAux;
		
		for(VentasResumidosVentas ventasresumidosventasAux:ventasresumidosventassAux) {
			if(ventasresumidosventasAux.getIsChanged()) {
				ventasresumidosventasAux.setIsChanged(false);
			}		
			
			if(ventasresumidosventasAux.getIsNew()) {
				ventasresumidosventasAux.setIsNew(false);
			}	
			
			if(ventasresumidosventasAux.getIsDeleted()) {
				ventasresumidosventasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasResumidosVentas(VentasResumidosVentas ventasresumidosventasAux) throws Exception {
		//this.ventasresumidosventasAux=ventasresumidosventasAux;
		
			if(ventasresumidosventasAux.getIsChanged()) {
				ventasresumidosventasAux.setIsChanged(false);
			}		
			
			if(ventasresumidosventasAux.getIsNew()) {
				ventasresumidosventasAux.setIsNew(false);
			}	
			
			if(ventasresumidosventasAux.getIsDeleted()) {
				ventasresumidosventasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasResumidosVentas ventasresumidosventasAsignar,VentasResumidosVentas ventasresumidosventas) throws Exception {
		ventasresumidosventasAsignar.setId(ventasresumidosventas.getId());	
		ventasresumidosventasAsignar.setVersionRow(ventasresumidosventas.getVersionRow());	
		ventasresumidosventasAsignar.setdia(ventasresumidosventas.getdia());	
		ventasresumidosventasAsignar.settotal_iva(ventasresumidosventas.gettotal_iva());	
		ventasresumidosventasAsignar.settotal_sin_iva(ventasresumidosventas.gettotal_sin_iva());	
		ventasresumidosventasAsignar.settotal_flete(ventasresumidosventas.gettotal_flete());	
		ventasresumidosventasAsignar.setiva(ventasresumidosventas.getiva());	
		ventasresumidosventasAsignar.setnombre_anio(ventasresumidosventas.getnombre_anio());	
		ventasresumidosventasAsignar.setnombre_mes(ventasresumidosventas.getnombre_mes());	
	}
	
	public static void inicializarVentasResumidosVentas(VentasResumidosVentas ventasresumidosventas) throws Exception {
		try {
				ventasresumidosventas.setId(0L);	
					
				ventasresumidosventas.setdia("");	
				ventasresumidosventas.settotal_iva(0.0);	
				ventasresumidosventas.settotal_sin_iva(0.0);	
				ventasresumidosventas.settotal_flete(0.0);	
				ventasresumidosventas.setiva(0.0);	
				ventasresumidosventas.setnombre_anio("");	
				ventasresumidosventas.setnombre_mes("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasResumidosVentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_DIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosVentasConstantesFunciones.LABEL_NOMBREMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasResumidosVentas(String sTipo,Row row,Workbook workbook,VentasResumidosVentas ventasresumidosventas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getdia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.gettotal_flete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getnombre_anio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidosventas.getnombre_mes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasResumidosVentas="";
	
	public String getsFinalQueryVentasResumidosVentas() {
		return this.sFinalQueryVentasResumidosVentas;
	}
	
	public void setsFinalQueryVentasResumidosVentas(String sFinalQueryVentasResumidosVentas) {
		this.sFinalQueryVentasResumidosVentas= sFinalQueryVentasResumidosVentas;
	}
	
	public Border resaltarSeleccionarVentasResumidosVentas=null;
	
	public Border setResaltarSeleccionarVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasResumidosVentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasResumidosVentas() {
		return this.resaltarSeleccionarVentasResumidosVentas;
	}
	
	public void setResaltarSeleccionarVentasResumidosVentas(Border borderResaltarSeleccionarVentasResumidosVentas) {
		this.resaltarSeleccionarVentasResumidosVentas= borderResaltarSeleccionarVentasResumidosVentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasResumidosVentas=null;
	public Boolean mostraridVentasResumidosVentas=true;
	public Boolean activaridVentasResumidosVentas=true;

	public Border resaltarid_empresaVentasResumidosVentas=null;
	public Boolean mostrarid_empresaVentasResumidosVentas=true;
	public Boolean activarid_empresaVentasResumidosVentas=true;
	public Boolean cargarid_empresaVentasResumidosVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasResumidosVentas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasResumidosVentas=null;
	public Boolean mostrarfecha_emision_desdeVentasResumidosVentas=true;
	public Boolean activarfecha_emision_desdeVentasResumidosVentas=true;

	public Border resaltarfecha_emision_hastaVentasResumidosVentas=null;
	public Boolean mostrarfecha_emision_hastaVentasResumidosVentas=true;
	public Boolean activarfecha_emision_hastaVentasResumidosVentas=true;

	public Border resaltardiaVentasResumidosVentas=null;
	public Boolean mostrardiaVentasResumidosVentas=true;
	public Boolean activardiaVentasResumidosVentas=true;

	public Border resaltartotal_ivaVentasResumidosVentas=null;
	public Boolean mostrartotal_ivaVentasResumidosVentas=true;
	public Boolean activartotal_ivaVentasResumidosVentas=true;

	public Border resaltartotal_sin_ivaVentasResumidosVentas=null;
	public Boolean mostrartotal_sin_ivaVentasResumidosVentas=true;
	public Boolean activartotal_sin_ivaVentasResumidosVentas=true;

	public Border resaltartotal_fleteVentasResumidosVentas=null;
	public Boolean mostrartotal_fleteVentasResumidosVentas=true;
	public Boolean activartotal_fleteVentasResumidosVentas=true;

	public Border resaltarivaVentasResumidosVentas=null;
	public Boolean mostrarivaVentasResumidosVentas=true;
	public Boolean activarivaVentasResumidosVentas=true;

	public Border resaltarnombre_anioVentasResumidosVentas=null;
	public Boolean mostrarnombre_anioVentasResumidosVentas=true;
	public Boolean activarnombre_anioVentasResumidosVentas=true;

	public Border resaltarnombre_mesVentasResumidosVentas=null;
	public Boolean mostrarnombre_mesVentasResumidosVentas=true;
	public Boolean activarnombre_mesVentasResumidosVentas=true;

	
	

	public Border setResaltaridVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltaridVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasResumidosVentas() {
		return this.resaltaridVentasResumidosVentas;
	}

	public void setResaltaridVentasResumidosVentas(Border borderResaltar) {
		this.resaltaridVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostraridVentasResumidosVentas() {
		return this.mostraridVentasResumidosVentas;
	}

	public void setMostraridVentasResumidosVentas(Boolean mostraridVentasResumidosVentas) {
		this.mostraridVentasResumidosVentas= mostraridVentasResumidosVentas;
	}

	public Boolean getActivaridVentasResumidosVentas() {
		return this.activaridVentasResumidosVentas;
	}

	public void setActivaridVentasResumidosVentas(Boolean activaridVentasResumidosVentas) {
		this.activaridVentasResumidosVentas= activaridVentasResumidosVentas;
	}

	public Border setResaltarid_empresaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasResumidosVentas() {
		return this.resaltarid_empresaVentasResumidosVentas;
	}

	public void setResaltarid_empresaVentasResumidosVentas(Border borderResaltar) {
		this.resaltarid_empresaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasResumidosVentas() {
		return this.mostrarid_empresaVentasResumidosVentas;
	}

	public void setMostrarid_empresaVentasResumidosVentas(Boolean mostrarid_empresaVentasResumidosVentas) {
		this.mostrarid_empresaVentasResumidosVentas= mostrarid_empresaVentasResumidosVentas;
	}

	public Boolean getActivarid_empresaVentasResumidosVentas() {
		return this.activarid_empresaVentasResumidosVentas;
	}

	public void setActivarid_empresaVentasResumidosVentas(Boolean activarid_empresaVentasResumidosVentas) {
		this.activarid_empresaVentasResumidosVentas= activarid_empresaVentasResumidosVentas;
	}

	public Boolean getCargarid_empresaVentasResumidosVentas() {
		return this.cargarid_empresaVentasResumidosVentas;
	}

	public void setCargarid_empresaVentasResumidosVentas(Boolean cargarid_empresaVentasResumidosVentas) {
		this.cargarid_empresaVentasResumidosVentas= cargarid_empresaVentasResumidosVentas;
	}

	public Border setResaltarfecha_emision_desdeVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasResumidosVentas() {
		return this.resaltarfecha_emision_desdeVentasResumidosVentas;
	}

	public void setResaltarfecha_emision_desdeVentasResumidosVentas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasResumidosVentas() {
		return this.mostrarfecha_emision_desdeVentasResumidosVentas;
	}

	public void setMostrarfecha_emision_desdeVentasResumidosVentas(Boolean mostrarfecha_emision_desdeVentasResumidosVentas) {
		this.mostrarfecha_emision_desdeVentasResumidosVentas= mostrarfecha_emision_desdeVentasResumidosVentas;
	}

	public Boolean getActivarfecha_emision_desdeVentasResumidosVentas() {
		return this.activarfecha_emision_desdeVentasResumidosVentas;
	}

	public void setActivarfecha_emision_desdeVentasResumidosVentas(Boolean activarfecha_emision_desdeVentasResumidosVentas) {
		this.activarfecha_emision_desdeVentasResumidosVentas= activarfecha_emision_desdeVentasResumidosVentas;
	}

	public Border setResaltarfecha_emision_hastaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasResumidosVentas() {
		return this.resaltarfecha_emision_hastaVentasResumidosVentas;
	}

	public void setResaltarfecha_emision_hastaVentasResumidosVentas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasResumidosVentas() {
		return this.mostrarfecha_emision_hastaVentasResumidosVentas;
	}

	public void setMostrarfecha_emision_hastaVentasResumidosVentas(Boolean mostrarfecha_emision_hastaVentasResumidosVentas) {
		this.mostrarfecha_emision_hastaVentasResumidosVentas= mostrarfecha_emision_hastaVentasResumidosVentas;
	}

	public Boolean getActivarfecha_emision_hastaVentasResumidosVentas() {
		return this.activarfecha_emision_hastaVentasResumidosVentas;
	}

	public void setActivarfecha_emision_hastaVentasResumidosVentas(Boolean activarfecha_emision_hastaVentasResumidosVentas) {
		this.activarfecha_emision_hastaVentasResumidosVentas= activarfecha_emision_hastaVentasResumidosVentas;
	}

	public Border setResaltardiaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltardiaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiaVentasResumidosVentas() {
		return this.resaltardiaVentasResumidosVentas;
	}

	public void setResaltardiaVentasResumidosVentas(Border borderResaltar) {
		this.resaltardiaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrardiaVentasResumidosVentas() {
		return this.mostrardiaVentasResumidosVentas;
	}

	public void setMostrardiaVentasResumidosVentas(Boolean mostrardiaVentasResumidosVentas) {
		this.mostrardiaVentasResumidosVentas= mostrardiaVentasResumidosVentas;
	}

	public Boolean getActivardiaVentasResumidosVentas() {
		return this.activardiaVentasResumidosVentas;
	}

	public void setActivardiaVentasResumidosVentas(Boolean activardiaVentasResumidosVentas) {
		this.activardiaVentasResumidosVentas= activardiaVentasResumidosVentas;
	}

	public Border setResaltartotal_ivaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltartotal_ivaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaVentasResumidosVentas() {
		return this.resaltartotal_ivaVentasResumidosVentas;
	}

	public void setResaltartotal_ivaVentasResumidosVentas(Border borderResaltar) {
		this.resaltartotal_ivaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrartotal_ivaVentasResumidosVentas() {
		return this.mostrartotal_ivaVentasResumidosVentas;
	}

	public void setMostrartotal_ivaVentasResumidosVentas(Boolean mostrartotal_ivaVentasResumidosVentas) {
		this.mostrartotal_ivaVentasResumidosVentas= mostrartotal_ivaVentasResumidosVentas;
	}

	public Boolean getActivartotal_ivaVentasResumidosVentas() {
		return this.activartotal_ivaVentasResumidosVentas;
	}

	public void setActivartotal_ivaVentasResumidosVentas(Boolean activartotal_ivaVentasResumidosVentas) {
		this.activartotal_ivaVentasResumidosVentas= activartotal_ivaVentasResumidosVentas;
	}

	public Border setResaltartotal_sin_ivaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaVentasResumidosVentas() {
		return this.resaltartotal_sin_ivaVentasResumidosVentas;
	}

	public void setResaltartotal_sin_ivaVentasResumidosVentas(Border borderResaltar) {
		this.resaltartotal_sin_ivaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaVentasResumidosVentas() {
		return this.mostrartotal_sin_ivaVentasResumidosVentas;
	}

	public void setMostrartotal_sin_ivaVentasResumidosVentas(Boolean mostrartotal_sin_ivaVentasResumidosVentas) {
		this.mostrartotal_sin_ivaVentasResumidosVentas= mostrartotal_sin_ivaVentasResumidosVentas;
	}

	public Boolean getActivartotal_sin_ivaVentasResumidosVentas() {
		return this.activartotal_sin_ivaVentasResumidosVentas;
	}

	public void setActivartotal_sin_ivaVentasResumidosVentas(Boolean activartotal_sin_ivaVentasResumidosVentas) {
		this.activartotal_sin_ivaVentasResumidosVentas= activartotal_sin_ivaVentasResumidosVentas;
	}

	public Border setResaltartotal_fleteVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltartotal_fleteVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_fleteVentasResumidosVentas() {
		return this.resaltartotal_fleteVentasResumidosVentas;
	}

	public void setResaltartotal_fleteVentasResumidosVentas(Border borderResaltar) {
		this.resaltartotal_fleteVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrartotal_fleteVentasResumidosVentas() {
		return this.mostrartotal_fleteVentasResumidosVentas;
	}

	public void setMostrartotal_fleteVentasResumidosVentas(Boolean mostrartotal_fleteVentasResumidosVentas) {
		this.mostrartotal_fleteVentasResumidosVentas= mostrartotal_fleteVentasResumidosVentas;
	}

	public Boolean getActivartotal_fleteVentasResumidosVentas() {
		return this.activartotal_fleteVentasResumidosVentas;
	}

	public void setActivartotal_fleteVentasResumidosVentas(Boolean activartotal_fleteVentasResumidosVentas) {
		this.activartotal_fleteVentasResumidosVentas= activartotal_fleteVentasResumidosVentas;
	}

	public Border setResaltarivaVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarivaVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaVentasResumidosVentas() {
		return this.resaltarivaVentasResumidosVentas;
	}

	public void setResaltarivaVentasResumidosVentas(Border borderResaltar) {
		this.resaltarivaVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarivaVentasResumidosVentas() {
		return this.mostrarivaVentasResumidosVentas;
	}

	public void setMostrarivaVentasResumidosVentas(Boolean mostrarivaVentasResumidosVentas) {
		this.mostrarivaVentasResumidosVentas= mostrarivaVentasResumidosVentas;
	}

	public Boolean getActivarivaVentasResumidosVentas() {
		return this.activarivaVentasResumidosVentas;
	}

	public void setActivarivaVentasResumidosVentas(Boolean activarivaVentasResumidosVentas) {
		this.activarivaVentasResumidosVentas= activarivaVentasResumidosVentas;
	}

	public Border setResaltarnombre_anioVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_anioVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_anioVentasResumidosVentas() {
		return this.resaltarnombre_anioVentasResumidosVentas;
	}

	public void setResaltarnombre_anioVentasResumidosVentas(Border borderResaltar) {
		this.resaltarnombre_anioVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_anioVentasResumidosVentas() {
		return this.mostrarnombre_anioVentasResumidosVentas;
	}

	public void setMostrarnombre_anioVentasResumidosVentas(Boolean mostrarnombre_anioVentasResumidosVentas) {
		this.mostrarnombre_anioVentasResumidosVentas= mostrarnombre_anioVentasResumidosVentas;
	}

	public Boolean getActivarnombre_anioVentasResumidosVentas() {
		return this.activarnombre_anioVentasResumidosVentas;
	}

	public void setActivarnombre_anioVentasResumidosVentas(Boolean activarnombre_anioVentasResumidosVentas) {
		this.activarnombre_anioVentasResumidosVentas= activarnombre_anioVentasResumidosVentas;
	}

	public Border setResaltarnombre_mesVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosventasBeanSwingJInternalFrame.jTtoolBarVentasResumidosVentas.setBorder(borderResaltar);
		
		this.resaltarnombre_mesVentasResumidosVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_mesVentasResumidosVentas() {
		return this.resaltarnombre_mesVentasResumidosVentas;
	}

	public void setResaltarnombre_mesVentasResumidosVentas(Border borderResaltar) {
		this.resaltarnombre_mesVentasResumidosVentas= borderResaltar;
	}

	public Boolean getMostrarnombre_mesVentasResumidosVentas() {
		return this.mostrarnombre_mesVentasResumidosVentas;
	}

	public void setMostrarnombre_mesVentasResumidosVentas(Boolean mostrarnombre_mesVentasResumidosVentas) {
		this.mostrarnombre_mesVentasResumidosVentas= mostrarnombre_mesVentasResumidosVentas;
	}

	public Boolean getActivarnombre_mesVentasResumidosVentas() {
		return this.activarnombre_mesVentasResumidosVentas;
	}

	public void setActivarnombre_mesVentasResumidosVentas(Boolean activarnombre_mesVentasResumidosVentas) {
		this.activarnombre_mesVentasResumidosVentas= activarnombre_mesVentasResumidosVentas;
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
		
		
		this.setMostraridVentasResumidosVentas(esInicial);
		this.setMostrarid_empresaVentasResumidosVentas(esInicial);
		this.setMostrarfecha_emision_desdeVentasResumidosVentas(esInicial);
		this.setMostrarfecha_emision_hastaVentasResumidosVentas(esInicial);
		this.setMostrardiaVentasResumidosVentas(esInicial);
		this.setMostrartotal_ivaVentasResumidosVentas(esInicial);
		this.setMostrartotal_sin_ivaVentasResumidosVentas(esInicial);
		this.setMostrartotal_fleteVentasResumidosVentas(esInicial);
		this.setMostrarivaVentasResumidosVentas(esInicial);
		this.setMostrarnombre_anioVentasResumidosVentas(esInicial);
		this.setMostrarnombre_mesVentasResumidosVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.ID)) {
				this.setMostraridVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.DIA)) {
				this.setMostrardiaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALFLETE)) {
				this.setMostrartotal_fleteVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IVA)) {
				this.setMostrarivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREANIO)) {
				this.setMostrarnombre_anioVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREMES)) {
				this.setMostrarnombre_mesVentasResumidosVentas(esAsigna);
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
		
		
		this.setActivaridVentasResumidosVentas(esInicial);
		this.setActivarid_empresaVentasResumidosVentas(esInicial);
		this.setActivarfecha_emision_desdeVentasResumidosVentas(esInicial);
		this.setActivarfecha_emision_hastaVentasResumidosVentas(esInicial);
		this.setActivardiaVentasResumidosVentas(esInicial);
		this.setActivartotal_ivaVentasResumidosVentas(esInicial);
		this.setActivartotal_sin_ivaVentasResumidosVentas(esInicial);
		this.setActivartotal_fleteVentasResumidosVentas(esInicial);
		this.setActivarivaVentasResumidosVentas(esInicial);
		this.setActivarnombre_anioVentasResumidosVentas(esInicial);
		this.setActivarnombre_mesVentasResumidosVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.ID)) {
				this.setActivaridVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.DIA)) {
				this.setActivardiaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALFLETE)) {
				this.setActivartotal_fleteVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IVA)) {
				this.setActivarivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREANIO)) {
				this.setActivarnombre_anioVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREMES)) {
				this.setActivarnombre_mesVentasResumidosVentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasResumidosVentas(esInicial);
		this.setResaltarid_empresaVentasResumidosVentas(esInicial);
		this.setResaltarfecha_emision_desdeVentasResumidosVentas(esInicial);
		this.setResaltarfecha_emision_hastaVentasResumidosVentas(esInicial);
		this.setResaltardiaVentasResumidosVentas(esInicial);
		this.setResaltartotal_ivaVentasResumidosVentas(esInicial);
		this.setResaltartotal_sin_ivaVentasResumidosVentas(esInicial);
		this.setResaltartotal_fleteVentasResumidosVentas(esInicial);
		this.setResaltarivaVentasResumidosVentas(esInicial);
		this.setResaltarnombre_anioVentasResumidosVentas(esInicial);
		this.setResaltarnombre_mesVentasResumidosVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.ID)) {
				this.setResaltaridVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.DIA)) {
				this.setResaltardiaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.TOTALFLETE)) {
				this.setResaltartotal_fleteVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.IVA)) {
				this.setResaltarivaVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREANIO)) {
				this.setResaltarnombre_anioVentasResumidosVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosVentasConstantesFunciones.NOMBREMES)) {
				this.setResaltarnombre_mesVentasResumidosVentas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasResumidosVentasVentasResumidosVentas=true;

	public Boolean getMostrarBusquedaVentasResumidosVentasVentasResumidosVentas() {
		return this.mostrarBusquedaVentasResumidosVentasVentasResumidosVentas;
	}

	public void setMostrarBusquedaVentasResumidosVentasVentasResumidosVentas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasResumidosVentasVentasResumidosVentas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasResumidosVentasVentasResumidosVentas=true;

	public Boolean getActivarBusquedaVentasResumidosVentasVentasResumidosVentas() {
		return this.activarBusquedaVentasResumidosVentasVentasResumidosVentas;
	}

	public void setActivarBusquedaVentasResumidosVentasVentasResumidosVentas(Boolean habilitarResaltar) {
		this.activarBusquedaVentasResumidosVentasVentasResumidosVentas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasResumidosVentasVentasResumidosVentas=null;

	public Border getResaltarBusquedaVentasResumidosVentasVentasResumidosVentas() {
		return this.resaltarBusquedaVentasResumidosVentasVentasResumidosVentas;
	}

	public void setResaltarBusquedaVentasResumidosVentasVentasResumidosVentas(Border borderResaltar) {
		this.resaltarBusquedaVentasResumidosVentasVentasResumidosVentas= borderResaltar;
	}

	public void setResaltarBusquedaVentasResumidosVentasVentasResumidosVentas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosVentasBeanSwingJInternalFrame ventasresumidosventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasResumidosVentasVentasResumidosVentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}