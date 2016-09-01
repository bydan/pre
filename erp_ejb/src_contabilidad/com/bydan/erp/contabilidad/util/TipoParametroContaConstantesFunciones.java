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


import com.bydan.erp.contabilidad.util.TipoParametroContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoParametroContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoParametroContaParameterGeneral;

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
final public class TipoParametroContaConstantesFunciones extends TipoParametroContaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParametroConta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParametroConta"+TipoParametroContaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParametroContaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParametroContaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParametroContaConstantesFunciones.SCHEMA+"_"+TipoParametroContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParametroContaConstantesFunciones.SCHEMA+"_"+TipoParametroContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParametroContaConstantesFunciones.SCHEMA+"_"+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParametroContaConstantesFunciones.SCHEMA+"_"+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParametroContaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParametroContaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParametroContaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParametroContaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Parametro Contas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Parametro Conta";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Parametro Conta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParametroConta";
	public static final String OBJECTNAME="tipoparametroconta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_parametro_conta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparametroconta from "+TipoParametroContaConstantesFunciones.SPERSISTENCENAME+" tipoparametroconta";
	public static String QUERYSELECTNATIVE="select "+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME+".id,"+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME+".version_row,"+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME+".id_empresa,"+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME+".codigo,"+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME+".nombre from "+TipoParametroContaConstantesFunciones.SCHEMA+"."+TipoParametroContaConstantesFunciones.TABLENAME;//+" as "+TipoParametroContaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParametroContaConstantesFuncionesAdditional tipoparametrocontaConstantesFuncionesAdditional=null;
	
	public TipoParametroContaConstantesFuncionesAdditional getTipoParametroContaConstantesFuncionesAdditional() {
		return this.tipoparametrocontaConstantesFuncionesAdditional;
	}
	
	public void setTipoParametroContaConstantesFuncionesAdditional(TipoParametroContaConstantesFuncionesAdditional tipoparametrocontaConstantesFuncionesAdditional) {
		try {
			this.tipoparametrocontaConstantesFuncionesAdditional=tipoparametrocontaConstantesFuncionesAdditional;
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
	
	public static String getTipoParametroContaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParametroContaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoParametroContaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoParametroContaConstantesFunciones.CODIGO)) {sLabelColumna=TipoParametroContaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoParametroContaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParametroContaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoParametroContaDescripcion(TipoParametroConta tipoparametroconta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparametroconta !=null/* && tipoparametroconta.getId()!=0*/) {
			sDescripcion=tipoparametroconta.getcodigo();//tipoparametrocontatipoparametroconta.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParametroContaDescripcionDetallado(TipoParametroConta tipoparametroconta) {
		String sDescripcion="";
			
		sDescripcion+=TipoParametroContaConstantesFunciones.ID+"=";
		sDescripcion+=tipoparametroconta.getId().toString()+",";
		sDescripcion+=TipoParametroContaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparametroconta.getVersionRow().toString()+",";
		sDescripcion+=TipoParametroContaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoparametroconta.getid_empresa().toString()+",";
		sDescripcion+=TipoParametroContaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoparametroconta.getcodigo()+",";
		sDescripcion+=TipoParametroContaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparametroconta.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParametroContaDescripcion(TipoParametroConta tipoparametroconta,String sValor) throws Exception {			
		if(tipoparametroconta !=null) {
			tipoparametroconta.setcodigo(sValor);;//tipoparametrocontatipoparametroconta.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoParametroConta(TipoParametroConta tipoparametroconta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparametroconta.setcodigo(tipoparametroconta.getcodigo().trim());
		tipoparametroconta.setnombre(tipoparametroconta.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoParametroContas(List<TipoParametroConta> tipoparametrocontas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParametroConta tipoparametroconta: tipoparametrocontas) {
			tipoparametroconta.setcodigo(tipoparametroconta.getcodigo().trim());
			tipoparametroconta.setnombre(tipoparametroconta.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParametroConta(TipoParametroConta tipoparametroconta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparametroconta.getConCambioAuxiliar()) {
			tipoparametroconta.setIsDeleted(tipoparametroconta.getIsDeletedAuxiliar());	
			tipoparametroconta.setIsNew(tipoparametroconta.getIsNewAuxiliar());	
			tipoparametroconta.setIsChanged(tipoparametroconta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparametroconta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparametroconta.setIsDeletedAuxiliar(false);	
			tipoparametroconta.setIsNewAuxiliar(false);	
			tipoparametroconta.setIsChangedAuxiliar(false);
			
			tipoparametroconta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParametroContas(List<TipoParametroConta> tipoparametrocontas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParametroConta tipoparametroconta : tipoparametrocontas) {
			if(conAsignarBase && tipoparametroconta.getConCambioAuxiliar()) {
				tipoparametroconta.setIsDeleted(tipoparametroconta.getIsDeletedAuxiliar());	
				tipoparametroconta.setIsNew(tipoparametroconta.getIsNewAuxiliar());	
				tipoparametroconta.setIsChanged(tipoparametroconta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparametroconta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparametroconta.setIsDeletedAuxiliar(false);	
				tipoparametroconta.setIsNewAuxiliar(false);	
				tipoparametroconta.setIsChangedAuxiliar(false);
				
				tipoparametroconta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParametroConta(TipoParametroConta tipoparametroconta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParametroContas(List<TipoParametroConta> tipoparametrocontas,Boolean conEnteros) throws Exception  {
		
		for(TipoParametroConta tipoparametroconta: tipoparametrocontas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParametroConta(List<TipoParametroConta> tipoparametrocontas,TipoParametroConta tipoparametrocontaAux) throws Exception  {
		TipoParametroContaConstantesFunciones.InicializarValoresTipoParametroConta(tipoparametrocontaAux,true);
		
		for(TipoParametroConta tipoparametroconta: tipoparametrocontas) {
			if(tipoparametroconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParametroConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParametroContaConstantesFunciones.getArrayColumnasGlobalesTipoParametroConta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParametroConta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoParametroContaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoParametroContaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParametroConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParametroConta> tipoparametrocontas,TipoParametroConta tipoparametroconta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParametroConta tipoparametrocontaAux: tipoparametrocontas) {
			if(tipoparametrocontaAux!=null && tipoparametroconta!=null) {
				if((tipoparametrocontaAux.getId()==null && tipoparametroconta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparametrocontaAux.getId()!=null && tipoparametroconta.getId()!=null){
					if(tipoparametrocontaAux.getId().equals(tipoparametroconta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParametroConta(List<TipoParametroConta> tipoparametrocontas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParametroConta tipoparametroconta: tipoparametrocontas) {			
			if(tipoparametroconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParametroConta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParametroContaConstantesFunciones.LABEL_ID, TipoParametroContaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroContaConstantesFunciones.LABEL_VERSIONROW, TipoParametroContaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroContaConstantesFunciones.LABEL_IDEMPRESA, TipoParametroContaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroContaConstantesFunciones.LABEL_CODIGO, TipoParametroContaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroContaConstantesFunciones.LABEL_NOMBRE, TipoParametroContaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParametroConta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParametroContaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroContaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroContaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroContaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroContaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroConta() throws Exception  {
		return TipoParametroContaConstantesFunciones.getTiposSeleccionarTipoParametroConta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroConta(Boolean conFk) throws Exception  {
		return TipoParametroContaConstantesFunciones.getTiposSeleccionarTipoParametroConta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroConta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParametroContaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoParametroContaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParametroContaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoParametroContaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParametroContaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParametroContaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParametroConta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParametroConta(TipoParametroConta tipoparametrocontaAux) throws Exception {
		
			tipoparametrocontaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoparametrocontaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParametroConta(List<TipoParametroConta> tipoparametrocontasTemp) throws Exception {
		for(TipoParametroConta tipoparametrocontaAux:tipoparametrocontasTemp) {
			
			tipoparametrocontaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoparametrocontaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParametroContaConstantesFunciones.getClassesRelationshipsOfTipoParametroConta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroContaDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroContaDetalle.class)) {
						classes.add(new Classe(ParametroContaDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParametroContaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParametroConta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContaDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContaDetalle.class)); continue;
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
	public static void actualizarLista(TipoParametroConta tipoparametroconta,List<TipoParametroConta> tipoparametrocontas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParametroConta tipoparametrocontaEncontrado=null;
			
			for(TipoParametroConta tipoparametrocontaLocal:tipoparametrocontas) {
				if(tipoparametrocontaLocal.getId().equals(tipoparametroconta.getId())) {
					tipoparametrocontaEncontrado=tipoparametrocontaLocal;
					
					tipoparametrocontaLocal.setIsChanged(tipoparametroconta.getIsChanged());
					tipoparametrocontaLocal.setIsNew(tipoparametroconta.getIsNew());
					tipoparametrocontaLocal.setIsDeleted(tipoparametroconta.getIsDeleted());
					
					tipoparametrocontaLocal.setGeneralEntityOriginal(tipoparametroconta.getGeneralEntityOriginal());
					
					tipoparametrocontaLocal.setId(tipoparametroconta.getId());	
					tipoparametrocontaLocal.setVersionRow(tipoparametroconta.getVersionRow());	
					tipoparametrocontaLocal.setid_empresa(tipoparametroconta.getid_empresa());	
					tipoparametrocontaLocal.setcodigo(tipoparametroconta.getcodigo());	
					tipoparametrocontaLocal.setnombre(tipoparametroconta.getnombre());	
					
					
					tipoparametrocontaLocal.setParametroContaDetalles(tipoparametroconta.getParametroContaDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparametroconta.getIsDeleted()) {
				if(!existe) {
					tipoparametrocontas.add(tipoparametroconta);
				}
			} else {
				if(tipoparametrocontaEncontrado!=null && permiteQuitar)  {
					tipoparametrocontas.remove(tipoparametrocontaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParametroConta tipoparametroconta,List<TipoParametroConta> tipoparametrocontas) throws Exception {
		try	{			
			for(TipoParametroConta tipoparametrocontaLocal:tipoparametrocontas) {
				if(tipoparametrocontaLocal.getId().equals(tipoparametroconta.getId())) {
					tipoparametrocontaLocal.setIsSelected(tipoparametroconta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParametroConta(List<TipoParametroConta> tipoparametrocontasAux) throws Exception {
		//this.tipoparametrocontasAux=tipoparametrocontasAux;
		
		for(TipoParametroConta tipoparametrocontaAux:tipoparametrocontasAux) {
			if(tipoparametrocontaAux.getIsChanged()) {
				tipoparametrocontaAux.setIsChanged(false);
			}		
			
			if(tipoparametrocontaAux.getIsNew()) {
				tipoparametrocontaAux.setIsNew(false);
			}	
			
			if(tipoparametrocontaAux.getIsDeleted()) {
				tipoparametrocontaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParametroConta(TipoParametroConta tipoparametrocontaAux) throws Exception {
		//this.tipoparametrocontaAux=tipoparametrocontaAux;
		
			if(tipoparametrocontaAux.getIsChanged()) {
				tipoparametrocontaAux.setIsChanged(false);
			}		
			
			if(tipoparametrocontaAux.getIsNew()) {
				tipoparametrocontaAux.setIsNew(false);
			}	
			
			if(tipoparametrocontaAux.getIsDeleted()) {
				tipoparametrocontaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParametroConta tipoparametrocontaAsignar,TipoParametroConta tipoparametroconta) throws Exception {
		tipoparametrocontaAsignar.setId(tipoparametroconta.getId());	
		tipoparametrocontaAsignar.setVersionRow(tipoparametroconta.getVersionRow());	
		tipoparametrocontaAsignar.setid_empresa(tipoparametroconta.getid_empresa());
		tipoparametrocontaAsignar.setempresa_descripcion(tipoparametroconta.getempresa_descripcion());	
		tipoparametrocontaAsignar.setcodigo(tipoparametroconta.getcodigo());	
		tipoparametrocontaAsignar.setnombre(tipoparametroconta.getnombre());	
	}
	
	public static void inicializarTipoParametroConta(TipoParametroConta tipoparametroconta) throws Exception {
		try {
				tipoparametroconta.setId(0L);	
					
				tipoparametroconta.setid_empresa(-1L);	
				tipoparametroconta.setcodigo("");	
				tipoparametroconta.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParametroConta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParametroContaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParametroContaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParametroContaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParametroConta(String sTipo,Row row,Workbook workbook,TipoParametroConta tipoparametroconta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparametroconta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparametroconta.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparametroconta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParametroConta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParametroConta() {
		return this.sFinalQueryTipoParametroConta;
	}
	
	public void setsFinalQueryTipoParametroConta(String sFinalQueryTipoParametroConta) {
		this.sFinalQueryTipoParametroConta= sFinalQueryTipoParametroConta;
	}
	
	public Border resaltarSeleccionarTipoParametroConta=null;
	
	public Border setResaltarSeleccionarTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParametroConta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParametroConta() {
		return this.resaltarSeleccionarTipoParametroConta;
	}
	
	public void setResaltarSeleccionarTipoParametroConta(Border borderResaltarSeleccionarTipoParametroConta) {
		this.resaltarSeleccionarTipoParametroConta= borderResaltarSeleccionarTipoParametroConta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParametroConta=null;
	public Boolean mostraridTipoParametroConta=true;
	public Boolean activaridTipoParametroConta=true;

	public Border resaltarid_empresaTipoParametroConta=null;
	public Boolean mostrarid_empresaTipoParametroConta=true;
	public Boolean activarid_empresaTipoParametroConta=true;
	public Boolean cargarid_empresaTipoParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoParametroConta=false;//ConEventDepend=true

	public Border resaltarcodigoTipoParametroConta=null;
	public Boolean mostrarcodigoTipoParametroConta=true;
	public Boolean activarcodigoTipoParametroConta=true;

	public Border resaltarnombreTipoParametroConta=null;
	public Boolean mostrarnombreTipoParametroConta=true;
	public Boolean activarnombreTipoParametroConta=true;

	
	

	public Border setResaltaridTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltar);
		
		this.resaltaridTipoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParametroConta() {
		return this.resaltaridTipoParametroConta;
	}

	public void setResaltaridTipoParametroConta(Border borderResaltar) {
		this.resaltaridTipoParametroConta= borderResaltar;
	}

	public Boolean getMostraridTipoParametroConta() {
		return this.mostraridTipoParametroConta;
	}

	public void setMostraridTipoParametroConta(Boolean mostraridTipoParametroConta) {
		this.mostraridTipoParametroConta= mostraridTipoParametroConta;
	}

	public Boolean getActivaridTipoParametroConta() {
		return this.activaridTipoParametroConta;
	}

	public void setActivaridTipoParametroConta(Boolean activaridTipoParametroConta) {
		this.activaridTipoParametroConta= activaridTipoParametroConta;
	}

	public Border setResaltarid_empresaTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoParametroConta() {
		return this.resaltarid_empresaTipoParametroConta;
	}

	public void setResaltarid_empresaTipoParametroConta(Border borderResaltar) {
		this.resaltarid_empresaTipoParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoParametroConta() {
		return this.mostrarid_empresaTipoParametroConta;
	}

	public void setMostrarid_empresaTipoParametroConta(Boolean mostrarid_empresaTipoParametroConta) {
		this.mostrarid_empresaTipoParametroConta= mostrarid_empresaTipoParametroConta;
	}

	public Boolean getActivarid_empresaTipoParametroConta() {
		return this.activarid_empresaTipoParametroConta;
	}

	public void setActivarid_empresaTipoParametroConta(Boolean activarid_empresaTipoParametroConta) {
		this.activarid_empresaTipoParametroConta= activarid_empresaTipoParametroConta;
	}

	public Boolean getCargarid_empresaTipoParametroConta() {
		return this.cargarid_empresaTipoParametroConta;
	}

	public void setCargarid_empresaTipoParametroConta(Boolean cargarid_empresaTipoParametroConta) {
		this.cargarid_empresaTipoParametroConta= cargarid_empresaTipoParametroConta;
	}

	public Border setResaltarcodigoTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoParametroConta() {
		return this.resaltarcodigoTipoParametroConta;
	}

	public void setResaltarcodigoTipoParametroConta(Border borderResaltar) {
		this.resaltarcodigoTipoParametroConta= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoParametroConta() {
		return this.mostrarcodigoTipoParametroConta;
	}

	public void setMostrarcodigoTipoParametroConta(Boolean mostrarcodigoTipoParametroConta) {
		this.mostrarcodigoTipoParametroConta= mostrarcodigoTipoParametroConta;
	}

	public Boolean getActivarcodigoTipoParametroConta() {
		return this.activarcodigoTipoParametroConta;
	}

	public void setActivarcodigoTipoParametroConta(Boolean activarcodigoTipoParametroConta) {
		this.activarcodigoTipoParametroConta= activarcodigoTipoParametroConta;
	}

	public Border setResaltarnombreTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParametroConta() {
		return this.resaltarnombreTipoParametroConta;
	}

	public void setResaltarnombreTipoParametroConta(Border borderResaltar) {
		this.resaltarnombreTipoParametroConta= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParametroConta() {
		return this.mostrarnombreTipoParametroConta;
	}

	public void setMostrarnombreTipoParametroConta(Boolean mostrarnombreTipoParametroConta) {
		this.mostrarnombreTipoParametroConta= mostrarnombreTipoParametroConta;
	}

	public Boolean getActivarnombreTipoParametroConta() {
		return this.activarnombreTipoParametroConta;
	}

	public void setActivarnombreTipoParametroConta(Boolean activarnombreTipoParametroConta) {
		this.activarnombreTipoParametroConta= activarnombreTipoParametroConta;
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
		
		
		this.setMostraridTipoParametroConta(esInicial);
		this.setMostrarid_empresaTipoParametroConta(esInicial);
		this.setMostrarcodigoTipoParametroConta(esInicial);
		this.setMostrarnombreTipoParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.ID)) {
				this.setMostraridTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParametroConta(esAsigna);
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
		
		
		this.setActivaridTipoParametroConta(esInicial);
		this.setActivarid_empresaTipoParametroConta(esInicial);
		this.setActivarcodigoTipoParametroConta(esInicial);
		this.setActivarnombreTipoParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.ID)) {
				this.setActivaridTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParametroConta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParametroConta(esInicial);
		this.setResaltarid_empresaTipoParametroConta(esInicial);
		this.setResaltarcodigoTipoParametroConta(esInicial);
		this.setResaltarnombreTipoParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.ID)) {
				this.setResaltaridTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroContaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParametroConta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroContaDetalleTipoParametroConta=null;

	public Border getResaltarParametroContaDetalleTipoParametroConta() {
		return this.resaltarParametroContaDetalleTipoParametroConta;
	}

	public void setResaltarParametroContaDetalleTipoParametroConta(Border borderResaltarParametroContaDetalle) {
		if(borderResaltarParametroContaDetalle!=null) {
			this.resaltarParametroContaDetalleTipoParametroConta= borderResaltarParametroContaDetalle;
		}
	}

	public Border setResaltarParametroContaDetalleTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroContaDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoparametrocontaBeanSwingJInternalFrame.jTtoolBarTipoParametroConta.setBorder(borderResaltarParametroContaDetalle);
			
		this.resaltarParametroContaDetalleTipoParametroConta= borderResaltarParametroContaDetalle;

		 return borderResaltarParametroContaDetalle;
	}



	public Boolean mostrarParametroContaDetalleTipoParametroConta=true;

	public Boolean getMostrarParametroContaDetalleTipoParametroConta() {
		return this.mostrarParametroContaDetalleTipoParametroConta;
	}

	public void setMostrarParametroContaDetalleTipoParametroConta(Boolean visibilidadResaltarParametroContaDetalle) {
		this.mostrarParametroContaDetalleTipoParametroConta= visibilidadResaltarParametroContaDetalle;
	}



	public Boolean activarParametroContaDetalleTipoParametroConta=true;

	public Boolean gethabilitarResaltarParametroContaDetalleTipoParametroConta() {
		return this.activarParametroContaDetalleTipoParametroConta;
	}

	public void setActivarParametroContaDetalleTipoParametroConta(Boolean habilitarResaltarParametroContaDetalle) {
		this.activarParametroContaDetalleTipoParametroConta= habilitarResaltarParametroContaDetalle;
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

		this.setMostrarParametroContaDetalleTipoParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setMostrarParametroContaDetalleTipoParametroConta(esAsigna);
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

		this.setActivarParametroContaDetalleTipoParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setActivarParametroContaDetalleTipoParametroConta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroContaDetalleTipoParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setResaltarParametroContaDetalleTipoParametroConta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoParametroConta=true;

	public Boolean getMostrarFK_IdEmpresaTipoParametroConta() {
		return this.mostrarFK_IdEmpresaTipoParametroConta;
	}

	public void setMostrarFK_IdEmpresaTipoParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoParametroConta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoParametroConta=true;

	public Boolean getActivarFK_IdEmpresaTipoParametroConta() {
		return this.activarFK_IdEmpresaTipoParametroConta;
	}

	public void setActivarFK_IdEmpresaTipoParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoParametroConta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoParametroConta=null;

	public Border getResaltarFK_IdEmpresaTipoParametroConta() {
		return this.resaltarFK_IdEmpresaTipoParametroConta;
	}

	public void setResaltarFK_IdEmpresaTipoParametroConta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroContaBeanSwingJInternalFrame tipoparametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoParametroConta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}