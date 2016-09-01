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


import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCalificacionEmpleadoConstantesFunciones extends TipoCalificacionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCalificacionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCalificacionEmpleado"+TipoCalificacionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCalificacionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCalificacionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalificacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalificacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCalificacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCalificacionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCalificacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCalificacionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Calificacion Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Calificacion Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Calificacion Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCalificacionEmpleado";
	public static final String OBJECTNAME="tipocalificacionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_calificacion_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocalificacionempleado from "+TipoCalificacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipocalificacionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCalificacionEmpleadoConstantesFuncionesAdditional tipocalificacionempleadoConstantesFuncionesAdditional=null;
	
	public TipoCalificacionEmpleadoConstantesFuncionesAdditional getTipoCalificacionEmpleadoConstantesFuncionesAdditional() {
		return this.tipocalificacionempleadoConstantesFuncionesAdditional;
	}
	
	public void setTipoCalificacionEmpleadoConstantesFuncionesAdditional(TipoCalificacionEmpleadoConstantesFuncionesAdditional tipocalificacionempleadoConstantesFuncionesAdditional) {
		try {
			this.tipocalificacionempleadoConstantesFuncionesAdditional=tipocalificacionempleadoConstantesFuncionesAdditional;
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
	
	public static String getTipoCalificacionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCalificacionEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCalificacionEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCalificacionEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCalificacionEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoCalificacionEmpleadoDescripcion(TipoCalificacionEmpleado tipocalificacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocalificacionempleado !=null/* && tipocalificacionempleado.getId()!=0*/) {
			sDescripcion=tipocalificacionempleado.getcodigo();//tipocalificacionempleadotipocalificacionempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCalificacionEmpleadoDescripcionDetallado(TipoCalificacionEmpleado tipocalificacionempleado) {
		String sDescripcion="";
			
		sDescripcion+=TipoCalificacionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=tipocalificacionempleado.getId().toString()+",";
		sDescripcion+=TipoCalificacionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocalificacionempleado.getVersionRow().toString()+",";
		sDescripcion+=TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocalificacionempleado.getid_empresa().toString()+",";
		sDescripcion+=TipoCalificacionEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocalificacionempleado.getcodigo()+",";
		sDescripcion+=TipoCalificacionEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocalificacionempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCalificacionEmpleadoDescripcion(TipoCalificacionEmpleado tipocalificacionempleado,String sValor) throws Exception {			
		if(tipocalificacionempleado !=null) {
			tipocalificacionempleado.setcodigo(sValor);;//tipocalificacionempleadotipocalificacionempleado.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocalificacionempleado.setcodigo(tipocalificacionempleado.getcodigo().trim());
		tipocalificacionempleado.setnombre(tipocalificacionempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCalificacionEmpleados(List<TipoCalificacionEmpleado> tipocalificacionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCalificacionEmpleado tipocalificacionempleado: tipocalificacionempleados) {
			tipocalificacionempleado.setcodigo(tipocalificacionempleado.getcodigo().trim());
			tipocalificacionempleado.setnombre(tipocalificacionempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocalificacionempleado.getConCambioAuxiliar()) {
			tipocalificacionempleado.setIsDeleted(tipocalificacionempleado.getIsDeletedAuxiliar());	
			tipocalificacionempleado.setIsNew(tipocalificacionempleado.getIsNewAuxiliar());	
			tipocalificacionempleado.setIsChanged(tipocalificacionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocalificacionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocalificacionempleado.setIsDeletedAuxiliar(false);	
			tipocalificacionempleado.setIsNewAuxiliar(false);	
			tipocalificacionempleado.setIsChangedAuxiliar(false);
			
			tipocalificacionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalificacionEmpleados(List<TipoCalificacionEmpleado> tipocalificacionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCalificacionEmpleado tipocalificacionempleado : tipocalificacionempleados) {
			if(conAsignarBase && tipocalificacionempleado.getConCambioAuxiliar()) {
				tipocalificacionempleado.setIsDeleted(tipocalificacionempleado.getIsDeletedAuxiliar());	
				tipocalificacionempleado.setIsNew(tipocalificacionempleado.getIsNewAuxiliar());	
				tipocalificacionempleado.setIsChanged(tipocalificacionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocalificacionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocalificacionempleado.setIsDeletedAuxiliar(false);	
				tipocalificacionempleado.setIsNewAuxiliar(false);	
				tipocalificacionempleado.setIsChangedAuxiliar(false);
				
				tipocalificacionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCalificacionEmpleados(List<TipoCalificacionEmpleado> tipocalificacionempleados,Boolean conEnteros) throws Exception  {
		
		for(TipoCalificacionEmpleado tipocalificacionempleado: tipocalificacionempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleado tipocalificacionempleadoAux) throws Exception  {
		TipoCalificacionEmpleadoConstantesFunciones.InicializarValoresTipoCalificacionEmpleado(tipocalificacionempleadoAux,true);
		
		for(TipoCalificacionEmpleado tipocalificacionempleado: tipocalificacionempleados) {
			if(tipocalificacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCalificacionEmpleadoConstantesFunciones.getArrayColumnasGlobalesTipoCalificacionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCalificacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleado tipocalificacionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCalificacionEmpleado tipocalificacionempleadoAux: tipocalificacionempleados) {
			if(tipocalificacionempleadoAux!=null && tipocalificacionempleado!=null) {
				if((tipocalificacionempleadoAux.getId()==null && tipocalificacionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocalificacionempleadoAux.getId()!=null && tipocalificacionempleado.getId()!=null){
					if(tipocalificacionempleadoAux.getId().equals(tipocalificacionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> tipocalificacionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCalificacionEmpleado tipocalificacionempleado: tipocalificacionempleados) {			
			if(tipocalificacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCalificacionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCalificacionEmpleadoConstantesFunciones.LABEL_ID, TipoCalificacionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalificacionEmpleadoConstantesFunciones.LABEL_VERSIONROW, TipoCalificacionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalificacionEmpleadoConstantesFunciones.LABEL_CODIGO, TipoCalificacionEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalificacionEmpleadoConstantesFunciones.LABEL_NOMBRE, TipoCalificacionEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCalificacionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCalificacionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalificacionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalificacionEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalificacionEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalificacionEmpleado() throws Exception  {
		return TipoCalificacionEmpleadoConstantesFunciones.getTiposSeleccionarTipoCalificacionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalificacionEmpleado(Boolean conFk) throws Exception  {
		return TipoCalificacionEmpleadoConstantesFunciones.getTiposSeleccionarTipoCalificacionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalificacionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalificacionEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCalificacionEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalificacionEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCalificacionEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCalificacionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleadoAux) throws Exception {
		
			tipocalificacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocalificacionempleadoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> tipocalificacionempleadosTemp) throws Exception {
		for(TipoCalificacionEmpleado tipocalificacionempleadoAux:tipocalificacionempleadosTemp) {
			
			tipocalificacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocalificacionempleadoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalificacionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoCalificacionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CalificacionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CalificacionEmpleado.class)) {
						classes.add(new Classe(CalificacionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalificacionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCalificacionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalificacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CalificacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalificacionEmpleado.class)); continue;
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
	public static void actualizarLista(TipoCalificacionEmpleado tipocalificacionempleado,List<TipoCalificacionEmpleado> tipocalificacionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCalificacionEmpleado tipocalificacionempleadoEncontrado=null;
			
			for(TipoCalificacionEmpleado tipocalificacionempleadoLocal:tipocalificacionempleados) {
				if(tipocalificacionempleadoLocal.getId().equals(tipocalificacionempleado.getId())) {
					tipocalificacionempleadoEncontrado=tipocalificacionempleadoLocal;
					
					tipocalificacionempleadoLocal.setIsChanged(tipocalificacionempleado.getIsChanged());
					tipocalificacionempleadoLocal.setIsNew(tipocalificacionempleado.getIsNew());
					tipocalificacionempleadoLocal.setIsDeleted(tipocalificacionempleado.getIsDeleted());
					
					tipocalificacionempleadoLocal.setGeneralEntityOriginal(tipocalificacionempleado.getGeneralEntityOriginal());
					
					tipocalificacionempleadoLocal.setId(tipocalificacionempleado.getId());	
					tipocalificacionempleadoLocal.setVersionRow(tipocalificacionempleado.getVersionRow());	
					tipocalificacionempleadoLocal.setid_empresa(tipocalificacionempleado.getid_empresa());	
					tipocalificacionempleadoLocal.setcodigo(tipocalificacionempleado.getcodigo());	
					tipocalificacionempleadoLocal.setnombre(tipocalificacionempleado.getnombre());	
					
					
					tipocalificacionempleadoLocal.setCalificacionEmpleados(tipocalificacionempleado.getCalificacionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocalificacionempleado.getIsDeleted()) {
				if(!existe) {
					tipocalificacionempleados.add(tipocalificacionempleado);
				}
			} else {
				if(tipocalificacionempleadoEncontrado!=null && permiteQuitar)  {
					tipocalificacionempleados.remove(tipocalificacionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCalificacionEmpleado tipocalificacionempleado,List<TipoCalificacionEmpleado> tipocalificacionempleados) throws Exception {
		try	{			
			for(TipoCalificacionEmpleado tipocalificacionempleadoLocal:tipocalificacionempleados) {
				if(tipocalificacionempleadoLocal.getId().equals(tipocalificacionempleado.getId())) {
					tipocalificacionempleadoLocal.setIsSelected(tipocalificacionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> tipocalificacionempleadosAux) throws Exception {
		//this.tipocalificacionempleadosAux=tipocalificacionempleadosAux;
		
		for(TipoCalificacionEmpleado tipocalificacionempleadoAux:tipocalificacionempleadosAux) {
			if(tipocalificacionempleadoAux.getIsChanged()) {
				tipocalificacionempleadoAux.setIsChanged(false);
			}		
			
			if(tipocalificacionempleadoAux.getIsNew()) {
				tipocalificacionempleadoAux.setIsNew(false);
			}	
			
			if(tipocalificacionempleadoAux.getIsDeleted()) {
				tipocalificacionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleadoAux) throws Exception {
		//this.tipocalificacionempleadoAux=tipocalificacionempleadoAux;
		
			if(tipocalificacionempleadoAux.getIsChanged()) {
				tipocalificacionempleadoAux.setIsChanged(false);
			}		
			
			if(tipocalificacionempleadoAux.getIsNew()) {
				tipocalificacionempleadoAux.setIsNew(false);
			}	
			
			if(tipocalificacionempleadoAux.getIsDeleted()) {
				tipocalificacionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCalificacionEmpleado tipocalificacionempleadoAsignar,TipoCalificacionEmpleado tipocalificacionempleado) throws Exception {
		tipocalificacionempleadoAsignar.setId(tipocalificacionempleado.getId());	
		tipocalificacionempleadoAsignar.setVersionRow(tipocalificacionempleado.getVersionRow());	
		tipocalificacionempleadoAsignar.setid_empresa(tipocalificacionempleado.getid_empresa());
		tipocalificacionempleadoAsignar.setempresa_descripcion(tipocalificacionempleado.getempresa_descripcion());	
		tipocalificacionempleadoAsignar.setcodigo(tipocalificacionempleado.getcodigo());	
		tipocalificacionempleadoAsignar.setnombre(tipocalificacionempleado.getnombre());	
	}
	
	public static void inicializarTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado) throws Exception {
		try {
				tipocalificacionempleado.setId(0L);	
					
				tipocalificacionempleado.setid_empresa(-1L);	
				tipocalificacionempleado.setcodigo("");	
				tipocalificacionempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCalificacionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalificacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalificacionEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalificacionEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCalificacionEmpleado(String sTipo,Row row,Workbook workbook,TipoCalificacionEmpleado tipocalificacionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalificacionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalificacionempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalificacionempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCalificacionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCalificacionEmpleado() {
		return this.sFinalQueryTipoCalificacionEmpleado;
	}
	
	public void setsFinalQueryTipoCalificacionEmpleado(String sFinalQueryTipoCalificacionEmpleado) {
		this.sFinalQueryTipoCalificacionEmpleado= sFinalQueryTipoCalificacionEmpleado;
	}
	
	public Border resaltarSeleccionarTipoCalificacionEmpleado=null;
	
	public Border setResaltarSeleccionarTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCalificacionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCalificacionEmpleado() {
		return this.resaltarSeleccionarTipoCalificacionEmpleado;
	}
	
	public void setResaltarSeleccionarTipoCalificacionEmpleado(Border borderResaltarSeleccionarTipoCalificacionEmpleado) {
		this.resaltarSeleccionarTipoCalificacionEmpleado= borderResaltarSeleccionarTipoCalificacionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCalificacionEmpleado=null;
	public Boolean mostraridTipoCalificacionEmpleado=true;
	public Boolean activaridTipoCalificacionEmpleado=true;

	public Border resaltarid_empresaTipoCalificacionEmpleado=null;
	public Boolean mostrarid_empresaTipoCalificacionEmpleado=true;
	public Boolean activarid_empresaTipoCalificacionEmpleado=true;
	public Boolean cargarid_empresaTipoCalificacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCalificacionEmpleado=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCalificacionEmpleado=null;
	public Boolean mostrarcodigoTipoCalificacionEmpleado=true;
	public Boolean activarcodigoTipoCalificacionEmpleado=true;

	public Border resaltarnombreTipoCalificacionEmpleado=null;
	public Boolean mostrarnombreTipoCalificacionEmpleado=true;
	public Boolean activarnombreTipoCalificacionEmpleado=true;

	
	

	public Border setResaltaridTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridTipoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCalificacionEmpleado() {
		return this.resaltaridTipoCalificacionEmpleado;
	}

	public void setResaltaridTipoCalificacionEmpleado(Border borderResaltar) {
		this.resaltaridTipoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostraridTipoCalificacionEmpleado() {
		return this.mostraridTipoCalificacionEmpleado;
	}

	public void setMostraridTipoCalificacionEmpleado(Boolean mostraridTipoCalificacionEmpleado) {
		this.mostraridTipoCalificacionEmpleado= mostraridTipoCalificacionEmpleado;
	}

	public Boolean getActivaridTipoCalificacionEmpleado() {
		return this.activaridTipoCalificacionEmpleado;
	}

	public void setActivaridTipoCalificacionEmpleado(Boolean activaridTipoCalificacionEmpleado) {
		this.activaridTipoCalificacionEmpleado= activaridTipoCalificacionEmpleado;
	}

	public Border setResaltarid_empresaTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCalificacionEmpleado() {
		return this.resaltarid_empresaTipoCalificacionEmpleado;
	}

	public void setResaltarid_empresaTipoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaTipoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCalificacionEmpleado() {
		return this.mostrarid_empresaTipoCalificacionEmpleado;
	}

	public void setMostrarid_empresaTipoCalificacionEmpleado(Boolean mostrarid_empresaTipoCalificacionEmpleado) {
		this.mostrarid_empresaTipoCalificacionEmpleado= mostrarid_empresaTipoCalificacionEmpleado;
	}

	public Boolean getActivarid_empresaTipoCalificacionEmpleado() {
		return this.activarid_empresaTipoCalificacionEmpleado;
	}

	public void setActivarid_empresaTipoCalificacionEmpleado(Boolean activarid_empresaTipoCalificacionEmpleado) {
		this.activarid_empresaTipoCalificacionEmpleado= activarid_empresaTipoCalificacionEmpleado;
	}

	public Boolean getCargarid_empresaTipoCalificacionEmpleado() {
		return this.cargarid_empresaTipoCalificacionEmpleado;
	}

	public void setCargarid_empresaTipoCalificacionEmpleado(Boolean cargarid_empresaTipoCalificacionEmpleado) {
		this.cargarid_empresaTipoCalificacionEmpleado= cargarid_empresaTipoCalificacionEmpleado;
	}

	public Border setResaltarcodigoTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCalificacionEmpleado() {
		return this.resaltarcodigoTipoCalificacionEmpleado;
	}

	public void setResaltarcodigoTipoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarcodigoTipoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCalificacionEmpleado() {
		return this.mostrarcodigoTipoCalificacionEmpleado;
	}

	public void setMostrarcodigoTipoCalificacionEmpleado(Boolean mostrarcodigoTipoCalificacionEmpleado) {
		this.mostrarcodigoTipoCalificacionEmpleado= mostrarcodigoTipoCalificacionEmpleado;
	}

	public Boolean getActivarcodigoTipoCalificacionEmpleado() {
		return this.activarcodigoTipoCalificacionEmpleado;
	}

	public void setActivarcodigoTipoCalificacionEmpleado(Boolean activarcodigoTipoCalificacionEmpleado) {
		this.activarcodigoTipoCalificacionEmpleado= activarcodigoTipoCalificacionEmpleado;
	}

	public Border setResaltarnombreTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCalificacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCalificacionEmpleado() {
		return this.resaltarnombreTipoCalificacionEmpleado;
	}

	public void setResaltarnombreTipoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarnombreTipoCalificacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCalificacionEmpleado() {
		return this.mostrarnombreTipoCalificacionEmpleado;
	}

	public void setMostrarnombreTipoCalificacionEmpleado(Boolean mostrarnombreTipoCalificacionEmpleado) {
		this.mostrarnombreTipoCalificacionEmpleado= mostrarnombreTipoCalificacionEmpleado;
	}

	public Boolean getActivarnombreTipoCalificacionEmpleado() {
		return this.activarnombreTipoCalificacionEmpleado;
	}

	public void setActivarnombreTipoCalificacionEmpleado(Boolean activarnombreTipoCalificacionEmpleado) {
		this.activarnombreTipoCalificacionEmpleado= activarnombreTipoCalificacionEmpleado;
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
		
		
		this.setMostraridTipoCalificacionEmpleado(esInicial);
		this.setMostrarid_empresaTipoCalificacionEmpleado(esInicial);
		this.setMostrarcodigoTipoCalificacionEmpleado(esInicial);
		this.setMostrarnombreTipoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCalificacionEmpleado(esAsigna);
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
		
		
		this.setActivaridTipoCalificacionEmpleado(esInicial);
		this.setActivarid_empresaTipoCalificacionEmpleado(esInicial);
		this.setActivarcodigoTipoCalificacionEmpleado(esInicial);
		this.setActivarnombreTipoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCalificacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCalificacionEmpleado(esInicial);
		this.setResaltarid_empresaTipoCalificacionEmpleado(esInicial);
		this.setResaltarcodigoTipoCalificacionEmpleado(esInicial);
		this.setResaltarnombreTipoCalificacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCalificacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalificacionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCalificacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCalificacionEmpleadoTipoCalificacionEmpleado=null;

	public Border getResaltarCalificacionEmpleadoTipoCalificacionEmpleado() {
		return this.resaltarCalificacionEmpleadoTipoCalificacionEmpleado;
	}

	public void setResaltarCalificacionEmpleadoTipoCalificacionEmpleado(Border borderResaltarCalificacionEmpleado) {
		if(borderResaltarCalificacionEmpleado!=null) {
			this.resaltarCalificacionEmpleadoTipoCalificacionEmpleado= borderResaltarCalificacionEmpleado;
		}
	}

	public Border setResaltarCalificacionEmpleadoTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCalificacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocalificacionempleadoBeanSwingJInternalFrame.jTtoolBarTipoCalificacionEmpleado.setBorder(borderResaltarCalificacionEmpleado);
			
		this.resaltarCalificacionEmpleadoTipoCalificacionEmpleado= borderResaltarCalificacionEmpleado;

		 return borderResaltarCalificacionEmpleado;
	}



	public Boolean mostrarCalificacionEmpleadoTipoCalificacionEmpleado=true;

	public Boolean getMostrarCalificacionEmpleadoTipoCalificacionEmpleado() {
		return this.mostrarCalificacionEmpleadoTipoCalificacionEmpleado;
	}

	public void setMostrarCalificacionEmpleadoTipoCalificacionEmpleado(Boolean visibilidadResaltarCalificacionEmpleado) {
		this.mostrarCalificacionEmpleadoTipoCalificacionEmpleado= visibilidadResaltarCalificacionEmpleado;
	}



	public Boolean activarCalificacionEmpleadoTipoCalificacionEmpleado=true;

	public Boolean gethabilitarResaltarCalificacionEmpleadoTipoCalificacionEmpleado() {
		return this.activarCalificacionEmpleadoTipoCalificacionEmpleado;
	}

	public void setActivarCalificacionEmpleadoTipoCalificacionEmpleado(Boolean habilitarResaltarCalificacionEmpleado) {
		this.activarCalificacionEmpleadoTipoCalificacionEmpleado= habilitarResaltarCalificacionEmpleado;
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

		this.setMostrarCalificacionEmpleadoTipoCalificacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setMostrarCalificacionEmpleadoTipoCalificacionEmpleado(esAsigna);
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

		this.setActivarCalificacionEmpleadoTipoCalificacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setActivarCalificacionEmpleadoTipoCalificacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCalificacionEmpleadoTipoCalificacionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CalificacionEmpleado.class)) {
				this.setResaltarCalificacionEmpleadoTipoCalificacionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoCalificacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaTipoCalificacionEmpleado() {
		return this.mostrarFK_IdEmpresaTipoCalificacionEmpleado;
	}

	public void setMostrarFK_IdEmpresaTipoCalificacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCalificacionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCalificacionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaTipoCalificacionEmpleado() {
		return this.activarFK_IdEmpresaTipoCalificacionEmpleado;
	}

	public void setActivarFK_IdEmpresaTipoCalificacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCalificacionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCalificacionEmpleado=null;

	public Border getResaltarFK_IdEmpresaTipoCalificacionEmpleado() {
		return this.resaltarFK_IdEmpresaTipoCalificacionEmpleado;
	}

	public void setResaltarFK_IdEmpresaTipoCalificacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCalificacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCalificacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalificacionEmpleadoBeanSwingJInternalFrame tipocalificacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCalificacionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}