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


import com.bydan.erp.nomina.util.TipoCuotaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCuotaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCuotaConstantesFunciones extends TipoCuotaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCuota";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCuota"+TipoCuotaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCuotaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCuotaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCuotaConstantesFunciones.SCHEMA+"_"+TipoCuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCuotaConstantesFunciones.SCHEMA+"_"+TipoCuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCuotaConstantesFunciones.SCHEMA+"_"+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCuotaConstantesFunciones.SCHEMA+"_"+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCuotaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCuotaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCuotaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCuotaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuotas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cuota";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cuota";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCuota";
	public static final String OBJECTNAME="tipocuota";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_cuota";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocuota from "+TipoCuotaConstantesFunciones.SPERSISTENCENAME+" tipocuota";
	public static String QUERYSELECTNATIVE="select "+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".id,"+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".version_row,"+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".id_empresa,"+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".codigo,"+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".nombre,"+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME+".es_prove from "+TipoCuotaConstantesFunciones.SCHEMA+"."+TipoCuotaConstantesFunciones.TABLENAME;//+" as "+TipoCuotaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCuotaConstantesFuncionesAdditional tipocuotaConstantesFuncionesAdditional=null;
	
	public TipoCuotaConstantesFuncionesAdditional getTipoCuotaConstantesFuncionesAdditional() {
		return this.tipocuotaConstantesFuncionesAdditional;
	}
	
	public void setTipoCuotaConstantesFuncionesAdditional(TipoCuotaConstantesFuncionesAdditional tipocuotaConstantesFuncionesAdditional) {
		try {
			this.tipocuotaConstantesFuncionesAdditional=tipocuotaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESPROVE= "es_prove";
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
    	public static final String LABEL_ESPROVE= "Es Prove";
		public static final String LABEL_ESPROVE_LOWER= "Es Prove";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoCuotaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCuotaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCuotaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCuotaConstantesFunciones.CODIGO)) {sLabelColumna=TipoCuotaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCuotaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCuotaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoCuotaConstantesFunciones.ESPROVE)) {sLabelColumna=TipoCuotaConstantesFunciones.LABEL_ESPROVE;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_proveDescripcion(TipoCuota tipocuota) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipocuota.getes_prove()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveHtmlDescripcion(TipoCuota tipocuota) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipocuota.getId(),tipocuota.getes_prove());

		return sDescripcion;
	}	
	
	public static String getTipoCuotaDescripcion(TipoCuota tipocuota) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocuota !=null/* && tipocuota.getId()!=0*/) {
			sDescripcion=tipocuota.getcodigo();//tipocuotatipocuota.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCuotaDescripcionDetallado(TipoCuota tipocuota) {
		String sDescripcion="";
			
		sDescripcion+=TipoCuotaConstantesFunciones.ID+"=";
		sDescripcion+=tipocuota.getId().toString()+",";
		sDescripcion+=TipoCuotaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocuota.getVersionRow().toString()+",";
		sDescripcion+=TipoCuotaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocuota.getid_empresa().toString()+",";
		sDescripcion+=TipoCuotaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocuota.getcodigo()+",";
		sDescripcion+=TipoCuotaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocuota.getnombre()+",";
		sDescripcion+=TipoCuotaConstantesFunciones.ESPROVE+"=";
		sDescripcion+=tipocuota.getes_prove().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCuotaDescripcion(TipoCuota tipocuota,String sValor) throws Exception {			
		if(tipocuota !=null) {
			tipocuota.setcodigo(sValor);;//tipocuotatipocuota.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCuota(TipoCuota tipocuota,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocuota.setcodigo(tipocuota.getcodigo().trim());
		tipocuota.setnombre(tipocuota.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCuotas(List<TipoCuota> tipocuotas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCuota tipocuota: tipocuotas) {
			tipocuota.setcodigo(tipocuota.getcodigo().trim());
			tipocuota.setnombre(tipocuota.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuota(TipoCuota tipocuota,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocuota.getConCambioAuxiliar()) {
			tipocuota.setIsDeleted(tipocuota.getIsDeletedAuxiliar());	
			tipocuota.setIsNew(tipocuota.getIsNewAuxiliar());	
			tipocuota.setIsChanged(tipocuota.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocuota.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocuota.setIsDeletedAuxiliar(false);	
			tipocuota.setIsNewAuxiliar(false);	
			tipocuota.setIsChangedAuxiliar(false);
			
			tipocuota.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuotas(List<TipoCuota> tipocuotas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCuota tipocuota : tipocuotas) {
			if(conAsignarBase && tipocuota.getConCambioAuxiliar()) {
				tipocuota.setIsDeleted(tipocuota.getIsDeletedAuxiliar());	
				tipocuota.setIsNew(tipocuota.getIsNewAuxiliar());	
				tipocuota.setIsChanged(tipocuota.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocuota.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocuota.setIsDeletedAuxiliar(false);	
				tipocuota.setIsNewAuxiliar(false);	
				tipocuota.setIsChangedAuxiliar(false);
				
				tipocuota.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCuota(TipoCuota tipocuota,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCuotas(List<TipoCuota> tipocuotas,Boolean conEnteros) throws Exception  {
		
		for(TipoCuota tipocuota: tipocuotas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCuota(List<TipoCuota> tipocuotas,TipoCuota tipocuotaAux) throws Exception  {
		TipoCuotaConstantesFunciones.InicializarValoresTipoCuota(tipocuotaAux,true);
		
		for(TipoCuota tipocuota: tipocuotas) {
			if(tipocuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCuotaConstantesFunciones.getArrayColumnasGlobalesTipoCuota(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuota(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCuotaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCuotaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCuota> tipocuotas,TipoCuota tipocuota,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCuota tipocuotaAux: tipocuotas) {
			if(tipocuotaAux!=null && tipocuota!=null) {
				if((tipocuotaAux.getId()==null && tipocuota.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocuotaAux.getId()!=null && tipocuota.getId()!=null){
					if(tipocuotaAux.getId().equals(tipocuota.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCuota(List<TipoCuota> tipocuotas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCuota tipocuota: tipocuotas) {			
			if(tipocuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCuota() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_ID, TipoCuotaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_VERSIONROW, TipoCuotaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_IDEMPRESA, TipoCuotaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_CODIGO, TipoCuotaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_NOMBRE, TipoCuotaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuotaConstantesFunciones.LABEL_ESPROVE, TipoCuotaConstantesFunciones.ESPROVE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCuota() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuotaConstantesFunciones.ESPROVE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuota() throws Exception  {
		return TipoCuotaConstantesFunciones.getTiposSeleccionarTipoCuota(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuota(Boolean conFk) throws Exception  {
		return TipoCuotaConstantesFunciones.getTiposSeleccionarTipoCuota(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuota(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuotaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCuotaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuotaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCuotaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuotaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCuotaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuotaConstantesFunciones.LABEL_ESPROVE);
			reporte.setsDescripcion(TipoCuotaConstantesFunciones.LABEL_ESPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCuota(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuota(TipoCuota tipocuotaAux) throws Exception {
		
			tipocuotaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuotaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuota(List<TipoCuota> tipocuotasTemp) throws Exception {
		for(TipoCuota tipocuotaAux:tipocuotasTemp) {
			
			tipocuotaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuotaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuotaConstantesFunciones.getClassesRelationshipsOfTipoCuota(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Prestamo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuotaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCuota(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
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
	public static void actualizarLista(TipoCuota tipocuota,List<TipoCuota> tipocuotas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCuota tipocuotaEncontrado=null;
			
			for(TipoCuota tipocuotaLocal:tipocuotas) {
				if(tipocuotaLocal.getId().equals(tipocuota.getId())) {
					tipocuotaEncontrado=tipocuotaLocal;
					
					tipocuotaLocal.setIsChanged(tipocuota.getIsChanged());
					tipocuotaLocal.setIsNew(tipocuota.getIsNew());
					tipocuotaLocal.setIsDeleted(tipocuota.getIsDeleted());
					
					tipocuotaLocal.setGeneralEntityOriginal(tipocuota.getGeneralEntityOriginal());
					
					tipocuotaLocal.setId(tipocuota.getId());	
					tipocuotaLocal.setVersionRow(tipocuota.getVersionRow());	
					tipocuotaLocal.setid_empresa(tipocuota.getid_empresa());	
					tipocuotaLocal.setcodigo(tipocuota.getcodigo());	
					tipocuotaLocal.setnombre(tipocuota.getnombre());	
					tipocuotaLocal.setes_prove(tipocuota.getes_prove());	
					
					
					tipocuotaLocal.setPrestamos(tipocuota.getPrestamos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocuota.getIsDeleted()) {
				if(!existe) {
					tipocuotas.add(tipocuota);
				}
			} else {
				if(tipocuotaEncontrado!=null && permiteQuitar)  {
					tipocuotas.remove(tipocuotaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCuota tipocuota,List<TipoCuota> tipocuotas) throws Exception {
		try	{			
			for(TipoCuota tipocuotaLocal:tipocuotas) {
				if(tipocuotaLocal.getId().equals(tipocuota.getId())) {
					tipocuotaLocal.setIsSelected(tipocuota.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCuota(List<TipoCuota> tipocuotasAux) throws Exception {
		//this.tipocuotasAux=tipocuotasAux;
		
		for(TipoCuota tipocuotaAux:tipocuotasAux) {
			if(tipocuotaAux.getIsChanged()) {
				tipocuotaAux.setIsChanged(false);
			}		
			
			if(tipocuotaAux.getIsNew()) {
				tipocuotaAux.setIsNew(false);
			}	
			
			if(tipocuotaAux.getIsDeleted()) {
				tipocuotaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCuota(TipoCuota tipocuotaAux) throws Exception {
		//this.tipocuotaAux=tipocuotaAux;
		
			if(tipocuotaAux.getIsChanged()) {
				tipocuotaAux.setIsChanged(false);
			}		
			
			if(tipocuotaAux.getIsNew()) {
				tipocuotaAux.setIsNew(false);
			}	
			
			if(tipocuotaAux.getIsDeleted()) {
				tipocuotaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCuota tipocuotaAsignar,TipoCuota tipocuota) throws Exception {
		tipocuotaAsignar.setId(tipocuota.getId());	
		tipocuotaAsignar.setVersionRow(tipocuota.getVersionRow());	
		tipocuotaAsignar.setid_empresa(tipocuota.getid_empresa());
		tipocuotaAsignar.setempresa_descripcion(tipocuota.getempresa_descripcion());	
		tipocuotaAsignar.setcodigo(tipocuota.getcodigo());	
		tipocuotaAsignar.setnombre(tipocuota.getnombre());	
		tipocuotaAsignar.setes_prove(tipocuota.getes_prove());	
	}
	
	public static void inicializarTipoCuota(TipoCuota tipocuota) throws Exception {
		try {
				tipocuota.setId(0L);	
					
				tipocuota.setid_empresa(-1L);	
				tipocuota.setcodigo("");	
				tipocuota.setnombre("");	
				tipocuota.setes_prove(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCuota(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuotaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuotaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuotaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuotaConstantesFunciones.LABEL_ESPROVE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCuota(String sTipo,Row row,Workbook workbook,TipoCuota tipocuota,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuota.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuota.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuota.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipocuota.getes_prove()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCuota=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCuota() {
		return this.sFinalQueryTipoCuota;
	}
	
	public void setsFinalQueryTipoCuota(String sFinalQueryTipoCuota) {
		this.sFinalQueryTipoCuota= sFinalQueryTipoCuota;
	}
	
	public Border resaltarSeleccionarTipoCuota=null;
	
	public Border setResaltarSeleccionarTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCuota= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCuota() {
		return this.resaltarSeleccionarTipoCuota;
	}
	
	public void setResaltarSeleccionarTipoCuota(Border borderResaltarSeleccionarTipoCuota) {
		this.resaltarSeleccionarTipoCuota= borderResaltarSeleccionarTipoCuota;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCuota=null;
	public Boolean mostraridTipoCuota=true;
	public Boolean activaridTipoCuota=true;

	public Border resaltarid_empresaTipoCuota=null;
	public Boolean mostrarid_empresaTipoCuota=true;
	public Boolean activarid_empresaTipoCuota=true;
	public Boolean cargarid_empresaTipoCuota=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCuota=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCuota=null;
	public Boolean mostrarcodigoTipoCuota=true;
	public Boolean activarcodigoTipoCuota=true;

	public Border resaltarnombreTipoCuota=null;
	public Boolean mostrarnombreTipoCuota=true;
	public Boolean activarnombreTipoCuota=true;

	public Border resaltares_proveTipoCuota=null;
	public Boolean mostrares_proveTipoCuota=true;
	public Boolean activares_proveTipoCuota=true;

	
	

	public Border setResaltaridTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltaridTipoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCuota() {
		return this.resaltaridTipoCuota;
	}

	public void setResaltaridTipoCuota(Border borderResaltar) {
		this.resaltaridTipoCuota= borderResaltar;
	}

	public Boolean getMostraridTipoCuota() {
		return this.mostraridTipoCuota;
	}

	public void setMostraridTipoCuota(Boolean mostraridTipoCuota) {
		this.mostraridTipoCuota= mostraridTipoCuota;
	}

	public Boolean getActivaridTipoCuota() {
		return this.activaridTipoCuota;
	}

	public void setActivaridTipoCuota(Boolean activaridTipoCuota) {
		this.activaridTipoCuota= activaridTipoCuota;
	}

	public Border setResaltarid_empresaTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCuota() {
		return this.resaltarid_empresaTipoCuota;
	}

	public void setResaltarid_empresaTipoCuota(Border borderResaltar) {
		this.resaltarid_empresaTipoCuota= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCuota() {
		return this.mostrarid_empresaTipoCuota;
	}

	public void setMostrarid_empresaTipoCuota(Boolean mostrarid_empresaTipoCuota) {
		this.mostrarid_empresaTipoCuota= mostrarid_empresaTipoCuota;
	}

	public Boolean getActivarid_empresaTipoCuota() {
		return this.activarid_empresaTipoCuota;
	}

	public void setActivarid_empresaTipoCuota(Boolean activarid_empresaTipoCuota) {
		this.activarid_empresaTipoCuota= activarid_empresaTipoCuota;
	}

	public Boolean getCargarid_empresaTipoCuota() {
		return this.cargarid_empresaTipoCuota;
	}

	public void setCargarid_empresaTipoCuota(Boolean cargarid_empresaTipoCuota) {
		this.cargarid_empresaTipoCuota= cargarid_empresaTipoCuota;
	}

	public Border setResaltarcodigoTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCuota() {
		return this.resaltarcodigoTipoCuota;
	}

	public void setResaltarcodigoTipoCuota(Border borderResaltar) {
		this.resaltarcodigoTipoCuota= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCuota() {
		return this.mostrarcodigoTipoCuota;
	}

	public void setMostrarcodigoTipoCuota(Boolean mostrarcodigoTipoCuota) {
		this.mostrarcodigoTipoCuota= mostrarcodigoTipoCuota;
	}

	public Boolean getActivarcodigoTipoCuota() {
		return this.activarcodigoTipoCuota;
	}

	public void setActivarcodigoTipoCuota(Boolean activarcodigoTipoCuota) {
		this.activarcodigoTipoCuota= activarcodigoTipoCuota;
	}

	public Border setResaltarnombreTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCuota() {
		return this.resaltarnombreTipoCuota;
	}

	public void setResaltarnombreTipoCuota(Border borderResaltar) {
		this.resaltarnombreTipoCuota= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCuota() {
		return this.mostrarnombreTipoCuota;
	}

	public void setMostrarnombreTipoCuota(Boolean mostrarnombreTipoCuota) {
		this.mostrarnombreTipoCuota= mostrarnombreTipoCuota;
	}

	public Boolean getActivarnombreTipoCuota() {
		return this.activarnombreTipoCuota;
	}

	public void setActivarnombreTipoCuota(Boolean activarnombreTipoCuota) {
		this.activarnombreTipoCuota= activarnombreTipoCuota;
	}

	public Border setResaltares_proveTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltar);
		
		this.resaltares_proveTipoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveTipoCuota() {
		return this.resaltares_proveTipoCuota;
	}

	public void setResaltares_proveTipoCuota(Border borderResaltar) {
		this.resaltares_proveTipoCuota= borderResaltar;
	}

	public Boolean getMostrares_proveTipoCuota() {
		return this.mostrares_proveTipoCuota;
	}

	public void setMostrares_proveTipoCuota(Boolean mostrares_proveTipoCuota) {
		this.mostrares_proveTipoCuota= mostrares_proveTipoCuota;
	}

	public Boolean getActivares_proveTipoCuota() {
		return this.activares_proveTipoCuota;
	}

	public void setActivares_proveTipoCuota(Boolean activares_proveTipoCuota) {
		this.activares_proveTipoCuota= activares_proveTipoCuota;
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
		
		
		this.setMostraridTipoCuota(esInicial);
		this.setMostrarid_empresaTipoCuota(esInicial);
		this.setMostrarcodigoTipoCuota(esInicial);
		this.setMostrarnombreTipoCuota(esInicial);
		this.setMostrares_proveTipoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ID)) {
				this.setMostraridTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ESPROVE)) {
				this.setMostrares_proveTipoCuota(esAsigna);
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
		
		
		this.setActivaridTipoCuota(esInicial);
		this.setActivarid_empresaTipoCuota(esInicial);
		this.setActivarcodigoTipoCuota(esInicial);
		this.setActivarnombreTipoCuota(esInicial);
		this.setActivares_proveTipoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ID)) {
				this.setActivaridTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ESPROVE)) {
				this.setActivares_proveTipoCuota(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCuota(esInicial);
		this.setResaltarid_empresaTipoCuota(esInicial);
		this.setResaltarcodigoTipoCuota(esInicial);
		this.setResaltarnombreTipoCuota(esInicial);
		this.setResaltares_proveTipoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ID)) {
				this.setResaltaridTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuotaConstantesFunciones.ESPROVE)) {
				this.setResaltares_proveTipoCuota(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPrestamoTipoCuota=null;

	public Border getResaltarPrestamoTipoCuota() {
		return this.resaltarPrestamoTipoCuota;
	}

	public void setResaltarPrestamoTipoCuota(Border borderResaltarPrestamo) {
		if(borderResaltarPrestamo!=null) {
			this.resaltarPrestamoTipoCuota= borderResaltarPrestamo;
		}
	}

	public Border setResaltarPrestamoTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltarPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuotaBeanSwingJInternalFrame.jTtoolBarTipoCuota.setBorder(borderResaltarPrestamo);
			
		this.resaltarPrestamoTipoCuota= borderResaltarPrestamo;

		 return borderResaltarPrestamo;
	}



	public Boolean mostrarPrestamoTipoCuota=true;

	public Boolean getMostrarPrestamoTipoCuota() {
		return this.mostrarPrestamoTipoCuota;
	}

	public void setMostrarPrestamoTipoCuota(Boolean visibilidadResaltarPrestamo) {
		this.mostrarPrestamoTipoCuota= visibilidadResaltarPrestamo;
	}



	public Boolean activarPrestamoTipoCuota=true;

	public Boolean gethabilitarResaltarPrestamoTipoCuota() {
		return this.activarPrestamoTipoCuota;
	}

	public void setActivarPrestamoTipoCuota(Boolean habilitarResaltarPrestamo) {
		this.activarPrestamoTipoCuota= habilitarResaltarPrestamo;
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

		this.setMostrarPrestamoTipoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setMostrarPrestamoTipoCuota(esAsigna);
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

		this.setActivarPrestamoTipoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setActivarPrestamoTipoCuota(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPrestamoTipoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setResaltarPrestamoTipoCuota(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoCuota=true;

	public Boolean getMostrarFK_IdEmpresaTipoCuota() {
		return this.mostrarFK_IdEmpresaTipoCuota;
	}

	public void setMostrarFK_IdEmpresaTipoCuota(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCuota= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCuota=true;

	public Boolean getActivarFK_IdEmpresaTipoCuota() {
		return this.activarFK_IdEmpresaTipoCuota;
	}

	public void setActivarFK_IdEmpresaTipoCuota(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCuota= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCuota=null;

	public Border getResaltarFK_IdEmpresaTipoCuota() {
		return this.resaltarFK_IdEmpresaTipoCuota;
	}

	public void setResaltarFK_IdEmpresaTipoCuota(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCuota= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuotaBeanSwingJInternalFrame tipocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCuota= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}