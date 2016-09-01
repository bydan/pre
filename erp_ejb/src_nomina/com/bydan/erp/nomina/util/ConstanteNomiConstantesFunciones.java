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


import com.bydan.erp.nomina.util.ConstanteNomiConstantesFunciones;
import com.bydan.erp.nomina.util.ConstanteNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ConstanteNomiParameterGeneral;

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
final public class ConstanteNomiConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConstanteNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConstanteNomi"+ConstanteNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConstanteNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConstanteNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConstanteNomiConstantesFunciones.SCHEMA+"_"+ConstanteNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConstanteNomiConstantesFunciones.SCHEMA+"_"+ConstanteNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConstanteNomiConstantesFunciones.SCHEMA+"_"+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConstanteNomiConstantesFunciones.SCHEMA+"_"+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConstanteNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConstanteNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConstanteNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConstanteNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Constante Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Constante Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Constante Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConstanteNomi";
	public static final String OBJECTNAME="constantenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="constante_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select constantenomi from "+ConstanteNomiConstantesFunciones.SPERSISTENCENAME+" constantenomi";
	public static String QUERYSELECTNATIVE="select "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".version_row,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id_empresa,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id_tipo_constante_nomi,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".nombre,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".valor,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".es_para_pregunta from "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME;//+" as "+ConstanteNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOCONSTANTENOMI= "id_tipo_constante_nomi";
    public static final String NOMBRE= "nombre";
    public static final String VALOR= "valor";
    public static final String ESPARAPREGUNTA= "es_para_pregunta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOCONSTANTENOMI= "Tipo Constante";
		public static final String LABEL_IDTIPOCONSTANTENOMI_LOWER= "Tipo Constante Nomi";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ESPARAPREGUNTA= "Es Para Pregunta";
		public static final String LABEL_ESPARAPREGUNTA_LOWER= "Es Para Pregunta";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getConstanteNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConstanteNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConstanteNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI)) {sLabelColumna=ConstanteNomiConstantesFunciones.LABEL_IDTIPOCONSTANTENOMI;}
		if(sNombreColumna.equals(ConstanteNomiConstantesFunciones.NOMBRE)) {sLabelColumna=ConstanteNomiConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConstanteNomiConstantesFunciones.VALOR)) {sLabelColumna=ConstanteNomiConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ConstanteNomiConstantesFunciones.ESPARAPREGUNTA)) {sLabelColumna=ConstanteNomiConstantesFunciones.LABEL_ESPARAPREGUNTA;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getes_para_preguntaDescripcion(ConstanteNomi constantenomi) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!constantenomi.getes_para_pregunta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_preguntaHtmlDescripcion(ConstanteNomi constantenomi) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(constantenomi.getId(),constantenomi.getes_para_pregunta());

		return sDescripcion;
	}	
	
	public static String getConstanteNomiDescripcion(ConstanteNomi constantenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(constantenomi !=null/* && constantenomi.getId()!=0*/) {
			sDescripcion=constantenomi.getnombre();//constantenomiconstantenomi.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConstanteNomiDescripcionDetallado(ConstanteNomi constantenomi) {
		String sDescripcion="";
			
		sDescripcion+=ConstanteNomiConstantesFunciones.ID+"=";
		sDescripcion+=constantenomi.getId().toString()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=constantenomi.getVersionRow().toString()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=constantenomi.getid_empresa().toString()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI+"=";
		sDescripcion+=constantenomi.getid_tipo_constante_nomi().toString()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=constantenomi.getnombre()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.VALOR+"=";
		sDescripcion+=constantenomi.getvalor().toString()+",";
		sDescripcion+=ConstanteNomiConstantesFunciones.ESPARAPREGUNTA+"=";
		sDescripcion+=constantenomi.getes_para_pregunta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConstanteNomiDescripcion(ConstanteNomi constantenomi,String sValor) throws Exception {			
		if(constantenomi !=null) {
			constantenomi.setnombre(sValor);;//constantenomiconstantenomi.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoConstanteNomiDescripcion(TipoConstanteNomi tipoconstantenomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoconstantenomi!=null/*&&tipoconstantenomi.getId()>0*/) {
			sDescripcion=TipoConstanteNomiConstantesFunciones.getTipoConstanteNomiDescripcion(tipoconstantenomi);
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
		} else if(sNombreIndice.equals("FK_IdTipoConstante")) {
			sNombreIndice="Tipo=  Por Tipo Constante";
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

	public static String getDetalleIndiceFK_IdTipoConstante(Long id_tipo_constante_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_constante_nomi!=null) {sDetalleIndice+=" Codigo Unico De Tipo Constante="+id_tipo_constante_nomi.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConstanteNomi(ConstanteNomi constantenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		constantenomi.setnombre(constantenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosConstanteNomis(List<ConstanteNomi> constantenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConstanteNomi constantenomi: constantenomis) {
			constantenomi.setnombre(constantenomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConstanteNomi(ConstanteNomi constantenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && constantenomi.getConCambioAuxiliar()) {
			constantenomi.setIsDeleted(constantenomi.getIsDeletedAuxiliar());	
			constantenomi.setIsNew(constantenomi.getIsNewAuxiliar());	
			constantenomi.setIsChanged(constantenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			constantenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			constantenomi.setIsDeletedAuxiliar(false);	
			constantenomi.setIsNewAuxiliar(false);	
			constantenomi.setIsChangedAuxiliar(false);
			
			constantenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConstanteNomis(List<ConstanteNomi> constantenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConstanteNomi constantenomi : constantenomis) {
			if(conAsignarBase && constantenomi.getConCambioAuxiliar()) {
				constantenomi.setIsDeleted(constantenomi.getIsDeletedAuxiliar());	
				constantenomi.setIsNew(constantenomi.getIsNewAuxiliar());	
				constantenomi.setIsChanged(constantenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				constantenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				constantenomi.setIsDeletedAuxiliar(false);	
				constantenomi.setIsNewAuxiliar(false);	
				constantenomi.setIsChangedAuxiliar(false);
				
				constantenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConstanteNomi(ConstanteNomi constantenomi,Boolean conEnteros) throws Exception  {
		constantenomi.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConstanteNomis(List<ConstanteNomi> constantenomis,Boolean conEnteros) throws Exception  {
		
		for(ConstanteNomi constantenomi: constantenomis) {
			constantenomi.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConstanteNomi(List<ConstanteNomi> constantenomis,ConstanteNomi constantenomiAux) throws Exception  {
		ConstanteNomiConstantesFunciones.InicializarValoresConstanteNomi(constantenomiAux,true);
		
		for(ConstanteNomi constantenomi: constantenomis) {
			if(constantenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			constantenomiAux.setvalor(constantenomiAux.getvalor()+constantenomi.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConstanteNomiConstantesFunciones.getArrayColumnasGlobalesConstanteNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConstanteNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConstanteNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConstanteNomi> constantenomis,ConstanteNomi constantenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConstanteNomi constantenomiAux: constantenomis) {
			if(constantenomiAux!=null && constantenomi!=null) {
				if((constantenomiAux.getId()==null && constantenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(constantenomiAux.getId()!=null && constantenomi.getId()!=null){
					if(constantenomiAux.getId().equals(constantenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConstanteNomi(List<ConstanteNomi> constantenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ConstanteNomi constantenomi: constantenomis) {			
			if(constantenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=constantenomi.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConstanteNomiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConstanteNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_ID, ConstanteNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_VERSIONROW, ConstanteNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_IDEMPRESA, ConstanteNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_IDTIPOCONSTANTENOMI, ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_NOMBRE, ConstanteNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_VALOR, ConstanteNomiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConstanteNomiConstantesFunciones.LABEL_ESPARAPREGUNTA, ConstanteNomiConstantesFunciones.ESPARAPREGUNTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConstanteNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConstanteNomiConstantesFunciones.ESPARAPREGUNTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConstanteNomi() throws Exception  {
		return ConstanteNomiConstantesFunciones.getTiposSeleccionarConstanteNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConstanteNomi(Boolean conFk) throws Exception  {
		return ConstanteNomiConstantesFunciones.getTiposSeleccionarConstanteNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConstanteNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConstanteNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConstanteNomiConstantesFunciones.LABEL_IDTIPOCONSTANTENOMI);
			reporte.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_IDTIPOCONSTANTENOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConstanteNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConstanteNomiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConstanteNomiConstantesFunciones.LABEL_ESPARAPREGUNTA);
			reporte.setsDescripcion(ConstanteNomiConstantesFunciones.LABEL_ESPARAPREGUNTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConstanteNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConstanteNomi(ConstanteNomi constantenomiAux) throws Exception {
		
			constantenomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(constantenomiAux.getEmpresa()));
			constantenomiAux.settipoconstantenomi_descripcion(TipoConstanteNomiConstantesFunciones.getTipoConstanteNomiDescripcion(constantenomiAux.getTipoConstanteNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConstanteNomi(List<ConstanteNomi> constantenomisTemp) throws Exception {
		for(ConstanteNomi constantenomiAux:constantenomisTemp) {
			
			constantenomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(constantenomiAux.getEmpresa()));
			constantenomiAux.settipoconstantenomi_descripcion(TipoConstanteNomiConstantesFunciones.getTipoConstanteNomiDescripcion(constantenomiAux.getTipoConstanteNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoConstanteNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoConstanteNomi.class)) {
						classes.add(new Classe(TipoConstanteNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConstanteNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConstanteNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConstanteNomiConstantesFunciones.getClassesRelationshipsOfConstanteNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoConstante.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoConstante.class)) {
						classes.add(new Classe(EmpleadoConstante.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConstanteNomiConstantesFunciones.getClassesRelationshipsFromStringsOfConstanteNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoConstante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoConstante.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoConstante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoConstante.class)); continue;
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
	public static void actualizarLista(ConstanteNomi constantenomi,List<ConstanteNomi> constantenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ConstanteNomi constantenomiEncontrado=null;
			
			for(ConstanteNomi constantenomiLocal:constantenomis) {
				if(constantenomiLocal.getId().equals(constantenomi.getId())) {
					constantenomiEncontrado=constantenomiLocal;
					
					constantenomiLocal.setIsChanged(constantenomi.getIsChanged());
					constantenomiLocal.setIsNew(constantenomi.getIsNew());
					constantenomiLocal.setIsDeleted(constantenomi.getIsDeleted());
					
					constantenomiLocal.setGeneralEntityOriginal(constantenomi.getGeneralEntityOriginal());
					
					constantenomiLocal.setId(constantenomi.getId());	
					constantenomiLocal.setVersionRow(constantenomi.getVersionRow());	
					constantenomiLocal.setid_empresa(constantenomi.getid_empresa());	
					constantenomiLocal.setid_tipo_constante_nomi(constantenomi.getid_tipo_constante_nomi());	
					constantenomiLocal.setnombre(constantenomi.getnombre());	
					constantenomiLocal.setvalor(constantenomi.getvalor());	
					constantenomiLocal.setes_para_pregunta(constantenomi.getes_para_pregunta());	
					
					
					constantenomiLocal.setEmpleadoConstantes(constantenomi.getEmpleadoConstantes());
					
					existe=true;
					break;
				}
			}
			
			if(!constantenomi.getIsDeleted()) {
				if(!existe) {
					constantenomis.add(constantenomi);
				}
			} else {
				if(constantenomiEncontrado!=null && permiteQuitar)  {
					constantenomis.remove(constantenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ConstanteNomi constantenomi,List<ConstanteNomi> constantenomis) throws Exception {
		try	{			
			for(ConstanteNomi constantenomiLocal:constantenomis) {
				if(constantenomiLocal.getId().equals(constantenomi.getId())) {
					constantenomiLocal.setIsSelected(constantenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConstanteNomi(List<ConstanteNomi> constantenomisAux) throws Exception {
		//this.constantenomisAux=constantenomisAux;
		
		for(ConstanteNomi constantenomiAux:constantenomisAux) {
			if(constantenomiAux.getIsChanged()) {
				constantenomiAux.setIsChanged(false);
			}		
			
			if(constantenomiAux.getIsNew()) {
				constantenomiAux.setIsNew(false);
			}	
			
			if(constantenomiAux.getIsDeleted()) {
				constantenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConstanteNomi(ConstanteNomi constantenomiAux) throws Exception {
		//this.constantenomiAux=constantenomiAux;
		
			if(constantenomiAux.getIsChanged()) {
				constantenomiAux.setIsChanged(false);
			}		
			
			if(constantenomiAux.getIsNew()) {
				constantenomiAux.setIsNew(false);
			}	
			
			if(constantenomiAux.getIsDeleted()) {
				constantenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConstanteNomi constantenomiAsignar,ConstanteNomi constantenomi) throws Exception {
		constantenomiAsignar.setId(constantenomi.getId());	
		constantenomiAsignar.setVersionRow(constantenomi.getVersionRow());	
		constantenomiAsignar.setid_empresa(constantenomi.getid_empresa());
		constantenomiAsignar.setempresa_descripcion(constantenomi.getempresa_descripcion());	
		constantenomiAsignar.setid_tipo_constante_nomi(constantenomi.getid_tipo_constante_nomi());
		constantenomiAsignar.settipoconstantenomi_descripcion(constantenomi.gettipoconstantenomi_descripcion());	
		constantenomiAsignar.setnombre(constantenomi.getnombre());	
		constantenomiAsignar.setvalor(constantenomi.getvalor());	
		constantenomiAsignar.setes_para_pregunta(constantenomi.getes_para_pregunta());	
	}
	
	public static void inicializarConstanteNomi(ConstanteNomi constantenomi) throws Exception {
		try {
				constantenomi.setId(0L);	
					
				constantenomi.setid_empresa(-1L);	
				constantenomi.setid_tipo_constante_nomi(-1L);	
				constantenomi.setnombre("");	
				constantenomi.setvalor(0.0);	
				constantenomi.setes_para_pregunta(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConstanteNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConstanteNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConstanteNomiConstantesFunciones.LABEL_IDTIPOCONSTANTENOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConstanteNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConstanteNomiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConstanteNomiConstantesFunciones.LABEL_ESPARAPREGUNTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConstanteNomi(String sTipo,Row row,Workbook workbook,ConstanteNomi constantenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(constantenomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(constantenomi.gettipoconstantenomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(constantenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(constantenomi.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(constantenomi.getes_para_pregunta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConstanteNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConstanteNomi() {
		return this.sFinalQueryConstanteNomi;
	}
	
	public void setsFinalQueryConstanteNomi(String sFinalQueryConstanteNomi) {
		this.sFinalQueryConstanteNomi= sFinalQueryConstanteNomi;
	}
	
	public Border resaltarSeleccionarConstanteNomi=null;
	
	public Border setResaltarSeleccionarConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConstanteNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConstanteNomi() {
		return this.resaltarSeleccionarConstanteNomi;
	}
	
	public void setResaltarSeleccionarConstanteNomi(Border borderResaltarSeleccionarConstanteNomi) {
		this.resaltarSeleccionarConstanteNomi= borderResaltarSeleccionarConstanteNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConstanteNomi=null;
	public Boolean mostraridConstanteNomi=true;
	public Boolean activaridConstanteNomi=true;

	public Border resaltarid_empresaConstanteNomi=null;
	public Boolean mostrarid_empresaConstanteNomi=true;
	public Boolean activarid_empresaConstanteNomi=true;
	public Boolean cargarid_empresaConstanteNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConstanteNomi=false;//ConEventDepend=true

	public Border resaltarid_tipo_constante_nomiConstanteNomi=null;
	public Boolean mostrarid_tipo_constante_nomiConstanteNomi=true;
	public Boolean activarid_tipo_constante_nomiConstanteNomi=true;
	public Boolean cargarid_tipo_constante_nomiConstanteNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_constante_nomiConstanteNomi=false;//ConEventDepend=true

	public Border resaltarnombreConstanteNomi=null;
	public Boolean mostrarnombreConstanteNomi=true;
	public Boolean activarnombreConstanteNomi=true;

	public Border resaltarvalorConstanteNomi=null;
	public Boolean mostrarvalorConstanteNomi=true;
	public Boolean activarvalorConstanteNomi=true;

	public Border resaltares_para_preguntaConstanteNomi=null;
	public Boolean mostrares_para_preguntaConstanteNomi=true;
	public Boolean activares_para_preguntaConstanteNomi=true;

	
	

	public Border setResaltaridConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltaridConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConstanteNomi() {
		return this.resaltaridConstanteNomi;
	}

	public void setResaltaridConstanteNomi(Border borderResaltar) {
		this.resaltaridConstanteNomi= borderResaltar;
	}

	public Boolean getMostraridConstanteNomi() {
		return this.mostraridConstanteNomi;
	}

	public void setMostraridConstanteNomi(Boolean mostraridConstanteNomi) {
		this.mostraridConstanteNomi= mostraridConstanteNomi;
	}

	public Boolean getActivaridConstanteNomi() {
		return this.activaridConstanteNomi;
	}

	public void setActivaridConstanteNomi(Boolean activaridConstanteNomi) {
		this.activaridConstanteNomi= activaridConstanteNomi;
	}

	public Border setResaltarid_empresaConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConstanteNomi() {
		return this.resaltarid_empresaConstanteNomi;
	}

	public void setResaltarid_empresaConstanteNomi(Border borderResaltar) {
		this.resaltarid_empresaConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaConstanteNomi() {
		return this.mostrarid_empresaConstanteNomi;
	}

	public void setMostrarid_empresaConstanteNomi(Boolean mostrarid_empresaConstanteNomi) {
		this.mostrarid_empresaConstanteNomi= mostrarid_empresaConstanteNomi;
	}

	public Boolean getActivarid_empresaConstanteNomi() {
		return this.activarid_empresaConstanteNomi;
	}

	public void setActivarid_empresaConstanteNomi(Boolean activarid_empresaConstanteNomi) {
		this.activarid_empresaConstanteNomi= activarid_empresaConstanteNomi;
	}

	public Boolean getCargarid_empresaConstanteNomi() {
		return this.cargarid_empresaConstanteNomi;
	}

	public void setCargarid_empresaConstanteNomi(Boolean cargarid_empresaConstanteNomi) {
		this.cargarid_empresaConstanteNomi= cargarid_empresaConstanteNomi;
	}

	public Border setResaltarid_tipo_constante_nomiConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarid_tipo_constante_nomiConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_constante_nomiConstanteNomi() {
		return this.resaltarid_tipo_constante_nomiConstanteNomi;
	}

	public void setResaltarid_tipo_constante_nomiConstanteNomi(Border borderResaltar) {
		this.resaltarid_tipo_constante_nomiConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarid_tipo_constante_nomiConstanteNomi() {
		return this.mostrarid_tipo_constante_nomiConstanteNomi;
	}

	public void setMostrarid_tipo_constante_nomiConstanteNomi(Boolean mostrarid_tipo_constante_nomiConstanteNomi) {
		this.mostrarid_tipo_constante_nomiConstanteNomi= mostrarid_tipo_constante_nomiConstanteNomi;
	}

	public Boolean getActivarid_tipo_constante_nomiConstanteNomi() {
		return this.activarid_tipo_constante_nomiConstanteNomi;
	}

	public void setActivarid_tipo_constante_nomiConstanteNomi(Boolean activarid_tipo_constante_nomiConstanteNomi) {
		this.activarid_tipo_constante_nomiConstanteNomi= activarid_tipo_constante_nomiConstanteNomi;
	}

	public Boolean getCargarid_tipo_constante_nomiConstanteNomi() {
		return this.cargarid_tipo_constante_nomiConstanteNomi;
	}

	public void setCargarid_tipo_constante_nomiConstanteNomi(Boolean cargarid_tipo_constante_nomiConstanteNomi) {
		this.cargarid_tipo_constante_nomiConstanteNomi= cargarid_tipo_constante_nomiConstanteNomi;
	}

	public Border setResaltarnombreConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarnombreConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConstanteNomi() {
		return this.resaltarnombreConstanteNomi;
	}

	public void setResaltarnombreConstanteNomi(Border borderResaltar) {
		this.resaltarnombreConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarnombreConstanteNomi() {
		return this.mostrarnombreConstanteNomi;
	}

	public void setMostrarnombreConstanteNomi(Boolean mostrarnombreConstanteNomi) {
		this.mostrarnombreConstanteNomi= mostrarnombreConstanteNomi;
	}

	public Boolean getActivarnombreConstanteNomi() {
		return this.activarnombreConstanteNomi;
	}

	public void setActivarnombreConstanteNomi(Boolean activarnombreConstanteNomi) {
		this.activarnombreConstanteNomi= activarnombreConstanteNomi;
	}

	public Border setResaltarvalorConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarvalorConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorConstanteNomi() {
		return this.resaltarvalorConstanteNomi;
	}

	public void setResaltarvalorConstanteNomi(Border borderResaltar) {
		this.resaltarvalorConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarvalorConstanteNomi() {
		return this.mostrarvalorConstanteNomi;
	}

	public void setMostrarvalorConstanteNomi(Boolean mostrarvalorConstanteNomi) {
		this.mostrarvalorConstanteNomi= mostrarvalorConstanteNomi;
	}

	public Boolean getActivarvalorConstanteNomi() {
		return this.activarvalorConstanteNomi;
	}

	public void setActivarvalorConstanteNomi(Boolean activarvalorConstanteNomi) {
		this.activarvalorConstanteNomi= activarvalorConstanteNomi;
	}

	public Border setResaltares_para_preguntaConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltar);
		
		this.resaltares_para_preguntaConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_preguntaConstanteNomi() {
		return this.resaltares_para_preguntaConstanteNomi;
	}

	public void setResaltares_para_preguntaConstanteNomi(Border borderResaltar) {
		this.resaltares_para_preguntaConstanteNomi= borderResaltar;
	}

	public Boolean getMostrares_para_preguntaConstanteNomi() {
		return this.mostrares_para_preguntaConstanteNomi;
	}

	public void setMostrares_para_preguntaConstanteNomi(Boolean mostrares_para_preguntaConstanteNomi) {
		this.mostrares_para_preguntaConstanteNomi= mostrares_para_preguntaConstanteNomi;
	}

	public Boolean getActivares_para_preguntaConstanteNomi() {
		return this.activares_para_preguntaConstanteNomi;
	}

	public void setActivares_para_preguntaConstanteNomi(Boolean activares_para_preguntaConstanteNomi) {
		this.activares_para_preguntaConstanteNomi= activares_para_preguntaConstanteNomi;
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
		
		
		this.setMostraridConstanteNomi(esInicial);
		this.setMostrarid_empresaConstanteNomi(esInicial);
		this.setMostrarid_tipo_constante_nomiConstanteNomi(esInicial);
		this.setMostrarnombreConstanteNomi(esInicial);
		this.setMostrarvalorConstanteNomi(esInicial);
		this.setMostrares_para_preguntaConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ID)) {
				this.setMostraridConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI)) {
				this.setMostrarid_tipo_constante_nomiConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.VALOR)) {
				this.setMostrarvalorConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ESPARAPREGUNTA)) {
				this.setMostrares_para_preguntaConstanteNomi(esAsigna);
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
		
		
		this.setActivaridConstanteNomi(esInicial);
		this.setActivarid_empresaConstanteNomi(esInicial);
		this.setActivarid_tipo_constante_nomiConstanteNomi(esInicial);
		this.setActivarnombreConstanteNomi(esInicial);
		this.setActivarvalorConstanteNomi(esInicial);
		this.setActivares_para_preguntaConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ID)) {
				this.setActivaridConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI)) {
				this.setActivarid_tipo_constante_nomiConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.VALOR)) {
				this.setActivarvalorConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ESPARAPREGUNTA)) {
				this.setActivares_para_preguntaConstanteNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConstanteNomi(esInicial);
		this.setResaltarid_empresaConstanteNomi(esInicial);
		this.setResaltarid_tipo_constante_nomiConstanteNomi(esInicial);
		this.setResaltarnombreConstanteNomi(esInicial);
		this.setResaltarvalorConstanteNomi(esInicial);
		this.setResaltares_para_preguntaConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ID)) {
				this.setResaltaridConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI)) {
				this.setResaltarid_tipo_constante_nomiConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.VALOR)) {
				this.setResaltarvalorConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConstanteNomiConstantesFunciones.ESPARAPREGUNTA)) {
				this.setResaltares_para_preguntaConstanteNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoConstanteConstanteNomi=null;

	public Border getResaltarEmpleadoConstanteConstanteNomi() {
		return this.resaltarEmpleadoConstanteConstanteNomi;
	}

	public void setResaltarEmpleadoConstanteConstanteNomi(Border borderResaltarEmpleadoConstante) {
		if(borderResaltarEmpleadoConstante!=null) {
			this.resaltarEmpleadoConstanteConstanteNomi= borderResaltarEmpleadoConstante;
		}
	}

	public Border setResaltarEmpleadoConstanteConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoConstante=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//constantenomiBeanSwingJInternalFrame.jTtoolBarConstanteNomi.setBorder(borderResaltarEmpleadoConstante);
			
		this.resaltarEmpleadoConstanteConstanteNomi= borderResaltarEmpleadoConstante;

		 return borderResaltarEmpleadoConstante;
	}



	public Boolean mostrarEmpleadoConstanteConstanteNomi=true;

	public Boolean getMostrarEmpleadoConstanteConstanteNomi() {
		return this.mostrarEmpleadoConstanteConstanteNomi;
	}

	public void setMostrarEmpleadoConstanteConstanteNomi(Boolean visibilidadResaltarEmpleadoConstante) {
		this.mostrarEmpleadoConstanteConstanteNomi= visibilidadResaltarEmpleadoConstante;
	}



	public Boolean activarEmpleadoConstanteConstanteNomi=true;

	public Boolean gethabilitarResaltarEmpleadoConstanteConstanteNomi() {
		return this.activarEmpleadoConstanteConstanteNomi;
	}

	public void setActivarEmpleadoConstanteConstanteNomi(Boolean habilitarResaltarEmpleadoConstante) {
		this.activarEmpleadoConstanteConstanteNomi= habilitarResaltarEmpleadoConstante;
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

		this.setMostrarEmpleadoConstanteConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setMostrarEmpleadoConstanteConstanteNomi(esAsigna);
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

		this.setActivarEmpleadoConstanteConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setActivarEmpleadoConstanteConstanteNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoConstanteConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setResaltarEmpleadoConstanteConstanteNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaConstanteNomi=true;

	public Boolean getMostrarFK_IdEmpresaConstanteNomi() {
		return this.mostrarFK_IdEmpresaConstanteNomi;
	}

	public void setMostrarFK_IdEmpresaConstanteNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConstanteNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoConstanteConstanteNomi=true;

	public Boolean getMostrarFK_IdTipoConstanteConstanteNomi() {
		return this.mostrarFK_IdTipoConstanteConstanteNomi;
	}

	public void setMostrarFK_IdTipoConstanteConstanteNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoConstanteConstanteNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaConstanteNomi=true;

	public Boolean getActivarFK_IdEmpresaConstanteNomi() {
		return this.activarFK_IdEmpresaConstanteNomi;
	}

	public void setActivarFK_IdEmpresaConstanteNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConstanteNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoConstanteConstanteNomi=true;

	public Boolean getActivarFK_IdTipoConstanteConstanteNomi() {
		return this.activarFK_IdTipoConstanteConstanteNomi;
	}

	public void setActivarFK_IdTipoConstanteConstanteNomi(Boolean habilitarResaltar) {
		this.activarFK_IdTipoConstanteConstanteNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaConstanteNomi=null;

	public Border getResaltarFK_IdEmpresaConstanteNomi() {
		return this.resaltarFK_IdEmpresaConstanteNomi;
	}

	public void setResaltarFK_IdEmpresaConstanteNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConstanteNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConstanteNomi= borderResaltar;
	}

	public Border resaltarFK_IdTipoConstanteConstanteNomi=null;

	public Border getResaltarFK_IdTipoConstanteConstanteNomi() {
		return this.resaltarFK_IdTipoConstanteConstanteNomi;
	}

	public void setResaltarFK_IdTipoConstanteConstanteNomi(Border borderResaltar) {
		this.resaltarFK_IdTipoConstanteConstanteNomi= borderResaltar;
	}

	public void setResaltarFK_IdTipoConstanteConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*ConstanteNomiBeanSwingJInternalFrame constantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoConstanteConstanteNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}