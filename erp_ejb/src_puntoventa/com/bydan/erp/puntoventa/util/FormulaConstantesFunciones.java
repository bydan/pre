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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.FormulaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FormulaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FormulaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormulaConstantesFunciones extends FormulaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Formula";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Formula"+FormulaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormulaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormulaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormulaConstantesFunciones.SCHEMA+"_"+FormulaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormulaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormulaConstantesFunciones.SCHEMA+"_"+FormulaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormulaConstantesFunciones.SCHEMA+"_"+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormulaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormulaConstantesFunciones.SCHEMA+"_"+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormulaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormulaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormulaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormulaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormulaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormulaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formulas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formula";
	public static final String SCLASSWEBTITULO_LOWER="Formula";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Formula";
	public static final String OBJECTNAME="formula";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="formula";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formula from "+FormulaConstantesFunciones.SPERSISTENCENAME+" formula";
	public static String QUERYSELECTNATIVE="select "+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".id,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".version_row,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".id_empresa,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".id_tipo_formula,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".codigo,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".nombre,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".alias,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".valor,"+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME+".formula1 from "+FormulaConstantesFunciones.SCHEMA+"."+FormulaConstantesFunciones.TABLENAME;//+" as "+FormulaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormulaConstantesFuncionesAdditional formulaConstantesFuncionesAdditional=null;
	
	public FormulaConstantesFuncionesAdditional getFormulaConstantesFuncionesAdditional() {
		return this.formulaConstantesFuncionesAdditional;
	}
	
	public void setFormulaConstantesFuncionesAdditional(FormulaConstantesFuncionesAdditional formulaConstantesFuncionesAdditional) {
		try {
			this.formulaConstantesFuncionesAdditional=formulaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOFORMULA= "id_tipo_formula";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ALIAS= "alias";
    public static final String VALOR= "valor";
    public static final String FORMULA1= "formula1";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOFORMULA= "Tipo Formula";
		public static final String LABEL_IDTIPOFORMULA_LOWER= "Tipo Formula";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ALIAS= "Alias";
		public static final String LABEL_ALIAS_LOWER= "Alias";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FORMULA1= "Formula1";
		public static final String LABEL_FORMULA1_LOWER= "Formula1";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXALIAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXALIAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXFORMULA1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMULA1=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFormulaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormulaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormulaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.IDTIPOFORMULA)) {sLabelColumna=FormulaConstantesFunciones.LABEL_IDTIPOFORMULA;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.CODIGO)) {sLabelColumna=FormulaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.NOMBRE)) {sLabelColumna=FormulaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.ALIAS)) {sLabelColumna=FormulaConstantesFunciones.LABEL_ALIAS;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.VALOR)) {sLabelColumna=FormulaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(FormulaConstantesFunciones.FORMULA1)) {sLabelColumna=FormulaConstantesFunciones.LABEL_FORMULA1;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getFormulaDescripcion(Formula formula) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formula !=null/* && formula.getId()!=0*/) {
			sDescripcion=formula.getcodigo();//formulaformula.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFormulaDescripcionDetallado(Formula formula) {
		String sDescripcion="";
			
		sDescripcion+=FormulaConstantesFunciones.ID+"=";
		sDescripcion+=formula.getId().toString()+",";
		sDescripcion+=FormulaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formula.getVersionRow().toString()+",";
		sDescripcion+=FormulaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formula.getid_empresa().toString()+",";
		sDescripcion+=FormulaConstantesFunciones.IDTIPOFORMULA+"=";
		sDescripcion+=formula.getid_tipo_formula().toString()+",";
		sDescripcion+=FormulaConstantesFunciones.CODIGO+"=";
		sDescripcion+=formula.getcodigo()+",";
		sDescripcion+=FormulaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=formula.getnombre()+",";
		sDescripcion+=FormulaConstantesFunciones.ALIAS+"=";
		sDescripcion+=formula.getalias()+",";
		sDescripcion+=FormulaConstantesFunciones.VALOR+"=";
		sDescripcion+=formula.getvalor().toString()+",";
		sDescripcion+=FormulaConstantesFunciones.FORMULA1+"=";
		sDescripcion+=formula.getformula1()+",";
			
		return sDescripcion;
	}
	
	public static void setFormulaDescripcion(Formula formula,String sValor) throws Exception {			
		if(formula !=null) {
			formula.setcodigo(sValor);;//formulaformula.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoFormulaDescripcion(TipoFormula tipoformula) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformula!=null/*&&tipoformula.getId()>0*/) {
			sDescripcion=TipoFormulaConstantesFunciones.getTipoFormulaDescripcion(tipoformula);
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
		} else if(sNombreIndice.equals("FK_IdTipoFormula")) {
			sNombreIndice="Tipo=  Por Tipo Formula";
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

	public static String getDetalleIndiceFK_IdTipoFormula(Long id_tipo_formula) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_formula!=null) {sDetalleIndice+=" Codigo Unico De Tipo Formula="+id_tipo_formula.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormula(Formula formula,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formula.setcodigo(formula.getcodigo().trim());
		formula.setnombre(formula.getnombre().trim());
		formula.setalias(formula.getalias().trim());
		formula.setformula1(formula.getformula1().trim());
	}
	
	public static void quitarEspaciosFormulas(List<Formula> formulas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Formula formula: formulas) {
			formula.setcodigo(formula.getcodigo().trim());
			formula.setnombre(formula.getnombre().trim());
			formula.setalias(formula.getalias().trim());
			formula.setformula1(formula.getformula1().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormula(Formula formula,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formula.getConCambioAuxiliar()) {
			formula.setIsDeleted(formula.getIsDeletedAuxiliar());	
			formula.setIsNew(formula.getIsNewAuxiliar());	
			formula.setIsChanged(formula.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formula.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formula.setIsDeletedAuxiliar(false);	
			formula.setIsNewAuxiliar(false);	
			formula.setIsChangedAuxiliar(false);
			
			formula.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormulas(List<Formula> formulas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Formula formula : formulas) {
			if(conAsignarBase && formula.getConCambioAuxiliar()) {
				formula.setIsDeleted(formula.getIsDeletedAuxiliar());	
				formula.setIsNew(formula.getIsNewAuxiliar());	
				formula.setIsChanged(formula.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formula.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formula.setIsDeletedAuxiliar(false);	
				formula.setIsNewAuxiliar(false);	
				formula.setIsChangedAuxiliar(false);
				
				formula.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormula(Formula formula,Boolean conEnteros) throws Exception  {
		formula.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormulas(List<Formula> formulas,Boolean conEnteros) throws Exception  {
		
		for(Formula formula: formulas) {
			formula.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormula(List<Formula> formulas,Formula formulaAux) throws Exception  {
		FormulaConstantesFunciones.InicializarValoresFormula(formulaAux,true);
		
		for(Formula formula: formulas) {
			if(formula.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formulaAux.setvalor(formulaAux.getvalor()+formula.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormula(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormulaConstantesFunciones.getArrayColumnasGlobalesFormula(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormula(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormulaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormulaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormula(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Formula> formulas,Formula formula,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Formula formulaAux: formulas) {
			if(formulaAux!=null && formula!=null) {
				if((formulaAux.getId()==null && formula.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formulaAux.getId()!=null && formula.getId()!=null){
					if(formulaAux.getId().equals(formula.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormula(List<Formula> formulas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(Formula formula: formulas) {			
			if(formula.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=formula.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormulaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(FormulaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormula() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_ID, FormulaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_VERSIONROW, FormulaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_IDEMPRESA, FormulaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_IDTIPOFORMULA, FormulaConstantesFunciones.IDTIPOFORMULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_CODIGO, FormulaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_NOMBRE, FormulaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_ALIAS, FormulaConstantesFunciones.ALIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_VALOR, FormulaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormulaConstantesFunciones.LABEL_FORMULA1, FormulaConstantesFunciones.FORMULA1,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormula() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.IDTIPOFORMULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.ALIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormulaConstantesFunciones.FORMULA1;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormula() throws Exception  {
		return FormulaConstantesFunciones.getTiposSeleccionarFormula(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormula(Boolean conFk) throws Exception  {
		return FormulaConstantesFunciones.getTiposSeleccionarFormula(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormula(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_IDTIPOFORMULA);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_IDTIPOFORMULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_ALIAS);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_ALIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormulaConstantesFunciones.LABEL_FORMULA1);
			reporte.setsDescripcion(FormulaConstantesFunciones.LABEL_FORMULA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormula(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormula(Formula formulaAux) throws Exception {
		
			formulaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulaAux.getEmpresa()));
			formulaAux.settipoformula_descripcion(TipoFormulaConstantesFunciones.getTipoFormulaDescripcion(formulaAux.getTipoFormula()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormula(List<Formula> formulasTemp) throws Exception {
		for(Formula formulaAux:formulasTemp) {
			
			formulaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulaAux.getEmpresa()));
			formulaAux.settipoformula_descripcion(TipoFormulaConstantesFunciones.getTipoFormulaDescripcion(formulaAux.getTipoFormula()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoFormula.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormula.class)) {
						classes.add(new Classe(TipoFormula.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoFormula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormula.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoFormula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormula.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormulaConstantesFunciones.getClassesRelationshipsOfFormula(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TarjetaCredito.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormulaConstantesFunciones.getClassesRelationshipsFromStringsOfFormula(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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
	public static void actualizarLista(Formula formula,List<Formula> formulas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Formula formulaEncontrado=null;
			
			for(Formula formulaLocal:formulas) {
				if(formulaLocal.getId().equals(formula.getId())) {
					formulaEncontrado=formulaLocal;
					
					formulaLocal.setIsChanged(formula.getIsChanged());
					formulaLocal.setIsNew(formula.getIsNew());
					formulaLocal.setIsDeleted(formula.getIsDeleted());
					
					formulaLocal.setGeneralEntityOriginal(formula.getGeneralEntityOriginal());
					
					formulaLocal.setId(formula.getId());	
					formulaLocal.setVersionRow(formula.getVersionRow());	
					formulaLocal.setid_empresa(formula.getid_empresa());	
					formulaLocal.setid_tipo_formula(formula.getid_tipo_formula());	
					formulaLocal.setcodigo(formula.getcodigo());	
					formulaLocal.setnombre(formula.getnombre());	
					formulaLocal.setalias(formula.getalias());	
					formulaLocal.setvalor(formula.getvalor());	
					formulaLocal.setformula1(formula.getformula1());	
					
					
					formulaLocal.setTarjetaCreditoComisions(formula.getTarjetaCreditoComisions());
					
					existe=true;
					break;
				}
			}
			
			if(!formula.getIsDeleted()) {
				if(!existe) {
					formulas.add(formula);
				}
			} else {
				if(formulaEncontrado!=null && permiteQuitar)  {
					formulas.remove(formulaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Formula formula,List<Formula> formulas) throws Exception {
		try	{			
			for(Formula formulaLocal:formulas) {
				if(formulaLocal.getId().equals(formula.getId())) {
					formulaLocal.setIsSelected(formula.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormula(List<Formula> formulasAux) throws Exception {
		//this.formulasAux=formulasAux;
		
		for(Formula formulaAux:formulasAux) {
			if(formulaAux.getIsChanged()) {
				formulaAux.setIsChanged(false);
			}		
			
			if(formulaAux.getIsNew()) {
				formulaAux.setIsNew(false);
			}	
			
			if(formulaAux.getIsDeleted()) {
				formulaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormula(Formula formulaAux) throws Exception {
		//this.formulaAux=formulaAux;
		
			if(formulaAux.getIsChanged()) {
				formulaAux.setIsChanged(false);
			}		
			
			if(formulaAux.getIsNew()) {
				formulaAux.setIsNew(false);
			}	
			
			if(formulaAux.getIsDeleted()) {
				formulaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Formula formulaAsignar,Formula formula) throws Exception {
		formulaAsignar.setId(formula.getId());	
		formulaAsignar.setVersionRow(formula.getVersionRow());	
		formulaAsignar.setid_empresa(formula.getid_empresa());
		formulaAsignar.setempresa_descripcion(formula.getempresa_descripcion());	
		formulaAsignar.setid_tipo_formula(formula.getid_tipo_formula());
		formulaAsignar.settipoformula_descripcion(formula.gettipoformula_descripcion());	
		formulaAsignar.setcodigo(formula.getcodigo());	
		formulaAsignar.setnombre(formula.getnombre());	
		formulaAsignar.setalias(formula.getalias());	
		formulaAsignar.setvalor(formula.getvalor());	
		formulaAsignar.setformula1(formula.getformula1());	
	}
	
	public static void inicializarFormula(Formula formula) throws Exception {
		try {
				formula.setId(0L);	
					
				formula.setid_empresa(-1L);	
				formula.setid_tipo_formula(-1L);	
				formula.setcodigo("");	
				formula.setnombre("");	
				formula.setalias("");	
				formula.setvalor(0.0);	
				formula.setformula1("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormula(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_IDTIPOFORMULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_ALIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormulaConstantesFunciones.LABEL_FORMULA1);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormula(String sTipo,Row row,Workbook workbook,Formula formula,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.gettipoformula_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getalias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formula.getformula1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormula=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormula() {
		return this.sFinalQueryFormula;
	}
	
	public void setsFinalQueryFormula(String sFinalQueryFormula) {
		this.sFinalQueryFormula= sFinalQueryFormula;
	}
	
	public Border resaltarSeleccionarFormula=null;
	
	public Border setResaltarSeleccionarFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormula= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormula() {
		return this.resaltarSeleccionarFormula;
	}
	
	public void setResaltarSeleccionarFormula(Border borderResaltarSeleccionarFormula) {
		this.resaltarSeleccionarFormula= borderResaltarSeleccionarFormula;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormula=null;
	public Boolean mostraridFormula=true;
	public Boolean activaridFormula=true;

	public Border resaltarid_empresaFormula=null;
	public Boolean mostrarid_empresaFormula=true;
	public Boolean activarid_empresaFormula=true;
	public Boolean cargarid_empresaFormula=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormula=false;//ConEventDepend=true

	public Border resaltarid_tipo_formulaFormula=null;
	public Boolean mostrarid_tipo_formulaFormula=true;
	public Boolean activarid_tipo_formulaFormula=true;
	public Boolean cargarid_tipo_formulaFormula=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_formulaFormula=false;//ConEventDepend=true

	public Border resaltarcodigoFormula=null;
	public Boolean mostrarcodigoFormula=true;
	public Boolean activarcodigoFormula=true;

	public Border resaltarnombreFormula=null;
	public Boolean mostrarnombreFormula=true;
	public Boolean activarnombreFormula=true;

	public Border resaltaraliasFormula=null;
	public Boolean mostraraliasFormula=true;
	public Boolean activaraliasFormula=true;

	public Border resaltarvalorFormula=null;
	public Boolean mostrarvalorFormula=true;
	public Boolean activarvalorFormula=true;

	public Border resaltarformula1Formula=null;
	public Boolean mostrarformula1Formula=true;
	public Boolean activarformula1Formula=true;

	
	

	public Border setResaltaridFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltaridFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormula() {
		return this.resaltaridFormula;
	}

	public void setResaltaridFormula(Border borderResaltar) {
		this.resaltaridFormula= borderResaltar;
	}

	public Boolean getMostraridFormula() {
		return this.mostraridFormula;
	}

	public void setMostraridFormula(Boolean mostraridFormula) {
		this.mostraridFormula= mostraridFormula;
	}

	public Boolean getActivaridFormula() {
		return this.activaridFormula;
	}

	public void setActivaridFormula(Boolean activaridFormula) {
		this.activaridFormula= activaridFormula;
	}

	public Border setResaltarid_empresaFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormula() {
		return this.resaltarid_empresaFormula;
	}

	public void setResaltarid_empresaFormula(Border borderResaltar) {
		this.resaltarid_empresaFormula= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormula() {
		return this.mostrarid_empresaFormula;
	}

	public void setMostrarid_empresaFormula(Boolean mostrarid_empresaFormula) {
		this.mostrarid_empresaFormula= mostrarid_empresaFormula;
	}

	public Boolean getActivarid_empresaFormula() {
		return this.activarid_empresaFormula;
	}

	public void setActivarid_empresaFormula(Boolean activarid_empresaFormula) {
		this.activarid_empresaFormula= activarid_empresaFormula;
	}

	public Boolean getCargarid_empresaFormula() {
		return this.cargarid_empresaFormula;
	}

	public void setCargarid_empresaFormula(Boolean cargarid_empresaFormula) {
		this.cargarid_empresaFormula= cargarid_empresaFormula;
	}

	public Border setResaltarid_tipo_formulaFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarid_tipo_formulaFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_formulaFormula() {
		return this.resaltarid_tipo_formulaFormula;
	}

	public void setResaltarid_tipo_formulaFormula(Border borderResaltar) {
		this.resaltarid_tipo_formulaFormula= borderResaltar;
	}

	public Boolean getMostrarid_tipo_formulaFormula() {
		return this.mostrarid_tipo_formulaFormula;
	}

	public void setMostrarid_tipo_formulaFormula(Boolean mostrarid_tipo_formulaFormula) {
		this.mostrarid_tipo_formulaFormula= mostrarid_tipo_formulaFormula;
	}

	public Boolean getActivarid_tipo_formulaFormula() {
		return this.activarid_tipo_formulaFormula;
	}

	public void setActivarid_tipo_formulaFormula(Boolean activarid_tipo_formulaFormula) {
		this.activarid_tipo_formulaFormula= activarid_tipo_formulaFormula;
	}

	public Boolean getCargarid_tipo_formulaFormula() {
		return this.cargarid_tipo_formulaFormula;
	}

	public void setCargarid_tipo_formulaFormula(Boolean cargarid_tipo_formulaFormula) {
		this.cargarid_tipo_formulaFormula= cargarid_tipo_formulaFormula;
	}

	public Border setResaltarcodigoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarcodigoFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoFormula() {
		return this.resaltarcodigoFormula;
	}

	public void setResaltarcodigoFormula(Border borderResaltar) {
		this.resaltarcodigoFormula= borderResaltar;
	}

	public Boolean getMostrarcodigoFormula() {
		return this.mostrarcodigoFormula;
	}

	public void setMostrarcodigoFormula(Boolean mostrarcodigoFormula) {
		this.mostrarcodigoFormula= mostrarcodigoFormula;
	}

	public Boolean getActivarcodigoFormula() {
		return this.activarcodigoFormula;
	}

	public void setActivarcodigoFormula(Boolean activarcodigoFormula) {
		this.activarcodigoFormula= activarcodigoFormula;
	}

	public Border setResaltarnombreFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarnombreFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFormula() {
		return this.resaltarnombreFormula;
	}

	public void setResaltarnombreFormula(Border borderResaltar) {
		this.resaltarnombreFormula= borderResaltar;
	}

	public Boolean getMostrarnombreFormula() {
		return this.mostrarnombreFormula;
	}

	public void setMostrarnombreFormula(Boolean mostrarnombreFormula) {
		this.mostrarnombreFormula= mostrarnombreFormula;
	}

	public Boolean getActivarnombreFormula() {
		return this.activarnombreFormula;
	}

	public void setActivarnombreFormula(Boolean activarnombreFormula) {
		this.activarnombreFormula= activarnombreFormula;
	}

	public Border setResaltaraliasFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltaraliasFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraliasFormula() {
		return this.resaltaraliasFormula;
	}

	public void setResaltaraliasFormula(Border borderResaltar) {
		this.resaltaraliasFormula= borderResaltar;
	}

	public Boolean getMostraraliasFormula() {
		return this.mostraraliasFormula;
	}

	public void setMostraraliasFormula(Boolean mostraraliasFormula) {
		this.mostraraliasFormula= mostraraliasFormula;
	}

	public Boolean getActivaraliasFormula() {
		return this.activaraliasFormula;
	}

	public void setActivaraliasFormula(Boolean activaraliasFormula) {
		this.activaraliasFormula= activaraliasFormula;
	}

	public Border setResaltarvalorFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarvalorFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorFormula() {
		return this.resaltarvalorFormula;
	}

	public void setResaltarvalorFormula(Border borderResaltar) {
		this.resaltarvalorFormula= borderResaltar;
	}

	public Boolean getMostrarvalorFormula() {
		return this.mostrarvalorFormula;
	}

	public void setMostrarvalorFormula(Boolean mostrarvalorFormula) {
		this.mostrarvalorFormula= mostrarvalorFormula;
	}

	public Boolean getActivarvalorFormula() {
		return this.activarvalorFormula;
	}

	public void setActivarvalorFormula(Boolean activarvalorFormula) {
		this.activarvalorFormula= activarvalorFormula;
	}

	public Border setResaltarformula1Formula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltar);
		
		this.resaltarformula1Formula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarformula1Formula() {
		return this.resaltarformula1Formula;
	}

	public void setResaltarformula1Formula(Border borderResaltar) {
		this.resaltarformula1Formula= borderResaltar;
	}

	public Boolean getMostrarformula1Formula() {
		return this.mostrarformula1Formula;
	}

	public void setMostrarformula1Formula(Boolean mostrarformula1Formula) {
		this.mostrarformula1Formula= mostrarformula1Formula;
	}

	public Boolean getActivarformula1Formula() {
		return this.activarformula1Formula;
	}

	public void setActivarformula1Formula(Boolean activarformula1Formula) {
		this.activarformula1Formula= activarformula1Formula;
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
		
		
		this.setMostraridFormula(esInicial);
		this.setMostrarid_empresaFormula(esInicial);
		this.setMostrarid_tipo_formulaFormula(esInicial);
		this.setMostrarcodigoFormula(esInicial);
		this.setMostrarnombreFormula(esInicial);
		this.setMostraraliasFormula(esInicial);
		this.setMostrarvalorFormula(esInicial);
		this.setMostrarformula1Formula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormulaConstantesFunciones.ID)) {
				this.setMostraridFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDTIPOFORMULA)) {
				this.setMostrarid_tipo_formulaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.ALIAS)) {
				this.setMostraraliasFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.VALOR)) {
				this.setMostrarvalorFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.FORMULA1)) {
				this.setMostrarformula1Formula(esAsigna);
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
		
		
		this.setActivaridFormula(esInicial);
		this.setActivarid_empresaFormula(esInicial);
		this.setActivarid_tipo_formulaFormula(esInicial);
		this.setActivarcodigoFormula(esInicial);
		this.setActivarnombreFormula(esInicial);
		this.setActivaraliasFormula(esInicial);
		this.setActivarvalorFormula(esInicial);
		this.setActivarformula1Formula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormulaConstantesFunciones.ID)) {
				this.setActivaridFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDTIPOFORMULA)) {
				this.setActivarid_tipo_formulaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.ALIAS)) {
				this.setActivaraliasFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.VALOR)) {
				this.setActivarvalorFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.FORMULA1)) {
				this.setActivarformula1Formula(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormula(esInicial);
		this.setResaltarid_empresaFormula(esInicial);
		this.setResaltarid_tipo_formulaFormula(esInicial);
		this.setResaltarcodigoFormula(esInicial);
		this.setResaltarnombreFormula(esInicial);
		this.setResaltaraliasFormula(esInicial);
		this.setResaltarvalorFormula(esInicial);
		this.setResaltarformula1Formula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormulaConstantesFunciones.ID)) {
				this.setResaltaridFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.IDTIPOFORMULA)) {
				this.setResaltarid_tipo_formulaFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.ALIAS)) {
				this.setResaltaraliasFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.VALOR)) {
				this.setResaltarvalorFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormulaConstantesFunciones.FORMULA1)) {
				this.setResaltarformula1Formula(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTarjetaCreditoFormula=null;

	public Border getResaltarTarjetaCreditoFormula() {
		return this.resaltarTarjetaCreditoFormula;
	}

	public void setResaltarTarjetaCreditoFormula(Border borderResaltarTarjetaCredito) {
		if(borderResaltarTarjetaCredito!=null) {
			this.resaltarTarjetaCreditoFormula= borderResaltarTarjetaCredito;
		}
	}

	public Border setResaltarTarjetaCreditoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCredito=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formulaBeanSwingJInternalFrame.jTtoolBarFormula.setBorder(borderResaltarTarjetaCredito);
			
		this.resaltarTarjetaCreditoFormula= borderResaltarTarjetaCredito;

		 return borderResaltarTarjetaCredito;
	}



	public Boolean mostrarTarjetaCreditoFormula=true;

	public Boolean getMostrarTarjetaCreditoFormula() {
		return this.mostrarTarjetaCreditoFormula;
	}

	public void setMostrarTarjetaCreditoFormula(Boolean visibilidadResaltarTarjetaCredito) {
		this.mostrarTarjetaCreditoFormula= visibilidadResaltarTarjetaCredito;
	}



	public Boolean activarTarjetaCreditoFormula=true;

	public Boolean gethabilitarResaltarTarjetaCreditoFormula() {
		return this.activarTarjetaCreditoFormula;
	}

	public void setActivarTarjetaCreditoFormula(Boolean habilitarResaltarTarjetaCredito) {
		this.activarTarjetaCreditoFormula= habilitarResaltarTarjetaCredito;
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

		this.setMostrarTarjetaCreditoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setMostrarTarjetaCreditoFormula(esAsigna);
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

		this.setActivarTarjetaCreditoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setActivarTarjetaCreditoFormula(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTarjetaCreditoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setResaltarTarjetaCreditoFormula(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFormula=true;

	public Boolean getMostrarFK_IdEmpresaFormula() {
		return this.mostrarFK_IdEmpresaFormula;
	}

	public void setMostrarFK_IdEmpresaFormula(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormula= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormulaFormula=true;

	public Boolean getMostrarFK_IdTipoFormulaFormula() {
		return this.mostrarFK_IdTipoFormulaFormula;
	}

	public void setMostrarFK_IdTipoFormulaFormula(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormulaFormula= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFormula=true;

	public Boolean getActivarFK_IdEmpresaFormula() {
		return this.activarFK_IdEmpresaFormula;
	}

	public void setActivarFK_IdEmpresaFormula(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormula= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormulaFormula=true;

	public Boolean getActivarFK_IdTipoFormulaFormula() {
		return this.activarFK_IdTipoFormulaFormula;
	}

	public void setActivarFK_IdTipoFormulaFormula(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormulaFormula= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFormula=null;

	public Border getResaltarFK_IdEmpresaFormula() {
		return this.resaltarFK_IdEmpresaFormula;
	}

	public void setResaltarFK_IdEmpresaFormula(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormula= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormula= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormulaFormula=null;

	public Border getResaltarFK_IdTipoFormulaFormula() {
		return this.resaltarFK_IdTipoFormulaFormula;
	}

	public void setResaltarFK_IdTipoFormulaFormula(Border borderResaltar) {
		this.resaltarFK_IdTipoFormulaFormula= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormulaFormula(ParametroGeneralUsuario parametroGeneralUsuario/*FormulaBeanSwingJInternalFrame formulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormulaFormula= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}