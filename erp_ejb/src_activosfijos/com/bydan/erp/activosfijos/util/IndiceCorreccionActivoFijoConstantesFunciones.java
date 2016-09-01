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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class IndiceCorreccionActivoFijoConstantesFunciones extends IndiceCorreccionActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="IndiceCorreccionActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="IndiceCorreccionActivoFijo"+IndiceCorreccionActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="IndiceCorreccionActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="IndiceCorreccionActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"_"+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/IndiceCorreccionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"_"+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"_"+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/IndiceCorreccionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"_"+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IndiceCorreccionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IndiceCorreccionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IndiceCorreccionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=IndiceCorreccionActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+IndiceCorreccionActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=IndiceCorreccionActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+IndiceCorreccionActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Indice Correccion Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Indice Correccion Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Indice Correccion Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="IndiceCorreccionActivoFijo";
	public static final String OBJECTNAME="indicecorreccionactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="indice_correccion_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select indicecorreccionactivofijo from "+IndiceCorreccionActivoFijoConstantesFunciones.SPERSISTENCENAME+" indicecorreccionactivofijo";
	public static String QUERYSELECTNATIVE="select "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".id,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".version_row,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".anio,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".valor from "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;//+" as "+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected IndiceCorreccionActivoFijoConstantesFuncionesAdditional indicecorreccionactivofijoConstantesFuncionesAdditional=null;
	
	public IndiceCorreccionActivoFijoConstantesFuncionesAdditional getIndiceCorreccionActivoFijoConstantesFuncionesAdditional() {
		return this.indicecorreccionactivofijoConstantesFuncionesAdditional;
	}
	
	public void setIndiceCorreccionActivoFijoConstantesFuncionesAdditional(IndiceCorreccionActivoFijoConstantesFuncionesAdditional indicecorreccionactivofijoConstantesFuncionesAdditional) {
		try {
			this.indicecorreccionactivofijoConstantesFuncionesAdditional=indicecorreccionactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String ANIO= "anio";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_ANIO= "Anio";
		public static final String LABEL_ANIO_LOWER= "Anio";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
	
	public static String getIndiceCorreccionActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=IndiceCorreccionActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(IndiceCorreccionActivoFijoConstantesFunciones.ANIO)) {sLabelColumna=IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ANIO;}
		if(sNombreColumna.equals(IndiceCorreccionActivoFijoConstantesFunciones.VALOR)) {sLabelColumna=IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getIndiceCorreccionActivoFijoDescripcion(IndiceCorreccionActivoFijo indicecorreccionactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(indicecorreccionactivofijo !=null/* && indicecorreccionactivofijo.getId()!=0*/) {
			if(indicecorreccionactivofijo.getId()!=null) {
				sDescripcion=indicecorreccionactivofijo.getId().toString();
			}//indicecorreccionactivofijoindicecorreccionactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getIndiceCorreccionActivoFijoDescripcionDetallado(IndiceCorreccionActivoFijo indicecorreccionactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=IndiceCorreccionActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=indicecorreccionactivofijo.getId().toString()+",";
		sDescripcion+=IndiceCorreccionActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=indicecorreccionactivofijo.getVersionRow().toString()+",";
		sDescripcion+=IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=indicecorreccionactivofijo.getid_empresa().toString()+",";
		sDescripcion+=IndiceCorreccionActivoFijoConstantesFunciones.ANIO+"=";
		sDescripcion+=indicecorreccionactivofijo.getanio().toString()+",";
		sDescripcion+=IndiceCorreccionActivoFijoConstantesFunciones.VALOR+"=";
		sDescripcion+=indicecorreccionactivofijo.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setIndiceCorreccionActivoFijoDescripcion(IndiceCorreccionActivoFijo indicecorreccionactivofijo,String sValor) throws Exception {			
		if(indicecorreccionactivofijo !=null) {
			//indicecorreccionactivofijoindicecorreccionactivofijo.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo: indicecorreccionactivofijos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && indicecorreccionactivofijo.getConCambioAuxiliar()) {
			indicecorreccionactivofijo.setIsDeleted(indicecorreccionactivofijo.getIsDeletedAuxiliar());	
			indicecorreccionactivofijo.setIsNew(indicecorreccionactivofijo.getIsNewAuxiliar());	
			indicecorreccionactivofijo.setIsChanged(indicecorreccionactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			indicecorreccionactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			indicecorreccionactivofijo.setIsDeletedAuxiliar(false);	
			indicecorreccionactivofijo.setIsNewAuxiliar(false);	
			indicecorreccionactivofijo.setIsChangedAuxiliar(false);
			
			indicecorreccionactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo : indicecorreccionactivofijos) {
			if(conAsignarBase && indicecorreccionactivofijo.getConCambioAuxiliar()) {
				indicecorreccionactivofijo.setIsDeleted(indicecorreccionactivofijo.getIsDeletedAuxiliar());	
				indicecorreccionactivofijo.setIsNew(indicecorreccionactivofijo.getIsNewAuxiliar());	
				indicecorreccionactivofijo.setIsChanged(indicecorreccionactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				indicecorreccionactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				indicecorreccionactivofijo.setIsDeletedAuxiliar(false);	
				indicecorreccionactivofijo.setIsNewAuxiliar(false);	
				indicecorreccionactivofijo.setIsChangedAuxiliar(false);
				
				indicecorreccionactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean conEnteros) throws Exception  {
		indicecorreccionactivofijo.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			indicecorreccionactivofijo.setanio(0);
		}
	}		
	
	public static void InicializarValoresIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,Boolean conEnteros) throws Exception  {
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo: indicecorreccionactivofijos) {
			indicecorreccionactivofijo.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				indicecorreccionactivofijo.setanio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijo indicecorreccionactivofijoAux) throws Exception  {
		IndiceCorreccionActivoFijoConstantesFunciones.InicializarValoresIndiceCorreccionActivoFijo(indicecorreccionactivofijoAux,true);
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo: indicecorreccionactivofijos) {
			if(indicecorreccionactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			indicecorreccionactivofijoAux.setanio(indicecorreccionactivofijoAux.getanio()+indicecorreccionactivofijo.getanio());			
			indicecorreccionactivofijoAux.setvalor(indicecorreccionactivofijoAux.getvalor()+indicecorreccionactivofijo.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesIndiceCorreccionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=IndiceCorreccionActivoFijoConstantesFunciones.getArrayColumnasGlobalesIndiceCorreccionActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesIndiceCorreccionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoIndiceCorreccionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux: indicecorreccionactivofijos) {
			if(indicecorreccionactivofijoAux!=null && indicecorreccionactivofijo!=null) {
				if((indicecorreccionactivofijoAux.getId()==null && indicecorreccionactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(indicecorreccionactivofijoAux.getId()!=null && indicecorreccionactivofijo.getId()!=null){
					if(indicecorreccionactivofijoAux.getId().equals(indicecorreccionactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo: indicecorreccionactivofijos) {			
			if(indicecorreccionactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=indicecorreccionactivofijo.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(IndiceCorreccionActivoFijoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaIndiceCorreccionActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ID, IndiceCorreccionActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VERSIONROW, IndiceCorreccionActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IndiceCorreccionActivoFijoConstantesFunciones.LABEL_IDEMPRESA, IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ANIO, IndiceCorreccionActivoFijoConstantesFunciones.ANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR, IndiceCorreccionActivoFijoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasIndiceCorreccionActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=IndiceCorreccionActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IndiceCorreccionActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IndiceCorreccionActivoFijoConstantesFunciones.ANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IndiceCorreccionActivoFijoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIndiceCorreccionActivoFijo() throws Exception  {
		return IndiceCorreccionActivoFijoConstantesFunciones.getTiposSeleccionarIndiceCorreccionActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIndiceCorreccionActivoFijo(Boolean conFk) throws Exception  {
		return IndiceCorreccionActivoFijoConstantesFunciones.getTiposSeleccionarIndiceCorreccionActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIndiceCorreccionActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ANIO);
			reporte.setsDescripcion(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesIndiceCorreccionActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux) throws Exception {
		
			indicecorreccionactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(indicecorreccionactivofijoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijosTemp) throws Exception {
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux:indicecorreccionactivofijosTemp) {
			
			indicecorreccionactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(indicecorreccionactivofijoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfIndiceCorreccionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfIndiceCorreccionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfIndiceCorreccionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return IndiceCorreccionActivoFijoConstantesFunciones.getClassesRelationshipsOfIndiceCorreccionActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIndiceCorreccionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIndiceCorreccionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return IndiceCorreccionActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfIndiceCorreccionActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIndiceCorreccionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(IndiceCorreccionActivoFijo indicecorreccionactivofijo,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			IndiceCorreccionActivoFijo indicecorreccionactivofijoEncontrado=null;
			
			for(IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal:indicecorreccionactivofijos) {
				if(indicecorreccionactivofijoLocal.getId().equals(indicecorreccionactivofijo.getId())) {
					indicecorreccionactivofijoEncontrado=indicecorreccionactivofijoLocal;
					
					indicecorreccionactivofijoLocal.setIsChanged(indicecorreccionactivofijo.getIsChanged());
					indicecorreccionactivofijoLocal.setIsNew(indicecorreccionactivofijo.getIsNew());
					indicecorreccionactivofijoLocal.setIsDeleted(indicecorreccionactivofijo.getIsDeleted());
					
					indicecorreccionactivofijoLocal.setGeneralEntityOriginal(indicecorreccionactivofijo.getGeneralEntityOriginal());
					
					indicecorreccionactivofijoLocal.setId(indicecorreccionactivofijo.getId());	
					indicecorreccionactivofijoLocal.setVersionRow(indicecorreccionactivofijo.getVersionRow());	
					indicecorreccionactivofijoLocal.setid_empresa(indicecorreccionactivofijo.getid_empresa());	
					indicecorreccionactivofijoLocal.setanio(indicecorreccionactivofijo.getanio());	
					indicecorreccionactivofijoLocal.setvalor(indicecorreccionactivofijo.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!indicecorreccionactivofijo.getIsDeleted()) {
				if(!existe) {
					indicecorreccionactivofijos.add(indicecorreccionactivofijo);
				}
			} else {
				if(indicecorreccionactivofijoEncontrado!=null && permiteQuitar)  {
					indicecorreccionactivofijos.remove(indicecorreccionactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(IndiceCorreccionActivoFijo indicecorreccionactivofijo,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos) throws Exception {
		try	{			
			for(IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal:indicecorreccionactivofijos) {
				if(indicecorreccionactivofijoLocal.getId().equals(indicecorreccionactivofijo.getId())) {
					indicecorreccionactivofijoLocal.setIsSelected(indicecorreccionactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijosAux) throws Exception {
		//this.indicecorreccionactivofijosAux=indicecorreccionactivofijosAux;
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux:indicecorreccionactivofijosAux) {
			if(indicecorreccionactivofijoAux.getIsChanged()) {
				indicecorreccionactivofijoAux.setIsChanged(false);
			}		
			
			if(indicecorreccionactivofijoAux.getIsNew()) {
				indicecorreccionactivofijoAux.setIsNew(false);
			}	
			
			if(indicecorreccionactivofijoAux.getIsDeleted()) {
				indicecorreccionactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux) throws Exception {
		//this.indicecorreccionactivofijoAux=indicecorreccionactivofijoAux;
		
			if(indicecorreccionactivofijoAux.getIsChanged()) {
				indicecorreccionactivofijoAux.setIsChanged(false);
			}		
			
			if(indicecorreccionactivofijoAux.getIsNew()) {
				indicecorreccionactivofijoAux.setIsNew(false);
			}	
			
			if(indicecorreccionactivofijoAux.getIsDeleted()) {
				indicecorreccionactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(IndiceCorreccionActivoFijo indicecorreccionactivofijoAsignar,IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {
		indicecorreccionactivofijoAsignar.setId(indicecorreccionactivofijo.getId());	
		indicecorreccionactivofijoAsignar.setVersionRow(indicecorreccionactivofijo.getVersionRow());	
		indicecorreccionactivofijoAsignar.setid_empresa(indicecorreccionactivofijo.getid_empresa());
		indicecorreccionactivofijoAsignar.setempresa_descripcion(indicecorreccionactivofijo.getempresa_descripcion());	
		indicecorreccionactivofijoAsignar.setanio(indicecorreccionactivofijo.getanio());	
		indicecorreccionactivofijoAsignar.setvalor(indicecorreccionactivofijo.getvalor());	
	}
	
	public static void inicializarIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {
		try {
				indicecorreccionactivofijo.setId(0L);	
					
				indicecorreccionactivofijo.setid_empresa(-1L);	
				indicecorreccionactivofijo.setanio(0);	
				indicecorreccionactivofijo.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderIndiceCorreccionActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_ANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IndiceCorreccionActivoFijoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataIndiceCorreccionActivoFijo(String sTipo,Row row,Workbook workbook,IndiceCorreccionActivoFijo indicecorreccionactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(indicecorreccionactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(indicecorreccionactivofijo.getanio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(indicecorreccionactivofijo.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryIndiceCorreccionActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryIndiceCorreccionActivoFijo() {
		return this.sFinalQueryIndiceCorreccionActivoFijo;
	}
	
	public void setsFinalQueryIndiceCorreccionActivoFijo(String sFinalQueryIndiceCorreccionActivoFijo) {
		this.sFinalQueryIndiceCorreccionActivoFijo= sFinalQueryIndiceCorreccionActivoFijo;
	}
	
	public Border resaltarSeleccionarIndiceCorreccionActivoFijo=null;
	
	public Border setResaltarSeleccionarIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//indicecorreccionactivofijoBeanSwingJInternalFrame.jTtoolBarIndiceCorreccionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarIndiceCorreccionActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarIndiceCorreccionActivoFijo() {
		return this.resaltarSeleccionarIndiceCorreccionActivoFijo;
	}
	
	public void setResaltarSeleccionarIndiceCorreccionActivoFijo(Border borderResaltarSeleccionarIndiceCorreccionActivoFijo) {
		this.resaltarSeleccionarIndiceCorreccionActivoFijo= borderResaltarSeleccionarIndiceCorreccionActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridIndiceCorreccionActivoFijo=null;
	public Boolean mostraridIndiceCorreccionActivoFijo=true;
	public Boolean activaridIndiceCorreccionActivoFijo=true;

	public Border resaltarid_empresaIndiceCorreccionActivoFijo=null;
	public Boolean mostrarid_empresaIndiceCorreccionActivoFijo=true;
	public Boolean activarid_empresaIndiceCorreccionActivoFijo=true;
	public Boolean cargarid_empresaIndiceCorreccionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaIndiceCorreccionActivoFijo=false;//ConEventDepend=true

	public Border resaltaranioIndiceCorreccionActivoFijo=null;
	public Boolean mostraranioIndiceCorreccionActivoFijo=true;
	public Boolean activaranioIndiceCorreccionActivoFijo=true;

	public Border resaltarvalorIndiceCorreccionActivoFijo=null;
	public Boolean mostrarvalorIndiceCorreccionActivoFijo=true;
	public Boolean activarvalorIndiceCorreccionActivoFijo=true;

	
	

	public Border setResaltaridIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//indicecorreccionactivofijoBeanSwingJInternalFrame.jTtoolBarIndiceCorreccionActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridIndiceCorreccionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridIndiceCorreccionActivoFijo() {
		return this.resaltaridIndiceCorreccionActivoFijo;
	}

	public void setResaltaridIndiceCorreccionActivoFijo(Border borderResaltar) {
		this.resaltaridIndiceCorreccionActivoFijo= borderResaltar;
	}

	public Boolean getMostraridIndiceCorreccionActivoFijo() {
		return this.mostraridIndiceCorreccionActivoFijo;
	}

	public void setMostraridIndiceCorreccionActivoFijo(Boolean mostraridIndiceCorreccionActivoFijo) {
		this.mostraridIndiceCorreccionActivoFijo= mostraridIndiceCorreccionActivoFijo;
	}

	public Boolean getActivaridIndiceCorreccionActivoFijo() {
		return this.activaridIndiceCorreccionActivoFijo;
	}

	public void setActivaridIndiceCorreccionActivoFijo(Boolean activaridIndiceCorreccionActivoFijo) {
		this.activaridIndiceCorreccionActivoFijo= activaridIndiceCorreccionActivoFijo;
	}

	public Border setResaltarid_empresaIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//indicecorreccionactivofijoBeanSwingJInternalFrame.jTtoolBarIndiceCorreccionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaIndiceCorreccionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaIndiceCorreccionActivoFijo() {
		return this.resaltarid_empresaIndiceCorreccionActivoFijo;
	}

	public void setResaltarid_empresaIndiceCorreccionActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaIndiceCorreccionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaIndiceCorreccionActivoFijo() {
		return this.mostrarid_empresaIndiceCorreccionActivoFijo;
	}

	public void setMostrarid_empresaIndiceCorreccionActivoFijo(Boolean mostrarid_empresaIndiceCorreccionActivoFijo) {
		this.mostrarid_empresaIndiceCorreccionActivoFijo= mostrarid_empresaIndiceCorreccionActivoFijo;
	}

	public Boolean getActivarid_empresaIndiceCorreccionActivoFijo() {
		return this.activarid_empresaIndiceCorreccionActivoFijo;
	}

	public void setActivarid_empresaIndiceCorreccionActivoFijo(Boolean activarid_empresaIndiceCorreccionActivoFijo) {
		this.activarid_empresaIndiceCorreccionActivoFijo= activarid_empresaIndiceCorreccionActivoFijo;
	}

	public Boolean getCargarid_empresaIndiceCorreccionActivoFijo() {
		return this.cargarid_empresaIndiceCorreccionActivoFijo;
	}

	public void setCargarid_empresaIndiceCorreccionActivoFijo(Boolean cargarid_empresaIndiceCorreccionActivoFijo) {
		this.cargarid_empresaIndiceCorreccionActivoFijo= cargarid_empresaIndiceCorreccionActivoFijo;
	}

	public Border setResaltaranioIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//indicecorreccionactivofijoBeanSwingJInternalFrame.jTtoolBarIndiceCorreccionActivoFijo.setBorder(borderResaltar);
		
		this.resaltaranioIndiceCorreccionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranioIndiceCorreccionActivoFijo() {
		return this.resaltaranioIndiceCorreccionActivoFijo;
	}

	public void setResaltaranioIndiceCorreccionActivoFijo(Border borderResaltar) {
		this.resaltaranioIndiceCorreccionActivoFijo= borderResaltar;
	}

	public Boolean getMostraranioIndiceCorreccionActivoFijo() {
		return this.mostraranioIndiceCorreccionActivoFijo;
	}

	public void setMostraranioIndiceCorreccionActivoFijo(Boolean mostraranioIndiceCorreccionActivoFijo) {
		this.mostraranioIndiceCorreccionActivoFijo= mostraranioIndiceCorreccionActivoFijo;
	}

	public Boolean getActivaranioIndiceCorreccionActivoFijo() {
		return this.activaranioIndiceCorreccionActivoFijo;
	}

	public void setActivaranioIndiceCorreccionActivoFijo(Boolean activaranioIndiceCorreccionActivoFijo) {
		this.activaranioIndiceCorreccionActivoFijo= activaranioIndiceCorreccionActivoFijo;
	}

	public Border setResaltarvalorIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//indicecorreccionactivofijoBeanSwingJInternalFrame.jTtoolBarIndiceCorreccionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalorIndiceCorreccionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorIndiceCorreccionActivoFijo() {
		return this.resaltarvalorIndiceCorreccionActivoFijo;
	}

	public void setResaltarvalorIndiceCorreccionActivoFijo(Border borderResaltar) {
		this.resaltarvalorIndiceCorreccionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalorIndiceCorreccionActivoFijo() {
		return this.mostrarvalorIndiceCorreccionActivoFijo;
	}

	public void setMostrarvalorIndiceCorreccionActivoFijo(Boolean mostrarvalorIndiceCorreccionActivoFijo) {
		this.mostrarvalorIndiceCorreccionActivoFijo= mostrarvalorIndiceCorreccionActivoFijo;
	}

	public Boolean getActivarvalorIndiceCorreccionActivoFijo() {
		return this.activarvalorIndiceCorreccionActivoFijo;
	}

	public void setActivarvalorIndiceCorreccionActivoFijo(Boolean activarvalorIndiceCorreccionActivoFijo) {
		this.activarvalorIndiceCorreccionActivoFijo= activarvalorIndiceCorreccionActivoFijo;
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
		
		
		this.setMostraridIndiceCorreccionActivoFijo(esInicial);
		this.setMostrarid_empresaIndiceCorreccionActivoFijo(esInicial);
		this.setMostraranioIndiceCorreccionActivoFijo(esInicial);
		this.setMostrarvalorIndiceCorreccionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ID)) {
				this.setMostraridIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ANIO)) {
				this.setMostraranioIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.VALOR)) {
				this.setMostrarvalorIndiceCorreccionActivoFijo(esAsigna);
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
		
		
		this.setActivaridIndiceCorreccionActivoFijo(esInicial);
		this.setActivarid_empresaIndiceCorreccionActivoFijo(esInicial);
		this.setActivaranioIndiceCorreccionActivoFijo(esInicial);
		this.setActivarvalorIndiceCorreccionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ID)) {
				this.setActivaridIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ANIO)) {
				this.setActivaranioIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.VALOR)) {
				this.setActivarvalorIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridIndiceCorreccionActivoFijo(esInicial);
		this.setResaltarid_empresaIndiceCorreccionActivoFijo(esInicial);
		this.setResaltaranioIndiceCorreccionActivoFijo(esInicial);
		this.setResaltarvalorIndiceCorreccionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.ANIO)) {
				this.setResaltaranioIndiceCorreccionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(IndiceCorreccionActivoFijoConstantesFunciones.VALOR)) {
				this.setResaltarvalorIndiceCorreccionActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaIndiceCorreccionActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaIndiceCorreccionActivoFijo() {
		return this.mostrarFK_IdEmpresaIndiceCorreccionActivoFijo;
	}

	public void setMostrarFK_IdEmpresaIndiceCorreccionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaIndiceCorreccionActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaIndiceCorreccionActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaIndiceCorreccionActivoFijo() {
		return this.activarFK_IdEmpresaIndiceCorreccionActivoFijo;
	}

	public void setActivarFK_IdEmpresaIndiceCorreccionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaIndiceCorreccionActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaIndiceCorreccionActivoFijo=null;

	public Border getResaltarFK_IdEmpresaIndiceCorreccionActivoFijo() {
		return this.resaltarFK_IdEmpresaIndiceCorreccionActivoFijo;
	}

	public void setResaltarFK_IdEmpresaIndiceCorreccionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaIndiceCorreccionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaIndiceCorreccionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*IndiceCorreccionActivoFijoBeanSwingJInternalFrame indicecorreccionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaIndiceCorreccionActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}