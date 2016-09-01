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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ReporteTestConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ReporteTestParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ReporteTestParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ReporteTestConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ReporteTest";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ReporteTest"+ReporteTestConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReporteTestHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReporteTestHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReporteTestConstantesFunciones.SCHEMA+"_"+ReporteTestConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReporteTestHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReporteTestConstantesFunciones.SCHEMA+"_"+ReporteTestConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReporteTestConstantesFunciones.SCHEMA+"_"+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReporteTestHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReporteTestConstantesFunciones.SCHEMA+"_"+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReporteTestHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReporteTestHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReporteTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReporteTestConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReporteTestConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReporteTestConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReporteTestConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Reporte Testes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Reporte Test";
	public static final String SCLASSWEBTITULO_LOWER="Reporte Test";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ReporteTest";
	public static final String OBJECTNAME="reportetest";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="reporte_test";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select reportetest from "+ReporteTestConstantesFunciones.SPERSISTENCENAME+" reportetest";
	public static String QUERYSELECTNATIVE="select "+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".id,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".version_row,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".id_empresa,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".id_modulo,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".nombre,"+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME+".ubicacion from "+ReporteTestConstantesFunciones.SCHEMA+"."+ReporteTestConstantesFunciones.TABLENAME;//+" as "+ReporteTestConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String NOMBRE= "nombre";
    public static final String UBICACION= "ubicacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_UBICACION= "Ubicacion";
		public static final String LABEL_UBICACION_LOWER= "Ubicacion";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXUBICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUBICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getReporteTestLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReporteTestConstantesFunciones.IDEMPRESA)) {sLabelColumna=ReporteTestConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ReporteTestConstantesFunciones.IDMODULO)) {sLabelColumna=ReporteTestConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ReporteTestConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ReporteTestConstantesFunciones.NOMBRE)) {sLabelColumna=ReporteTestConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ReporteTestConstantesFunciones.UBICACION)) {sLabelColumna=ReporteTestConstantesFunciones.LABEL_UBICACION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getReporteTestDescripcion(ReporteTest reportetest) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(reportetest !=null/* && reportetest.getId()!=0*/) {
			sDescripcion=reportetest.getnombre();//reportetestreportetest.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getReporteTestDescripcionDetallado(ReporteTest reportetest) {
		String sDescripcion="";
			
		sDescripcion+=ReporteTestConstantesFunciones.ID+"=";
		sDescripcion+=reportetest.getId().toString()+",";
		sDescripcion+=ReporteTestConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=reportetest.getVersionRow().toString()+",";
		sDescripcion+=ReporteTestConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=reportetest.getid_empresa().toString()+",";
		sDescripcion+=ReporteTestConstantesFunciones.IDMODULO+"=";
		sDescripcion+=reportetest.getid_modulo().toString()+",";
		sDescripcion+=ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=reportetest.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ReporteTestConstantesFunciones.NOMBRE+"=";
		sDescripcion+=reportetest.getnombre()+",";
		sDescripcion+=ReporteTestConstantesFunciones.UBICACION+"=";
		sDescripcion+=reportetest.getubicacion()+",";
			
		return sDescripcion;
	}
	
	public static void setReporteTestDescripcion(ReporteTest reportetest,String sValor) throws Exception {			
		if(reportetest !=null) {
			reportetest.setnombre(sValor);;//reportetestreportetest.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaReporteTest")) {
			sNombreIndice="Tipo=  Por Empresa Por Modulo Por Nombre Por Ubicacion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaReporteTest(Long id_empresa,Long id_modulo,String nombre,String ubicacion) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;}
		if(ubicacion!=null) {sDetalleIndice+=" Ubicacion="+ubicacion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReporteTest(ReporteTest reportetest,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		reportetest.setnombre(reportetest.getnombre().trim());
		reportetest.setubicacion(reportetest.getubicacion().trim());
	}
	
	public static void quitarEspaciosReporteTests(List<ReporteTest> reportetests,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReporteTest reportetest: reportetests) {
			reportetest.setnombre(reportetest.getnombre().trim());
			reportetest.setubicacion(reportetest.getubicacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReporteTest(ReporteTest reportetest,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && reportetest.getConCambioAuxiliar()) {
			reportetest.setIsDeleted(reportetest.getIsDeletedAuxiliar());	
			reportetest.setIsNew(reportetest.getIsNewAuxiliar());	
			reportetest.setIsChanged(reportetest.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			reportetest.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			reportetest.setIsDeletedAuxiliar(false);	
			reportetest.setIsNewAuxiliar(false);	
			reportetest.setIsChangedAuxiliar(false);
			
			reportetest.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReporteTests(List<ReporteTest> reportetests,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ReporteTest reportetest : reportetests) {
			if(conAsignarBase && reportetest.getConCambioAuxiliar()) {
				reportetest.setIsDeleted(reportetest.getIsDeletedAuxiliar());	
				reportetest.setIsNew(reportetest.getIsNewAuxiliar());	
				reportetest.setIsChanged(reportetest.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				reportetest.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				reportetest.setIsDeletedAuxiliar(false);	
				reportetest.setIsNewAuxiliar(false);	
				reportetest.setIsChangedAuxiliar(false);
				
				reportetest.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReporteTest(ReporteTest reportetest,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresReporteTests(List<ReporteTest> reportetests,Boolean conEnteros) throws Exception  {
		
		for(ReporteTest reportetest: reportetests) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaReporteTest(List<ReporteTest> reportetests,ReporteTest reportetestAux) throws Exception  {
		ReporteTestConstantesFunciones.InicializarValoresReporteTest(reportetestAux,true);
		
		for(ReporteTest reportetest: reportetests) {
			if(reportetest.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReporteTest(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReporteTestConstantesFunciones.getArrayColumnasGlobalesReporteTest(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReporteTest(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReporteTestConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReporteTestConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReporteTestConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReporteTestConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReporteTest(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ReporteTest> reportetests,ReporteTest reportetest,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ReporteTest reportetestAux: reportetests) {
			if(reportetestAux!=null && reportetest!=null) {
				if((reportetestAux.getId()==null && reportetest.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(reportetestAux.getId()!=null && reportetest.getId()!=null){
					if(reportetestAux.getId().equals(reportetest.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReporteTest(List<ReporteTest> reportetests) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ReporteTest reportetest: reportetests) {			
			if(reportetest.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReporteTest() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReporteTestConstantesFunciones.LABEL_ID, ReporteTestConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReporteTestConstantesFunciones.LABEL_VERSIONROW, ReporteTestConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReporteTestConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReporteTestConstantesFunciones.LABEL_NOMBRE, ReporteTestConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReporteTestConstantesFunciones.LABEL_UBICACION, ReporteTestConstantesFunciones.UBICACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReporteTest() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReporteTestConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReporteTestConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReporteTestConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReporteTestConstantesFunciones.UBICACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReporteTest() throws Exception  {
		return ReporteTestConstantesFunciones.getTiposSeleccionarReporteTest(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReporteTest(Boolean conFk) throws Exception  {
		return ReporteTestConstantesFunciones.getTiposSeleccionarReporteTest(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReporteTest(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReporteTestConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ReporteTestConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReporteTestConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ReporteTestConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReporteTestConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ReporteTestConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReporteTestConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ReporteTestConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReporteTestConstantesFunciones.LABEL_UBICACION);
			reporte.setsDescripcion(ReporteTestConstantesFunciones.LABEL_UBICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReporteTest(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReporteTest(ReporteTest reportetestAux) throws Exception {
		
			reportetestAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(reportetestAux.getEmpresa()));
			reportetestAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(reportetestAux.getModulo()));
			reportetestAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(reportetestAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReporteTest(List<ReporteTest> reportetestsTemp) throws Exception {
		for(ReporteTest reportetestAux:reportetestsTemp) {
			
			reportetestAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(reportetestAux.getEmpresa()));
			reportetestAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(reportetestAux.getModulo()));
			reportetestAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(reportetestAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReporteTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimiento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReporteTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReporteTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReporteTestConstantesFunciones.getClassesRelationshipsOfReporteTest(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReporteTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReporteTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReporteTestConstantesFunciones.getClassesRelationshipsFromStringsOfReporteTest(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReporteTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ReporteTest reportetest,List<ReporteTest> reportetests,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ReporteTest reportetest,List<ReporteTest> reportetests) throws Exception {
		try	{			
			for(ReporteTest reportetestLocal:reportetests) {
				if(reportetestLocal.getId().equals(reportetest.getId())) {
					reportetestLocal.setIsSelected(reportetest.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReporteTest(List<ReporteTest> reportetestsAux) throws Exception {
		//this.reportetestsAux=reportetestsAux;
		
		for(ReporteTest reportetestAux:reportetestsAux) {
			if(reportetestAux.getIsChanged()) {
				reportetestAux.setIsChanged(false);
			}		
			
			if(reportetestAux.getIsNew()) {
				reportetestAux.setIsNew(false);
			}	
			
			if(reportetestAux.getIsDeleted()) {
				reportetestAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReporteTest(ReporteTest reportetestAux) throws Exception {
		//this.reportetestAux=reportetestAux;
		
			if(reportetestAux.getIsChanged()) {
				reportetestAux.setIsChanged(false);
			}		
			
			if(reportetestAux.getIsNew()) {
				reportetestAux.setIsNew(false);
			}	
			
			if(reportetestAux.getIsDeleted()) {
				reportetestAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ReporteTest reportetestAsignar,ReporteTest reportetest) throws Exception {
		reportetestAsignar.setId(reportetest.getId());	
		reportetestAsignar.setVersionRow(reportetest.getVersionRow());	
		reportetestAsignar.setid_tipo_movimiento(reportetest.getid_tipo_movimiento());
		reportetestAsignar.settipomovimiento_descripcion(reportetest.gettipomovimiento_descripcion());	
		reportetestAsignar.setnombre(reportetest.getnombre());	
		reportetestAsignar.setubicacion(reportetest.getubicacion());	
	}
	
	public static void inicializarReporteTest(ReporteTest reportetest) throws Exception {
		try {
				reportetest.setId(0L);	
					
				reportetest.setid_tipo_movimiento(-1L);	
				reportetest.setnombre("");	
				reportetest.setubicacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReporteTest(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReporteTestConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReporteTestConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReporteTestConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReporteTestConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReporteTestConstantesFunciones.LABEL_UBICACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReporteTest(String sTipo,Row row,Workbook workbook,ReporteTest reportetest,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(reportetest.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(reportetest.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(reportetest.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(reportetest.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(reportetest.getubicacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReporteTest="";
	
	public String getsFinalQueryReporteTest() {
		return this.sFinalQueryReporteTest;
	}
	
	public void setsFinalQueryReporteTest(String sFinalQueryReporteTest) {
		this.sFinalQueryReporteTest= sFinalQueryReporteTest;
	}
	
	public Border resaltarSeleccionarReporteTest=null;
	
	public Border setResaltarSeleccionarReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReporteTest= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReporteTest() {
		return this.resaltarSeleccionarReporteTest;
	}
	
	public void setResaltarSeleccionarReporteTest(Border borderResaltarSeleccionarReporteTest) {
		this.resaltarSeleccionarReporteTest= borderResaltarSeleccionarReporteTest;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReporteTest=null;
	public Boolean mostraridReporteTest=true;
	public Boolean activaridReporteTest=true;

	public Border resaltarid_empresaReporteTest=null;
	public Boolean mostrarid_empresaReporteTest=true;
	public Boolean activarid_empresaReporteTest=true;
	public Boolean cargarid_empresaReporteTest=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaReporteTest=false;//ConEventDepend=true

	public Border resaltarid_moduloReporteTest=null;
	public Boolean mostrarid_moduloReporteTest=true;
	public Boolean activarid_moduloReporteTest=true;
	public Boolean cargarid_moduloReporteTest=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloReporteTest=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoReporteTest=null;
	public Boolean mostrarid_tipo_movimientoReporteTest=true;
	public Boolean activarid_tipo_movimientoReporteTest=true;
	public Boolean cargarid_tipo_movimientoReporteTest=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoReporteTest=false;//ConEventDepend=true

	public Border resaltarnombreReporteTest=null;
	public Boolean mostrarnombreReporteTest=true;
	public Boolean activarnombreReporteTest=true;

	public Border resaltarubicacionReporteTest=null;
	public Boolean mostrarubicacionReporteTest=true;
	public Boolean activarubicacionReporteTest=true;

	
	

	public Border setResaltaridReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltaridReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReporteTest() {
		return this.resaltaridReporteTest;
	}

	public void setResaltaridReporteTest(Border borderResaltar) {
		this.resaltaridReporteTest= borderResaltar;
	}

	public Boolean getMostraridReporteTest() {
		return this.mostraridReporteTest;
	}

	public void setMostraridReporteTest(Boolean mostraridReporteTest) {
		this.mostraridReporteTest= mostraridReporteTest;
	}

	public Boolean getActivaridReporteTest() {
		return this.activaridReporteTest;
	}

	public void setActivaridReporteTest(Boolean activaridReporteTest) {
		this.activaridReporteTest= activaridReporteTest;
	}

	public Border setResaltarid_empresaReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarid_empresaReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaReporteTest() {
		return this.resaltarid_empresaReporteTest;
	}

	public void setResaltarid_empresaReporteTest(Border borderResaltar) {
		this.resaltarid_empresaReporteTest= borderResaltar;
	}

	public Boolean getMostrarid_empresaReporteTest() {
		return this.mostrarid_empresaReporteTest;
	}

	public void setMostrarid_empresaReporteTest(Boolean mostrarid_empresaReporteTest) {
		this.mostrarid_empresaReporteTest= mostrarid_empresaReporteTest;
	}

	public Boolean getActivarid_empresaReporteTest() {
		return this.activarid_empresaReporteTest;
	}

	public void setActivarid_empresaReporteTest(Boolean activarid_empresaReporteTest) {
		this.activarid_empresaReporteTest= activarid_empresaReporteTest;
	}

	public Boolean getCargarid_empresaReporteTest() {
		return this.cargarid_empresaReporteTest;
	}

	public void setCargarid_empresaReporteTest(Boolean cargarid_empresaReporteTest) {
		this.cargarid_empresaReporteTest= cargarid_empresaReporteTest;
	}

	public Border setResaltarid_moduloReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarid_moduloReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloReporteTest() {
		return this.resaltarid_moduloReporteTest;
	}

	public void setResaltarid_moduloReporteTest(Border borderResaltar) {
		this.resaltarid_moduloReporteTest= borderResaltar;
	}

	public Boolean getMostrarid_moduloReporteTest() {
		return this.mostrarid_moduloReporteTest;
	}

	public void setMostrarid_moduloReporteTest(Boolean mostrarid_moduloReporteTest) {
		this.mostrarid_moduloReporteTest= mostrarid_moduloReporteTest;
	}

	public Boolean getActivarid_moduloReporteTest() {
		return this.activarid_moduloReporteTest;
	}

	public void setActivarid_moduloReporteTest(Boolean activarid_moduloReporteTest) {
		this.activarid_moduloReporteTest= activarid_moduloReporteTest;
	}

	public Boolean getCargarid_moduloReporteTest() {
		return this.cargarid_moduloReporteTest;
	}

	public void setCargarid_moduloReporteTest(Boolean cargarid_moduloReporteTest) {
		this.cargarid_moduloReporteTest= cargarid_moduloReporteTest;
	}

	public Border setResaltarid_tipo_movimientoReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoReporteTest() {
		return this.resaltarid_tipo_movimientoReporteTest;
	}

	public void setResaltarid_tipo_movimientoReporteTest(Border borderResaltar) {
		this.resaltarid_tipo_movimientoReporteTest= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoReporteTest() {
		return this.mostrarid_tipo_movimientoReporteTest;
	}

	public void setMostrarid_tipo_movimientoReporteTest(Boolean mostrarid_tipo_movimientoReporteTest) {
		this.mostrarid_tipo_movimientoReporteTest= mostrarid_tipo_movimientoReporteTest;
	}

	public Boolean getActivarid_tipo_movimientoReporteTest() {
		return this.activarid_tipo_movimientoReporteTest;
	}

	public void setActivarid_tipo_movimientoReporteTest(Boolean activarid_tipo_movimientoReporteTest) {
		this.activarid_tipo_movimientoReporteTest= activarid_tipo_movimientoReporteTest;
	}

	public Boolean getCargarid_tipo_movimientoReporteTest() {
		return this.cargarid_tipo_movimientoReporteTest;
	}

	public void setCargarid_tipo_movimientoReporteTest(Boolean cargarid_tipo_movimientoReporteTest) {
		this.cargarid_tipo_movimientoReporteTest= cargarid_tipo_movimientoReporteTest;
	}

	public Border setResaltarnombreReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarnombreReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreReporteTest() {
		return this.resaltarnombreReporteTest;
	}

	public void setResaltarnombreReporteTest(Border borderResaltar) {
		this.resaltarnombreReporteTest= borderResaltar;
	}

	public Boolean getMostrarnombreReporteTest() {
		return this.mostrarnombreReporteTest;
	}

	public void setMostrarnombreReporteTest(Boolean mostrarnombreReporteTest) {
		this.mostrarnombreReporteTest= mostrarnombreReporteTest;
	}

	public Boolean getActivarnombreReporteTest() {
		return this.activarnombreReporteTest;
	}

	public void setActivarnombreReporteTest(Boolean activarnombreReporteTest) {
		this.activarnombreReporteTest= activarnombreReporteTest;
	}

	public Border setResaltarubicacionReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//reportetestBeanSwingJInternalFrame.jTtoolBarReporteTest.setBorder(borderResaltar);
		
		this.resaltarubicacionReporteTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarubicacionReporteTest() {
		return this.resaltarubicacionReporteTest;
	}

	public void setResaltarubicacionReporteTest(Border borderResaltar) {
		this.resaltarubicacionReporteTest= borderResaltar;
	}

	public Boolean getMostrarubicacionReporteTest() {
		return this.mostrarubicacionReporteTest;
	}

	public void setMostrarubicacionReporteTest(Boolean mostrarubicacionReporteTest) {
		this.mostrarubicacionReporteTest= mostrarubicacionReporteTest;
	}

	public Boolean getActivarubicacionReporteTest() {
		return this.activarubicacionReporteTest;
	}

	public void setActivarubicacionReporteTest(Boolean activarubicacionReporteTest) {
		this.activarubicacionReporteTest= activarubicacionReporteTest;
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
		
		
		this.setMostraridReporteTest(esInicial);
		this.setMostrarid_empresaReporteTest(esInicial);
		this.setMostrarid_moduloReporteTest(esInicial);
		this.setMostrarid_tipo_movimientoReporteTest(esInicial);
		this.setMostrarnombreReporteTest(esInicial);
		this.setMostrarubicacionReporteTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReporteTestConstantesFunciones.ID)) {
				this.setMostraridReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.UBICACION)) {
				this.setMostrarubicacionReporteTest(esAsigna);
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
		
		
		this.setActivaridReporteTest(esInicial);
		this.setActivarid_empresaReporteTest(esInicial);
		this.setActivarid_moduloReporteTest(esInicial);
		this.setActivarid_tipo_movimientoReporteTest(esInicial);
		this.setActivarnombreReporteTest(esInicial);
		this.setActivarubicacionReporteTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReporteTestConstantesFunciones.ID)) {
				this.setActivaridReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.NOMBRE)) {
				this.setActivarnombreReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.UBICACION)) {
				this.setActivarubicacionReporteTest(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReporteTest(esInicial);
		this.setResaltarid_empresaReporteTest(esInicial);
		this.setResaltarid_moduloReporteTest(esInicial);
		this.setResaltarid_tipo_movimientoReporteTest(esInicial);
		this.setResaltarnombreReporteTest(esInicial);
		this.setResaltarubicacionReporteTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReporteTestConstantesFunciones.ID)) {
				this.setResaltaridReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreReporteTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReporteTestConstantesFunciones.UBICACION)) {
				this.setResaltarubicacionReporteTest(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaReporteTestReporteTest=true;

	public Boolean getMostrarBusquedaReporteTestReporteTest() {
		return this.mostrarBusquedaReporteTestReporteTest;
	}

	public void setMostrarBusquedaReporteTestReporteTest(Boolean visibilidadResaltar) {
		this.mostrarBusquedaReporteTestReporteTest= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaReporteTestReporteTest=true;

	public Boolean getActivarBusquedaReporteTestReporteTest() {
		return this.activarBusquedaReporteTestReporteTest;
	}

	public void setActivarBusquedaReporteTestReporteTest(Boolean habilitarResaltar) {
		this.activarBusquedaReporteTestReporteTest= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaReporteTestReporteTest=null;

	public Border getResaltarBusquedaReporteTestReporteTest() {
		return this.resaltarBusquedaReporteTestReporteTest;
	}

	public void setResaltarBusquedaReporteTestReporteTest(Border borderResaltar) {
		this.resaltarBusquedaReporteTestReporteTest= borderResaltar;
	}

	public void setResaltarBusquedaReporteTestReporteTest(ParametroGeneralUsuario parametroGeneralUsuario/*ReporteTestBeanSwingJInternalFrame reportetestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaReporteTestReporteTest= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}