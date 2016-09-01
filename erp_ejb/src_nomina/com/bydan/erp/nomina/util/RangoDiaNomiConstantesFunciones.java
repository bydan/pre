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


import com.bydan.erp.nomina.util.RangoDiaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.RangoDiaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RangoDiaNomiParameterGeneral;

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
final public class RangoDiaNomiConstantesFunciones extends RangoDiaNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RangoDiaNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RangoDiaNomi"+RangoDiaNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RangoDiaNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RangoDiaNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RangoDiaNomiConstantesFunciones.SCHEMA+"_"+RangoDiaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RangoDiaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RangoDiaNomiConstantesFunciones.SCHEMA+"_"+RangoDiaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RangoDiaNomiConstantesFunciones.SCHEMA+"_"+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RangoDiaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RangoDiaNomiConstantesFunciones.SCHEMA+"_"+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RangoDiaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RangoDiaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoDiaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RangoDiaNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RangoDiaNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RangoDiaNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RangoDiaNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rango Dia Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rango Dia Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Rango Dia Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RangoDiaNomi";
	public static final String OBJECTNAME="rangodianomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rango_dia_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rangodianomi from "+RangoDiaNomiConstantesFunciones.SPERSISTENCENAME+" rangodianomi";
	public static String QUERYSELECTNATIVE="select "+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".id,"+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".version_row,"+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".id_empresa,"+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".fecha_inicio,"+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".fecha_fin,"+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME+".descripcion from "+RangoDiaNomiConstantesFunciones.SCHEMA+"."+RangoDiaNomiConstantesFunciones.TABLENAME;//+" as "+RangoDiaNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RangoDiaNomiConstantesFuncionesAdditional rangodianomiConstantesFuncionesAdditional=null;
	
	public RangoDiaNomiConstantesFuncionesAdditional getRangoDiaNomiConstantesFuncionesAdditional() {
		return this.rangodianomiConstantesFuncionesAdditional;
	}
	
	public void setRangoDiaNomiConstantesFuncionesAdditional(RangoDiaNomiConstantesFuncionesAdditional rangodianomiConstantesFuncionesAdditional) {
		try {
			this.rangodianomiConstantesFuncionesAdditional=rangodianomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRangoDiaNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RangoDiaNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=RangoDiaNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RangoDiaNomiConstantesFunciones.FECHAINICIO)) {sLabelColumna=RangoDiaNomiConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(RangoDiaNomiConstantesFunciones.FECHAFIN)) {sLabelColumna=RangoDiaNomiConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(RangoDiaNomiConstantesFunciones.DESCRIPCION)) {sLabelColumna=RangoDiaNomiConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getRangoDiaNomiDescripcion(RangoDiaNomi rangodianomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rangodianomi !=null/* && rangodianomi.getId()!=0*/) {
			sDescripcion=rangodianomi.getfecha_fin().toString();//rangodianomirangodianomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRangoDiaNomiDescripcionDetallado(RangoDiaNomi rangodianomi) {
		String sDescripcion="";
			
		sDescripcion+=RangoDiaNomiConstantesFunciones.ID+"=";
		sDescripcion+=rangodianomi.getId().toString()+",";
		sDescripcion+=RangoDiaNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rangodianomi.getVersionRow().toString()+",";
		sDescripcion+=RangoDiaNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rangodianomi.getid_empresa().toString()+",";
		sDescripcion+=RangoDiaNomiConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=rangodianomi.getfecha_inicio().toString()+",";
		sDescripcion+=RangoDiaNomiConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=rangodianomi.getfecha_fin().toString()+",";
		sDescripcion+=RangoDiaNomiConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=rangodianomi.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setRangoDiaNomiDescripcion(RangoDiaNomi rangodianomi,String sValor) throws Exception {			
		if(rangodianomi !=null) {
			//rangodianomirangodianomi.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosRangoDiaNomi(RangoDiaNomi rangodianomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rangodianomi.setdescripcion(rangodianomi.getdescripcion().trim());
	}
	
	public static void quitarEspaciosRangoDiaNomis(List<RangoDiaNomi> rangodianomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RangoDiaNomi rangodianomi: rangodianomis) {
			rangodianomi.setdescripcion(rangodianomi.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRangoDiaNomi(RangoDiaNomi rangodianomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rangodianomi.getConCambioAuxiliar()) {
			rangodianomi.setIsDeleted(rangodianomi.getIsDeletedAuxiliar());	
			rangodianomi.setIsNew(rangodianomi.getIsNewAuxiliar());	
			rangodianomi.setIsChanged(rangodianomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rangodianomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rangodianomi.setIsDeletedAuxiliar(false);	
			rangodianomi.setIsNewAuxiliar(false);	
			rangodianomi.setIsChangedAuxiliar(false);
			
			rangodianomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRangoDiaNomis(List<RangoDiaNomi> rangodianomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RangoDiaNomi rangodianomi : rangodianomis) {
			if(conAsignarBase && rangodianomi.getConCambioAuxiliar()) {
				rangodianomi.setIsDeleted(rangodianomi.getIsDeletedAuxiliar());	
				rangodianomi.setIsNew(rangodianomi.getIsNewAuxiliar());	
				rangodianomi.setIsChanged(rangodianomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rangodianomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rangodianomi.setIsDeletedAuxiliar(false);	
				rangodianomi.setIsNewAuxiliar(false);	
				rangodianomi.setIsChangedAuxiliar(false);
				
				rangodianomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRangoDiaNomi(RangoDiaNomi rangodianomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRangoDiaNomis(List<RangoDiaNomi> rangodianomis,Boolean conEnteros) throws Exception  {
		
		for(RangoDiaNomi rangodianomi: rangodianomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRangoDiaNomi(List<RangoDiaNomi> rangodianomis,RangoDiaNomi rangodianomiAux) throws Exception  {
		RangoDiaNomiConstantesFunciones.InicializarValoresRangoDiaNomi(rangodianomiAux,true);
		
		for(RangoDiaNomi rangodianomi: rangodianomis) {
			if(rangodianomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRangoDiaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RangoDiaNomiConstantesFunciones.getArrayColumnasGlobalesRangoDiaNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRangoDiaNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RangoDiaNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RangoDiaNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRangoDiaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RangoDiaNomi> rangodianomis,RangoDiaNomi rangodianomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RangoDiaNomi rangodianomiAux: rangodianomis) {
			if(rangodianomiAux!=null && rangodianomi!=null) {
				if((rangodianomiAux.getId()==null && rangodianomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rangodianomiAux.getId()!=null && rangodianomi.getId()!=null){
					if(rangodianomiAux.getId().equals(rangodianomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRangoDiaNomi(List<RangoDiaNomi> rangodianomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RangoDiaNomi rangodianomi: rangodianomis) {			
			if(rangodianomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRangoDiaNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_ID, RangoDiaNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_VERSIONROW, RangoDiaNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_IDEMPRESA, RangoDiaNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_FECHAINICIO, RangoDiaNomiConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_FECHAFIN, RangoDiaNomiConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoDiaNomiConstantesFunciones.LABEL_DESCRIPCION, RangoDiaNomiConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRangoDiaNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoDiaNomiConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoDiaNomi() throws Exception  {
		return RangoDiaNomiConstantesFunciones.getTiposSeleccionarRangoDiaNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoDiaNomi(Boolean conFk) throws Exception  {
		return RangoDiaNomiConstantesFunciones.getTiposSeleccionarRangoDiaNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoDiaNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoDiaNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RangoDiaNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoDiaNomiConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(RangoDiaNomiConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoDiaNomiConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(RangoDiaNomiConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoDiaNomiConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(RangoDiaNomiConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRangoDiaNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRangoDiaNomi(RangoDiaNomi rangodianomiAux) throws Exception {
		
			rangodianomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rangodianomiAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRangoDiaNomi(List<RangoDiaNomi> rangodianomisTemp) throws Exception {
		for(RangoDiaNomi rangodianomiAux:rangodianomisTemp) {
			
			rangodianomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rangodianomiAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRangoDiaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRangoDiaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoDiaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RangoDiaNomiConstantesFunciones.getClassesRelationshipsOfRangoDiaNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoDiaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRangoDiaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RangoDiaNomiConstantesFunciones.getClassesRelationshipsFromStringsOfRangoDiaNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRangoDiaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RangoDiaNomi rangodianomi,List<RangoDiaNomi> rangodianomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RangoDiaNomi rangodianomiEncontrado=null;
			
			for(RangoDiaNomi rangodianomiLocal:rangodianomis) {
				if(rangodianomiLocal.getId().equals(rangodianomi.getId())) {
					rangodianomiEncontrado=rangodianomiLocal;
					
					rangodianomiLocal.setIsChanged(rangodianomi.getIsChanged());
					rangodianomiLocal.setIsNew(rangodianomi.getIsNew());
					rangodianomiLocal.setIsDeleted(rangodianomi.getIsDeleted());
					
					rangodianomiLocal.setGeneralEntityOriginal(rangodianomi.getGeneralEntityOriginal());
					
					rangodianomiLocal.setId(rangodianomi.getId());	
					rangodianomiLocal.setVersionRow(rangodianomi.getVersionRow());	
					rangodianomiLocal.setid_empresa(rangodianomi.getid_empresa());	
					rangodianomiLocal.setfecha_inicio(rangodianomi.getfecha_inicio());	
					rangodianomiLocal.setfecha_fin(rangodianomi.getfecha_fin());	
					rangodianomiLocal.setdescripcion(rangodianomi.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!rangodianomi.getIsDeleted()) {
				if(!existe) {
					rangodianomis.add(rangodianomi);
				}
			} else {
				if(rangodianomiEncontrado!=null && permiteQuitar)  {
					rangodianomis.remove(rangodianomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RangoDiaNomi rangodianomi,List<RangoDiaNomi> rangodianomis) throws Exception {
		try	{			
			for(RangoDiaNomi rangodianomiLocal:rangodianomis) {
				if(rangodianomiLocal.getId().equals(rangodianomi.getId())) {
					rangodianomiLocal.setIsSelected(rangodianomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRangoDiaNomi(List<RangoDiaNomi> rangodianomisAux) throws Exception {
		//this.rangodianomisAux=rangodianomisAux;
		
		for(RangoDiaNomi rangodianomiAux:rangodianomisAux) {
			if(rangodianomiAux.getIsChanged()) {
				rangodianomiAux.setIsChanged(false);
			}		
			
			if(rangodianomiAux.getIsNew()) {
				rangodianomiAux.setIsNew(false);
			}	
			
			if(rangodianomiAux.getIsDeleted()) {
				rangodianomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRangoDiaNomi(RangoDiaNomi rangodianomiAux) throws Exception {
		//this.rangodianomiAux=rangodianomiAux;
		
			if(rangodianomiAux.getIsChanged()) {
				rangodianomiAux.setIsChanged(false);
			}		
			
			if(rangodianomiAux.getIsNew()) {
				rangodianomiAux.setIsNew(false);
			}	
			
			if(rangodianomiAux.getIsDeleted()) {
				rangodianomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RangoDiaNomi rangodianomiAsignar,RangoDiaNomi rangodianomi) throws Exception {
		rangodianomiAsignar.setId(rangodianomi.getId());	
		rangodianomiAsignar.setVersionRow(rangodianomi.getVersionRow());	
		rangodianomiAsignar.setid_empresa(rangodianomi.getid_empresa());
		rangodianomiAsignar.setempresa_descripcion(rangodianomi.getempresa_descripcion());	
		rangodianomiAsignar.setfecha_inicio(rangodianomi.getfecha_inicio());	
		rangodianomiAsignar.setfecha_fin(rangodianomi.getfecha_fin());	
		rangodianomiAsignar.setdescripcion(rangodianomi.getdescripcion());	
	}
	
	public static void inicializarRangoDiaNomi(RangoDiaNomi rangodianomi) throws Exception {
		try {
				rangodianomi.setId(0L);	
					
				rangodianomi.setid_empresa(-1L);	
				rangodianomi.setfecha_inicio(new Date());	
				rangodianomi.setfecha_fin(new Date());	
				rangodianomi.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRangoDiaNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoDiaNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoDiaNomiConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoDiaNomiConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoDiaNomiConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRangoDiaNomi(String sTipo,Row row,Workbook workbook,RangoDiaNomi rangodianomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rangodianomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangodianomi.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangodianomi.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangodianomi.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRangoDiaNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRangoDiaNomi() {
		return this.sFinalQueryRangoDiaNomi;
	}
	
	public void setsFinalQueryRangoDiaNomi(String sFinalQueryRangoDiaNomi) {
		this.sFinalQueryRangoDiaNomi= sFinalQueryRangoDiaNomi;
	}
	
	public Border resaltarSeleccionarRangoDiaNomi=null;
	
	public Border setResaltarSeleccionarRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRangoDiaNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRangoDiaNomi() {
		return this.resaltarSeleccionarRangoDiaNomi;
	}
	
	public void setResaltarSeleccionarRangoDiaNomi(Border borderResaltarSeleccionarRangoDiaNomi) {
		this.resaltarSeleccionarRangoDiaNomi= borderResaltarSeleccionarRangoDiaNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRangoDiaNomi=null;
	public Boolean mostraridRangoDiaNomi=true;
	public Boolean activaridRangoDiaNomi=true;

	public Border resaltarid_empresaRangoDiaNomi=null;
	public Boolean mostrarid_empresaRangoDiaNomi=true;
	public Boolean activarid_empresaRangoDiaNomi=true;
	public Boolean cargarid_empresaRangoDiaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRangoDiaNomi=false;//ConEventDepend=true

	public Border resaltarfecha_inicioRangoDiaNomi=null;
	public Boolean mostrarfecha_inicioRangoDiaNomi=true;
	public Boolean activarfecha_inicioRangoDiaNomi=false;

	public Border resaltarfecha_finRangoDiaNomi=null;
	public Boolean mostrarfecha_finRangoDiaNomi=true;
	public Boolean activarfecha_finRangoDiaNomi=false;

	public Border resaltardescripcionRangoDiaNomi=null;
	public Boolean mostrardescripcionRangoDiaNomi=true;
	public Boolean activardescripcionRangoDiaNomi=true;

	
	

	public Border setResaltaridRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltaridRangoDiaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRangoDiaNomi() {
		return this.resaltaridRangoDiaNomi;
	}

	public void setResaltaridRangoDiaNomi(Border borderResaltar) {
		this.resaltaridRangoDiaNomi= borderResaltar;
	}

	public Boolean getMostraridRangoDiaNomi() {
		return this.mostraridRangoDiaNomi;
	}

	public void setMostraridRangoDiaNomi(Boolean mostraridRangoDiaNomi) {
		this.mostraridRangoDiaNomi= mostraridRangoDiaNomi;
	}

	public Boolean getActivaridRangoDiaNomi() {
		return this.activaridRangoDiaNomi;
	}

	public void setActivaridRangoDiaNomi(Boolean activaridRangoDiaNomi) {
		this.activaridRangoDiaNomi= activaridRangoDiaNomi;
	}

	public Border setResaltarid_empresaRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaRangoDiaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRangoDiaNomi() {
		return this.resaltarid_empresaRangoDiaNomi;
	}

	public void setResaltarid_empresaRangoDiaNomi(Border borderResaltar) {
		this.resaltarid_empresaRangoDiaNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaRangoDiaNomi() {
		return this.mostrarid_empresaRangoDiaNomi;
	}

	public void setMostrarid_empresaRangoDiaNomi(Boolean mostrarid_empresaRangoDiaNomi) {
		this.mostrarid_empresaRangoDiaNomi= mostrarid_empresaRangoDiaNomi;
	}

	public Boolean getActivarid_empresaRangoDiaNomi() {
		return this.activarid_empresaRangoDiaNomi;
	}

	public void setActivarid_empresaRangoDiaNomi(Boolean activarid_empresaRangoDiaNomi) {
		this.activarid_empresaRangoDiaNomi= activarid_empresaRangoDiaNomi;
	}

	public Boolean getCargarid_empresaRangoDiaNomi() {
		return this.cargarid_empresaRangoDiaNomi;
	}

	public void setCargarid_empresaRangoDiaNomi(Boolean cargarid_empresaRangoDiaNomi) {
		this.cargarid_empresaRangoDiaNomi= cargarid_empresaRangoDiaNomi;
	}

	public Border setResaltarfecha_inicioRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioRangoDiaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioRangoDiaNomi() {
		return this.resaltarfecha_inicioRangoDiaNomi;
	}

	public void setResaltarfecha_inicioRangoDiaNomi(Border borderResaltar) {
		this.resaltarfecha_inicioRangoDiaNomi= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioRangoDiaNomi() {
		return this.mostrarfecha_inicioRangoDiaNomi;
	}

	public void setMostrarfecha_inicioRangoDiaNomi(Boolean mostrarfecha_inicioRangoDiaNomi) {
		this.mostrarfecha_inicioRangoDiaNomi= mostrarfecha_inicioRangoDiaNomi;
	}

	public Boolean getActivarfecha_inicioRangoDiaNomi() {
		return this.activarfecha_inicioRangoDiaNomi;
	}

	public void setActivarfecha_inicioRangoDiaNomi(Boolean activarfecha_inicioRangoDiaNomi) {
		this.activarfecha_inicioRangoDiaNomi= activarfecha_inicioRangoDiaNomi;
	}

	public Border setResaltarfecha_finRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltarfecha_finRangoDiaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finRangoDiaNomi() {
		return this.resaltarfecha_finRangoDiaNomi;
	}

	public void setResaltarfecha_finRangoDiaNomi(Border borderResaltar) {
		this.resaltarfecha_finRangoDiaNomi= borderResaltar;
	}

	public Boolean getMostrarfecha_finRangoDiaNomi() {
		return this.mostrarfecha_finRangoDiaNomi;
	}

	public void setMostrarfecha_finRangoDiaNomi(Boolean mostrarfecha_finRangoDiaNomi) {
		this.mostrarfecha_finRangoDiaNomi= mostrarfecha_finRangoDiaNomi;
	}

	public Boolean getActivarfecha_finRangoDiaNomi() {
		return this.activarfecha_finRangoDiaNomi;
	}

	public void setActivarfecha_finRangoDiaNomi(Boolean activarfecha_finRangoDiaNomi) {
		this.activarfecha_finRangoDiaNomi= activarfecha_finRangoDiaNomi;
	}

	public Border setResaltardescripcionRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangodianomiBeanSwingJInternalFrame.jTtoolBarRangoDiaNomi.setBorder(borderResaltar);
		
		this.resaltardescripcionRangoDiaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionRangoDiaNomi() {
		return this.resaltardescripcionRangoDiaNomi;
	}

	public void setResaltardescripcionRangoDiaNomi(Border borderResaltar) {
		this.resaltardescripcionRangoDiaNomi= borderResaltar;
	}

	public Boolean getMostrardescripcionRangoDiaNomi() {
		return this.mostrardescripcionRangoDiaNomi;
	}

	public void setMostrardescripcionRangoDiaNomi(Boolean mostrardescripcionRangoDiaNomi) {
		this.mostrardescripcionRangoDiaNomi= mostrardescripcionRangoDiaNomi;
	}

	public Boolean getActivardescripcionRangoDiaNomi() {
		return this.activardescripcionRangoDiaNomi;
	}

	public void setActivardescripcionRangoDiaNomi(Boolean activardescripcionRangoDiaNomi) {
		this.activardescripcionRangoDiaNomi= activardescripcionRangoDiaNomi;
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
		
		
		this.setMostraridRangoDiaNomi(esInicial);
		this.setMostrarid_empresaRangoDiaNomi(esInicial);
		this.setMostrarfecha_inicioRangoDiaNomi(esInicial);
		this.setMostrarfecha_finRangoDiaNomi(esInicial);
		this.setMostrardescripcionRangoDiaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.ID)) {
				this.setMostraridRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionRangoDiaNomi(esAsigna);
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
		
		
		this.setActivaridRangoDiaNomi(esInicial);
		this.setActivarid_empresaRangoDiaNomi(esInicial);
		this.setActivarfecha_inicioRangoDiaNomi(esInicial);
		this.setActivarfecha_finRangoDiaNomi(esInicial);
		this.setActivardescripcionRangoDiaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.ID)) {
				this.setActivaridRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionRangoDiaNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRangoDiaNomi(esInicial);
		this.setResaltarid_empresaRangoDiaNomi(esInicial);
		this.setResaltarfecha_inicioRangoDiaNomi(esInicial);
		this.setResaltarfecha_finRangoDiaNomi(esInicial);
		this.setResaltardescripcionRangoDiaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.ID)) {
				this.setResaltaridRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finRangoDiaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoDiaNomiConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionRangoDiaNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaRangoDiaNomi=true;

	public Boolean getMostrarFK_IdEmpresaRangoDiaNomi() {
		return this.mostrarFK_IdEmpresaRangoDiaNomi;
	}

	public void setMostrarFK_IdEmpresaRangoDiaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRangoDiaNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRangoDiaNomi=true;

	public Boolean getActivarFK_IdEmpresaRangoDiaNomi() {
		return this.activarFK_IdEmpresaRangoDiaNomi;
	}

	public void setActivarFK_IdEmpresaRangoDiaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRangoDiaNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRangoDiaNomi=null;

	public Border getResaltarFK_IdEmpresaRangoDiaNomi() {
		return this.resaltarFK_IdEmpresaRangoDiaNomi;
	}

	public void setResaltarFK_IdEmpresaRangoDiaNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRangoDiaNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRangoDiaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*RangoDiaNomiBeanSwingJInternalFrame rangodianomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRangoDiaNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}