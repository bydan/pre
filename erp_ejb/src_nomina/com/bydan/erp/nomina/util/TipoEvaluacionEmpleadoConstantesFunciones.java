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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoEvaluacionEmpleadoConstantesFunciones extends TipoEvaluacionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEvaluacionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEvaluacionEmpleado"+TipoEvaluacionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEvaluacionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEvaluacionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEvaluacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEvaluacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEvaluacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEvaluacionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEvaluacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEvaluacionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Evaluacion Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Evaluacion Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Evaluacion Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEvaluacionEmpleado";
	public static final String OBJECTNAME="tipoevaluacionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_evaluacion_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoevaluacionempleado from "+TipoEvaluacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipoevaluacionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoEvaluacionEmpleadoConstantesFuncionesAdditional tipoevaluacionempleadoConstantesFuncionesAdditional=null;
	
	public TipoEvaluacionEmpleadoConstantesFuncionesAdditional getTipoEvaluacionEmpleadoConstantesFuncionesAdditional() {
		return this.tipoevaluacionempleadoConstantesFuncionesAdditional;
	}
	
	public void setTipoEvaluacionEmpleadoConstantesFuncionesAdditional(TipoEvaluacionEmpleadoConstantesFuncionesAdditional tipoevaluacionempleadoConstantesFuncionesAdditional) {
		try {
			this.tipoevaluacionempleadoConstantesFuncionesAdditional=tipoevaluacionempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoEvaluacionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoEvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoEvaluacionEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=TipoEvaluacionEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEvaluacionEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoEvaluacionEmpleadoDescripcion(TipoEvaluacionEmpleado tipoevaluacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoevaluacionempleado !=null/* && tipoevaluacionempleado.getId()!=0*/) {
			sDescripcion=tipoevaluacionempleado.getcodigo();//tipoevaluacionempleadotipoevaluacionempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEvaluacionEmpleadoDescripcionDetallado(TipoEvaluacionEmpleado tipoevaluacionempleado) {
		String sDescripcion="";
			
		sDescripcion+=TipoEvaluacionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=tipoevaluacionempleado.getId().toString()+",";
		sDescripcion+=TipoEvaluacionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoevaluacionempleado.getVersionRow().toString()+",";
		sDescripcion+=TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoevaluacionempleado.getid_empresa().toString()+",";
		sDescripcion+=TipoEvaluacionEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoevaluacionempleado.getcodigo()+",";
		sDescripcion+=TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoevaluacionempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEvaluacionEmpleadoDescripcion(TipoEvaluacionEmpleado tipoevaluacionempleado,String sValor) throws Exception {			
		if(tipoevaluacionempleado !=null) {
			tipoevaluacionempleado.setcodigo(sValor);;//tipoevaluacionempleadotipoevaluacionempleado.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoevaluacionempleado.setcodigo(tipoevaluacionempleado.getcodigo().trim());
		tipoevaluacionempleado.setnombre(tipoevaluacionempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEvaluacionEmpleados(List<TipoEvaluacionEmpleado> tipoevaluacionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado: tipoevaluacionempleados) {
			tipoevaluacionempleado.setcodigo(tipoevaluacionempleado.getcodigo().trim());
			tipoevaluacionempleado.setnombre(tipoevaluacionempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoevaluacionempleado.getConCambioAuxiliar()) {
			tipoevaluacionempleado.setIsDeleted(tipoevaluacionempleado.getIsDeletedAuxiliar());	
			tipoevaluacionempleado.setIsNew(tipoevaluacionempleado.getIsNewAuxiliar());	
			tipoevaluacionempleado.setIsChanged(tipoevaluacionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoevaluacionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoevaluacionempleado.setIsDeletedAuxiliar(false);	
			tipoevaluacionempleado.setIsNewAuxiliar(false);	
			tipoevaluacionempleado.setIsChangedAuxiliar(false);
			
			tipoevaluacionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEvaluacionEmpleados(List<TipoEvaluacionEmpleado> tipoevaluacionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado : tipoevaluacionempleados) {
			if(conAsignarBase && tipoevaluacionempleado.getConCambioAuxiliar()) {
				tipoevaluacionempleado.setIsDeleted(tipoevaluacionempleado.getIsDeletedAuxiliar());	
				tipoevaluacionempleado.setIsNew(tipoevaluacionempleado.getIsNewAuxiliar());	
				tipoevaluacionempleado.setIsChanged(tipoevaluacionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoevaluacionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoevaluacionempleado.setIsDeletedAuxiliar(false);	
				tipoevaluacionempleado.setIsNewAuxiliar(false);	
				tipoevaluacionempleado.setIsChangedAuxiliar(false);
				
				tipoevaluacionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEvaluacionEmpleados(List<TipoEvaluacionEmpleado> tipoevaluacionempleados,Boolean conEnteros) throws Exception  {
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado: tipoevaluacionempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleado tipoevaluacionempleadoAux) throws Exception  {
		TipoEvaluacionEmpleadoConstantesFunciones.InicializarValoresTipoEvaluacionEmpleado(tipoevaluacionempleadoAux,true);
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado: tipoevaluacionempleados) {
			if(tipoevaluacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEvaluacionEmpleadoConstantesFunciones.getArrayColumnasGlobalesTipoEvaluacionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEvaluacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleado tipoevaluacionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleadoAux: tipoevaluacionempleados) {
			if(tipoevaluacionempleadoAux!=null && tipoevaluacionempleado!=null) {
				if((tipoevaluacionempleadoAux.getId()==null && tipoevaluacionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoevaluacionempleadoAux.getId()!=null && tipoevaluacionempleado.getId()!=null){
					if(tipoevaluacionempleadoAux.getId().equals(tipoevaluacionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> tipoevaluacionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEvaluacionEmpleado tipoevaluacionempleado: tipoevaluacionempleados) {			
			if(tipoevaluacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEvaluacionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEvaluacionEmpleadoConstantesFunciones.LABEL_ID, TipoEvaluacionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEvaluacionEmpleadoConstantesFunciones.LABEL_VERSIONROW, TipoEvaluacionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEvaluacionEmpleadoConstantesFunciones.LABEL_CODIGO, TipoEvaluacionEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEvaluacionEmpleadoConstantesFunciones.LABEL_NOMBRE, TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEvaluacionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEvaluacionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEvaluacionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEvaluacionEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEvaluacionEmpleado() throws Exception  {
		return TipoEvaluacionEmpleadoConstantesFunciones.getTiposSeleccionarTipoEvaluacionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEvaluacionEmpleado(Boolean conFk) throws Exception  {
		return TipoEvaluacionEmpleadoConstantesFunciones.getTiposSeleccionarTipoEvaluacionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEvaluacionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEvaluacionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleadoAux) throws Exception {
		
			tipoevaluacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoevaluacionempleadoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> tipoevaluacionempleadosTemp) throws Exception {
		for(TipoEvaluacionEmpleado tipoevaluacionempleadoAux:tipoevaluacionempleadosTemp) {
			
			tipoevaluacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoevaluacionempleadoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoEvaluacionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EvaluacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionEmpleado.class)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEvaluacionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEvaluacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoEvaluacionEmpleado tipoevaluacionempleado,List<TipoEvaluacionEmpleado> tipoevaluacionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEvaluacionEmpleado tipoevaluacionempleadoEncontrado=null;
			
			for(TipoEvaluacionEmpleado tipoevaluacionempleadoLocal:tipoevaluacionempleados) {
				if(tipoevaluacionempleadoLocal.getId().equals(tipoevaluacionempleado.getId())) {
					tipoevaluacionempleadoEncontrado=tipoevaluacionempleadoLocal;
					
					tipoevaluacionempleadoLocal.setIsChanged(tipoevaluacionempleado.getIsChanged());
					tipoevaluacionempleadoLocal.setIsNew(tipoevaluacionempleado.getIsNew());
					tipoevaluacionempleadoLocal.setIsDeleted(tipoevaluacionempleado.getIsDeleted());
					
					tipoevaluacionempleadoLocal.setGeneralEntityOriginal(tipoevaluacionempleado.getGeneralEntityOriginal());
					
					tipoevaluacionempleadoLocal.setId(tipoevaluacionempleado.getId());	
					tipoevaluacionempleadoLocal.setVersionRow(tipoevaluacionempleado.getVersionRow());	
					tipoevaluacionempleadoLocal.setid_empresa(tipoevaluacionempleado.getid_empresa());	
					tipoevaluacionempleadoLocal.setcodigo(tipoevaluacionempleado.getcodigo());	
					tipoevaluacionempleadoLocal.setnombre(tipoevaluacionempleado.getnombre());	
					
					
					tipoevaluacionempleadoLocal.setEvaluacionEmpleados(tipoevaluacionempleado.getEvaluacionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoevaluacionempleado.getIsDeleted()) {
				if(!existe) {
					tipoevaluacionempleados.add(tipoevaluacionempleado);
				}
			} else {
				if(tipoevaluacionempleadoEncontrado!=null && permiteQuitar)  {
					tipoevaluacionempleados.remove(tipoevaluacionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEvaluacionEmpleado tipoevaluacionempleado,List<TipoEvaluacionEmpleado> tipoevaluacionempleados) throws Exception {
		try	{			
			for(TipoEvaluacionEmpleado tipoevaluacionempleadoLocal:tipoevaluacionempleados) {
				if(tipoevaluacionempleadoLocal.getId().equals(tipoevaluacionempleado.getId())) {
					tipoevaluacionempleadoLocal.setIsSelected(tipoevaluacionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> tipoevaluacionempleadosAux) throws Exception {
		//this.tipoevaluacionempleadosAux=tipoevaluacionempleadosAux;
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleadoAux:tipoevaluacionempleadosAux) {
			if(tipoevaluacionempleadoAux.getIsChanged()) {
				tipoevaluacionempleadoAux.setIsChanged(false);
			}		
			
			if(tipoevaluacionempleadoAux.getIsNew()) {
				tipoevaluacionempleadoAux.setIsNew(false);
			}	
			
			if(tipoevaluacionempleadoAux.getIsDeleted()) {
				tipoevaluacionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleadoAux) throws Exception {
		//this.tipoevaluacionempleadoAux=tipoevaluacionempleadoAux;
		
			if(tipoevaluacionempleadoAux.getIsChanged()) {
				tipoevaluacionempleadoAux.setIsChanged(false);
			}		
			
			if(tipoevaluacionempleadoAux.getIsNew()) {
				tipoevaluacionempleadoAux.setIsNew(false);
			}	
			
			if(tipoevaluacionempleadoAux.getIsDeleted()) {
				tipoevaluacionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEvaluacionEmpleado tipoevaluacionempleadoAsignar,TipoEvaluacionEmpleado tipoevaluacionempleado) throws Exception {
		tipoevaluacionempleadoAsignar.setId(tipoevaluacionempleado.getId());	
		tipoevaluacionempleadoAsignar.setVersionRow(tipoevaluacionempleado.getVersionRow());	
		tipoevaluacionempleadoAsignar.setid_empresa(tipoevaluacionempleado.getid_empresa());
		tipoevaluacionempleadoAsignar.setempresa_descripcion(tipoevaluacionempleado.getempresa_descripcion());	
		tipoevaluacionempleadoAsignar.setcodigo(tipoevaluacionempleado.getcodigo());	
		tipoevaluacionempleadoAsignar.setnombre(tipoevaluacionempleado.getnombre());	
	}
	
	public static void inicializarTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado) throws Exception {
		try {
				tipoevaluacionempleado.setId(0L);	
					
				tipoevaluacionempleado.setid_empresa(-1L);	
				tipoevaluacionempleado.setcodigo("");	
				tipoevaluacionempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEvaluacionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEvaluacionEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEvaluacionEmpleado(String sTipo,Row row,Workbook workbook,TipoEvaluacionEmpleado tipoevaluacionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoevaluacionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoevaluacionempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoevaluacionempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEvaluacionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEvaluacionEmpleado() {
		return this.sFinalQueryTipoEvaluacionEmpleado;
	}
	
	public void setsFinalQueryTipoEvaluacionEmpleado(String sFinalQueryTipoEvaluacionEmpleado) {
		this.sFinalQueryTipoEvaluacionEmpleado= sFinalQueryTipoEvaluacionEmpleado;
	}
	
	public Border resaltarSeleccionarTipoEvaluacionEmpleado=null;
	
	public Border setResaltarSeleccionarTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEvaluacionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEvaluacionEmpleado() {
		return this.resaltarSeleccionarTipoEvaluacionEmpleado;
	}
	
	public void setResaltarSeleccionarTipoEvaluacionEmpleado(Border borderResaltarSeleccionarTipoEvaluacionEmpleado) {
		this.resaltarSeleccionarTipoEvaluacionEmpleado= borderResaltarSeleccionarTipoEvaluacionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEvaluacionEmpleado=null;
	public Boolean mostraridTipoEvaluacionEmpleado=true;
	public Boolean activaridTipoEvaluacionEmpleado=true;

	public Border resaltarid_empresaTipoEvaluacionEmpleado=null;
	public Boolean mostrarid_empresaTipoEvaluacionEmpleado=true;
	public Boolean activarid_empresaTipoEvaluacionEmpleado=true;
	public Boolean cargarid_empresaTipoEvaluacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoEvaluacionEmpleado=false;//ConEventDepend=true

	public Border resaltarcodigoTipoEvaluacionEmpleado=null;
	public Boolean mostrarcodigoTipoEvaluacionEmpleado=true;
	public Boolean activarcodigoTipoEvaluacionEmpleado=true;

	public Border resaltarnombreTipoEvaluacionEmpleado=null;
	public Boolean mostrarnombreTipoEvaluacionEmpleado=true;
	public Boolean activarnombreTipoEvaluacionEmpleado=true;

	
	

	public Border setResaltaridTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridTipoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEvaluacionEmpleado() {
		return this.resaltaridTipoEvaluacionEmpleado;
	}

	public void setResaltaridTipoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltaridTipoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostraridTipoEvaluacionEmpleado() {
		return this.mostraridTipoEvaluacionEmpleado;
	}

	public void setMostraridTipoEvaluacionEmpleado(Boolean mostraridTipoEvaluacionEmpleado) {
		this.mostraridTipoEvaluacionEmpleado= mostraridTipoEvaluacionEmpleado;
	}

	public Boolean getActivaridTipoEvaluacionEmpleado() {
		return this.activaridTipoEvaluacionEmpleado;
	}

	public void setActivaridTipoEvaluacionEmpleado(Boolean activaridTipoEvaluacionEmpleado) {
		this.activaridTipoEvaluacionEmpleado= activaridTipoEvaluacionEmpleado;
	}

	public Border setResaltarid_empresaTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoEvaluacionEmpleado() {
		return this.resaltarid_empresaTipoEvaluacionEmpleado;
	}

	public void setResaltarid_empresaTipoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaTipoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoEvaluacionEmpleado() {
		return this.mostrarid_empresaTipoEvaluacionEmpleado;
	}

	public void setMostrarid_empresaTipoEvaluacionEmpleado(Boolean mostrarid_empresaTipoEvaluacionEmpleado) {
		this.mostrarid_empresaTipoEvaluacionEmpleado= mostrarid_empresaTipoEvaluacionEmpleado;
	}

	public Boolean getActivarid_empresaTipoEvaluacionEmpleado() {
		return this.activarid_empresaTipoEvaluacionEmpleado;
	}

	public void setActivarid_empresaTipoEvaluacionEmpleado(Boolean activarid_empresaTipoEvaluacionEmpleado) {
		this.activarid_empresaTipoEvaluacionEmpleado= activarid_empresaTipoEvaluacionEmpleado;
	}

	public Boolean getCargarid_empresaTipoEvaluacionEmpleado() {
		return this.cargarid_empresaTipoEvaluacionEmpleado;
	}

	public void setCargarid_empresaTipoEvaluacionEmpleado(Boolean cargarid_empresaTipoEvaluacionEmpleado) {
		this.cargarid_empresaTipoEvaluacionEmpleado= cargarid_empresaTipoEvaluacionEmpleado;
	}

	public Border setResaltarcodigoTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoEvaluacionEmpleado() {
		return this.resaltarcodigoTipoEvaluacionEmpleado;
	}

	public void setResaltarcodigoTipoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarcodigoTipoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoEvaluacionEmpleado() {
		return this.mostrarcodigoTipoEvaluacionEmpleado;
	}

	public void setMostrarcodigoTipoEvaluacionEmpleado(Boolean mostrarcodigoTipoEvaluacionEmpleado) {
		this.mostrarcodigoTipoEvaluacionEmpleado= mostrarcodigoTipoEvaluacionEmpleado;
	}

	public Boolean getActivarcodigoTipoEvaluacionEmpleado() {
		return this.activarcodigoTipoEvaluacionEmpleado;
	}

	public void setActivarcodigoTipoEvaluacionEmpleado(Boolean activarcodigoTipoEvaluacionEmpleado) {
		this.activarcodigoTipoEvaluacionEmpleado= activarcodigoTipoEvaluacionEmpleado;
	}

	public Border setResaltarnombreTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEvaluacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEvaluacionEmpleado() {
		return this.resaltarnombreTipoEvaluacionEmpleado;
	}

	public void setResaltarnombreTipoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarnombreTipoEvaluacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEvaluacionEmpleado() {
		return this.mostrarnombreTipoEvaluacionEmpleado;
	}

	public void setMostrarnombreTipoEvaluacionEmpleado(Boolean mostrarnombreTipoEvaluacionEmpleado) {
		this.mostrarnombreTipoEvaluacionEmpleado= mostrarnombreTipoEvaluacionEmpleado;
	}

	public Boolean getActivarnombreTipoEvaluacionEmpleado() {
		return this.activarnombreTipoEvaluacionEmpleado;
	}

	public void setActivarnombreTipoEvaluacionEmpleado(Boolean activarnombreTipoEvaluacionEmpleado) {
		this.activarnombreTipoEvaluacionEmpleado= activarnombreTipoEvaluacionEmpleado;
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
		
		
		this.setMostraridTipoEvaluacionEmpleado(esInicial);
		this.setMostrarid_empresaTipoEvaluacionEmpleado(esInicial);
		this.setMostrarcodigoTipoEvaluacionEmpleado(esInicial);
		this.setMostrarnombreTipoEvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEvaluacionEmpleado(esAsigna);
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
		
		
		this.setActivaridTipoEvaluacionEmpleado(esInicial);
		this.setActivarid_empresaTipoEvaluacionEmpleado(esInicial);
		this.setActivarcodigoTipoEvaluacionEmpleado(esInicial);
		this.setActivarnombreTipoEvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEvaluacionEmpleado(esInicial);
		this.setResaltarid_empresaTipoEvaluacionEmpleado(esInicial);
		this.setResaltarcodigoTipoEvaluacionEmpleado(esInicial);
		this.setResaltarnombreTipoEvaluacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEvaluacionEmpleadoTipoEvaluacionEmpleado=null;

	public Border getResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado() {
		return this.resaltarEvaluacionEmpleadoTipoEvaluacionEmpleado;
	}

	public void setResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado(Border borderResaltarEvaluacionEmpleado) {
		if(borderResaltarEvaluacionEmpleado!=null) {
			this.resaltarEvaluacionEmpleadoTipoEvaluacionEmpleado= borderResaltarEvaluacionEmpleado;
		}
	}

	public Border setResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEvaluacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoevaluacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoEvaluacionEmpleado.setBorder(borderResaltarEvaluacionEmpleado);
			
		this.resaltarEvaluacionEmpleadoTipoEvaluacionEmpleado= borderResaltarEvaluacionEmpleado;

		 return borderResaltarEvaluacionEmpleado;
	}



	public Boolean mostrarEvaluacionEmpleadoTipoEvaluacionEmpleado=true;

	public Boolean getMostrarEvaluacionEmpleadoTipoEvaluacionEmpleado() {
		return this.mostrarEvaluacionEmpleadoTipoEvaluacionEmpleado;
	}

	public void setMostrarEvaluacionEmpleadoTipoEvaluacionEmpleado(Boolean visibilidadResaltarEvaluacionEmpleado) {
		this.mostrarEvaluacionEmpleadoTipoEvaluacionEmpleado= visibilidadResaltarEvaluacionEmpleado;
	}



	public Boolean activarEvaluacionEmpleadoTipoEvaluacionEmpleado=true;

	public Boolean gethabilitarResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado() {
		return this.activarEvaluacionEmpleadoTipoEvaluacionEmpleado;
	}

	public void setActivarEvaluacionEmpleadoTipoEvaluacionEmpleado(Boolean habilitarResaltarEvaluacionEmpleado) {
		this.activarEvaluacionEmpleadoTipoEvaluacionEmpleado= habilitarResaltarEvaluacionEmpleado;
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

		this.setMostrarEvaluacionEmpleadoTipoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setMostrarEvaluacionEmpleadoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}
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

		this.setActivarEvaluacionEmpleadoTipoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setActivarEvaluacionEmpleadoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setResaltarEvaluacionEmpleadoTipoEvaluacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoEvaluacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaTipoEvaluacionEmpleado() {
		return this.mostrarFK_IdEmpresaTipoEvaluacionEmpleado;
	}

	public void setMostrarFK_IdEmpresaTipoEvaluacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoEvaluacionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoEvaluacionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaTipoEvaluacionEmpleado() {
		return this.activarFK_IdEmpresaTipoEvaluacionEmpleado;
	}

	public void setActivarFK_IdEmpresaTipoEvaluacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoEvaluacionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoEvaluacionEmpleado=null;

	public Border getResaltarFK_IdEmpresaTipoEvaluacionEmpleado() {
		return this.resaltarFK_IdEmpresaTipoEvaluacionEmpleado;
	}

	public void setResaltarFK_IdEmpresaTipoEvaluacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoEvaluacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoEvaluacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEvaluacionEmpleadoBeanSwingJInternalFrame tipoevaluacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoEvaluacionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}