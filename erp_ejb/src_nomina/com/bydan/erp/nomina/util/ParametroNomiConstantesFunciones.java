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


import com.bydan.erp.nomina.util.ParametroNomiConstantesFunciones;
import com.bydan.erp.nomina.util.ParametroNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ParametroNomiParameterGeneral;

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
final public class ParametroNomiConstantesFunciones extends ParametroNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroNomi"+ParametroNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroNomiConstantesFunciones.SCHEMA+"_"+ParametroNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroNomiConstantesFunciones.SCHEMA+"_"+ParametroNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroNomiConstantesFunciones.SCHEMA+"_"+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroNomiConstantesFunciones.SCHEMA+"_"+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroNomi";
	public static final String OBJECTNAME="parametronomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="parametro_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametronomi from "+ParametroNomiConstantesFunciones.SPERSISTENCENAME+" parametronomi";
	public static String QUERYSELECTNATIVE="select "+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".id,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".version_row,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".id_empresa,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".codigo,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".nombre,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".valor,"+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME+".descripcion from "+ParametroNomiConstantesFunciones.SCHEMA+"."+ParametroNomiConstantesFunciones.TABLENAME;//+" as "+ParametroNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroNomiConstantesFuncionesAdditional parametronomiConstantesFuncionesAdditional=null;
	
	public ParametroNomiConstantesFuncionesAdditional getParametroNomiConstantesFuncionesAdditional() {
		return this.parametronomiConstantesFuncionesAdditional;
	}
	
	public void setParametroNomiConstantesFuncionesAdditional(ParametroNomiConstantesFuncionesAdditional parametronomiConstantesFuncionesAdditional) {
		try {
			this.parametronomiConstantesFuncionesAdditional=parametronomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXVALOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXVALOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParametroNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroNomiConstantesFunciones.CODIGO)) {sLabelColumna=ParametroNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ParametroNomiConstantesFunciones.NOMBRE)) {sLabelColumna=ParametroNomiConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ParametroNomiConstantesFunciones.VALOR)) {sLabelColumna=ParametroNomiConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ParametroNomiConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroNomiConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getParametroNomiDescripcion(ParametroNomi parametronomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametronomi !=null/* && parametronomi.getId()!=0*/) {
			sDescripcion=parametronomi.getcodigo();//parametronomiparametronomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroNomiDescripcionDetallado(ParametroNomi parametronomi) {
		String sDescripcion="";
			
		sDescripcion+=ParametroNomiConstantesFunciones.ID+"=";
		sDescripcion+=parametronomi.getId().toString()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametronomi.getVersionRow().toString()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametronomi.getid_empresa().toString()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=parametronomi.getcodigo()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=parametronomi.getnombre()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.VALOR+"=";
		sDescripcion+=parametronomi.getvalor()+",";
		sDescripcion+=ParametroNomiConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametronomi.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroNomiDescripcion(ParametroNomi parametronomi,String sValor) throws Exception {			
		if(parametronomi !=null) {
			parametronomi.setcodigo(sValor);;//parametronomiparametronomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosParametroNomi(ParametroNomi parametronomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametronomi.setcodigo(parametronomi.getcodigo().trim());
		parametronomi.setnombre(parametronomi.getnombre().trim());
		parametronomi.setvalor(parametronomi.getvalor().trim());
		parametronomi.setdescripcion(parametronomi.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroNomis(List<ParametroNomi> parametronomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroNomi parametronomi: parametronomis) {
			parametronomi.setcodigo(parametronomi.getcodigo().trim());
			parametronomi.setnombre(parametronomi.getnombre().trim());
			parametronomi.setvalor(parametronomi.getvalor().trim());
			parametronomi.setdescripcion(parametronomi.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroNomi(ParametroNomi parametronomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametronomi.getConCambioAuxiliar()) {
			parametronomi.setIsDeleted(parametronomi.getIsDeletedAuxiliar());	
			parametronomi.setIsNew(parametronomi.getIsNewAuxiliar());	
			parametronomi.setIsChanged(parametronomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametronomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametronomi.setIsDeletedAuxiliar(false);	
			parametronomi.setIsNewAuxiliar(false);	
			parametronomi.setIsChangedAuxiliar(false);
			
			parametronomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroNomis(List<ParametroNomi> parametronomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroNomi parametronomi : parametronomis) {
			if(conAsignarBase && parametronomi.getConCambioAuxiliar()) {
				parametronomi.setIsDeleted(parametronomi.getIsDeletedAuxiliar());	
				parametronomi.setIsNew(parametronomi.getIsNewAuxiliar());	
				parametronomi.setIsChanged(parametronomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametronomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametronomi.setIsDeletedAuxiliar(false);	
				parametronomi.setIsNewAuxiliar(false);	
				parametronomi.setIsChangedAuxiliar(false);
				
				parametronomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroNomi(ParametroNomi parametronomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroNomis(List<ParametroNomi> parametronomis,Boolean conEnteros) throws Exception  {
		
		for(ParametroNomi parametronomi: parametronomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroNomi(List<ParametroNomi> parametronomis,ParametroNomi parametronomiAux) throws Exception  {
		ParametroNomiConstantesFunciones.InicializarValoresParametroNomi(parametronomiAux,true);
		
		for(ParametroNomi parametronomi: parametronomis) {
			if(parametronomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroNomiConstantesFunciones.getArrayColumnasGlobalesParametroNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroNomi> parametronomis,ParametroNomi parametronomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroNomi parametronomiAux: parametronomis) {
			if(parametronomiAux!=null && parametronomi!=null) {
				if((parametronomiAux.getId()==null && parametronomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametronomiAux.getId()!=null && parametronomi.getId()!=null){
					if(parametronomiAux.getId().equals(parametronomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroNomi(List<ParametroNomi> parametronomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroNomi parametronomi: parametronomis) {			
			if(parametronomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_ID, ParametroNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_VERSIONROW, ParametroNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_IDEMPRESA, ParametroNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_CODIGO, ParametroNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_NOMBRE, ParametroNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_VALOR, ParametroNomiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroNomiConstantesFunciones.LABEL_DESCRIPCION, ParametroNomiConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroNomiConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroNomi() throws Exception  {
		return ParametroNomiConstantesFunciones.getTiposSeleccionarParametroNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroNomi(Boolean conFk) throws Exception  {
		return ParametroNomiConstantesFunciones.getTiposSeleccionarParametroNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ParametroNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ParametroNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroNomiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ParametroNomiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroNomiConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroNomiConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroNomi(ParametroNomi parametronomiAux) throws Exception {
		
			parametronomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametronomiAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroNomi(List<ParametroNomi> parametronomisTemp) throws Exception {
		for(ParametroNomi parametronomiAux:parametronomisTemp) {
			
			parametronomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametronomiAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroNomiConstantesFunciones.getClassesRelationshipsOfParametroNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroNomiConstantesFunciones.getClassesRelationshipsFromStringsOfParametroNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroNomi parametronomi,List<ParametroNomi> parametronomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroNomi parametronomiEncontrado=null;
			
			for(ParametroNomi parametronomiLocal:parametronomis) {
				if(parametronomiLocal.getId().equals(parametronomi.getId())) {
					parametronomiEncontrado=parametronomiLocal;
					
					parametronomiLocal.setIsChanged(parametronomi.getIsChanged());
					parametronomiLocal.setIsNew(parametronomi.getIsNew());
					parametronomiLocal.setIsDeleted(parametronomi.getIsDeleted());
					
					parametronomiLocal.setGeneralEntityOriginal(parametronomi.getGeneralEntityOriginal());
					
					parametronomiLocal.setId(parametronomi.getId());	
					parametronomiLocal.setVersionRow(parametronomi.getVersionRow());	
					parametronomiLocal.setid_empresa(parametronomi.getid_empresa());	
					parametronomiLocal.setcodigo(parametronomi.getcodigo());	
					parametronomiLocal.setnombre(parametronomi.getnombre());	
					parametronomiLocal.setvalor(parametronomi.getvalor());	
					parametronomiLocal.setdescripcion(parametronomi.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametronomi.getIsDeleted()) {
				if(!existe) {
					parametronomis.add(parametronomi);
				}
			} else {
				if(parametronomiEncontrado!=null && permiteQuitar)  {
					parametronomis.remove(parametronomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroNomi parametronomi,List<ParametroNomi> parametronomis) throws Exception {
		try	{			
			for(ParametroNomi parametronomiLocal:parametronomis) {
				if(parametronomiLocal.getId().equals(parametronomi.getId())) {
					parametronomiLocal.setIsSelected(parametronomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroNomi(List<ParametroNomi> parametronomisAux) throws Exception {
		//this.parametronomisAux=parametronomisAux;
		
		for(ParametroNomi parametronomiAux:parametronomisAux) {
			if(parametronomiAux.getIsChanged()) {
				parametronomiAux.setIsChanged(false);
			}		
			
			if(parametronomiAux.getIsNew()) {
				parametronomiAux.setIsNew(false);
			}	
			
			if(parametronomiAux.getIsDeleted()) {
				parametronomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroNomi(ParametroNomi parametronomiAux) throws Exception {
		//this.parametronomiAux=parametronomiAux;
		
			if(parametronomiAux.getIsChanged()) {
				parametronomiAux.setIsChanged(false);
			}		
			
			if(parametronomiAux.getIsNew()) {
				parametronomiAux.setIsNew(false);
			}	
			
			if(parametronomiAux.getIsDeleted()) {
				parametronomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroNomi parametronomiAsignar,ParametroNomi parametronomi) throws Exception {
		parametronomiAsignar.setId(parametronomi.getId());	
		parametronomiAsignar.setVersionRow(parametronomi.getVersionRow());	
		parametronomiAsignar.setid_empresa(parametronomi.getid_empresa());
		parametronomiAsignar.setempresa_descripcion(parametronomi.getempresa_descripcion());	
		parametronomiAsignar.setcodigo(parametronomi.getcodigo());	
		parametronomiAsignar.setnombre(parametronomi.getnombre());	
		parametronomiAsignar.setvalor(parametronomi.getvalor());	
		parametronomiAsignar.setdescripcion(parametronomi.getdescripcion());	
	}
	
	public static void inicializarParametroNomi(ParametroNomi parametronomi) throws Exception {
		try {
				parametronomi.setId(0L);	
					
				parametronomi.setid_empresa(-1L);	
				parametronomi.setcodigo("");	
				parametronomi.setnombre("");	
				parametronomi.setvalor("");	
				parametronomi.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroNomiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroNomiConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroNomi(String sTipo,Row row,Workbook workbook,ParametroNomi parametronomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametronomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametronomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametronomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametronomi.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametronomi.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroNomi() {
		return this.sFinalQueryParametroNomi;
	}
	
	public void setsFinalQueryParametroNomi(String sFinalQueryParametroNomi) {
		this.sFinalQueryParametroNomi= sFinalQueryParametroNomi;
	}
	
	public Border resaltarSeleccionarParametroNomi=null;
	
	public Border setResaltarSeleccionarParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroNomi() {
		return this.resaltarSeleccionarParametroNomi;
	}
	
	public void setResaltarSeleccionarParametroNomi(Border borderResaltarSeleccionarParametroNomi) {
		this.resaltarSeleccionarParametroNomi= borderResaltarSeleccionarParametroNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroNomi=null;
	public Boolean mostraridParametroNomi=true;
	public Boolean activaridParametroNomi=true;

	public Border resaltarid_empresaParametroNomi=null;
	public Boolean mostrarid_empresaParametroNomi=true;
	public Boolean activarid_empresaParametroNomi=true;
	public Boolean cargarid_empresaParametroNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroNomi=false;//ConEventDepend=true

	public Border resaltarcodigoParametroNomi=null;
	public Boolean mostrarcodigoParametroNomi=true;
	public Boolean activarcodigoParametroNomi=true;

	public Border resaltarnombreParametroNomi=null;
	public Boolean mostrarnombreParametroNomi=true;
	public Boolean activarnombreParametroNomi=true;

	public Border resaltarvalorParametroNomi=null;
	public Boolean mostrarvalorParametroNomi=true;
	public Boolean activarvalorParametroNomi=true;

	public Border resaltardescripcionParametroNomi=null;
	public Boolean mostrardescripcionParametroNomi=true;
	public Boolean activardescripcionParametroNomi=true;

	
	

	public Border setResaltaridParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltaridParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroNomi() {
		return this.resaltaridParametroNomi;
	}

	public void setResaltaridParametroNomi(Border borderResaltar) {
		this.resaltaridParametroNomi= borderResaltar;
	}

	public Boolean getMostraridParametroNomi() {
		return this.mostraridParametroNomi;
	}

	public void setMostraridParametroNomi(Boolean mostraridParametroNomi) {
		this.mostraridParametroNomi= mostraridParametroNomi;
	}

	public Boolean getActivaridParametroNomi() {
		return this.activaridParametroNomi;
	}

	public void setActivaridParametroNomi(Boolean activaridParametroNomi) {
		this.activaridParametroNomi= activaridParametroNomi;
	}

	public Border setResaltarid_empresaParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroNomi() {
		return this.resaltarid_empresaParametroNomi;
	}

	public void setResaltarid_empresaParametroNomi(Border borderResaltar) {
		this.resaltarid_empresaParametroNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroNomi() {
		return this.mostrarid_empresaParametroNomi;
	}

	public void setMostrarid_empresaParametroNomi(Boolean mostrarid_empresaParametroNomi) {
		this.mostrarid_empresaParametroNomi= mostrarid_empresaParametroNomi;
	}

	public Boolean getActivarid_empresaParametroNomi() {
		return this.activarid_empresaParametroNomi;
	}

	public void setActivarid_empresaParametroNomi(Boolean activarid_empresaParametroNomi) {
		this.activarid_empresaParametroNomi= activarid_empresaParametroNomi;
	}

	public Boolean getCargarid_empresaParametroNomi() {
		return this.cargarid_empresaParametroNomi;
	}

	public void setCargarid_empresaParametroNomi(Boolean cargarid_empresaParametroNomi) {
		this.cargarid_empresaParametroNomi= cargarid_empresaParametroNomi;
	}

	public Border setResaltarcodigoParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoParametroNomi() {
		return this.resaltarcodigoParametroNomi;
	}

	public void setResaltarcodigoParametroNomi(Border borderResaltar) {
		this.resaltarcodigoParametroNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoParametroNomi() {
		return this.mostrarcodigoParametroNomi;
	}

	public void setMostrarcodigoParametroNomi(Boolean mostrarcodigoParametroNomi) {
		this.mostrarcodigoParametroNomi= mostrarcodigoParametroNomi;
	}

	public Boolean getActivarcodigoParametroNomi() {
		return this.activarcodigoParametroNomi;
	}

	public void setActivarcodigoParametroNomi(Boolean activarcodigoParametroNomi) {
		this.activarcodigoParametroNomi= activarcodigoParametroNomi;
	}

	public Border setResaltarnombreParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltarnombreParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreParametroNomi() {
		return this.resaltarnombreParametroNomi;
	}

	public void setResaltarnombreParametroNomi(Border borderResaltar) {
		this.resaltarnombreParametroNomi= borderResaltar;
	}

	public Boolean getMostrarnombreParametroNomi() {
		return this.mostrarnombreParametroNomi;
	}

	public void setMostrarnombreParametroNomi(Boolean mostrarnombreParametroNomi) {
		this.mostrarnombreParametroNomi= mostrarnombreParametroNomi;
	}

	public Boolean getActivarnombreParametroNomi() {
		return this.activarnombreParametroNomi;
	}

	public void setActivarnombreParametroNomi(Boolean activarnombreParametroNomi) {
		this.activarnombreParametroNomi= activarnombreParametroNomi;
	}

	public Border setResaltarvalorParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltarvalorParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorParametroNomi() {
		return this.resaltarvalorParametroNomi;
	}

	public void setResaltarvalorParametroNomi(Border borderResaltar) {
		this.resaltarvalorParametroNomi= borderResaltar;
	}

	public Boolean getMostrarvalorParametroNomi() {
		return this.mostrarvalorParametroNomi;
	}

	public void setMostrarvalorParametroNomi(Boolean mostrarvalorParametroNomi) {
		this.mostrarvalorParametroNomi= mostrarvalorParametroNomi;
	}

	public Boolean getActivarvalorParametroNomi() {
		return this.activarvalorParametroNomi;
	}

	public void setActivarvalorParametroNomi(Boolean activarvalorParametroNomi) {
		this.activarvalorParametroNomi= activarvalorParametroNomi;
	}

	public Border setResaltardescripcionParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametronomiBeanSwingJInternalFrame.jTtoolBarParametroNomi.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroNomi() {
		return this.resaltardescripcionParametroNomi;
	}

	public void setResaltardescripcionParametroNomi(Border borderResaltar) {
		this.resaltardescripcionParametroNomi= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroNomi() {
		return this.mostrardescripcionParametroNomi;
	}

	public void setMostrardescripcionParametroNomi(Boolean mostrardescripcionParametroNomi) {
		this.mostrardescripcionParametroNomi= mostrardescripcionParametroNomi;
	}

	public Boolean getActivardescripcionParametroNomi() {
		return this.activardescripcionParametroNomi;
	}

	public void setActivardescripcionParametroNomi(Boolean activardescripcionParametroNomi) {
		this.activardescripcionParametroNomi= activardescripcionParametroNomi;
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
		
		
		this.setMostraridParametroNomi(esInicial);
		this.setMostrarid_empresaParametroNomi(esInicial);
		this.setMostrarcodigoParametroNomi(esInicial);
		this.setMostrarnombreParametroNomi(esInicial);
		this.setMostrarvalorParametroNomi(esInicial);
		this.setMostrardescripcionParametroNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroNomiConstantesFunciones.ID)) {
				this.setMostraridParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.VALOR)) {
				this.setMostrarvalorParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroNomi(esAsigna);
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
		
		
		this.setActivaridParametroNomi(esInicial);
		this.setActivarid_empresaParametroNomi(esInicial);
		this.setActivarcodigoParametroNomi(esInicial);
		this.setActivarnombreParametroNomi(esInicial);
		this.setActivarvalorParametroNomi(esInicial);
		this.setActivardescripcionParametroNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroNomiConstantesFunciones.ID)) {
				this.setActivaridParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.VALOR)) {
				this.setActivarvalorParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroNomi(esInicial);
		this.setResaltarid_empresaParametroNomi(esInicial);
		this.setResaltarcodigoParametroNomi(esInicial);
		this.setResaltarnombreParametroNomi(esInicial);
		this.setResaltarvalorParametroNomi(esInicial);
		this.setResaltardescripcionParametroNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroNomiConstantesFunciones.ID)) {
				this.setResaltaridParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.VALOR)) {
				this.setResaltarvalorParametroNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroNomiConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroNomi=true;

	public Boolean getMostrarFK_IdEmpresaParametroNomi() {
		return this.mostrarFK_IdEmpresaParametroNomi;
	}

	public void setMostrarFK_IdEmpresaParametroNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroNomi=true;

	public Boolean getActivarFK_IdEmpresaParametroNomi() {
		return this.activarFK_IdEmpresaParametroNomi;
	}

	public void setActivarFK_IdEmpresaParametroNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroNomi=null;

	public Border getResaltarFK_IdEmpresaParametroNomi() {
		return this.resaltarFK_IdEmpresaParametroNomi;
	}

	public void setResaltarFK_IdEmpresaParametroNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroNomiBeanSwingJInternalFrame parametronomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}