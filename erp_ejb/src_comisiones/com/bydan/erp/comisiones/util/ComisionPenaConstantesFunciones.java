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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionPenaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionPenaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionPenaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionPenaConstantesFunciones extends ComisionPenaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionPena";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionPena"+ComisionPenaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionPenaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionPenaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionPenaConstantesFunciones.SCHEMA+"_"+ComisionPenaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionPenaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionPenaConstantesFunciones.SCHEMA+"_"+ComisionPenaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionPenaConstantesFunciones.SCHEMA+"_"+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionPenaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionPenaConstantesFunciones.SCHEMA+"_"+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionPenaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionPenaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionPenaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionPenaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionPenaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionPenaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionPenaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Penalidad Comisions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Penalidad Comision";
	public static final String SCLASSWEBTITULO_LOWER="Comision Pena";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionPena";
	public static final String OBJECTNAME="comisionpena";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_pena";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisionpena from "+ComisionPenaConstantesFunciones.SPERSISTENCENAME+" comisionpena";
	public static String QUERYSELECTNATIVE="select "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".version_row,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id_empresa,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".num_dias_inicio,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".num_dias_fin,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".porcentaje,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".descripcion from "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME;//+" as "+ComisionPenaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionPenaConstantesFuncionesAdditional comisionpenaConstantesFuncionesAdditional=null;
	
	public ComisionPenaConstantesFuncionesAdditional getComisionPenaConstantesFuncionesAdditional() {
		return this.comisionpenaConstantesFuncionesAdditional;
	}
	
	public void setComisionPenaConstantesFuncionesAdditional(ComisionPenaConstantesFuncionesAdditional comisionpenaConstantesFuncionesAdditional) {
		try {
			this.comisionpenaConstantesFuncionesAdditional=comisionpenaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCOMISIONCONFIG= "id_comision_config";
    public static final String NUMDIASINICIO= "num_dias_inicio";
    public static final String NUMDIASFIN= "num_dias_fin";
    public static final String PORCENTAJE= "porcentaje";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCOMISIONCONFIG= "Configuracion";
		public static final String LABEL_IDCOMISIONCONFIG_LOWER= "Comision Config";
    	public static final String LABEL_NUMDIASINICIO= "Num Dias Inicio";
		public static final String LABEL_NUMDIASINICIO_LOWER= "Num Dias Inicio";
    	public static final String LABEL_NUMDIASFIN= "Num Dias Fin";
		public static final String LABEL_NUMDIASFIN_LOWER= "Num Dias Fin";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComisionPenaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.IDCOMISIONCONFIG)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_IDCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.NUMDIASINICIO)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_NUMDIASINICIO;}
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.NUMDIASFIN)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_NUMDIASFIN;}
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.PORCENTAJE)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ComisionPenaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComisionPenaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getComisionPenaDescripcion(ComisionPena comisionpena) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisionpena !=null/* && comisionpena.getId()!=0*/) {
			if(comisionpena.getId()!=null) {
				sDescripcion=comisionpena.getId().toString();
			}//comisionpenacomisionpena.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionPenaDescripcionDetallado(ComisionPena comisionpena) {
		String sDescripcion="";
			
		sDescripcion+=ComisionPenaConstantesFunciones.ID+"=";
		sDescripcion+=comisionpena.getId().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisionpena.getVersionRow().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisionpena.getid_empresa().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.IDCOMISIONCONFIG+"=";
		sDescripcion+=comisionpena.getid_comision_config().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.NUMDIASINICIO+"=";
		sDescripcion+=comisionpena.getnum_dias_inicio().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.NUMDIASFIN+"=";
		sDescripcion+=comisionpena.getnum_dias_fin().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=comisionpena.getporcentaje().toString()+",";
		sDescripcion+=ComisionPenaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comisionpena.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionPenaDescripcion(ComisionPena comisionpena,String sValor) throws Exception {			
		if(comisionpena !=null) {
			//comisionpenacomisionpena.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getComisionConfigDescripcion(ComisionConfig comisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(comisionconfig!=null/*&&comisionconfig.getId()>0*/) {
			sDescripcion=ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionconfig);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdComisionConfig")) {
			sNombreIndice="Tipo=  Por Configuracion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdComisionConfig(Long id_comision_config) {
		String sDetalleIndice=" Parametros->";
		if(id_comision_config!=null) {sDetalleIndice+=" Codigo Unico De Configuracion="+id_comision_config.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionPena(ComisionPena comisionpena,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisionpena.setdescripcion(comisionpena.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComisionPenas(List<ComisionPena> comisionpenas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionPena comisionpena: comisionpenas) {
			comisionpena.setdescripcion(comisionpena.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionPena(ComisionPena comisionpena,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisionpena.getConCambioAuxiliar()) {
			comisionpena.setIsDeleted(comisionpena.getIsDeletedAuxiliar());	
			comisionpena.setIsNew(comisionpena.getIsNewAuxiliar());	
			comisionpena.setIsChanged(comisionpena.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisionpena.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisionpena.setIsDeletedAuxiliar(false);	
			comisionpena.setIsNewAuxiliar(false);	
			comisionpena.setIsChangedAuxiliar(false);
			
			comisionpena.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionPenas(List<ComisionPena> comisionpenas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionPena comisionpena : comisionpenas) {
			if(conAsignarBase && comisionpena.getConCambioAuxiliar()) {
				comisionpena.setIsDeleted(comisionpena.getIsDeletedAuxiliar());	
				comisionpena.setIsNew(comisionpena.getIsNewAuxiliar());	
				comisionpena.setIsChanged(comisionpena.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisionpena.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisionpena.setIsDeletedAuxiliar(false);	
				comisionpena.setIsNewAuxiliar(false);	
				comisionpena.setIsChangedAuxiliar(false);
				
				comisionpena.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionPena(ComisionPena comisionpena,Boolean conEnteros) throws Exception  {
		comisionpena.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			comisionpena.setnum_dias_inicio(0);
			comisionpena.setnum_dias_fin(0);
		}
	}		
	
	public static void InicializarValoresComisionPenas(List<ComisionPena> comisionpenas,Boolean conEnteros) throws Exception  {
		
		for(ComisionPena comisionpena: comisionpenas) {
			comisionpena.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				comisionpena.setnum_dias_inicio(0);
				comisionpena.setnum_dias_fin(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionPena(List<ComisionPena> comisionpenas,ComisionPena comisionpenaAux) throws Exception  {
		ComisionPenaConstantesFunciones.InicializarValoresComisionPena(comisionpenaAux,true);
		
		for(ComisionPena comisionpena: comisionpenas) {
			if(comisionpena.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisionpenaAux.setnum_dias_inicio(comisionpenaAux.getnum_dias_inicio()+comisionpena.getnum_dias_inicio());			
			comisionpenaAux.setnum_dias_fin(comisionpenaAux.getnum_dias_fin()+comisionpena.getnum_dias_fin());			
			comisionpenaAux.setporcentaje(comisionpenaAux.getporcentaje()+comisionpena.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionPena(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionPenaConstantesFunciones.getArrayColumnasGlobalesComisionPena(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionPena(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionPenaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionPenaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionPena(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionPena> comisionpenas,ComisionPena comisionpena,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionPena comisionpenaAux: comisionpenas) {
			if(comisionpenaAux!=null && comisionpena!=null) {
				if((comisionpenaAux.getId()==null && comisionpena.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionpenaAux.getId()!=null && comisionpena.getId()!=null){
					if(comisionpenaAux.getId().equals(comisionpena.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionPena(List<ComisionPena> comisionpenas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ComisionPena comisionpena: comisionpenas) {			
			if(comisionpena.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=comisionpena.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionPenaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionPena() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_ID, ComisionPenaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_VERSIONROW, ComisionPenaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_IDEMPRESA, ComisionPenaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_IDCOMISIONCONFIG, ComisionPenaConstantesFunciones.IDCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_NUMDIASINICIO, ComisionPenaConstantesFunciones.NUMDIASINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_NUMDIASFIN, ComisionPenaConstantesFunciones.NUMDIASFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_PORCENTAJE, ComisionPenaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionPenaConstantesFunciones.LABEL_DESCRIPCION, ComisionPenaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionPena() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.IDCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.NUMDIASINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.NUMDIASFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionPenaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionPena() throws Exception  {
		return ComisionPenaConstantesFunciones.getTiposSeleccionarComisionPena(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionPena(Boolean conFk) throws Exception  {
		return ComisionPenaConstantesFunciones.getTiposSeleccionarComisionPena(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionPena(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_IDCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_NUMDIASINICIO);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_NUMDIASINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_NUMDIASFIN);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_NUMDIASFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionPenaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComisionPenaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionPena(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionPena(ComisionPena comisionpenaAux) throws Exception {
		
			comisionpenaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionpenaAux.getEmpresa()));
			comisionpenaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionpenaAux.getComisionConfig()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionPena(List<ComisionPena> comisionpenasTemp) throws Exception {
		for(ComisionPena comisionpenaAux:comisionpenasTemp) {
			
			comisionpenaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionpenaAux.getEmpresa()));
			comisionpenaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionpenaAux.getComisionConfig()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionPena(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ComisionConfig.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionPena(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionPena(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionPenaConstantesFunciones.getClassesRelationshipsOfComisionPena(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionPena(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionPena(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionPenaConstantesFunciones.getClassesRelationshipsFromStringsOfComisionPena(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionPena(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionPena comisionpena,List<ComisionPena> comisionpenas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionPena comisionpenaEncontrado=null;
			
			for(ComisionPena comisionpenaLocal:comisionpenas) {
				if(comisionpenaLocal.getId().equals(comisionpena.getId())) {
					comisionpenaEncontrado=comisionpenaLocal;
					
					comisionpenaLocal.setIsChanged(comisionpena.getIsChanged());
					comisionpenaLocal.setIsNew(comisionpena.getIsNew());
					comisionpenaLocal.setIsDeleted(comisionpena.getIsDeleted());
					
					comisionpenaLocal.setGeneralEntityOriginal(comisionpena.getGeneralEntityOriginal());
					
					comisionpenaLocal.setId(comisionpena.getId());	
					comisionpenaLocal.setVersionRow(comisionpena.getVersionRow());	
					comisionpenaLocal.setid_empresa(comisionpena.getid_empresa());	
					comisionpenaLocal.setid_comision_config(comisionpena.getid_comision_config());	
					comisionpenaLocal.setnum_dias_inicio(comisionpena.getnum_dias_inicio());	
					comisionpenaLocal.setnum_dias_fin(comisionpena.getnum_dias_fin());	
					comisionpenaLocal.setporcentaje(comisionpena.getporcentaje());	
					comisionpenaLocal.setdescripcion(comisionpena.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisionpena.getIsDeleted()) {
				if(!existe) {
					comisionpenas.add(comisionpena);
				}
			} else {
				if(comisionpenaEncontrado!=null && permiteQuitar)  {
					comisionpenas.remove(comisionpenaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionPena comisionpena,List<ComisionPena> comisionpenas) throws Exception {
		try	{			
			for(ComisionPena comisionpenaLocal:comisionpenas) {
				if(comisionpenaLocal.getId().equals(comisionpena.getId())) {
					comisionpenaLocal.setIsSelected(comisionpena.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionPena(List<ComisionPena> comisionpenasAux) throws Exception {
		//this.comisionpenasAux=comisionpenasAux;
		
		for(ComisionPena comisionpenaAux:comisionpenasAux) {
			if(comisionpenaAux.getIsChanged()) {
				comisionpenaAux.setIsChanged(false);
			}		
			
			if(comisionpenaAux.getIsNew()) {
				comisionpenaAux.setIsNew(false);
			}	
			
			if(comisionpenaAux.getIsDeleted()) {
				comisionpenaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionPena(ComisionPena comisionpenaAux) throws Exception {
		//this.comisionpenaAux=comisionpenaAux;
		
			if(comisionpenaAux.getIsChanged()) {
				comisionpenaAux.setIsChanged(false);
			}		
			
			if(comisionpenaAux.getIsNew()) {
				comisionpenaAux.setIsNew(false);
			}	
			
			if(comisionpenaAux.getIsDeleted()) {
				comisionpenaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionPena comisionpenaAsignar,ComisionPena comisionpena) throws Exception {
		comisionpenaAsignar.setId(comisionpena.getId());	
		comisionpenaAsignar.setVersionRow(comisionpena.getVersionRow());	
		comisionpenaAsignar.setid_empresa(comisionpena.getid_empresa());
		comisionpenaAsignar.setempresa_descripcion(comisionpena.getempresa_descripcion());	
		comisionpenaAsignar.setid_comision_config(comisionpena.getid_comision_config());
		comisionpenaAsignar.setcomisionconfig_descripcion(comisionpena.getcomisionconfig_descripcion());	
		comisionpenaAsignar.setnum_dias_inicio(comisionpena.getnum_dias_inicio());	
		comisionpenaAsignar.setnum_dias_fin(comisionpena.getnum_dias_fin());	
		comisionpenaAsignar.setporcentaje(comisionpena.getporcentaje());	
		comisionpenaAsignar.setdescripcion(comisionpena.getdescripcion());	
	}
	
	public static void inicializarComisionPena(ComisionPena comisionpena) throws Exception {
		try {
				comisionpena.setId(0L);	
					
				comisionpena.setid_empresa(-1L);	
				comisionpena.setid_comision_config(-1L);	
				comisionpena.setnum_dias_inicio(0);	
				comisionpena.setnum_dias_fin(0);	
				comisionpena.setporcentaje(0.0);	
				comisionpena.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionPena(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_NUMDIASINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_NUMDIASFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionPenaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionPena(String sTipo,Row row,Workbook workbook,ComisionPena comisionpena,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getcomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getnum_dias_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getnum_dias_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionpena.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionPena=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionPena() {
		return this.sFinalQueryComisionPena;
	}
	
	public void setsFinalQueryComisionPena(String sFinalQueryComisionPena) {
		this.sFinalQueryComisionPena= sFinalQueryComisionPena;
	}
	
	public Border resaltarSeleccionarComisionPena=null;
	
	public Border setResaltarSeleccionarComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionPena= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionPena() {
		return this.resaltarSeleccionarComisionPena;
	}
	
	public void setResaltarSeleccionarComisionPena(Border borderResaltarSeleccionarComisionPena) {
		this.resaltarSeleccionarComisionPena= borderResaltarSeleccionarComisionPena;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionPena=null;
	public Boolean mostraridComisionPena=true;
	public Boolean activaridComisionPena=true;

	public Border resaltarid_empresaComisionPena=null;
	public Boolean mostrarid_empresaComisionPena=true;
	public Boolean activarid_empresaComisionPena=true;
	public Boolean cargarid_empresaComisionPena=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionPena=false;//ConEventDepend=true

	public Border resaltarid_comision_configComisionPena=null;
	public Boolean mostrarid_comision_configComisionPena=true;
	public Boolean activarid_comision_configComisionPena=true;
	public Boolean cargarid_comision_configComisionPena=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_comision_configComisionPena=false;//ConEventDepend=true

	public Border resaltarnum_dias_inicioComisionPena=null;
	public Boolean mostrarnum_dias_inicioComisionPena=true;
	public Boolean activarnum_dias_inicioComisionPena=true;

	public Border resaltarnum_dias_finComisionPena=null;
	public Boolean mostrarnum_dias_finComisionPena=true;
	public Boolean activarnum_dias_finComisionPena=true;

	public Border resaltarporcentajeComisionPena=null;
	public Boolean mostrarporcentajeComisionPena=true;
	public Boolean activarporcentajeComisionPena=true;

	public Border resaltardescripcionComisionPena=null;
	public Boolean mostrardescripcionComisionPena=true;
	public Boolean activardescripcionComisionPena=true;

	
	

	public Border setResaltaridComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltaridComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionPena() {
		return this.resaltaridComisionPena;
	}

	public void setResaltaridComisionPena(Border borderResaltar) {
		this.resaltaridComisionPena= borderResaltar;
	}

	public Boolean getMostraridComisionPena() {
		return this.mostraridComisionPena;
	}

	public void setMostraridComisionPena(Boolean mostraridComisionPena) {
		this.mostraridComisionPena= mostraridComisionPena;
	}

	public Boolean getActivaridComisionPena() {
		return this.activaridComisionPena;
	}

	public void setActivaridComisionPena(Boolean activaridComisionPena) {
		this.activaridComisionPena= activaridComisionPena;
	}

	public Border setResaltarid_empresaComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionPena() {
		return this.resaltarid_empresaComisionPena;
	}

	public void setResaltarid_empresaComisionPena(Border borderResaltar) {
		this.resaltarid_empresaComisionPena= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionPena() {
		return this.mostrarid_empresaComisionPena;
	}

	public void setMostrarid_empresaComisionPena(Boolean mostrarid_empresaComisionPena) {
		this.mostrarid_empresaComisionPena= mostrarid_empresaComisionPena;
	}

	public Boolean getActivarid_empresaComisionPena() {
		return this.activarid_empresaComisionPena;
	}

	public void setActivarid_empresaComisionPena(Boolean activarid_empresaComisionPena) {
		this.activarid_empresaComisionPena= activarid_empresaComisionPena;
	}

	public Boolean getCargarid_empresaComisionPena() {
		return this.cargarid_empresaComisionPena;
	}

	public void setCargarid_empresaComisionPena(Boolean cargarid_empresaComisionPena) {
		this.cargarid_empresaComisionPena= cargarid_empresaComisionPena;
	}

	public Border setResaltarid_comision_configComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarid_comision_configComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_comision_configComisionPena() {
		return this.resaltarid_comision_configComisionPena;
	}

	public void setResaltarid_comision_configComisionPena(Border borderResaltar) {
		this.resaltarid_comision_configComisionPena= borderResaltar;
	}

	public Boolean getMostrarid_comision_configComisionPena() {
		return this.mostrarid_comision_configComisionPena;
	}

	public void setMostrarid_comision_configComisionPena(Boolean mostrarid_comision_configComisionPena) {
		this.mostrarid_comision_configComisionPena= mostrarid_comision_configComisionPena;
	}

	public Boolean getActivarid_comision_configComisionPena() {
		return this.activarid_comision_configComisionPena;
	}

	public void setActivarid_comision_configComisionPena(Boolean activarid_comision_configComisionPena) {
		this.activarid_comision_configComisionPena= activarid_comision_configComisionPena;
	}

	public Boolean getCargarid_comision_configComisionPena() {
		return this.cargarid_comision_configComisionPena;
	}

	public void setCargarid_comision_configComisionPena(Boolean cargarid_comision_configComisionPena) {
		this.cargarid_comision_configComisionPena= cargarid_comision_configComisionPena;
	}

	public Border setResaltarnum_dias_inicioComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarnum_dias_inicioComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnum_dias_inicioComisionPena() {
		return this.resaltarnum_dias_inicioComisionPena;
	}

	public void setResaltarnum_dias_inicioComisionPena(Border borderResaltar) {
		this.resaltarnum_dias_inicioComisionPena= borderResaltar;
	}

	public Boolean getMostrarnum_dias_inicioComisionPena() {
		return this.mostrarnum_dias_inicioComisionPena;
	}

	public void setMostrarnum_dias_inicioComisionPena(Boolean mostrarnum_dias_inicioComisionPena) {
		this.mostrarnum_dias_inicioComisionPena= mostrarnum_dias_inicioComisionPena;
	}

	public Boolean getActivarnum_dias_inicioComisionPena() {
		return this.activarnum_dias_inicioComisionPena;
	}

	public void setActivarnum_dias_inicioComisionPena(Boolean activarnum_dias_inicioComisionPena) {
		this.activarnum_dias_inicioComisionPena= activarnum_dias_inicioComisionPena;
	}

	public Border setResaltarnum_dias_finComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarnum_dias_finComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnum_dias_finComisionPena() {
		return this.resaltarnum_dias_finComisionPena;
	}

	public void setResaltarnum_dias_finComisionPena(Border borderResaltar) {
		this.resaltarnum_dias_finComisionPena= borderResaltar;
	}

	public Boolean getMostrarnum_dias_finComisionPena() {
		return this.mostrarnum_dias_finComisionPena;
	}

	public void setMostrarnum_dias_finComisionPena(Boolean mostrarnum_dias_finComisionPena) {
		this.mostrarnum_dias_finComisionPena= mostrarnum_dias_finComisionPena;
	}

	public Boolean getActivarnum_dias_finComisionPena() {
		return this.activarnum_dias_finComisionPena;
	}

	public void setActivarnum_dias_finComisionPena(Boolean activarnum_dias_finComisionPena) {
		this.activarnum_dias_finComisionPena= activarnum_dias_finComisionPena;
	}

	public Border setResaltarporcentajeComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltarporcentajeComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeComisionPena() {
		return this.resaltarporcentajeComisionPena;
	}

	public void setResaltarporcentajeComisionPena(Border borderResaltar) {
		this.resaltarporcentajeComisionPena= borderResaltar;
	}

	public Boolean getMostrarporcentajeComisionPena() {
		return this.mostrarporcentajeComisionPena;
	}

	public void setMostrarporcentajeComisionPena(Boolean mostrarporcentajeComisionPena) {
		this.mostrarporcentajeComisionPena= mostrarporcentajeComisionPena;
	}

	public Boolean getActivarporcentajeComisionPena() {
		return this.activarporcentajeComisionPena;
	}

	public void setActivarporcentajeComisionPena(Boolean activarporcentajeComisionPena) {
		this.activarporcentajeComisionPena= activarporcentajeComisionPena;
	}

	public Border setResaltardescripcionComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionpenaBeanSwingJInternalFrame.jTtoolBarComisionPena.setBorder(borderResaltar);
		
		this.resaltardescripcionComisionPena= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComisionPena() {
		return this.resaltardescripcionComisionPena;
	}

	public void setResaltardescripcionComisionPena(Border borderResaltar) {
		this.resaltardescripcionComisionPena= borderResaltar;
	}

	public Boolean getMostrardescripcionComisionPena() {
		return this.mostrardescripcionComisionPena;
	}

	public void setMostrardescripcionComisionPena(Boolean mostrardescripcionComisionPena) {
		this.mostrardescripcionComisionPena= mostrardescripcionComisionPena;
	}

	public Boolean getActivardescripcionComisionPena() {
		return this.activardescripcionComisionPena;
	}

	public void setActivardescripcionComisionPena(Boolean activardescripcionComisionPena) {
		this.activardescripcionComisionPena= activardescripcionComisionPena;
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
		
		
		this.setMostraridComisionPena(esInicial);
		this.setMostrarid_empresaComisionPena(esInicial);
		this.setMostrarid_comision_configComisionPena(esInicial);
		this.setMostrarnum_dias_inicioComisionPena(esInicial);
		this.setMostrarnum_dias_finComisionPena(esInicial);
		this.setMostrarporcentajeComisionPena(esInicial);
		this.setMostrardescripcionComisionPena(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionPenaConstantesFunciones.ID)) {
				this.setMostraridComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setMostrarid_comision_configComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASINICIO)) {
				this.setMostrarnum_dias_inicioComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASFIN)) {
				this.setMostrarnum_dias_finComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComisionPena(esAsigna);
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
		
		
		this.setActivaridComisionPena(esInicial);
		this.setActivarid_empresaComisionPena(esInicial);
		this.setActivarid_comision_configComisionPena(esInicial);
		this.setActivarnum_dias_inicioComisionPena(esInicial);
		this.setActivarnum_dias_finComisionPena(esInicial);
		this.setActivarporcentajeComisionPena(esInicial);
		this.setActivardescripcionComisionPena(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionPenaConstantesFunciones.ID)) {
				this.setActivaridComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setActivarid_comision_configComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASINICIO)) {
				this.setActivarnum_dias_inicioComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASFIN)) {
				this.setActivarnum_dias_finComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComisionPena(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionPena(esInicial);
		this.setResaltarid_empresaComisionPena(esInicial);
		this.setResaltarid_comision_configComisionPena(esInicial);
		this.setResaltarnum_dias_inicioComisionPena(esInicial);
		this.setResaltarnum_dias_finComisionPena(esInicial);
		this.setResaltarporcentajeComisionPena(esInicial);
		this.setResaltardescripcionComisionPena(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionPenaConstantesFunciones.ID)) {
				this.setResaltaridComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setResaltarid_comision_configComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASINICIO)) {
				this.setResaltarnum_dias_inicioComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.NUMDIASFIN)) {
				this.setResaltarnum_dias_finComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeComisionPena(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionPenaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComisionPena(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdComisionConfigComisionPena=true;

	public Boolean getMostrarFK_IdComisionConfigComisionPena() {
		return this.mostrarFK_IdComisionConfigComisionPena;
	}

	public void setMostrarFK_IdComisionConfigComisionPena(Boolean visibilidadResaltar) {
		this.mostrarFK_IdComisionConfigComisionPena= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaComisionPena=true;

	public Boolean getMostrarFK_IdEmpresaComisionPena() {
		return this.mostrarFK_IdEmpresaComisionPena;
	}

	public void setMostrarFK_IdEmpresaComisionPena(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionPena= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdComisionConfigComisionPena=true;

	public Boolean getActivarFK_IdComisionConfigComisionPena() {
		return this.activarFK_IdComisionConfigComisionPena;
	}

	public void setActivarFK_IdComisionConfigComisionPena(Boolean habilitarResaltar) {
		this.activarFK_IdComisionConfigComisionPena= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaComisionPena=true;

	public Boolean getActivarFK_IdEmpresaComisionPena() {
		return this.activarFK_IdEmpresaComisionPena;
	}

	public void setActivarFK_IdEmpresaComisionPena(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionPena= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdComisionConfigComisionPena=null;

	public Border getResaltarFK_IdComisionConfigComisionPena() {
		return this.resaltarFK_IdComisionConfigComisionPena;
	}

	public void setResaltarFK_IdComisionConfigComisionPena(Border borderResaltar) {
		this.resaltarFK_IdComisionConfigComisionPena= borderResaltar;
	}

	public void setResaltarFK_IdComisionConfigComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdComisionConfigComisionPena= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaComisionPena=null;

	public Border getResaltarFK_IdEmpresaComisionPena() {
		return this.resaltarFK_IdEmpresaComisionPena;
	}

	public void setResaltarFK_IdEmpresaComisionPena(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionPena= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionPena(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionPenaBeanSwingJInternalFrame comisionpenaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionPena= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}