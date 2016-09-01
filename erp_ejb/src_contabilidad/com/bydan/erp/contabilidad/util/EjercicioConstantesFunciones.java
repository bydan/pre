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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.EjercicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.EjercicioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EjercicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EjercicioConstantesFunciones extends EjercicioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Ejercicio";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Ejercicio"+EjercicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EjercicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EjercicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EjercicioConstantesFunciones.SCHEMA+"_"+EjercicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EjercicioConstantesFunciones.SCHEMA+"_"+EjercicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EjercicioConstantesFunciones.SCHEMA+"_"+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EjercicioConstantesFunciones.SCHEMA+"_"+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EjercicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EjercicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EjercicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EjercicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EjercicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EjercicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ejercicios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ejercicio";
	public static final String SCLASSWEBTITULO_LOWER="Ejercicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Ejercicio";
	public static final String OBJECTNAME="ejercicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="ejercicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ejercicio from "+EjercicioConstantesFunciones.SPERSISTENCENAME+" ejercicio";
	public static String QUERYSELECTNATIVE="select "+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".id,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".version_row,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".id_empresa,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".id_anio,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".fecha_inicio,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".fecha_fin,"+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME+".esta_activo from "+EjercicioConstantesFunciones.SCHEMA+"."+EjercicioConstantesFunciones.TABLENAME;//+" as "+EjercicioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EjercicioConstantesFuncionesAdditional ejercicioConstantesFuncionesAdditional=null;
	
	public EjercicioConstantesFuncionesAdditional getEjercicioConstantesFuncionesAdditional() {
		return this.ejercicioConstantesFuncionesAdditional;
	}
	
	public void setEjercicioConstantesFuncionesAdditional(EjercicioConstantesFuncionesAdditional ejercicioConstantesFuncionesAdditional) {
		try {
			this.ejercicioConstantesFuncionesAdditional=ejercicioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDANIO= "id_anio";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	
	public static String getEjercicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EjercicioConstantesFunciones.IDEMPRESA)) {sLabelColumna=EjercicioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EjercicioConstantesFunciones.IDANIO)) {sLabelColumna=EjercicioConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(EjercicioConstantesFunciones.FECHAINICIO)) {sLabelColumna=EjercicioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(EjercicioConstantesFunciones.FECHAFIN)) {sLabelColumna=EjercicioConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(EjercicioConstantesFunciones.ESTAACTIVO)) {sLabelColumna=EjercicioConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(Ejercicio ejercicio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!ejercicio.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Ejercicio ejercicio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(ejercicio.getId(),ejercicio.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ejercicio !=null/* && ejercicio.getId()!=0*/) {
			sDescripcion=ejercicio.getid_anio().toString();//ejercicioejercicio.getid_anio().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEjercicioDescripcionDetallado(Ejercicio ejercicio) {
		String sDescripcion="";
			
		sDescripcion+=EjercicioConstantesFunciones.ID+"=";
		sDescripcion+=ejercicio.getId().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ejercicio.getVersionRow().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ejercicio.getid_empresa().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.IDANIO+"=";
		sDescripcion+=ejercicio.getid_anio().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=ejercicio.getfecha_inicio().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=ejercicio.getfecha_fin().toString()+",";
		sDescripcion+=EjercicioConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=ejercicio.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEjercicioDescripcion(Ejercicio ejercicio,String sValor) throws Exception {			
		if(ejercicio !=null) {
			;//ejercicioejercicio.getid_anio().toString().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorFechaInicio")) {
			sNombreIndice="Tipo=  Por Fecha Inicio";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorEmpresaPorAnio")) {
			sNombreIndice="Tipo=  Por Empresa Por Anio";
		} else if(sNombreIndice.equals("PorIdPorEmpresaPorAnio")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Anio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorFechaInicio(Date fecha_inicio) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorAnio(Long id_empresa,Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmpresaPorAnio(Long id,Long id_empresa,Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEjercicio(Ejercicio ejercicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEjercicios(List<Ejercicio> ejercicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Ejercicio ejercicio: ejercicios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEjercicio(Ejercicio ejercicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ejercicio.getConCambioAuxiliar()) {
			ejercicio.setIsDeleted(ejercicio.getIsDeletedAuxiliar());	
			ejercicio.setIsNew(ejercicio.getIsNewAuxiliar());	
			ejercicio.setIsChanged(ejercicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ejercicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ejercicio.setIsDeletedAuxiliar(false);	
			ejercicio.setIsNewAuxiliar(false);	
			ejercicio.setIsChangedAuxiliar(false);
			
			ejercicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEjercicios(List<Ejercicio> ejercicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Ejercicio ejercicio : ejercicios) {
			if(conAsignarBase && ejercicio.getConCambioAuxiliar()) {
				ejercicio.setIsDeleted(ejercicio.getIsDeletedAuxiliar());	
				ejercicio.setIsNew(ejercicio.getIsNewAuxiliar());	
				ejercicio.setIsChanged(ejercicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ejercicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ejercicio.setIsDeletedAuxiliar(false);	
				ejercicio.setIsNewAuxiliar(false);	
				ejercicio.setIsChangedAuxiliar(false);
				
				ejercicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEjercicio(Ejercicio ejercicio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEjercicios(List<Ejercicio> ejercicios,Boolean conEnteros) throws Exception  {
		
		for(Ejercicio ejercicio: ejercicios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEjercicio(List<Ejercicio> ejercicios,Ejercicio ejercicioAux) throws Exception  {
		EjercicioConstantesFunciones.InicializarValoresEjercicio(ejercicioAux,true);
		
		for(Ejercicio ejercicio: ejercicios) {
			if(ejercicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEjercicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EjercicioConstantesFunciones.getArrayColumnasGlobalesEjercicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEjercicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EjercicioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EjercicioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEjercicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Ejercicio> ejercicios,Ejercicio ejercicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Ejercicio ejercicioAux: ejercicios) {
			if(ejercicioAux!=null && ejercicio!=null) {
				if((ejercicioAux.getId()==null && ejercicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ejercicioAux.getId()!=null && ejercicio.getId()!=null){
					if(ejercicioAux.getId().equals(ejercicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEjercicio(List<Ejercicio> ejercicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Ejercicio ejercicio: ejercicios) {			
			if(ejercicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEjercicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_ID, EjercicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_VERSIONROW, EjercicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_IDEMPRESA, EjercicioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_IDANIO, EjercicioConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_FECHAINICIO, EjercicioConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_FECHAFIN, EjercicioConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EjercicioConstantesFunciones.LABEL_ESTAACTIVO, EjercicioConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEjercicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EjercicioConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEjercicio() throws Exception  {
		return EjercicioConstantesFunciones.getTiposSeleccionarEjercicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEjercicio(Boolean conFk) throws Exception  {
		return EjercicioConstantesFunciones.getTiposSeleccionarEjercicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEjercicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EjercicioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EjercicioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EjercicioConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(EjercicioConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EjercicioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(EjercicioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EjercicioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(EjercicioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EjercicioConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(EjercicioConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEjercicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEjercicio(Ejercicio ejercicioAux) throws Exception {
		
			ejercicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ejercicioAux.getEmpresa()));
			ejercicioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ejercicioAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEjercicio(List<Ejercicio> ejerciciosTemp) throws Exception {
		for(Ejercicio ejercicioAux:ejerciciosTemp) {
			
			ejercicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ejercicioAux.getEmpresa()));
			ejercicioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ejercicioAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Anio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EjercicioConstantesFunciones.getClassesRelationshipsOfEjercicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEjercicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EjercicioConstantesFunciones.getClassesRelationshipsFromStringsOfEjercicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEjercicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Ejercicio ejercicio,List<Ejercicio> ejercicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Ejercicio ejercicioEncontrado=null;
			
			for(Ejercicio ejercicioLocal:ejercicios) {
				if(ejercicioLocal.getId().equals(ejercicio.getId())) {
					ejercicioEncontrado=ejercicioLocal;
					
					ejercicioLocal.setIsChanged(ejercicio.getIsChanged());
					ejercicioLocal.setIsNew(ejercicio.getIsNew());
					ejercicioLocal.setIsDeleted(ejercicio.getIsDeleted());
					
					ejercicioLocal.setGeneralEntityOriginal(ejercicio.getGeneralEntityOriginal());
					
					ejercicioLocal.setId(ejercicio.getId());	
					ejercicioLocal.setVersionRow(ejercicio.getVersionRow());	
					ejercicioLocal.setid_empresa(ejercicio.getid_empresa());	
					ejercicioLocal.setid_anio(ejercicio.getid_anio());	
					ejercicioLocal.setfecha_inicio(ejercicio.getfecha_inicio());	
					ejercicioLocal.setfecha_fin(ejercicio.getfecha_fin());	
					ejercicioLocal.setesta_activo(ejercicio.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!ejercicio.getIsDeleted()) {
				if(!existe) {
					ejercicios.add(ejercicio);
				}
			} else {
				if(ejercicioEncontrado!=null && permiteQuitar)  {
					ejercicios.remove(ejercicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Ejercicio ejercicio,List<Ejercicio> ejercicios) throws Exception {
		try	{			
			for(Ejercicio ejercicioLocal:ejercicios) {
				if(ejercicioLocal.getId().equals(ejercicio.getId())) {
					ejercicioLocal.setIsSelected(ejercicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEjercicio(List<Ejercicio> ejerciciosAux) throws Exception {
		//this.ejerciciosAux=ejerciciosAux;
		
		for(Ejercicio ejercicioAux:ejerciciosAux) {
			if(ejercicioAux.getIsChanged()) {
				ejercicioAux.setIsChanged(false);
			}		
			
			if(ejercicioAux.getIsNew()) {
				ejercicioAux.setIsNew(false);
			}	
			
			if(ejercicioAux.getIsDeleted()) {
				ejercicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEjercicio(Ejercicio ejercicioAux) throws Exception {
		//this.ejercicioAux=ejercicioAux;
		
			if(ejercicioAux.getIsChanged()) {
				ejercicioAux.setIsChanged(false);
			}		
			
			if(ejercicioAux.getIsNew()) {
				ejercicioAux.setIsNew(false);
			}	
			
			if(ejercicioAux.getIsDeleted()) {
				ejercicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Ejercicio ejercicioAsignar,Ejercicio ejercicio) throws Exception {
		ejercicioAsignar.setId(ejercicio.getId());	
		ejercicioAsignar.setVersionRow(ejercicio.getVersionRow());	
		ejercicioAsignar.setid_empresa(ejercicio.getid_empresa());
		ejercicioAsignar.setempresa_descripcion(ejercicio.getempresa_descripcion());	
		ejercicioAsignar.setid_anio(ejercicio.getid_anio());
		ejercicioAsignar.setanio_descripcion(ejercicio.getanio_descripcion());	
		ejercicioAsignar.setfecha_inicio(ejercicio.getfecha_inicio());	
		ejercicioAsignar.setfecha_fin(ejercicio.getfecha_fin());	
		ejercicioAsignar.setesta_activo(ejercicio.getesta_activo());	
	}
	
	public static void inicializarEjercicio(Ejercicio ejercicio) throws Exception {
		try {
				ejercicio.setId(0L);	
					
				ejercicio.setid_empresa(-1L);	
				ejercicio.setid_anio(-1L);	
				ejercicio.setfecha_inicio(new Date());	
				ejercicio.setfecha_fin(new Date());	
				ejercicio.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEjercicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EjercicioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EjercicioConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EjercicioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EjercicioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EjercicioConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEjercicio(String sTipo,Row row,Workbook workbook,Ejercicio ejercicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ejercicio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ejercicio.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ejercicio.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ejercicio.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(ejercicio.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEjercicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEjercicio() {
		return this.sFinalQueryEjercicio;
	}
	
	public void setsFinalQueryEjercicio(String sFinalQueryEjercicio) {
		this.sFinalQueryEjercicio= sFinalQueryEjercicio;
	}
	
	public Border resaltarSeleccionarEjercicio=null;
	
	public Border setResaltarSeleccionarEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEjercicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEjercicio() {
		return this.resaltarSeleccionarEjercicio;
	}
	
	public void setResaltarSeleccionarEjercicio(Border borderResaltarSeleccionarEjercicio) {
		this.resaltarSeleccionarEjercicio= borderResaltarSeleccionarEjercicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEjercicio=null;
	public Boolean mostraridEjercicio=true;
	public Boolean activaridEjercicio=true;

	public Border resaltarid_empresaEjercicio=null;
	public Boolean mostrarid_empresaEjercicio=true;
	public Boolean activarid_empresaEjercicio=true;
	public Boolean cargarid_empresaEjercicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEjercicio=false;//ConEventDepend=true

	public Border resaltarid_anioEjercicio=null;
	public Boolean mostrarid_anioEjercicio=true;
	public Boolean activarid_anioEjercicio=true;
	public Boolean cargarid_anioEjercicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioEjercicio=false;//ConEventDepend=true

	public Border resaltarfecha_inicioEjercicio=null;
	public Boolean mostrarfecha_inicioEjercicio=true;
	public Boolean activarfecha_inicioEjercicio=true;

	public Border resaltarfecha_finEjercicio=null;
	public Boolean mostrarfecha_finEjercicio=true;
	public Boolean activarfecha_finEjercicio=true;

	public Border resaltaresta_activoEjercicio=null;
	public Boolean mostraresta_activoEjercicio=true;
	public Boolean activaresta_activoEjercicio=true;

	
	

	public Border setResaltaridEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltaridEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEjercicio() {
		return this.resaltaridEjercicio;
	}

	public void setResaltaridEjercicio(Border borderResaltar) {
		this.resaltaridEjercicio= borderResaltar;
	}

	public Boolean getMostraridEjercicio() {
		return this.mostraridEjercicio;
	}

	public void setMostraridEjercicio(Boolean mostraridEjercicio) {
		this.mostraridEjercicio= mostraridEjercicio;
	}

	public Boolean getActivaridEjercicio() {
		return this.activaridEjercicio;
	}

	public void setActivaridEjercicio(Boolean activaridEjercicio) {
		this.activaridEjercicio= activaridEjercicio;
	}

	public Border setResaltarid_empresaEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltarid_empresaEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEjercicio() {
		return this.resaltarid_empresaEjercicio;
	}

	public void setResaltarid_empresaEjercicio(Border borderResaltar) {
		this.resaltarid_empresaEjercicio= borderResaltar;
	}

	public Boolean getMostrarid_empresaEjercicio() {
		return this.mostrarid_empresaEjercicio;
	}

	public void setMostrarid_empresaEjercicio(Boolean mostrarid_empresaEjercicio) {
		this.mostrarid_empresaEjercicio= mostrarid_empresaEjercicio;
	}

	public Boolean getActivarid_empresaEjercicio() {
		return this.activarid_empresaEjercicio;
	}

	public void setActivarid_empresaEjercicio(Boolean activarid_empresaEjercicio) {
		this.activarid_empresaEjercicio= activarid_empresaEjercicio;
	}

	public Boolean getCargarid_empresaEjercicio() {
		return this.cargarid_empresaEjercicio;
	}

	public void setCargarid_empresaEjercicio(Boolean cargarid_empresaEjercicio) {
		this.cargarid_empresaEjercicio= cargarid_empresaEjercicio;
	}

	public Border setResaltarid_anioEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltarid_anioEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioEjercicio() {
		return this.resaltarid_anioEjercicio;
	}

	public void setResaltarid_anioEjercicio(Border borderResaltar) {
		this.resaltarid_anioEjercicio= borderResaltar;
	}

	public Boolean getMostrarid_anioEjercicio() {
		return this.mostrarid_anioEjercicio;
	}

	public void setMostrarid_anioEjercicio(Boolean mostrarid_anioEjercicio) {
		this.mostrarid_anioEjercicio= mostrarid_anioEjercicio;
	}

	public Boolean getActivarid_anioEjercicio() {
		return this.activarid_anioEjercicio;
	}

	public void setActivarid_anioEjercicio(Boolean activarid_anioEjercicio) {
		this.activarid_anioEjercicio= activarid_anioEjercicio;
	}

	public Boolean getCargarid_anioEjercicio() {
		return this.cargarid_anioEjercicio;
	}

	public void setCargarid_anioEjercicio(Boolean cargarid_anioEjercicio) {
		this.cargarid_anioEjercicio= cargarid_anioEjercicio;
	}

	public Border setResaltarfecha_inicioEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioEjercicio() {
		return this.resaltarfecha_inicioEjercicio;
	}

	public void setResaltarfecha_inicioEjercicio(Border borderResaltar) {
		this.resaltarfecha_inicioEjercicio= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioEjercicio() {
		return this.mostrarfecha_inicioEjercicio;
	}

	public void setMostrarfecha_inicioEjercicio(Boolean mostrarfecha_inicioEjercicio) {
		this.mostrarfecha_inicioEjercicio= mostrarfecha_inicioEjercicio;
	}

	public Boolean getActivarfecha_inicioEjercicio() {
		return this.activarfecha_inicioEjercicio;
	}

	public void setActivarfecha_inicioEjercicio(Boolean activarfecha_inicioEjercicio) {
		this.activarfecha_inicioEjercicio= activarfecha_inicioEjercicio;
	}

	public Border setResaltarfecha_finEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltarfecha_finEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finEjercicio() {
		return this.resaltarfecha_finEjercicio;
	}

	public void setResaltarfecha_finEjercicio(Border borderResaltar) {
		this.resaltarfecha_finEjercicio= borderResaltar;
	}

	public Boolean getMostrarfecha_finEjercicio() {
		return this.mostrarfecha_finEjercicio;
	}

	public void setMostrarfecha_finEjercicio(Boolean mostrarfecha_finEjercicio) {
		this.mostrarfecha_finEjercicio= mostrarfecha_finEjercicio;
	}

	public Boolean getActivarfecha_finEjercicio() {
		return this.activarfecha_finEjercicio;
	}

	public void setActivarfecha_finEjercicio(Boolean activarfecha_finEjercicio) {
		this.activarfecha_finEjercicio= activarfecha_finEjercicio;
	}

	public Border setResaltaresta_activoEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ejercicioBeanSwingJInternalFrame.jTtoolBarEjercicio.setBorder(borderResaltar);
		
		this.resaltaresta_activoEjercicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoEjercicio() {
		return this.resaltaresta_activoEjercicio;
	}

	public void setResaltaresta_activoEjercicio(Border borderResaltar) {
		this.resaltaresta_activoEjercicio= borderResaltar;
	}

	public Boolean getMostraresta_activoEjercicio() {
		return this.mostraresta_activoEjercicio;
	}

	public void setMostraresta_activoEjercicio(Boolean mostraresta_activoEjercicio) {
		this.mostraresta_activoEjercicio= mostraresta_activoEjercicio;
	}

	public Boolean getActivaresta_activoEjercicio() {
		return this.activaresta_activoEjercicio;
	}

	public void setActivaresta_activoEjercicio(Boolean activaresta_activoEjercicio) {
		this.activaresta_activoEjercicio= activaresta_activoEjercicio;
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
		
		
		this.setMostraridEjercicio(esInicial);
		this.setMostrarid_empresaEjercicio(esInicial);
		this.setMostrarid_anioEjercicio(esInicial);
		this.setMostrarfecha_inicioEjercicio(esInicial);
		this.setMostrarfecha_finEjercicio(esInicial);
		this.setMostraresta_activoEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EjercicioConstantesFunciones.ID)) {
				this.setMostraridEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoEjercicio(esAsigna);
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
		
		
		this.setActivaridEjercicio(esInicial);
		this.setActivarid_empresaEjercicio(esInicial);
		this.setActivarid_anioEjercicio(esInicial);
		this.setActivarfecha_inicioEjercicio(esInicial);
		this.setActivarfecha_finEjercicio(esInicial);
		this.setActivaresta_activoEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EjercicioConstantesFunciones.ID)) {
				this.setActivaridEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDANIO)) {
				this.setActivarid_anioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoEjercicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEjercicio(esInicial);
		this.setResaltarid_empresaEjercicio(esInicial);
		this.setResaltarid_anioEjercicio(esInicial);
		this.setResaltarfecha_inicioEjercicio(esInicial);
		this.setResaltarfecha_finEjercicio(esInicial);
		this.setResaltaresta_activoEjercicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EjercicioConstantesFunciones.ID)) {
				this.setResaltaridEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finEjercicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EjercicioConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoEjercicio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorFechaInicioEjercicio=true;

	public Boolean getMostrarBusquedaPorFechaInicioEjercicio() {
		return this.mostrarBusquedaPorFechaInicioEjercicio;
	}

	public void setMostrarBusquedaPorFechaInicioEjercicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaInicioEjercicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAnioEjercicio=true;

	public Boolean getMostrarFK_IdAnioEjercicio() {
		return this.mostrarFK_IdAnioEjercicio;
	}

	public void setMostrarFK_IdAnioEjercicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioEjercicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEjercicio=true;

	public Boolean getMostrarFK_IdEmpresaEjercicio() {
		return this.mostrarFK_IdEmpresaEjercicio;
	}

	public void setMostrarFK_IdEmpresaEjercicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEjercicio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorFechaInicioEjercicio=true;

	public Boolean getActivarBusquedaPorFechaInicioEjercicio() {
		return this.activarBusquedaPorFechaInicioEjercicio;
	}

	public void setActivarBusquedaPorFechaInicioEjercicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaInicioEjercicio= habilitarResaltar;
	}

	public Boolean activarFK_IdAnioEjercicio=true;

	public Boolean getActivarFK_IdAnioEjercicio() {
		return this.activarFK_IdAnioEjercicio;
	}

	public void setActivarFK_IdAnioEjercicio(Boolean habilitarResaltar) {
		this.activarFK_IdAnioEjercicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEjercicio=true;

	public Boolean getActivarFK_IdEmpresaEjercicio() {
		return this.activarFK_IdEmpresaEjercicio;
	}

	public void setActivarFK_IdEmpresaEjercicio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEjercicio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorFechaInicioEjercicio=null;

	public Border getResaltarBusquedaPorFechaInicioEjercicio() {
		return this.resaltarBusquedaPorFechaInicioEjercicio;
	}

	public void setResaltarBusquedaPorFechaInicioEjercicio(Border borderResaltar) {
		this.resaltarBusquedaPorFechaInicioEjercicio= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaInicioEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaInicioEjercicio= borderResaltar;
	}

	public Border resaltarFK_IdAnioEjercicio=null;

	public Border getResaltarFK_IdAnioEjercicio() {
		return this.resaltarFK_IdAnioEjercicio;
	}

	public void setResaltarFK_IdAnioEjercicio(Border borderResaltar) {
		this.resaltarFK_IdAnioEjercicio= borderResaltar;
	}

	public void setResaltarFK_IdAnioEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioEjercicio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEjercicio=null;

	public Border getResaltarFK_IdEmpresaEjercicio() {
		return this.resaltarFK_IdEmpresaEjercicio;
	}

	public void setResaltarFK_IdEmpresaEjercicio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEjercicio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEjercicio(ParametroGeneralUsuario parametroGeneralUsuario/*EjercicioBeanSwingJInternalFrame ejercicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEjercicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}