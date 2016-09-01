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


import com.bydan.erp.nomina.util.PreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.PreguntaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PreguntaNomiParameterGeneral;

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
final public class PreguntaNomiConstantesFunciones extends PreguntaNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PreguntaNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PreguntaNomi"+PreguntaNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PreguntaNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PreguntaNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PreguntaNomiConstantesFunciones.SCHEMA+"_"+PreguntaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PreguntaNomiConstantesFunciones.SCHEMA+"_"+PreguntaNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PreguntaNomiConstantesFunciones.SCHEMA+"_"+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PreguntaNomiConstantesFunciones.SCHEMA+"_"+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PreguntaNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PreguntaNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PreguntaNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PreguntaNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pregunta Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pregunta Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Pregunta Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PreguntaNomi";
	public static final String OBJECTNAME="preguntanomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="pregunta_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select preguntanomi from "+PreguntaNomiConstantesFunciones.SPERSISTENCENAME+" preguntanomi";
	public static String QUERYSELECTNATIVE="select "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".version_row,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".pregunta,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".orden from "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME;//+" as "+PreguntaNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PreguntaNomiConstantesFuncionesAdditional preguntanomiConstantesFuncionesAdditional=null;
	
	public PreguntaNomiConstantesFuncionesAdditional getPreguntaNomiConstantesFuncionesAdditional() {
		return this.preguntanomiConstantesFuncionesAdditional;
	}
	
	public void setPreguntaNomiConstantesFuncionesAdditional(PreguntaNomiConstantesFuncionesAdditional preguntanomiConstantesFuncionesAdditional) {
		try {
			this.preguntanomiConstantesFuncionesAdditional=preguntanomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDFACTORNOMI= "id_factor_nomi";
    public static final String PREGUNTA= "pregunta";
    public static final String ORDEN= "orden";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDFACTORNOMI= "Factor Nomi";
		public static final String LABEL_IDFACTORNOMI_LOWER= "Factor Nomi";
    	public static final String LABEL_PREGUNTA= "Pregunta";
		public static final String LABEL_PREGUNTA_LOWER= "Pregunta";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
	
		
		
		
		
	public static final String SREGEXPREGUNTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPREGUNTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPreguntaNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PreguntaNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=PreguntaNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PreguntaNomiConstantesFunciones.IDFACTORNOMI)) {sLabelColumna=PreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI;}
		if(sNombreColumna.equals(PreguntaNomiConstantesFunciones.PREGUNTA)) {sLabelColumna=PreguntaNomiConstantesFunciones.LABEL_PREGUNTA;}
		if(sNombreColumna.equals(PreguntaNomiConstantesFunciones.ORDEN)) {sLabelColumna=PreguntaNomiConstantesFunciones.LABEL_ORDEN;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getPreguntaNomiDescripcion(PreguntaNomi preguntanomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(preguntanomi !=null/* && preguntanomi.getId()!=0*/) {
			sDescripcion=preguntanomi.getpregunta();//preguntanomipreguntanomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPreguntaNomiDescripcionDetallado(PreguntaNomi preguntanomi) {
		String sDescripcion="";
			
		sDescripcion+=PreguntaNomiConstantesFunciones.ID+"=";
		sDescripcion+=preguntanomi.getId().toString()+",";
		sDescripcion+=PreguntaNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=preguntanomi.getVersionRow().toString()+",";
		sDescripcion+=PreguntaNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=preguntanomi.getid_empresa().toString()+",";
		sDescripcion+=PreguntaNomiConstantesFunciones.IDFACTORNOMI+"=";
		sDescripcion+=preguntanomi.getid_factor_nomi().toString()+",";
		sDescripcion+=PreguntaNomiConstantesFunciones.PREGUNTA+"=";
		sDescripcion+=preguntanomi.getpregunta()+",";
		sDescripcion+=PreguntaNomiConstantesFunciones.ORDEN+"=";
		sDescripcion+=preguntanomi.getorden().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPreguntaNomiDescripcion(PreguntaNomi preguntanomi,String sValor) throws Exception {			
		if(preguntanomi !=null) {
			preguntanomi.setpregunta(sValor);//preguntanomipreguntanomi.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getFactorNomiDescripcion(FactorNomi factornomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factornomi!=null/*&&factornomi.getId()>0*/) {
			sDescripcion=FactorNomiConstantesFunciones.getFactorNomiDescripcion(factornomi);
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
		} else if(sNombreIndice.equals("FK_IdFactorNomi")) {
			sNombreIndice="Tipo=  Por Factor Nomi";
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

	public static String getDetalleIndiceFK_IdFactorNomi(Long id_factor_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_factor_nomi!=null) {sDetalleIndice+=" Codigo Unico De Factor Nomi="+id_factor_nomi.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPreguntaNomi(PreguntaNomi preguntanomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		preguntanomi.setpregunta(preguntanomi.getpregunta().trim());
	}
	
	public static void quitarEspaciosPreguntaNomis(List<PreguntaNomi> preguntanomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PreguntaNomi preguntanomi: preguntanomis) {
			preguntanomi.setpregunta(preguntanomi.getpregunta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaNomi(PreguntaNomi preguntanomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && preguntanomi.getConCambioAuxiliar()) {
			preguntanomi.setIsDeleted(preguntanomi.getIsDeletedAuxiliar());	
			preguntanomi.setIsNew(preguntanomi.getIsNewAuxiliar());	
			preguntanomi.setIsChanged(preguntanomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			preguntanomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			preguntanomi.setIsDeletedAuxiliar(false);	
			preguntanomi.setIsNewAuxiliar(false);	
			preguntanomi.setIsChangedAuxiliar(false);
			
			preguntanomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaNomis(List<PreguntaNomi> preguntanomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PreguntaNomi preguntanomi : preguntanomis) {
			if(conAsignarBase && preguntanomi.getConCambioAuxiliar()) {
				preguntanomi.setIsDeleted(preguntanomi.getIsDeletedAuxiliar());	
				preguntanomi.setIsNew(preguntanomi.getIsNewAuxiliar());	
				preguntanomi.setIsChanged(preguntanomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				preguntanomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				preguntanomi.setIsDeletedAuxiliar(false);	
				preguntanomi.setIsNewAuxiliar(false);	
				preguntanomi.setIsChangedAuxiliar(false);
				
				preguntanomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPreguntaNomi(PreguntaNomi preguntanomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			preguntanomi.setorden(0);
		}
	}		
	
	public static void InicializarValoresPreguntaNomis(List<PreguntaNomi> preguntanomis,Boolean conEnteros) throws Exception  {
		
		for(PreguntaNomi preguntanomi: preguntanomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				preguntanomi.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPreguntaNomi(List<PreguntaNomi> preguntanomis,PreguntaNomi preguntanomiAux) throws Exception  {
		PreguntaNomiConstantesFunciones.InicializarValoresPreguntaNomi(preguntanomiAux,true);
		
		for(PreguntaNomi preguntanomi: preguntanomis) {
			if(preguntanomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			preguntanomiAux.setorden(preguntanomiAux.getorden()+preguntanomi.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PreguntaNomiConstantesFunciones.getArrayColumnasGlobalesPreguntaNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPreguntaNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PreguntaNomi> preguntanomis,PreguntaNomi preguntanomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PreguntaNomi preguntanomiAux: preguntanomis) {
			if(preguntanomiAux!=null && preguntanomi!=null) {
				if((preguntanomiAux.getId()==null && preguntanomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(preguntanomiAux.getId()!=null && preguntanomi.getId()!=null){
					if(preguntanomiAux.getId().equals(preguntanomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPreguntaNomi(List<PreguntaNomi> preguntanomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PreguntaNomi preguntanomi: preguntanomis) {			
			if(preguntanomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPreguntaNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_ID, PreguntaNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_VERSIONROW, PreguntaNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_IDEMPRESA, PreguntaNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI, PreguntaNomiConstantesFunciones.IDFACTORNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_PREGUNTA, PreguntaNomiConstantesFunciones.PREGUNTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaNomiConstantesFunciones.LABEL_ORDEN, PreguntaNomiConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPreguntaNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.IDFACTORNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.PREGUNTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaNomiConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaNomi() throws Exception  {
		return PreguntaNomiConstantesFunciones.getTiposSeleccionarPreguntaNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaNomi(Boolean conFk) throws Exception  {
		return PreguntaNomiConstantesFunciones.getTiposSeleccionarPreguntaNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);
			reporte.setsDescripcion(PreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaNomiConstantesFunciones.LABEL_PREGUNTA);
			reporte.setsDescripcion(PreguntaNomiConstantesFunciones.LABEL_PREGUNTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaNomiConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PreguntaNomiConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPreguntaNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaNomi(PreguntaNomi preguntanomiAux) throws Exception {
		
			preguntanomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntanomiAux.getEmpresa()));
			preguntanomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(preguntanomiAux.getFactorNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaNomi(List<PreguntaNomi> preguntanomisTemp) throws Exception {
		for(PreguntaNomi preguntanomiAux:preguntanomisTemp) {
			
			preguntanomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntanomiAux.getEmpresa()));
			preguntanomiAux.setfactornomi_descripcion(FactorNomiConstantesFunciones.getFactorNomiDescripcion(preguntanomiAux.getFactorNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(FactorNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FactorNomi.class)) {
						classes.add(new Classe(FactorNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(FactorNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FactorNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaNomiConstantesFunciones.getClassesRelationshipsOfPreguntaNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormatoNomiPreguntaNomi.class));
				classes.add(new Classe(DetalleEvaluacionNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionNomi.class)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaNomiConstantesFunciones.getClassesRelationshipsFromStringsOfPreguntaNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomiPreguntaNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomiPreguntaNomi.class)); continue;
					}

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
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
	public static void actualizarLista(PreguntaNomi preguntanomi,List<PreguntaNomi> preguntanomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PreguntaNomi preguntanomiEncontrado=null;
			
			for(PreguntaNomi preguntanomiLocal:preguntanomis) {
				if(preguntanomiLocal.getId().equals(preguntanomi.getId())) {
					preguntanomiEncontrado=preguntanomiLocal;
					
					preguntanomiLocal.setIsChanged(preguntanomi.getIsChanged());
					preguntanomiLocal.setIsNew(preguntanomi.getIsNew());
					preguntanomiLocal.setIsDeleted(preguntanomi.getIsDeleted());
					
					preguntanomiLocal.setGeneralEntityOriginal(preguntanomi.getGeneralEntityOriginal());
					
					preguntanomiLocal.setId(preguntanomi.getId());	
					preguntanomiLocal.setVersionRow(preguntanomi.getVersionRow());	
					preguntanomiLocal.setid_empresa(preguntanomi.getid_empresa());	
					preguntanomiLocal.setid_factor_nomi(preguntanomi.getid_factor_nomi());	
					preguntanomiLocal.setpregunta(preguntanomi.getpregunta());	
					preguntanomiLocal.setorden(preguntanomi.getorden());	
					
					
					preguntanomiLocal.setFormatoNomiPreguntaNomis(preguntanomi.getFormatoNomiPreguntaNomis());
					preguntanomiLocal.setDetalleEvaluacionNomis(preguntanomi.getDetalleEvaluacionNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!preguntanomi.getIsDeleted()) {
				if(!existe) {
					preguntanomis.add(preguntanomi);
				}
			} else {
				if(preguntanomiEncontrado!=null && permiteQuitar)  {
					preguntanomis.remove(preguntanomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PreguntaNomi preguntanomi,List<PreguntaNomi> preguntanomis) throws Exception {
		try	{			
			for(PreguntaNomi preguntanomiLocal:preguntanomis) {
				if(preguntanomiLocal.getId().equals(preguntanomi.getId())) {
					preguntanomiLocal.setIsSelected(preguntanomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPreguntaNomi(List<PreguntaNomi> preguntanomisAux) throws Exception {
		//this.preguntanomisAux=preguntanomisAux;
		
		for(PreguntaNomi preguntanomiAux:preguntanomisAux) {
			if(preguntanomiAux.getIsChanged()) {
				preguntanomiAux.setIsChanged(false);
			}		
			
			if(preguntanomiAux.getIsNew()) {
				preguntanomiAux.setIsNew(false);
			}	
			
			if(preguntanomiAux.getIsDeleted()) {
				preguntanomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPreguntaNomi(PreguntaNomi preguntanomiAux) throws Exception {
		//this.preguntanomiAux=preguntanomiAux;
		
			if(preguntanomiAux.getIsChanged()) {
				preguntanomiAux.setIsChanged(false);
			}		
			
			if(preguntanomiAux.getIsNew()) {
				preguntanomiAux.setIsNew(false);
			}	
			
			if(preguntanomiAux.getIsDeleted()) {
				preguntanomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PreguntaNomi preguntanomiAsignar,PreguntaNomi preguntanomi) throws Exception {
		preguntanomiAsignar.setId(preguntanomi.getId());	
		preguntanomiAsignar.setVersionRow(preguntanomi.getVersionRow());	
		preguntanomiAsignar.setid_empresa(preguntanomi.getid_empresa());
		preguntanomiAsignar.setempresa_descripcion(preguntanomi.getempresa_descripcion());	
		preguntanomiAsignar.setid_factor_nomi(preguntanomi.getid_factor_nomi());
		preguntanomiAsignar.setfactornomi_descripcion(preguntanomi.getfactornomi_descripcion());	
		preguntanomiAsignar.setpregunta(preguntanomi.getpregunta());	
		preguntanomiAsignar.setorden(preguntanomi.getorden());	
	}
	
	public static void inicializarPreguntaNomi(PreguntaNomi preguntanomi) throws Exception {
		try {
				preguntanomi.setId(0L);	
					
				preguntanomi.setid_empresa(-1L);	
				preguntanomi.setid_factor_nomi(-1L);	
				preguntanomi.setpregunta("");	
				preguntanomi.setorden(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPreguntaNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaNomiConstantesFunciones.LABEL_IDFACTORNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaNomiConstantesFunciones.LABEL_PREGUNTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaNomiConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPreguntaNomi(String sTipo,Row row,Workbook workbook,PreguntaNomi preguntanomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntanomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntanomi.getfactornomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntanomi.getpregunta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntanomi.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPreguntaNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPreguntaNomi() {
		return this.sFinalQueryPreguntaNomi;
	}
	
	public void setsFinalQueryPreguntaNomi(String sFinalQueryPreguntaNomi) {
		this.sFinalQueryPreguntaNomi= sFinalQueryPreguntaNomi;
	}
	
	public Border resaltarSeleccionarPreguntaNomi=null;
	
	public Border setResaltarSeleccionarPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPreguntaNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPreguntaNomi() {
		return this.resaltarSeleccionarPreguntaNomi;
	}
	
	public void setResaltarSeleccionarPreguntaNomi(Border borderResaltarSeleccionarPreguntaNomi) {
		this.resaltarSeleccionarPreguntaNomi= borderResaltarSeleccionarPreguntaNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPreguntaNomi=null;
	public Boolean mostraridPreguntaNomi=true;
	public Boolean activaridPreguntaNomi=true;

	public Border resaltarid_empresaPreguntaNomi=null;
	public Boolean mostrarid_empresaPreguntaNomi=true;
	public Boolean activarid_empresaPreguntaNomi=true;
	public Boolean cargarid_empresaPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarid_factor_nomiPreguntaNomi=null;
	public Boolean mostrarid_factor_nomiPreguntaNomi=true;
	public Boolean activarid_factor_nomiPreguntaNomi=true;
	public Boolean cargarid_factor_nomiPreguntaNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factor_nomiPreguntaNomi=false;//ConEventDepend=true

	public Border resaltarpreguntaPreguntaNomi=null;
	public Boolean mostrarpreguntaPreguntaNomi=true;
	public Boolean activarpreguntaPreguntaNomi=true;

	public Border resaltarordenPreguntaNomi=null;
	public Boolean mostrarordenPreguntaNomi=true;
	public Boolean activarordenPreguntaNomi=true;

	
	

	public Border setResaltaridPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltaridPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPreguntaNomi() {
		return this.resaltaridPreguntaNomi;
	}

	public void setResaltaridPreguntaNomi(Border borderResaltar) {
		this.resaltaridPreguntaNomi= borderResaltar;
	}

	public Boolean getMostraridPreguntaNomi() {
		return this.mostraridPreguntaNomi;
	}

	public void setMostraridPreguntaNomi(Boolean mostraridPreguntaNomi) {
		this.mostraridPreguntaNomi= mostraridPreguntaNomi;
	}

	public Boolean getActivaridPreguntaNomi() {
		return this.activaridPreguntaNomi;
	}

	public void setActivaridPreguntaNomi(Boolean activaridPreguntaNomi) {
		this.activaridPreguntaNomi= activaridPreguntaNomi;
	}

	public Border setResaltarid_empresaPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPreguntaNomi() {
		return this.resaltarid_empresaPreguntaNomi;
	}

	public void setResaltarid_empresaPreguntaNomi(Border borderResaltar) {
		this.resaltarid_empresaPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaPreguntaNomi() {
		return this.mostrarid_empresaPreguntaNomi;
	}

	public void setMostrarid_empresaPreguntaNomi(Boolean mostrarid_empresaPreguntaNomi) {
		this.mostrarid_empresaPreguntaNomi= mostrarid_empresaPreguntaNomi;
	}

	public Boolean getActivarid_empresaPreguntaNomi() {
		return this.activarid_empresaPreguntaNomi;
	}

	public void setActivarid_empresaPreguntaNomi(Boolean activarid_empresaPreguntaNomi) {
		this.activarid_empresaPreguntaNomi= activarid_empresaPreguntaNomi;
	}

	public Boolean getCargarid_empresaPreguntaNomi() {
		return this.cargarid_empresaPreguntaNomi;
	}

	public void setCargarid_empresaPreguntaNomi(Boolean cargarid_empresaPreguntaNomi) {
		this.cargarid_empresaPreguntaNomi= cargarid_empresaPreguntaNomi;
	}

	public Border setResaltarid_factor_nomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarid_factor_nomiPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factor_nomiPreguntaNomi() {
		return this.resaltarid_factor_nomiPreguntaNomi;
	}

	public void setResaltarid_factor_nomiPreguntaNomi(Border borderResaltar) {
		this.resaltarid_factor_nomiPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarid_factor_nomiPreguntaNomi() {
		return this.mostrarid_factor_nomiPreguntaNomi;
	}

	public void setMostrarid_factor_nomiPreguntaNomi(Boolean mostrarid_factor_nomiPreguntaNomi) {
		this.mostrarid_factor_nomiPreguntaNomi= mostrarid_factor_nomiPreguntaNomi;
	}

	public Boolean getActivarid_factor_nomiPreguntaNomi() {
		return this.activarid_factor_nomiPreguntaNomi;
	}

	public void setActivarid_factor_nomiPreguntaNomi(Boolean activarid_factor_nomiPreguntaNomi) {
		this.activarid_factor_nomiPreguntaNomi= activarid_factor_nomiPreguntaNomi;
	}

	public Boolean getCargarid_factor_nomiPreguntaNomi() {
		return this.cargarid_factor_nomiPreguntaNomi;
	}

	public void setCargarid_factor_nomiPreguntaNomi(Boolean cargarid_factor_nomiPreguntaNomi) {
		this.cargarid_factor_nomiPreguntaNomi= cargarid_factor_nomiPreguntaNomi;
	}

	public Border setResaltarpreguntaPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarpreguntaPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreguntaPreguntaNomi() {
		return this.resaltarpreguntaPreguntaNomi;
	}

	public void setResaltarpreguntaPreguntaNomi(Border borderResaltar) {
		this.resaltarpreguntaPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarpreguntaPreguntaNomi() {
		return this.mostrarpreguntaPreguntaNomi;
	}

	public void setMostrarpreguntaPreguntaNomi(Boolean mostrarpreguntaPreguntaNomi) {
		this.mostrarpreguntaPreguntaNomi= mostrarpreguntaPreguntaNomi;
	}

	public Boolean getActivarpreguntaPreguntaNomi() {
		return this.activarpreguntaPreguntaNomi;
	}

	public void setActivarpreguntaPreguntaNomi(Boolean activarpreguntaPreguntaNomi) {
		this.activarpreguntaPreguntaNomi= activarpreguntaPreguntaNomi;
	}

	public Border setResaltarordenPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltar);
		
		this.resaltarordenPreguntaNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPreguntaNomi() {
		return this.resaltarordenPreguntaNomi;
	}

	public void setResaltarordenPreguntaNomi(Border borderResaltar) {
		this.resaltarordenPreguntaNomi= borderResaltar;
	}

	public Boolean getMostrarordenPreguntaNomi() {
		return this.mostrarordenPreguntaNomi;
	}

	public void setMostrarordenPreguntaNomi(Boolean mostrarordenPreguntaNomi) {
		this.mostrarordenPreguntaNomi= mostrarordenPreguntaNomi;
	}

	public Boolean getActivarordenPreguntaNomi() {
		return this.activarordenPreguntaNomi;
	}

	public void setActivarordenPreguntaNomi(Boolean activarordenPreguntaNomi) {
		this.activarordenPreguntaNomi= activarordenPreguntaNomi;
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
		
		
		this.setMostraridPreguntaNomi(esInicial);
		this.setMostrarid_empresaPreguntaNomi(esInicial);
		this.setMostrarid_factor_nomiPreguntaNomi(esInicial);
		this.setMostrarpreguntaPreguntaNomi(esInicial);
		this.setMostrarordenPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ID)) {
				this.setMostraridPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setMostrarid_factor_nomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.PREGUNTA)) {
				this.setMostrarpreguntaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ORDEN)) {
				this.setMostrarordenPreguntaNomi(esAsigna);
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
		
		
		this.setActivaridPreguntaNomi(esInicial);
		this.setActivarid_empresaPreguntaNomi(esInicial);
		this.setActivarid_factor_nomiPreguntaNomi(esInicial);
		this.setActivarpreguntaPreguntaNomi(esInicial);
		this.setActivarordenPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ID)) {
				this.setActivaridPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setActivarid_factor_nomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.PREGUNTA)) {
				this.setActivarpreguntaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ORDEN)) {
				this.setActivarordenPreguntaNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPreguntaNomi(esInicial);
		this.setResaltarid_empresaPreguntaNomi(esInicial);
		this.setResaltarid_factor_nomiPreguntaNomi(esInicial);
		this.setResaltarpreguntaPreguntaNomi(esInicial);
		this.setResaltarordenPreguntaNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ID)) {
				this.setResaltaridPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.IDFACTORNOMI)) {
				this.setResaltarid_factor_nomiPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.PREGUNTA)) {
				this.setResaltarpreguntaPreguntaNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaNomiConstantesFunciones.ORDEN)) {
				this.setResaltarordenPreguntaNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormatoNomiPreguntaNomiPreguntaNomi=null;

	public Border getResaltarFormatoNomiPreguntaNomiPreguntaNomi() {
		return this.resaltarFormatoNomiPreguntaNomiPreguntaNomi;
	}

	public void setResaltarFormatoNomiPreguntaNomiPreguntaNomi(Border borderResaltarFormatoNomiPreguntaNomi) {
		if(borderResaltarFormatoNomiPreguntaNomi!=null) {
			this.resaltarFormatoNomiPreguntaNomiPreguntaNomi= borderResaltarFormatoNomiPreguntaNomi;
		}
	}

	public Border setResaltarFormatoNomiPreguntaNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomiPreguntaNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltarFormatoNomiPreguntaNomi);
			
		this.resaltarFormatoNomiPreguntaNomiPreguntaNomi= borderResaltarFormatoNomiPreguntaNomi;

		 return borderResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean mostrarFormatoNomiPreguntaNomiPreguntaNomi=true;

	public Boolean getMostrarFormatoNomiPreguntaNomiPreguntaNomi() {
		return this.mostrarFormatoNomiPreguntaNomiPreguntaNomi;
	}

	public void setMostrarFormatoNomiPreguntaNomiPreguntaNomi(Boolean visibilidadResaltarFormatoNomiPreguntaNomi) {
		this.mostrarFormatoNomiPreguntaNomiPreguntaNomi= visibilidadResaltarFormatoNomiPreguntaNomi;
	}



	public Boolean activarFormatoNomiPreguntaNomiPreguntaNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiPreguntaNomiPreguntaNomi() {
		return this.activarFormatoNomiPreguntaNomiPreguntaNomi;
	}

	public void setActivarFormatoNomiPreguntaNomiPreguntaNomi(Boolean habilitarResaltarFormatoNomiPreguntaNomi) {
		this.activarFormatoNomiPreguntaNomiPreguntaNomi= habilitarResaltarFormatoNomiPreguntaNomi;
	}


	public Border resaltarDetalleEvaluacionNomiPreguntaNomi=null;

	public Border getResaltarDetalleEvaluacionNomiPreguntaNomi() {
		return this.resaltarDetalleEvaluacionNomiPreguntaNomi;
	}

	public void setResaltarDetalleEvaluacionNomiPreguntaNomi(Border borderResaltarDetalleEvaluacionNomi) {
		if(borderResaltarDetalleEvaluacionNomi!=null) {
			this.resaltarDetalleEvaluacionNomiPreguntaNomi= borderResaltarDetalleEvaluacionNomi;
		}
	}

	public Border setResaltarDetalleEvaluacionNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//preguntanomiBeanSwingJInternalFrame.jTtoolBarPreguntaNomi.setBorder(borderResaltarDetalleEvaluacionNomi);
			
		this.resaltarDetalleEvaluacionNomiPreguntaNomi= borderResaltarDetalleEvaluacionNomi;

		 return borderResaltarDetalleEvaluacionNomi;
	}



	public Boolean mostrarDetalleEvaluacionNomiPreguntaNomi=true;

	public Boolean getMostrarDetalleEvaluacionNomiPreguntaNomi() {
		return this.mostrarDetalleEvaluacionNomiPreguntaNomi;
	}

	public void setMostrarDetalleEvaluacionNomiPreguntaNomi(Boolean visibilidadResaltarDetalleEvaluacionNomi) {
		this.mostrarDetalleEvaluacionNomiPreguntaNomi= visibilidadResaltarDetalleEvaluacionNomi;
	}



	public Boolean activarDetalleEvaluacionNomiPreguntaNomi=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionNomiPreguntaNomi() {
		return this.activarDetalleEvaluacionNomiPreguntaNomi;
	}

	public void setActivarDetalleEvaluacionNomiPreguntaNomi(Boolean habilitarResaltarDetalleEvaluacionNomi) {
		this.activarDetalleEvaluacionNomiPreguntaNomi= habilitarResaltarDetalleEvaluacionNomi;
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

		this.setMostrarFormatoNomiPreguntaNomiPreguntaNomi(esInicial);
		this.setMostrarDetalleEvaluacionNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setMostrarFormatoNomiPreguntaNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setMostrarDetalleEvaluacionNomiPreguntaNomi(esAsigna);
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

		this.setActivarFormatoNomiPreguntaNomiPreguntaNomi(esInicial);
		this.setActivarDetalleEvaluacionNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setActivarFormatoNomiPreguntaNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setActivarDetalleEvaluacionNomiPreguntaNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormatoNomiPreguntaNomiPreguntaNomi(esInicial);
		this.setResaltarDetalleEvaluacionNomiPreguntaNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomiPreguntaNomi.class)) {
				this.setResaltarFormatoNomiPreguntaNomiPreguntaNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setResaltarDetalleEvaluacionNomiPreguntaNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaPreguntaNomi=true;

	public Boolean getMostrarFK_IdEmpresaPreguntaNomi() {
		return this.mostrarFK_IdEmpresaPreguntaNomi;
	}

	public void setMostrarFK_IdEmpresaPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPreguntaNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFactorNomiPreguntaNomi=true;

	public Boolean getMostrarFK_IdFactorNomiPreguntaNomi() {
		return this.mostrarFK_IdFactorNomiPreguntaNomi;
	}

	public void setMostrarFK_IdFactorNomiPreguntaNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFactorNomiPreguntaNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaPreguntaNomi=true;

	public Boolean getActivarFK_IdEmpresaPreguntaNomi() {
		return this.activarFK_IdEmpresaPreguntaNomi;
	}

	public void setActivarFK_IdEmpresaPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPreguntaNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFactorNomiPreguntaNomi=true;

	public Boolean getActivarFK_IdFactorNomiPreguntaNomi() {
		return this.activarFK_IdFactorNomiPreguntaNomi;
	}

	public void setActivarFK_IdFactorNomiPreguntaNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFactorNomiPreguntaNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaPreguntaNomi=null;

	public Border getResaltarFK_IdEmpresaPreguntaNomi() {
		return this.resaltarFK_IdEmpresaPreguntaNomi;
	}

	public void setResaltarFK_IdEmpresaPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPreguntaNomi= borderResaltar;
	}

	public Border resaltarFK_IdFactorNomiPreguntaNomi=null;

	public Border getResaltarFK_IdFactorNomiPreguntaNomi() {
		return this.resaltarFK_IdFactorNomiPreguntaNomi;
	}

	public void setResaltarFK_IdFactorNomiPreguntaNomi(Border borderResaltar) {
		this.resaltarFK_IdFactorNomiPreguntaNomi= borderResaltar;
	}

	public void setResaltarFK_IdFactorNomiPreguntaNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaNomiBeanSwingJInternalFrame preguntanomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFactorNomiPreguntaNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}