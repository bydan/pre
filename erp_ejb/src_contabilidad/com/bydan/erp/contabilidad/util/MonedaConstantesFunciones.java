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


import com.bydan.erp.contabilidad.util.MonedaConstantesFunciones;
import com.bydan.erp.contabilidad.util.MonedaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.MonedaParameterGeneral;

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
final public class MonedaConstantesFunciones extends MonedaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Moneda";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Moneda"+MonedaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MonedaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MonedaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MonedaConstantesFunciones.SCHEMA+"_"+MonedaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MonedaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MonedaConstantesFunciones.SCHEMA+"_"+MonedaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MonedaConstantesFunciones.SCHEMA+"_"+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MonedaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MonedaConstantesFunciones.SCHEMA+"_"+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MonedaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MonedaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MonedaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MonedaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MonedaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MonedaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Monedas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Moneda";
	public static final String SCLASSWEBTITULO_LOWER="Moneda";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Moneda";
	public static final String OBJECTNAME="moneda";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="moneda";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select moneda from "+MonedaConstantesFunciones.SPERSISTENCENAME+" moneda";
	public static String QUERYSELECTNATIVE="select "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".id,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".version_row,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".id_empresa,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".nombre,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".sigla,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".simbolo,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".esta_activo from "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME;//+" as "+MonedaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MonedaConstantesFuncionesAdditional monedaConstantesFuncionesAdditional=null;
	
	public MonedaConstantesFuncionesAdditional getMonedaConstantesFuncionesAdditional() {
		return this.monedaConstantesFuncionesAdditional;
	}
	
	public void setMonedaConstantesFuncionesAdditional(MonedaConstantesFuncionesAdditional monedaConstantesFuncionesAdditional) {
		try {
			this.monedaConstantesFuncionesAdditional=monedaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String SIGLA= "sigla";
    public static final String SIMBOLO= "simbolo";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLA= "Sigla";
		public static final String LABEL_SIGLA_LOWER= "Sigla";
    	public static final String LABEL_SIMBOLO= "Simbolo";
		public static final String LABEL_SIMBOLO_LOWER= "Simbolo";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "esta Activo";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIMBOLO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIMBOLO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getMonedaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MonedaConstantesFunciones.IDEMPRESA)) {sLabelColumna=MonedaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MonedaConstantesFunciones.NOMBRE)) {sLabelColumna=MonedaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(MonedaConstantesFunciones.SIGLA)) {sLabelColumna=MonedaConstantesFunciones.LABEL_SIGLA;}
		if(sNombreColumna.equals(MonedaConstantesFunciones.SIMBOLO)) {sLabelColumna=MonedaConstantesFunciones.LABEL_SIMBOLO;}
		if(sNombreColumna.equals(MonedaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=MonedaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(Moneda moneda) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!moneda.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Moneda moneda) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(moneda.getId(),moneda.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(moneda !=null/* && moneda.getId()!=0*/) {
			sDescripcion=moneda.getnombre();//monedamoneda.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMonedaDescripcionDetallado(Moneda moneda) {
		String sDescripcion="";
			
		sDescripcion+=MonedaConstantesFunciones.ID+"=";
		sDescripcion+=moneda.getId().toString()+",";
		sDescripcion+=MonedaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=moneda.getVersionRow().toString()+",";
		sDescripcion+=MonedaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=moneda.getid_empresa().toString()+",";
		sDescripcion+=MonedaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=moneda.getnombre()+",";
		sDescripcion+=MonedaConstantesFunciones.SIGLA+"=";
		sDescripcion+=moneda.getsigla()+",";
		sDescripcion+=MonedaConstantesFunciones.SIMBOLO+"=";
		sDescripcion+=moneda.getsimbolo()+",";
		sDescripcion+=MonedaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=moneda.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMonedaDescripcion(Moneda moneda,String sValor) throws Exception {			
		if(moneda !=null) {
			moneda.setnombre(sValor);;//monedamoneda.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSigla")) {
			sNombreIndice="Tipo=  Por Sigla";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSigla(String sigla) {
		String sDetalleIndice=" Parametros->";
		if(sigla!=null) {sDetalleIndice+=" Sigla="+sigla;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMoneda(Moneda moneda,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		moneda.setnombre(moneda.getnombre().trim());
		moneda.setsigla(moneda.getsigla().trim());
		moneda.setsimbolo(moneda.getsimbolo().trim());
	}
	
	public static void quitarEspaciosMonedas(List<Moneda> monedas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Moneda moneda: monedas) {
			moneda.setnombre(moneda.getnombre().trim());
			moneda.setsigla(moneda.getsigla().trim());
			moneda.setsimbolo(moneda.getsimbolo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMoneda(Moneda moneda,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && moneda.getConCambioAuxiliar()) {
			moneda.setIsDeleted(moneda.getIsDeletedAuxiliar());	
			moneda.setIsNew(moneda.getIsNewAuxiliar());	
			moneda.setIsChanged(moneda.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			moneda.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			moneda.setIsDeletedAuxiliar(false);	
			moneda.setIsNewAuxiliar(false);	
			moneda.setIsChangedAuxiliar(false);
			
			moneda.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMonedas(List<Moneda> monedas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Moneda moneda : monedas) {
			if(conAsignarBase && moneda.getConCambioAuxiliar()) {
				moneda.setIsDeleted(moneda.getIsDeletedAuxiliar());	
				moneda.setIsNew(moneda.getIsNewAuxiliar());	
				moneda.setIsChanged(moneda.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				moneda.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				moneda.setIsDeletedAuxiliar(false);	
				moneda.setIsNewAuxiliar(false);	
				moneda.setIsChangedAuxiliar(false);
				
				moneda.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMoneda(Moneda moneda,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMonedas(List<Moneda> monedas,Boolean conEnteros) throws Exception  {
		
		for(Moneda moneda: monedas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMoneda(List<Moneda> monedas,Moneda monedaAux) throws Exception  {
		MonedaConstantesFunciones.InicializarValoresMoneda(monedaAux,true);
		
		for(Moneda moneda: monedas) {
			if(moneda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMoneda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MonedaConstantesFunciones.getArrayColumnasGlobalesMoneda(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMoneda(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MonedaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MonedaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMoneda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Moneda> monedas,Moneda moneda,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Moneda monedaAux: monedas) {
			if(monedaAux!=null && moneda!=null) {
				if((monedaAux.getId()==null && moneda.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(monedaAux.getId()!=null && moneda.getId()!=null){
					if(monedaAux.getId().equals(moneda.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMoneda(List<Moneda> monedas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Moneda moneda: monedas) {			
			if(moneda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMoneda() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_ID, MonedaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_VERSIONROW, MonedaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_IDEMPRESA, MonedaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_NOMBRE, MonedaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_SIGLA, MonedaConstantesFunciones.SIGLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_SIMBOLO, MonedaConstantesFunciones.SIMBOLO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MonedaConstantesFunciones.LABEL_ESTAACTIVO, MonedaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMoneda() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.SIGLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.SIMBOLO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MonedaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMoneda() throws Exception  {
		return MonedaConstantesFunciones.getTiposSeleccionarMoneda(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMoneda(Boolean conFk) throws Exception  {
		return MonedaConstantesFunciones.getTiposSeleccionarMoneda(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMoneda(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MonedaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MonedaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MonedaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MonedaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MonedaConstantesFunciones.LABEL_SIGLA);
			reporte.setsDescripcion(MonedaConstantesFunciones.LABEL_SIGLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MonedaConstantesFunciones.LABEL_SIMBOLO);
			reporte.setsDescripcion(MonedaConstantesFunciones.LABEL_SIMBOLO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MonedaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(MonedaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMoneda(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMoneda(Moneda monedaAux) throws Exception {
		
			monedaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(monedaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMoneda(List<Moneda> monedasTemp) throws Exception {
		for(Moneda monedaAux:monedasTemp) {
			
			monedaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(monedaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MonedaConstantesFunciones.getClassesRelationshipsOfMoneda(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MonedaConstantesFunciones.getClassesRelationshipsFromStringsOfMoneda(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Moneda moneda,List<Moneda> monedas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Moneda monedaEncontrado=null;
			
			for(Moneda monedaLocal:monedas) {
				if(monedaLocal.getId().equals(moneda.getId())) {
					monedaEncontrado=monedaLocal;
					
					monedaLocal.setIsChanged(moneda.getIsChanged());
					monedaLocal.setIsNew(moneda.getIsNew());
					monedaLocal.setIsDeleted(moneda.getIsDeleted());
					
					monedaLocal.setGeneralEntityOriginal(moneda.getGeneralEntityOriginal());
					
					monedaLocal.setId(moneda.getId());	
					monedaLocal.setVersionRow(moneda.getVersionRow());	
					monedaLocal.setid_empresa(moneda.getid_empresa());	
					monedaLocal.setnombre(moneda.getnombre());	
					monedaLocal.setsigla(moneda.getsigla());	
					monedaLocal.setsimbolo(moneda.getsimbolo());	
					monedaLocal.setesta_activo(moneda.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!moneda.getIsDeleted()) {
				if(!existe) {
					monedas.add(moneda);
				}
			} else {
				if(monedaEncontrado!=null && permiteQuitar)  {
					monedas.remove(monedaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Moneda moneda,List<Moneda> monedas) throws Exception {
		try	{			
			for(Moneda monedaLocal:monedas) {
				if(monedaLocal.getId().equals(moneda.getId())) {
					monedaLocal.setIsSelected(moneda.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMoneda(List<Moneda> monedasAux) throws Exception {
		//this.monedasAux=monedasAux;
		
		for(Moneda monedaAux:monedasAux) {
			if(monedaAux.getIsChanged()) {
				monedaAux.setIsChanged(false);
			}		
			
			if(monedaAux.getIsNew()) {
				monedaAux.setIsNew(false);
			}	
			
			if(monedaAux.getIsDeleted()) {
				monedaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMoneda(Moneda monedaAux) throws Exception {
		//this.monedaAux=monedaAux;
		
			if(monedaAux.getIsChanged()) {
				monedaAux.setIsChanged(false);
			}		
			
			if(monedaAux.getIsNew()) {
				monedaAux.setIsNew(false);
			}	
			
			if(monedaAux.getIsDeleted()) {
				monedaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Moneda monedaAsignar,Moneda moneda) throws Exception {
		monedaAsignar.setId(moneda.getId());	
		monedaAsignar.setVersionRow(moneda.getVersionRow());	
		monedaAsignar.setid_empresa(moneda.getid_empresa());
		monedaAsignar.setempresa_descripcion(moneda.getempresa_descripcion());	
		monedaAsignar.setnombre(moneda.getnombre());	
		monedaAsignar.setsigla(moneda.getsigla());	
		monedaAsignar.setsimbolo(moneda.getsimbolo());	
		monedaAsignar.setesta_activo(moneda.getesta_activo());	
	}
	
	public static void inicializarMoneda(Moneda moneda) throws Exception {
		try {
				moneda.setId(0L);	
					
				moneda.setid_empresa(-1L);	
				moneda.setnombre("");	
				moneda.setsigla("");	
				moneda.setsimbolo("");	
				moneda.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMoneda(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MonedaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MonedaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MonedaConstantesFunciones.LABEL_SIGLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MonedaConstantesFunciones.LABEL_SIMBOLO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MonedaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMoneda(String sTipo,Row row,Workbook workbook,Moneda moneda,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(moneda.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(moneda.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(moneda.getsigla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(moneda.getsimbolo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(moneda.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMoneda=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMoneda() {
		return this.sFinalQueryMoneda;
	}
	
	public void setsFinalQueryMoneda(String sFinalQueryMoneda) {
		this.sFinalQueryMoneda= sFinalQueryMoneda;
	}
	
	public Border resaltarSeleccionarMoneda=null;
	
	public Border setResaltarSeleccionarMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMoneda= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMoneda() {
		return this.resaltarSeleccionarMoneda;
	}
	
	public void setResaltarSeleccionarMoneda(Border borderResaltarSeleccionarMoneda) {
		this.resaltarSeleccionarMoneda= borderResaltarSeleccionarMoneda;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMoneda=null;
	public Boolean mostraridMoneda=true;
	public Boolean activaridMoneda=true;

	public Border resaltarid_empresaMoneda=null;
	public Boolean mostrarid_empresaMoneda=true;
	public Boolean activarid_empresaMoneda=true;
	public Boolean cargarid_empresaMoneda=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMoneda=false;//ConEventDepend=true

	public Border resaltarnombreMoneda=null;
	public Boolean mostrarnombreMoneda=true;
	public Boolean activarnombreMoneda=true;

	public Border resaltarsiglaMoneda=null;
	public Boolean mostrarsiglaMoneda=true;
	public Boolean activarsiglaMoneda=true;

	public Border resaltarsimboloMoneda=null;
	public Boolean mostrarsimboloMoneda=true;
	public Boolean activarsimboloMoneda=true;

	public Border resaltaresta_activoMoneda=null;
	public Boolean mostraresta_activoMoneda=true;
	public Boolean activaresta_activoMoneda=true;

	
	

	public Border setResaltaridMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltaridMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMoneda() {
		return this.resaltaridMoneda;
	}

	public void setResaltaridMoneda(Border borderResaltar) {
		this.resaltaridMoneda= borderResaltar;
	}

	public Boolean getMostraridMoneda() {
		return this.mostraridMoneda;
	}

	public void setMostraridMoneda(Boolean mostraridMoneda) {
		this.mostraridMoneda= mostraridMoneda;
	}

	public Boolean getActivaridMoneda() {
		return this.activaridMoneda;
	}

	public void setActivaridMoneda(Boolean activaridMoneda) {
		this.activaridMoneda= activaridMoneda;
	}

	public Border setResaltarid_empresaMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltarid_empresaMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMoneda() {
		return this.resaltarid_empresaMoneda;
	}

	public void setResaltarid_empresaMoneda(Border borderResaltar) {
		this.resaltarid_empresaMoneda= borderResaltar;
	}

	public Boolean getMostrarid_empresaMoneda() {
		return this.mostrarid_empresaMoneda;
	}

	public void setMostrarid_empresaMoneda(Boolean mostrarid_empresaMoneda) {
		this.mostrarid_empresaMoneda= mostrarid_empresaMoneda;
	}

	public Boolean getActivarid_empresaMoneda() {
		return this.activarid_empresaMoneda;
	}

	public void setActivarid_empresaMoneda(Boolean activarid_empresaMoneda) {
		this.activarid_empresaMoneda= activarid_empresaMoneda;
	}

	public Boolean getCargarid_empresaMoneda() {
		return this.cargarid_empresaMoneda;
	}

	public void setCargarid_empresaMoneda(Boolean cargarid_empresaMoneda) {
		this.cargarid_empresaMoneda= cargarid_empresaMoneda;
	}

	public Border setResaltarnombreMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltarnombreMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMoneda() {
		return this.resaltarnombreMoneda;
	}

	public void setResaltarnombreMoneda(Border borderResaltar) {
		this.resaltarnombreMoneda= borderResaltar;
	}

	public Boolean getMostrarnombreMoneda() {
		return this.mostrarnombreMoneda;
	}

	public void setMostrarnombreMoneda(Boolean mostrarnombreMoneda) {
		this.mostrarnombreMoneda= mostrarnombreMoneda;
	}

	public Boolean getActivarnombreMoneda() {
		return this.activarnombreMoneda;
	}

	public void setActivarnombreMoneda(Boolean activarnombreMoneda) {
		this.activarnombreMoneda= activarnombreMoneda;
	}

	public Border setResaltarsiglaMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltarsiglaMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglaMoneda() {
		return this.resaltarsiglaMoneda;
	}

	public void setResaltarsiglaMoneda(Border borderResaltar) {
		this.resaltarsiglaMoneda= borderResaltar;
	}

	public Boolean getMostrarsiglaMoneda() {
		return this.mostrarsiglaMoneda;
	}

	public void setMostrarsiglaMoneda(Boolean mostrarsiglaMoneda) {
		this.mostrarsiglaMoneda= mostrarsiglaMoneda;
	}

	public Boolean getActivarsiglaMoneda() {
		return this.activarsiglaMoneda;
	}

	public void setActivarsiglaMoneda(Boolean activarsiglaMoneda) {
		this.activarsiglaMoneda= activarsiglaMoneda;
	}

	public Border setResaltarsimboloMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltarsimboloMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsimboloMoneda() {
		return this.resaltarsimboloMoneda;
	}

	public void setResaltarsimboloMoneda(Border borderResaltar) {
		this.resaltarsimboloMoneda= borderResaltar;
	}

	public Boolean getMostrarsimboloMoneda() {
		return this.mostrarsimboloMoneda;
	}

	public void setMostrarsimboloMoneda(Boolean mostrarsimboloMoneda) {
		this.mostrarsimboloMoneda= mostrarsimboloMoneda;
	}

	public Boolean getActivarsimboloMoneda() {
		return this.activarsimboloMoneda;
	}

	public void setActivarsimboloMoneda(Boolean activarsimboloMoneda) {
		this.activarsimboloMoneda= activarsimboloMoneda;
	}

	public Border setResaltaresta_activoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//monedaBeanSwingJInternalFrame.jTtoolBarMoneda.setBorder(borderResaltar);
		
		this.resaltaresta_activoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoMoneda() {
		return this.resaltaresta_activoMoneda;
	}

	public void setResaltaresta_activoMoneda(Border borderResaltar) {
		this.resaltaresta_activoMoneda= borderResaltar;
	}

	public Boolean getMostraresta_activoMoneda() {
		return this.mostraresta_activoMoneda;
	}

	public void setMostraresta_activoMoneda(Boolean mostraresta_activoMoneda) {
		this.mostraresta_activoMoneda= mostraresta_activoMoneda;
	}

	public Boolean getActivaresta_activoMoneda() {
		return this.activaresta_activoMoneda;
	}

	public void setActivaresta_activoMoneda(Boolean activaresta_activoMoneda) {
		this.activaresta_activoMoneda= activaresta_activoMoneda;
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
		
		
		this.setMostraridMoneda(esInicial);
		this.setMostrarid_empresaMoneda(esInicial);
		this.setMostrarnombreMoneda(esInicial);
		this.setMostrarsiglaMoneda(esInicial);
		this.setMostrarsimboloMoneda(esInicial);
		this.setMostraresta_activoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MonedaConstantesFunciones.ID)) {
				this.setMostraridMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIGLA)) {
				this.setMostrarsiglaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIMBOLO)) {
				this.setMostrarsimboloMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoMoneda(esAsigna);
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
		
		
		this.setActivaridMoneda(esInicial);
		this.setActivarid_empresaMoneda(esInicial);
		this.setActivarnombreMoneda(esInicial);
		this.setActivarsiglaMoneda(esInicial);
		this.setActivarsimboloMoneda(esInicial);
		this.setActivaresta_activoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MonedaConstantesFunciones.ID)) {
				this.setActivaridMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIGLA)) {
				this.setActivarsiglaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIMBOLO)) {
				this.setActivarsimboloMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoMoneda(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMoneda(esInicial);
		this.setResaltarid_empresaMoneda(esInicial);
		this.setResaltarnombreMoneda(esInicial);
		this.setResaltarsiglaMoneda(esInicial);
		this.setResaltarsimboloMoneda(esInicial);
		this.setResaltaresta_activoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MonedaConstantesFunciones.ID)) {
				this.setResaltaridMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIGLA)) {
				this.setResaltarsiglaMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.SIMBOLO)) {
				this.setResaltarsimboloMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(MonedaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoMoneda(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreMoneda=true;

	public Boolean getMostrarBusquedaPorNombreMoneda() {
		return this.mostrarBusquedaPorNombreMoneda;
	}

	public void setMostrarBusquedaPorNombreMoneda(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreMoneda= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglaMoneda=true;

	public Boolean getMostrarBusquedaPorSiglaMoneda() {
		return this.mostrarBusquedaPorSiglaMoneda;
	}

	public void setMostrarBusquedaPorSiglaMoneda(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglaMoneda= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMoneda=true;

	public Boolean getMostrarFK_IdEmpresaMoneda() {
		return this.mostrarFK_IdEmpresaMoneda;
	}

	public void setMostrarFK_IdEmpresaMoneda(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMoneda= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreMoneda=true;

	public Boolean getActivarBusquedaPorNombreMoneda() {
		return this.activarBusquedaPorNombreMoneda;
	}

	public void setActivarBusquedaPorNombreMoneda(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreMoneda= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglaMoneda=true;

	public Boolean getActivarBusquedaPorSiglaMoneda() {
		return this.activarBusquedaPorSiglaMoneda;
	}

	public void setActivarBusquedaPorSiglaMoneda(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglaMoneda= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMoneda=true;

	public Boolean getActivarFK_IdEmpresaMoneda() {
		return this.activarFK_IdEmpresaMoneda;
	}

	public void setActivarFK_IdEmpresaMoneda(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMoneda= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreMoneda=null;

	public Border getResaltarBusquedaPorNombreMoneda() {
		return this.resaltarBusquedaPorNombreMoneda;
	}

	public void setResaltarBusquedaPorNombreMoneda(Border borderResaltar) {
		this.resaltarBusquedaPorNombreMoneda= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreMoneda= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglaMoneda=null;

	public Border getResaltarBusquedaPorSiglaMoneda() {
		return this.resaltarBusquedaPorSiglaMoneda;
	}

	public void setResaltarBusquedaPorSiglaMoneda(Border borderResaltar) {
		this.resaltarBusquedaPorSiglaMoneda= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglaMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglaMoneda= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMoneda=null;

	public Border getResaltarFK_IdEmpresaMoneda() {
		return this.resaltarFK_IdEmpresaMoneda;
	}

	public void setResaltarFK_IdEmpresaMoneda(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMoneda= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*MonedaBeanSwingJInternalFrame monedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMoneda= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}