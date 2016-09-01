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


import com.bydan.erp.nomina.util.ProfesionEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.ProfesionEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProfesionEmpleaParameterGeneral;

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
final public class ProfesionEmpleaConstantesFunciones extends ProfesionEmpleaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProfesionEmplea";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProfesionEmplea"+ProfesionEmpleaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProfesionEmpleaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProfesionEmpleaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProfesionEmpleaConstantesFunciones.SCHEMA+"_"+ProfesionEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProfesionEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProfesionEmpleaConstantesFunciones.SCHEMA+"_"+ProfesionEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProfesionEmpleaConstantesFunciones.SCHEMA+"_"+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProfesionEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProfesionEmpleaConstantesFunciones.SCHEMA+"_"+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProfesionEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProfesionEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProfesionEmpleaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProfesionEmpleaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProfesionEmpleaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProfesionEmpleaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Profesion Empleas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Profesion Emplea";
	public static final String SCLASSWEBTITULO_LOWER="Profesion Emplea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProfesionEmplea";
	public static final String OBJECTNAME="profesionemplea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="profesion_emplea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select profesionemplea from "+ProfesionEmpleaConstantesFunciones.SPERSISTENCENAME+" profesionemplea";
	public static String QUERYSELECTNATIVE="select "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".version_row,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_empresa,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_empleado,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_profesion from "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME;//+" as "+ProfesionEmpleaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProfesionEmpleaConstantesFuncionesAdditional profesionempleaConstantesFuncionesAdditional=null;
	
	public ProfesionEmpleaConstantesFuncionesAdditional getProfesionEmpleaConstantesFuncionesAdditional() {
		return this.profesionempleaConstantesFuncionesAdditional;
	}
	
	public void setProfesionEmpleaConstantesFuncionesAdditional(ProfesionEmpleaConstantesFuncionesAdditional profesionempleaConstantesFuncionesAdditional) {
		try {
			this.profesionempleaConstantesFuncionesAdditional=profesionempleaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDPROFESION= "id_profesion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDPROFESION= "Profesion";
		public static final String LABEL_IDPROFESION_LOWER= "Profesion";
	
		
		
		
		
		
	
	public static String getProfesionEmpleaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProfesionEmpleaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProfesionEmpleaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProfesionEmpleaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ProfesionEmpleaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ProfesionEmpleaConstantesFunciones.IDPROFESION)) {sLabelColumna=ProfesionEmpleaConstantesFunciones.LABEL_IDPROFESION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProfesionEmpleaDescripcion(ProfesionEmplea profesionemplea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(profesionemplea !=null/* && profesionemplea.getId()!=0*/) {
			if(profesionemplea.getId()!=null) {
				sDescripcion=profesionemplea.getId().toString();
			}//profesionempleaprofesionemplea.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProfesionEmpleaDescripcionDetallado(ProfesionEmplea profesionemplea) {
		String sDescripcion="";
			
		sDescripcion+=ProfesionEmpleaConstantesFunciones.ID+"=";
		sDescripcion+=profesionemplea.getId().toString()+",";
		sDescripcion+=ProfesionEmpleaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=profesionemplea.getVersionRow().toString()+",";
		sDescripcion+=ProfesionEmpleaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=profesionemplea.getid_empresa().toString()+",";
		sDescripcion+=ProfesionEmpleaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=profesionemplea.getid_empleado().toString()+",";
		sDescripcion+=ProfesionEmpleaConstantesFunciones.IDPROFESION+"=";
		sDescripcion+=profesionemplea.getid_profesion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProfesionEmpleaDescripcion(ProfesionEmplea profesionemplea,String sValor) throws Exception {			
		if(profesionemplea !=null) {
			//profesionempleaprofesionemplea.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getProfesionDescripcion(Profesion profesion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(profesion!=null/*&&profesion.getId()>0*/) {
			sDescripcion=ProfesionConstantesFunciones.getProfesionDescripcion(profesion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProfesion")) {
			sNombreIndice="Tipo=  Por Profesion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProfesion(Long id_profesion) {
		String sDetalleIndice=" Parametros->";
		if(id_profesion!=null) {sDetalleIndice+=" Codigo Unico De Profesion="+id_profesion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProfesionEmplea(ProfesionEmplea profesionemplea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProfesionEmpleas(List<ProfesionEmplea> profesionempleas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProfesionEmplea profesionemplea: profesionempleas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProfesionEmplea(ProfesionEmplea profesionemplea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && profesionemplea.getConCambioAuxiliar()) {
			profesionemplea.setIsDeleted(profesionemplea.getIsDeletedAuxiliar());	
			profesionemplea.setIsNew(profesionemplea.getIsNewAuxiliar());	
			profesionemplea.setIsChanged(profesionemplea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			profesionemplea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			profesionemplea.setIsDeletedAuxiliar(false);	
			profesionemplea.setIsNewAuxiliar(false);	
			profesionemplea.setIsChangedAuxiliar(false);
			
			profesionemplea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProfesionEmpleas(List<ProfesionEmplea> profesionempleas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProfesionEmplea profesionemplea : profesionempleas) {
			if(conAsignarBase && profesionemplea.getConCambioAuxiliar()) {
				profesionemplea.setIsDeleted(profesionemplea.getIsDeletedAuxiliar());	
				profesionemplea.setIsNew(profesionemplea.getIsNewAuxiliar());	
				profesionemplea.setIsChanged(profesionemplea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				profesionemplea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				profesionemplea.setIsDeletedAuxiliar(false);	
				profesionemplea.setIsNewAuxiliar(false);	
				profesionemplea.setIsChangedAuxiliar(false);
				
				profesionemplea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProfesionEmplea(ProfesionEmplea profesionemplea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProfesionEmpleas(List<ProfesionEmplea> profesionempleas,Boolean conEnteros) throws Exception  {
		
		for(ProfesionEmplea profesionemplea: profesionempleas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProfesionEmplea(List<ProfesionEmplea> profesionempleas,ProfesionEmplea profesionempleaAux) throws Exception  {
		ProfesionEmpleaConstantesFunciones.InicializarValoresProfesionEmplea(profesionempleaAux,true);
		
		for(ProfesionEmplea profesionemplea: profesionempleas) {
			if(profesionemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProfesionEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProfesionEmpleaConstantesFunciones.getArrayColumnasGlobalesProfesionEmplea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProfesionEmplea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProfesionEmpleaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProfesionEmpleaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProfesionEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProfesionEmplea> profesionempleas,ProfesionEmplea profesionemplea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProfesionEmplea profesionempleaAux: profesionempleas) {
			if(profesionempleaAux!=null && profesionemplea!=null) {
				if((profesionempleaAux.getId()==null && profesionemplea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(profesionempleaAux.getId()!=null && profesionemplea.getId()!=null){
					if(profesionempleaAux.getId().equals(profesionemplea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProfesionEmplea(List<ProfesionEmplea> profesionempleas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProfesionEmplea profesionemplea: profesionempleas) {			
			if(profesionemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProfesionEmplea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProfesionEmpleaConstantesFunciones.LABEL_ID, ProfesionEmpleaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionEmpleaConstantesFunciones.LABEL_VERSIONROW, ProfesionEmpleaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionEmpleaConstantesFunciones.LABEL_IDEMPRESA, ProfesionEmpleaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionEmpleaConstantesFunciones.LABEL_IDEMPLEADO, ProfesionEmpleaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionEmpleaConstantesFunciones.LABEL_IDPROFESION, ProfesionEmpleaConstantesFunciones.IDPROFESION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProfesionEmplea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProfesionEmpleaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionEmpleaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionEmpleaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionEmpleaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionEmpleaConstantesFunciones.IDPROFESION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesionEmplea() throws Exception  {
		return ProfesionEmpleaConstantesFunciones.getTiposSeleccionarProfesionEmplea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesionEmplea(Boolean conFk) throws Exception  {
		return ProfesionEmpleaConstantesFunciones.getTiposSeleccionarProfesionEmplea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesionEmplea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProfesionEmpleaConstantesFunciones.LABEL_IDPROFESION);
			reporte.setsDescripcion(ProfesionEmpleaConstantesFunciones.LABEL_IDPROFESION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProfesionEmplea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProfesionEmplea(ProfesionEmplea profesionempleaAux) throws Exception {
		
			profesionempleaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(profesionempleaAux.getEmpresa()));
			profesionempleaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(profesionempleaAux.getEmpleado()));
			profesionempleaAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(profesionempleaAux.getProfesion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProfesionEmplea(List<ProfesionEmplea> profesionempleasTemp) throws Exception {
		for(ProfesionEmplea profesionempleaAux:profesionempleasTemp) {
			
			profesionempleaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(profesionempleaAux.getEmpresa()));
			profesionempleaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(profesionempleaAux.getEmpleado()));
			profesionempleaAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(profesionempleaAux.getProfesion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProfesionEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Profesion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Profesion.class)) {
						classes.add(new Classe(Profesion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProfesionEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesionEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProfesionEmpleaConstantesFunciones.getClassesRelationshipsOfProfesionEmplea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesionEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProfesionEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProfesionEmpleaConstantesFunciones.getClassesRelationshipsFromStringsOfProfesionEmplea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProfesionEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProfesionEmplea profesionemplea,List<ProfesionEmplea> profesionempleas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProfesionEmplea profesionempleaEncontrado=null;
			
			for(ProfesionEmplea profesionempleaLocal:profesionempleas) {
				if(profesionempleaLocal.getId().equals(profesionemplea.getId())) {
					profesionempleaEncontrado=profesionempleaLocal;
					
					profesionempleaLocal.setIsChanged(profesionemplea.getIsChanged());
					profesionempleaLocal.setIsNew(profesionemplea.getIsNew());
					profesionempleaLocal.setIsDeleted(profesionemplea.getIsDeleted());
					
					profesionempleaLocal.setGeneralEntityOriginal(profesionemplea.getGeneralEntityOriginal());
					
					profesionempleaLocal.setId(profesionemplea.getId());	
					profesionempleaLocal.setVersionRow(profesionemplea.getVersionRow());	
					profesionempleaLocal.setid_empresa(profesionemplea.getid_empresa());	
					profesionempleaLocal.setid_empleado(profesionemplea.getid_empleado());	
					profesionempleaLocal.setid_profesion(profesionemplea.getid_profesion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!profesionemplea.getIsDeleted()) {
				if(!existe) {
					profesionempleas.add(profesionemplea);
				}
			} else {
				if(profesionempleaEncontrado!=null && permiteQuitar)  {
					profesionempleas.remove(profesionempleaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProfesionEmplea profesionemplea,List<ProfesionEmplea> profesionempleas) throws Exception {
		try	{			
			for(ProfesionEmplea profesionempleaLocal:profesionempleas) {
				if(profesionempleaLocal.getId().equals(profesionemplea.getId())) {
					profesionempleaLocal.setIsSelected(profesionemplea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProfesionEmplea(List<ProfesionEmplea> profesionempleasAux) throws Exception {
		//this.profesionempleasAux=profesionempleasAux;
		
		for(ProfesionEmplea profesionempleaAux:profesionempleasAux) {
			if(profesionempleaAux.getIsChanged()) {
				profesionempleaAux.setIsChanged(false);
			}		
			
			if(profesionempleaAux.getIsNew()) {
				profesionempleaAux.setIsNew(false);
			}	
			
			if(profesionempleaAux.getIsDeleted()) {
				profesionempleaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProfesionEmplea(ProfesionEmplea profesionempleaAux) throws Exception {
		//this.profesionempleaAux=profesionempleaAux;
		
			if(profesionempleaAux.getIsChanged()) {
				profesionempleaAux.setIsChanged(false);
			}		
			
			if(profesionempleaAux.getIsNew()) {
				profesionempleaAux.setIsNew(false);
			}	
			
			if(profesionempleaAux.getIsDeleted()) {
				profesionempleaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProfesionEmplea profesionempleaAsignar,ProfesionEmplea profesionemplea) throws Exception {
		profesionempleaAsignar.setId(profesionemplea.getId());	
		profesionempleaAsignar.setVersionRow(profesionemplea.getVersionRow());	
		profesionempleaAsignar.setid_empresa(profesionemplea.getid_empresa());
		profesionempleaAsignar.setempresa_descripcion(profesionemplea.getempresa_descripcion());	
		profesionempleaAsignar.setid_empleado(profesionemplea.getid_empleado());
		profesionempleaAsignar.setempleado_descripcion(profesionemplea.getempleado_descripcion());	
		profesionempleaAsignar.setid_profesion(profesionemplea.getid_profesion());
		profesionempleaAsignar.setprofesion_descripcion(profesionemplea.getprofesion_descripcion());	
	}
	
	public static void inicializarProfesionEmplea(ProfesionEmplea profesionemplea) throws Exception {
		try {
				profesionemplea.setId(0L);	
					
				profesionemplea.setid_empresa(-1L);	
				profesionemplea.setid_empleado(-1L);	
				profesionemplea.setid_profesion(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProfesionEmplea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProfesionEmpleaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProfesionEmpleaConstantesFunciones.LABEL_IDPROFESION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProfesionEmplea(String sTipo,Row row,Workbook workbook,ProfesionEmplea profesionemplea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(profesionemplea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(profesionemplea.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(profesionemplea.getprofesion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProfesionEmplea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProfesionEmplea() {
		return this.sFinalQueryProfesionEmplea;
	}
	
	public void setsFinalQueryProfesionEmplea(String sFinalQueryProfesionEmplea) {
		this.sFinalQueryProfesionEmplea= sFinalQueryProfesionEmplea;
	}
	
	public Border resaltarSeleccionarProfesionEmplea=null;
	
	public Border setResaltarSeleccionarProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//profesionempleaBeanSwingJInternalFrame.jTtoolBarProfesionEmplea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProfesionEmplea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProfesionEmplea() {
		return this.resaltarSeleccionarProfesionEmplea;
	}
	
	public void setResaltarSeleccionarProfesionEmplea(Border borderResaltarSeleccionarProfesionEmplea) {
		this.resaltarSeleccionarProfesionEmplea= borderResaltarSeleccionarProfesionEmplea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProfesionEmplea=null;
	public Boolean mostraridProfesionEmplea=true;
	public Boolean activaridProfesionEmplea=true;

	public Border resaltarid_empresaProfesionEmplea=null;
	public Boolean mostrarid_empresaProfesionEmplea=true;
	public Boolean activarid_empresaProfesionEmplea=true;
	public Boolean cargarid_empresaProfesionEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProfesionEmplea=false;//ConEventDepend=true

	public Border resaltarid_empleadoProfesionEmplea=null;
	public Boolean mostrarid_empleadoProfesionEmplea=true;
	public Boolean activarid_empleadoProfesionEmplea=true;
	public Boolean cargarid_empleadoProfesionEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoProfesionEmplea=false;//ConEventDepend=true

	public Border resaltarid_profesionProfesionEmplea=null;
	public Boolean mostrarid_profesionProfesionEmplea=true;
	public Boolean activarid_profesionProfesionEmplea=true;
	public Boolean cargarid_profesionProfesionEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_profesionProfesionEmplea=false;//ConEventDepend=true

	
	

	public Border setResaltaridProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionempleaBeanSwingJInternalFrame.jTtoolBarProfesionEmplea.setBorder(borderResaltar);
		
		this.resaltaridProfesionEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProfesionEmplea() {
		return this.resaltaridProfesionEmplea;
	}

	public void setResaltaridProfesionEmplea(Border borderResaltar) {
		this.resaltaridProfesionEmplea= borderResaltar;
	}

	public Boolean getMostraridProfesionEmplea() {
		return this.mostraridProfesionEmplea;
	}

	public void setMostraridProfesionEmplea(Boolean mostraridProfesionEmplea) {
		this.mostraridProfesionEmplea= mostraridProfesionEmplea;
	}

	public Boolean getActivaridProfesionEmplea() {
		return this.activaridProfesionEmplea;
	}

	public void setActivaridProfesionEmplea(Boolean activaridProfesionEmplea) {
		this.activaridProfesionEmplea= activaridProfesionEmplea;
	}

	public Border setResaltarid_empresaProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionempleaBeanSwingJInternalFrame.jTtoolBarProfesionEmplea.setBorder(borderResaltar);
		
		this.resaltarid_empresaProfesionEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProfesionEmplea() {
		return this.resaltarid_empresaProfesionEmplea;
	}

	public void setResaltarid_empresaProfesionEmplea(Border borderResaltar) {
		this.resaltarid_empresaProfesionEmplea= borderResaltar;
	}

	public Boolean getMostrarid_empresaProfesionEmplea() {
		return this.mostrarid_empresaProfesionEmplea;
	}

	public void setMostrarid_empresaProfesionEmplea(Boolean mostrarid_empresaProfesionEmplea) {
		this.mostrarid_empresaProfesionEmplea= mostrarid_empresaProfesionEmplea;
	}

	public Boolean getActivarid_empresaProfesionEmplea() {
		return this.activarid_empresaProfesionEmplea;
	}

	public void setActivarid_empresaProfesionEmplea(Boolean activarid_empresaProfesionEmplea) {
		this.activarid_empresaProfesionEmplea= activarid_empresaProfesionEmplea;
	}

	public Boolean getCargarid_empresaProfesionEmplea() {
		return this.cargarid_empresaProfesionEmplea;
	}

	public void setCargarid_empresaProfesionEmplea(Boolean cargarid_empresaProfesionEmplea) {
		this.cargarid_empresaProfesionEmplea= cargarid_empresaProfesionEmplea;
	}

	public Border setResaltarid_empleadoProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionempleaBeanSwingJInternalFrame.jTtoolBarProfesionEmplea.setBorder(borderResaltar);
		
		this.resaltarid_empleadoProfesionEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoProfesionEmplea() {
		return this.resaltarid_empleadoProfesionEmplea;
	}

	public void setResaltarid_empleadoProfesionEmplea(Border borderResaltar) {
		this.resaltarid_empleadoProfesionEmplea= borderResaltar;
	}

	public Boolean getMostrarid_empleadoProfesionEmplea() {
		return this.mostrarid_empleadoProfesionEmplea;
	}

	public void setMostrarid_empleadoProfesionEmplea(Boolean mostrarid_empleadoProfesionEmplea) {
		this.mostrarid_empleadoProfesionEmplea= mostrarid_empleadoProfesionEmplea;
	}

	public Boolean getActivarid_empleadoProfesionEmplea() {
		return this.activarid_empleadoProfesionEmplea;
	}

	public void setActivarid_empleadoProfesionEmplea(Boolean activarid_empleadoProfesionEmplea) {
		this.activarid_empleadoProfesionEmplea= activarid_empleadoProfesionEmplea;
	}

	public Boolean getCargarid_empleadoProfesionEmplea() {
		return this.cargarid_empleadoProfesionEmplea;
	}

	public void setCargarid_empleadoProfesionEmplea(Boolean cargarid_empleadoProfesionEmplea) {
		this.cargarid_empleadoProfesionEmplea= cargarid_empleadoProfesionEmplea;
	}

	public Border setResaltarid_profesionProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionempleaBeanSwingJInternalFrame.jTtoolBarProfesionEmplea.setBorder(borderResaltar);
		
		this.resaltarid_profesionProfesionEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_profesionProfesionEmplea() {
		return this.resaltarid_profesionProfesionEmplea;
	}

	public void setResaltarid_profesionProfesionEmplea(Border borderResaltar) {
		this.resaltarid_profesionProfesionEmplea= borderResaltar;
	}

	public Boolean getMostrarid_profesionProfesionEmplea() {
		return this.mostrarid_profesionProfesionEmplea;
	}

	public void setMostrarid_profesionProfesionEmplea(Boolean mostrarid_profesionProfesionEmplea) {
		this.mostrarid_profesionProfesionEmplea= mostrarid_profesionProfesionEmplea;
	}

	public Boolean getActivarid_profesionProfesionEmplea() {
		return this.activarid_profesionProfesionEmplea;
	}

	public void setActivarid_profesionProfesionEmplea(Boolean activarid_profesionProfesionEmplea) {
		this.activarid_profesionProfesionEmplea= activarid_profesionProfesionEmplea;
	}

	public Boolean getCargarid_profesionProfesionEmplea() {
		return this.cargarid_profesionProfesionEmplea;
	}

	public void setCargarid_profesionProfesionEmplea(Boolean cargarid_profesionProfesionEmplea) {
		this.cargarid_profesionProfesionEmplea= cargarid_profesionProfesionEmplea;
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
		
		
		this.setMostraridProfesionEmplea(esInicial);
		this.setMostrarid_empresaProfesionEmplea(esInicial);
		this.setMostrarid_empleadoProfesionEmplea(esInicial);
		this.setMostrarid_profesionProfesionEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.ID)) {
				this.setMostraridProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDPROFESION)) {
				this.setMostrarid_profesionProfesionEmplea(esAsigna);
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
		
		
		this.setActivaridProfesionEmplea(esInicial);
		this.setActivarid_empresaProfesionEmplea(esInicial);
		this.setActivarid_empleadoProfesionEmplea(esInicial);
		this.setActivarid_profesionProfesionEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.ID)) {
				this.setActivaridProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDPROFESION)) {
				this.setActivarid_profesionProfesionEmplea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProfesionEmplea(esInicial);
		this.setResaltarid_empresaProfesionEmplea(esInicial);
		this.setResaltarid_empleadoProfesionEmplea(esInicial);
		this.setResaltarid_profesionProfesionEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.ID)) {
				this.setResaltaridProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoProfesionEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionEmpleaConstantesFunciones.IDPROFESION)) {
				this.setResaltarid_profesionProfesionEmplea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoProfesionEmplea=true;

	public Boolean getMostrarFK_IdEmpleadoProfesionEmplea() {
		return this.mostrarFK_IdEmpleadoProfesionEmplea;
	}

	public void setMostrarFK_IdEmpleadoProfesionEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoProfesionEmplea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProfesionEmplea=true;

	public Boolean getMostrarFK_IdEmpresaProfesionEmplea() {
		return this.mostrarFK_IdEmpresaProfesionEmplea;
	}

	public void setMostrarFK_IdEmpresaProfesionEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProfesionEmplea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProfesionProfesionEmplea=true;

	public Boolean getMostrarFK_IdProfesionProfesionEmplea() {
		return this.mostrarFK_IdProfesionProfesionEmplea;
	}

	public void setMostrarFK_IdProfesionProfesionEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProfesionProfesionEmplea= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoProfesionEmplea=true;

	public Boolean getActivarFK_IdEmpleadoProfesionEmplea() {
		return this.activarFK_IdEmpleadoProfesionEmplea;
	}

	public void setActivarFK_IdEmpleadoProfesionEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoProfesionEmplea= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProfesionEmplea=true;

	public Boolean getActivarFK_IdEmpresaProfesionEmplea() {
		return this.activarFK_IdEmpresaProfesionEmplea;
	}

	public void setActivarFK_IdEmpresaProfesionEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProfesionEmplea= habilitarResaltar;
	}

	public Boolean activarFK_IdProfesionProfesionEmplea=true;

	public Boolean getActivarFK_IdProfesionProfesionEmplea() {
		return this.activarFK_IdProfesionProfesionEmplea;
	}

	public void setActivarFK_IdProfesionProfesionEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdProfesionProfesionEmplea= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoProfesionEmplea=null;

	public Border getResaltarFK_IdEmpleadoProfesionEmplea() {
		return this.resaltarFK_IdEmpleadoProfesionEmplea;
	}

	public void setResaltarFK_IdEmpleadoProfesionEmplea(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoProfesionEmplea= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoProfesionEmplea= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProfesionEmplea=null;

	public Border getResaltarFK_IdEmpresaProfesionEmplea() {
		return this.resaltarFK_IdEmpresaProfesionEmplea;
	}

	public void setResaltarFK_IdEmpresaProfesionEmplea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProfesionEmplea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProfesionEmplea= borderResaltar;
	}

	public Border resaltarFK_IdProfesionProfesionEmplea=null;

	public Border getResaltarFK_IdProfesionProfesionEmplea() {
		return this.resaltarFK_IdProfesionProfesionEmplea;
	}

	public void setResaltarFK_IdProfesionProfesionEmplea(Border borderResaltar) {
		this.resaltarFK_IdProfesionProfesionEmplea= borderResaltar;
	}

	public void setResaltarFK_IdProfesionProfesionEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionEmpleaBeanSwingJInternalFrame profesionempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProfesionProfesionEmplea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}