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


import com.bydan.erp.nomina.util.VariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.VariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VariableNomiParameterGeneral;

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
final public class VariableNomiConstantesFunciones extends VariableNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VariableNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VariableNomi"+VariableNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VariableNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VariableNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VariableNomiConstantesFunciones.SCHEMA+"_"+VariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VariableNomiConstantesFunciones.SCHEMA+"_"+VariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VariableNomiConstantesFunciones.SCHEMA+"_"+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VariableNomiConstantesFunciones.SCHEMA+"_"+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VariableNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VariableNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VariableNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VariableNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Variable Nominas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Variable Nomina";
	public static final String SCLASSWEBTITULO_LOWER="Variable Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VariableNomi";
	public static final String OBJECTNAME="variablenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="variable_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select variablenomi from "+VariableNomiConstantesFunciones.SPERSISTENCENAME+" variablenomi";
	public static String QUERYSELECTNATIVE="select "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".version_row,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_empresa,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_modulo,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_tipo_variable_nomi,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_tipo_valor_variable_nomi,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".codigo,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".nombre,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql1,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql2,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql3,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".valor from "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME;//+" as "+VariableNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VariableNomiConstantesFuncionesAdditional variablenomiConstantesFuncionesAdditional=null;
	
	public VariableNomiConstantesFuncionesAdditional getVariableNomiConstantesFuncionesAdditional() {
		return this.variablenomiConstantesFuncionesAdditional;
	}
	
	public void setVariableNomiConstantesFuncionesAdditional(VariableNomiConstantesFuncionesAdditional variablenomiConstantesFuncionesAdditional) {
		try {
			this.variablenomiConstantesFuncionesAdditional=variablenomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOVARIABLENOMI= "id_tipo_variable_nomi";
    public static final String IDTIPOVALORVARIABLENOMI= "id_tipo_valor_variable_nomi";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SQL1= "sql1";
    public static final String SQL2= "sql2";
    public static final String SQL3= "sql3";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOVARIABLENOMI= "Tipo Variable";
		public static final String LABEL_IDTIPOVARIABLENOMI_LOWER= "Tipo Variable Nomi";
    	public static final String LABEL_IDTIPOVALORVARIABLENOMI= "Tipo Valor Variable";
		public static final String LABEL_IDTIPOVALORVARIABLENOMI_LOWER= "Tipo Valor Variable Nomi";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SQL1= "Sql1";
		public static final String LABEL_SQL1_LOWER= "Sql1";
    	public static final String LABEL_SQL2= "Sql2";
		public static final String LABEL_SQL2_LOWER= "Sql2";
    	public static final String LABEL_SQL3= "Sql3";
		public static final String LABEL_SQL3_LOWER= "Sql3";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSQL1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSQL1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSQL2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSQL2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSQL3=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSQL3=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getVariableNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.IDMODULO)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_IDTIPOVARIABLENOMI;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_IDTIPOVALORVARIABLENOMI;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.CODIGO)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.NOMBRE)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.SQL1)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_SQL1;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.SQL2)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_SQL2;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.SQL3)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_SQL3;}
		if(sNombreColumna.equals(VariableNomiConstantesFunciones.VALOR)) {sLabelColumna=VariableNomiConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVariableNomiDescripcion(VariableNomi variablenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(variablenomi !=null/* && variablenomi.getId()!=0*/) {
			sDescripcion=variablenomi.getcodigo()+"-"+variablenomi.getnombre();//variablenomivariablenomi.getcodigo().trim()+"-"+variablenomi.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVariableNomiDescripcionDetallado(VariableNomi variablenomi) {
		String sDescripcion="";
			
		sDescripcion+=VariableNomiConstantesFunciones.ID+"=";
		sDescripcion+=variablenomi.getId().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=variablenomi.getVersionRow().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=variablenomi.getid_empresa().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.IDMODULO+"=";
		sDescripcion+=variablenomi.getid_modulo().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI+"=";
		sDescripcion+=variablenomi.getid_tipo_variable_nomi().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI+"=";
		sDescripcion+=variablenomi.getid_tipo_valor_variable_nomi().toString()+",";
		sDescripcion+=VariableNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=variablenomi.getcodigo()+",";
		sDescripcion+=VariableNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=variablenomi.getnombre()+",";
		sDescripcion+=VariableNomiConstantesFunciones.SQL1+"=";
		sDescripcion+=variablenomi.getsql1()+",";
		sDescripcion+=VariableNomiConstantesFunciones.SQL2+"=";
		sDescripcion+=variablenomi.getsql2()+",";
		sDescripcion+=VariableNomiConstantesFunciones.SQL3+"=";
		sDescripcion+=variablenomi.getsql3()+",";
		sDescripcion+=VariableNomiConstantesFunciones.VALOR+"=";
		sDescripcion+=variablenomi.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVariableNomiDescripcion(VariableNomi variablenomi,String sValor) throws Exception {			
		if(variablenomi !=null) {
			variablenomi.setcodigo(sValor);
variablenomi.setnombre(sValor);;//variablenomivariablenomi.getcodigo().trim()+"-"+variablenomi.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoVariableNomiDescripcion(TipoVariableNomi tipovariablenomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovariablenomi!=null/*&&tipovariablenomi.getId()>0*/) {
			sDescripcion=TipoVariableNomiConstantesFunciones.getTipoVariableNomiDescripcion(tipovariablenomi);
		}

		return sDescripcion;
	}

	public static String getTipoValorVariableNomiDescripcion(TipoValorVariableNomi tipovalorvariablenomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovalorvariablenomi!=null/*&&tipovalorvariablenomi.getId()>0*/) {
			sDescripcion=TipoValorVariableNomiConstantesFunciones.getTipoValorVariableNomiDescripcion(tipovalorvariablenomi);
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
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoValorVariableNomi")) {
			sNombreIndice="Tipo=  Por Tipo Valor Variable";
		} else if(sNombreIndice.equals("FK_IdTipoVariableNomi")) {
			sNombreIndice="Tipo=  Por Tipo Variable";
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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoValorVariableNomi(Long id_tipo_valor_variable_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_valor_variable_nomi!=null) {sDetalleIndice+=" Codigo Unico De Tipo Valor Variable="+id_tipo_valor_variable_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoVariableNomi(Long id_tipo_variable_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_variable_nomi!=null) {sDetalleIndice+=" Codigo Unico De Tipo Variable="+id_tipo_variable_nomi.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVariableNomi(VariableNomi variablenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		variablenomi.setcodigo(variablenomi.getcodigo().trim());
		variablenomi.setnombre(variablenomi.getnombre().trim());
		variablenomi.setsql1(variablenomi.getsql1().trim());
		variablenomi.setsql2(variablenomi.getsql2().trim());
		variablenomi.setsql3(variablenomi.getsql3().trim());
	}
	
	public static void quitarEspaciosVariableNomis(List<VariableNomi> variablenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VariableNomi variablenomi: variablenomis) {
			variablenomi.setcodigo(variablenomi.getcodigo().trim());
			variablenomi.setnombre(variablenomi.getnombre().trim());
			variablenomi.setsql1(variablenomi.getsql1().trim());
			variablenomi.setsql2(variablenomi.getsql2().trim());
			variablenomi.setsql3(variablenomi.getsql3().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVariableNomi(VariableNomi variablenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && variablenomi.getConCambioAuxiliar()) {
			variablenomi.setIsDeleted(variablenomi.getIsDeletedAuxiliar());	
			variablenomi.setIsNew(variablenomi.getIsNewAuxiliar());	
			variablenomi.setIsChanged(variablenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			variablenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			variablenomi.setIsDeletedAuxiliar(false);	
			variablenomi.setIsNewAuxiliar(false);	
			variablenomi.setIsChangedAuxiliar(false);
			
			variablenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVariableNomis(List<VariableNomi> variablenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VariableNomi variablenomi : variablenomis) {
			if(conAsignarBase && variablenomi.getConCambioAuxiliar()) {
				variablenomi.setIsDeleted(variablenomi.getIsDeletedAuxiliar());	
				variablenomi.setIsNew(variablenomi.getIsNewAuxiliar());	
				variablenomi.setIsChanged(variablenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				variablenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				variablenomi.setIsDeletedAuxiliar(false);	
				variablenomi.setIsNewAuxiliar(false);	
				variablenomi.setIsChangedAuxiliar(false);
				
				variablenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVariableNomi(VariableNomi variablenomi,Boolean conEnteros) throws Exception  {
		variablenomi.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVariableNomis(List<VariableNomi> variablenomis,Boolean conEnteros) throws Exception  {
		
		for(VariableNomi variablenomi: variablenomis) {
			variablenomi.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVariableNomi(List<VariableNomi> variablenomis,VariableNomi variablenomiAux) throws Exception  {
		VariableNomiConstantesFunciones.InicializarValoresVariableNomi(variablenomiAux,true);
		
		for(VariableNomi variablenomi: variablenomis) {
			if(variablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			variablenomiAux.setvalor(variablenomiAux.getvalor()+variablenomi.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VariableNomiConstantesFunciones.getArrayColumnasGlobalesVariableNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VariableNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VariableNomiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VariableNomiConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VariableNomiConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VariableNomi> variablenomis,VariableNomi variablenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VariableNomi variablenomiAux: variablenomis) {
			if(variablenomiAux!=null && variablenomi!=null) {
				if((variablenomiAux.getId()==null && variablenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(variablenomiAux.getId()!=null && variablenomi.getId()!=null){
					if(variablenomiAux.getId().equals(variablenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVariableNomi(List<VariableNomi> variablenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(VariableNomi variablenomi: variablenomis) {			
			if(variablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=variablenomi.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VariableNomiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(VariableNomiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVariableNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_ID, VariableNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_VERSIONROW, VariableNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_IDEMPRESA, VariableNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_IDMODULO, VariableNomiConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_IDTIPOVARIABLENOMI, VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_IDTIPOVALORVARIABLENOMI, VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_CODIGO, VariableNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_NOMBRE, VariableNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_SQL1, VariableNomiConstantesFunciones.SQL1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_SQL2, VariableNomiConstantesFunciones.SQL2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_SQL3, VariableNomiConstantesFunciones.SQL3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VariableNomiConstantesFunciones.LABEL_VALOR, VariableNomiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVariableNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.SQL1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.SQL2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.SQL3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VariableNomiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVariableNomi() throws Exception  {
		return VariableNomiConstantesFunciones.getTiposSeleccionarVariableNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVariableNomi(Boolean conFk) throws Exception  {
		return VariableNomiConstantesFunciones.getTiposSeleccionarVariableNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVariableNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_IDTIPOVARIABLENOMI);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_IDTIPOVARIABLENOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_IDTIPOVALORVARIABLENOMI);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_IDTIPOVALORVARIABLENOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_SQL1);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_SQL1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_SQL2);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_SQL2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_SQL3);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_SQL3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VariableNomiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(VariableNomiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVariableNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVariableNomi(VariableNomi variablenomiAux) throws Exception {
		
			variablenomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(variablenomiAux.getEmpresa()));
			variablenomiAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(variablenomiAux.getModulo()));
			variablenomiAux.settipovariablenomi_descripcion(TipoVariableNomiConstantesFunciones.getTipoVariableNomiDescripcion(variablenomiAux.getTipoVariableNomi()));
			variablenomiAux.settipovalorvariablenomi_descripcion(TipoValorVariableNomiConstantesFunciones.getTipoValorVariableNomiDescripcion(variablenomiAux.getTipoValorVariableNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVariableNomi(List<VariableNomi> variablenomisTemp) throws Exception {
		for(VariableNomi variablenomiAux:variablenomisTemp) {
			
			variablenomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(variablenomiAux.getEmpresa()));
			variablenomiAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(variablenomiAux.getModulo()));
			variablenomiAux.settipovariablenomi_descripcion(TipoVariableNomiConstantesFunciones.getTipoVariableNomiDescripcion(variablenomiAux.getTipoVariableNomi()));
			variablenomiAux.settipovalorvariablenomi_descripcion(TipoValorVariableNomiConstantesFunciones.getTipoValorVariableNomiDescripcion(variablenomiAux.getTipoValorVariableNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoVariableNomi.class));
				classes.add(new Classe(TipoValorVariableNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoVariableNomi.class)) {
						classes.add(new Classe(TipoVariableNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoValorVariableNomi.class)) {
						classes.add(new Classe(TipoValorVariableNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoVariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVariableNomi.class)); continue;
					}

					if(TipoValorVariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValorVariableNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoVariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVariableNomi.class)); continue;
					}

					if(TipoValorVariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValorVariableNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VariableNomiConstantesFunciones.getClassesRelationshipsOfVariableNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VariableNomiConstantesFunciones.getClassesRelationshipsFromStringsOfVariableNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VariableNomi variablenomi,List<VariableNomi> variablenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VariableNomi variablenomiEncontrado=null;
			
			for(VariableNomi variablenomiLocal:variablenomis) {
				if(variablenomiLocal.getId().equals(variablenomi.getId())) {
					variablenomiEncontrado=variablenomiLocal;
					
					variablenomiLocal.setIsChanged(variablenomi.getIsChanged());
					variablenomiLocal.setIsNew(variablenomi.getIsNew());
					variablenomiLocal.setIsDeleted(variablenomi.getIsDeleted());
					
					variablenomiLocal.setGeneralEntityOriginal(variablenomi.getGeneralEntityOriginal());
					
					variablenomiLocal.setId(variablenomi.getId());	
					variablenomiLocal.setVersionRow(variablenomi.getVersionRow());	
					variablenomiLocal.setid_empresa(variablenomi.getid_empresa());	
					variablenomiLocal.setid_modulo(variablenomi.getid_modulo());	
					variablenomiLocal.setid_tipo_variable_nomi(variablenomi.getid_tipo_variable_nomi());	
					variablenomiLocal.setid_tipo_valor_variable_nomi(variablenomi.getid_tipo_valor_variable_nomi());	
					variablenomiLocal.setcodigo(variablenomi.getcodigo());	
					variablenomiLocal.setnombre(variablenomi.getnombre());	
					variablenomiLocal.setsql1(variablenomi.getsql1());	
					variablenomiLocal.setsql2(variablenomi.getsql2());	
					variablenomiLocal.setsql3(variablenomi.getsql3());	
					variablenomiLocal.setvalor(variablenomi.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!variablenomi.getIsDeleted()) {
				if(!existe) {
					variablenomis.add(variablenomi);
				}
			} else {
				if(variablenomiEncontrado!=null && permiteQuitar)  {
					variablenomis.remove(variablenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VariableNomi variablenomi,List<VariableNomi> variablenomis) throws Exception {
		try	{			
			for(VariableNomi variablenomiLocal:variablenomis) {
				if(variablenomiLocal.getId().equals(variablenomi.getId())) {
					variablenomiLocal.setIsSelected(variablenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVariableNomi(List<VariableNomi> variablenomisAux) throws Exception {
		//this.variablenomisAux=variablenomisAux;
		
		for(VariableNomi variablenomiAux:variablenomisAux) {
			if(variablenomiAux.getIsChanged()) {
				variablenomiAux.setIsChanged(false);
			}		
			
			if(variablenomiAux.getIsNew()) {
				variablenomiAux.setIsNew(false);
			}	
			
			if(variablenomiAux.getIsDeleted()) {
				variablenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVariableNomi(VariableNomi variablenomiAux) throws Exception {
		//this.variablenomiAux=variablenomiAux;
		
			if(variablenomiAux.getIsChanged()) {
				variablenomiAux.setIsChanged(false);
			}		
			
			if(variablenomiAux.getIsNew()) {
				variablenomiAux.setIsNew(false);
			}	
			
			if(variablenomiAux.getIsDeleted()) {
				variablenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VariableNomi variablenomiAsignar,VariableNomi variablenomi) throws Exception {
		variablenomiAsignar.setId(variablenomi.getId());	
		variablenomiAsignar.setVersionRow(variablenomi.getVersionRow());	
		variablenomiAsignar.setid_empresa(variablenomi.getid_empresa());
		variablenomiAsignar.setempresa_descripcion(variablenomi.getempresa_descripcion());	
		variablenomiAsignar.setid_modulo(variablenomi.getid_modulo());
		variablenomiAsignar.setmodulo_descripcion(variablenomi.getmodulo_descripcion());	
		variablenomiAsignar.setid_tipo_variable_nomi(variablenomi.getid_tipo_variable_nomi());
		variablenomiAsignar.settipovariablenomi_descripcion(variablenomi.gettipovariablenomi_descripcion());	
		variablenomiAsignar.setid_tipo_valor_variable_nomi(variablenomi.getid_tipo_valor_variable_nomi());
		variablenomiAsignar.settipovalorvariablenomi_descripcion(variablenomi.gettipovalorvariablenomi_descripcion());	
		variablenomiAsignar.setcodigo(variablenomi.getcodigo());	
		variablenomiAsignar.setnombre(variablenomi.getnombre());	
		variablenomiAsignar.setsql1(variablenomi.getsql1());	
		variablenomiAsignar.setsql2(variablenomi.getsql2());	
		variablenomiAsignar.setsql3(variablenomi.getsql3());	
		variablenomiAsignar.setvalor(variablenomi.getvalor());	
	}
	
	public static void inicializarVariableNomi(VariableNomi variablenomi) throws Exception {
		try {
				variablenomi.setId(0L);	
					
				variablenomi.setid_empresa(-1L);	
				variablenomi.setid_modulo(-1L);	
				variablenomi.setid_tipo_variable_nomi(-1L);	
				variablenomi.setid_tipo_valor_variable_nomi(-1L);	
				variablenomi.setcodigo("");	
				variablenomi.setnombre("");	
				variablenomi.setsql1("");	
				variablenomi.setsql2("");	
				variablenomi.setsql3("");	
				variablenomi.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVariableNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_IDTIPOVARIABLENOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_IDTIPOVALORVARIABLENOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_SQL1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_SQL2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_SQL3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VariableNomiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVariableNomi(String sTipo,Row row,Workbook workbook,VariableNomi variablenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.gettipovariablenomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.gettipovalorvariablenomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getsql1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getsql2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getsql3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(variablenomi.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVariableNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVariableNomi() {
		return this.sFinalQueryVariableNomi;
	}
	
	public void setsFinalQueryVariableNomi(String sFinalQueryVariableNomi) {
		this.sFinalQueryVariableNomi= sFinalQueryVariableNomi;
	}
	
	public Border resaltarSeleccionarVariableNomi=null;
	
	public Border setResaltarSeleccionarVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVariableNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVariableNomi() {
		return this.resaltarSeleccionarVariableNomi;
	}
	
	public void setResaltarSeleccionarVariableNomi(Border borderResaltarSeleccionarVariableNomi) {
		this.resaltarSeleccionarVariableNomi= borderResaltarSeleccionarVariableNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVariableNomi=null;
	public Boolean mostraridVariableNomi=true;
	public Boolean activaridVariableNomi=true;

	public Border resaltarid_empresaVariableNomi=null;
	public Boolean mostrarid_empresaVariableNomi=true;
	public Boolean activarid_empresaVariableNomi=true;
	public Boolean cargarid_empresaVariableNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVariableNomi=false;//ConEventDepend=true

	public Border resaltarid_moduloVariableNomi=null;
	public Boolean mostrarid_moduloVariableNomi=true;
	public Boolean activarid_moduloVariableNomi=true;
	public Boolean cargarid_moduloVariableNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloVariableNomi=false;//ConEventDepend=true

	public Border resaltarid_tipo_variable_nomiVariableNomi=null;
	public Boolean mostrarid_tipo_variable_nomiVariableNomi=true;
	public Boolean activarid_tipo_variable_nomiVariableNomi=true;
	public Boolean cargarid_tipo_variable_nomiVariableNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_variable_nomiVariableNomi=false;//ConEventDepend=true

	public Border resaltarid_tipo_valor_variable_nomiVariableNomi=null;
	public Boolean mostrarid_tipo_valor_variable_nomiVariableNomi=true;
	public Boolean activarid_tipo_valor_variable_nomiVariableNomi=true;
	public Boolean cargarid_tipo_valor_variable_nomiVariableNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_valor_variable_nomiVariableNomi=false;//ConEventDepend=true

	public Border resaltarcodigoVariableNomi=null;
	public Boolean mostrarcodigoVariableNomi=true;
	public Boolean activarcodigoVariableNomi=true;

	public Border resaltarnombreVariableNomi=null;
	public Boolean mostrarnombreVariableNomi=true;
	public Boolean activarnombreVariableNomi=true;

	public Border resaltarsql1VariableNomi=null;
	public Boolean mostrarsql1VariableNomi=true;
	public Boolean activarsql1VariableNomi=true;

	public Border resaltarsql2VariableNomi=null;
	public Boolean mostrarsql2VariableNomi=true;
	public Boolean activarsql2VariableNomi=true;

	public Border resaltarsql3VariableNomi=null;
	public Boolean mostrarsql3VariableNomi=true;
	public Boolean activarsql3VariableNomi=true;

	public Border resaltarvalorVariableNomi=null;
	public Boolean mostrarvalorVariableNomi=true;
	public Boolean activarvalorVariableNomi=true;

	
	

	public Border setResaltaridVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltaridVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVariableNomi() {
		return this.resaltaridVariableNomi;
	}

	public void setResaltaridVariableNomi(Border borderResaltar) {
		this.resaltaridVariableNomi= borderResaltar;
	}

	public Boolean getMostraridVariableNomi() {
		return this.mostraridVariableNomi;
	}

	public void setMostraridVariableNomi(Boolean mostraridVariableNomi) {
		this.mostraridVariableNomi= mostraridVariableNomi;
	}

	public Boolean getActivaridVariableNomi() {
		return this.activaridVariableNomi;
	}

	public void setActivaridVariableNomi(Boolean activaridVariableNomi) {
		this.activaridVariableNomi= activaridVariableNomi;
	}

	public Border setResaltarid_empresaVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVariableNomi() {
		return this.resaltarid_empresaVariableNomi;
	}

	public void setResaltarid_empresaVariableNomi(Border borderResaltar) {
		this.resaltarid_empresaVariableNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaVariableNomi() {
		return this.mostrarid_empresaVariableNomi;
	}

	public void setMostrarid_empresaVariableNomi(Boolean mostrarid_empresaVariableNomi) {
		this.mostrarid_empresaVariableNomi= mostrarid_empresaVariableNomi;
	}

	public Boolean getActivarid_empresaVariableNomi() {
		return this.activarid_empresaVariableNomi;
	}

	public void setActivarid_empresaVariableNomi(Boolean activarid_empresaVariableNomi) {
		this.activarid_empresaVariableNomi= activarid_empresaVariableNomi;
	}

	public Boolean getCargarid_empresaVariableNomi() {
		return this.cargarid_empresaVariableNomi;
	}

	public void setCargarid_empresaVariableNomi(Boolean cargarid_empresaVariableNomi) {
		this.cargarid_empresaVariableNomi= cargarid_empresaVariableNomi;
	}

	public Border setResaltarid_moduloVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarid_moduloVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloVariableNomi() {
		return this.resaltarid_moduloVariableNomi;
	}

	public void setResaltarid_moduloVariableNomi(Border borderResaltar) {
		this.resaltarid_moduloVariableNomi= borderResaltar;
	}

	public Boolean getMostrarid_moduloVariableNomi() {
		return this.mostrarid_moduloVariableNomi;
	}

	public void setMostrarid_moduloVariableNomi(Boolean mostrarid_moduloVariableNomi) {
		this.mostrarid_moduloVariableNomi= mostrarid_moduloVariableNomi;
	}

	public Boolean getActivarid_moduloVariableNomi() {
		return this.activarid_moduloVariableNomi;
	}

	public void setActivarid_moduloVariableNomi(Boolean activarid_moduloVariableNomi) {
		this.activarid_moduloVariableNomi= activarid_moduloVariableNomi;
	}

	public Boolean getCargarid_moduloVariableNomi() {
		return this.cargarid_moduloVariableNomi;
	}

	public void setCargarid_moduloVariableNomi(Boolean cargarid_moduloVariableNomi) {
		this.cargarid_moduloVariableNomi= cargarid_moduloVariableNomi;
	}

	public Border setResaltarid_tipo_variable_nomiVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarid_tipo_variable_nomiVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_variable_nomiVariableNomi() {
		return this.resaltarid_tipo_variable_nomiVariableNomi;
	}

	public void setResaltarid_tipo_variable_nomiVariableNomi(Border borderResaltar) {
		this.resaltarid_tipo_variable_nomiVariableNomi= borderResaltar;
	}

	public Boolean getMostrarid_tipo_variable_nomiVariableNomi() {
		return this.mostrarid_tipo_variable_nomiVariableNomi;
	}

	public void setMostrarid_tipo_variable_nomiVariableNomi(Boolean mostrarid_tipo_variable_nomiVariableNomi) {
		this.mostrarid_tipo_variable_nomiVariableNomi= mostrarid_tipo_variable_nomiVariableNomi;
	}

	public Boolean getActivarid_tipo_variable_nomiVariableNomi() {
		return this.activarid_tipo_variable_nomiVariableNomi;
	}

	public void setActivarid_tipo_variable_nomiVariableNomi(Boolean activarid_tipo_variable_nomiVariableNomi) {
		this.activarid_tipo_variable_nomiVariableNomi= activarid_tipo_variable_nomiVariableNomi;
	}

	public Boolean getCargarid_tipo_variable_nomiVariableNomi() {
		return this.cargarid_tipo_variable_nomiVariableNomi;
	}

	public void setCargarid_tipo_variable_nomiVariableNomi(Boolean cargarid_tipo_variable_nomiVariableNomi) {
		this.cargarid_tipo_variable_nomiVariableNomi= cargarid_tipo_variable_nomiVariableNomi;
	}

	public Border setResaltarid_tipo_valor_variable_nomiVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarid_tipo_valor_variable_nomiVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_valor_variable_nomiVariableNomi() {
		return this.resaltarid_tipo_valor_variable_nomiVariableNomi;
	}

	public void setResaltarid_tipo_valor_variable_nomiVariableNomi(Border borderResaltar) {
		this.resaltarid_tipo_valor_variable_nomiVariableNomi= borderResaltar;
	}

	public Boolean getMostrarid_tipo_valor_variable_nomiVariableNomi() {
		return this.mostrarid_tipo_valor_variable_nomiVariableNomi;
	}

	public void setMostrarid_tipo_valor_variable_nomiVariableNomi(Boolean mostrarid_tipo_valor_variable_nomiVariableNomi) {
		this.mostrarid_tipo_valor_variable_nomiVariableNomi= mostrarid_tipo_valor_variable_nomiVariableNomi;
	}

	public Boolean getActivarid_tipo_valor_variable_nomiVariableNomi() {
		return this.activarid_tipo_valor_variable_nomiVariableNomi;
	}

	public void setActivarid_tipo_valor_variable_nomiVariableNomi(Boolean activarid_tipo_valor_variable_nomiVariableNomi) {
		this.activarid_tipo_valor_variable_nomiVariableNomi= activarid_tipo_valor_variable_nomiVariableNomi;
	}

	public Boolean getCargarid_tipo_valor_variable_nomiVariableNomi() {
		return this.cargarid_tipo_valor_variable_nomiVariableNomi;
	}

	public void setCargarid_tipo_valor_variable_nomiVariableNomi(Boolean cargarid_tipo_valor_variable_nomiVariableNomi) {
		this.cargarid_tipo_valor_variable_nomiVariableNomi= cargarid_tipo_valor_variable_nomiVariableNomi;
	}

	public Border setResaltarcodigoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoVariableNomi() {
		return this.resaltarcodigoVariableNomi;
	}

	public void setResaltarcodigoVariableNomi(Border borderResaltar) {
		this.resaltarcodigoVariableNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoVariableNomi() {
		return this.mostrarcodigoVariableNomi;
	}

	public void setMostrarcodigoVariableNomi(Boolean mostrarcodigoVariableNomi) {
		this.mostrarcodigoVariableNomi= mostrarcodigoVariableNomi;
	}

	public Boolean getActivarcodigoVariableNomi() {
		return this.activarcodigoVariableNomi;
	}

	public void setActivarcodigoVariableNomi(Boolean activarcodigoVariableNomi) {
		this.activarcodigoVariableNomi= activarcodigoVariableNomi;
	}

	public Border setResaltarnombreVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarnombreVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreVariableNomi() {
		return this.resaltarnombreVariableNomi;
	}

	public void setResaltarnombreVariableNomi(Border borderResaltar) {
		this.resaltarnombreVariableNomi= borderResaltar;
	}

	public Boolean getMostrarnombreVariableNomi() {
		return this.mostrarnombreVariableNomi;
	}

	public void setMostrarnombreVariableNomi(Boolean mostrarnombreVariableNomi) {
		this.mostrarnombreVariableNomi= mostrarnombreVariableNomi;
	}

	public Boolean getActivarnombreVariableNomi() {
		return this.activarnombreVariableNomi;
	}

	public void setActivarnombreVariableNomi(Boolean activarnombreVariableNomi) {
		this.activarnombreVariableNomi= activarnombreVariableNomi;
	}

	public Border setResaltarsql1VariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarsql1VariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsql1VariableNomi() {
		return this.resaltarsql1VariableNomi;
	}

	public void setResaltarsql1VariableNomi(Border borderResaltar) {
		this.resaltarsql1VariableNomi= borderResaltar;
	}

	public Boolean getMostrarsql1VariableNomi() {
		return this.mostrarsql1VariableNomi;
	}

	public void setMostrarsql1VariableNomi(Boolean mostrarsql1VariableNomi) {
		this.mostrarsql1VariableNomi= mostrarsql1VariableNomi;
	}

	public Boolean getActivarsql1VariableNomi() {
		return this.activarsql1VariableNomi;
	}

	public void setActivarsql1VariableNomi(Boolean activarsql1VariableNomi) {
		this.activarsql1VariableNomi= activarsql1VariableNomi;
	}

	public Border setResaltarsql2VariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarsql2VariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsql2VariableNomi() {
		return this.resaltarsql2VariableNomi;
	}

	public void setResaltarsql2VariableNomi(Border borderResaltar) {
		this.resaltarsql2VariableNomi= borderResaltar;
	}

	public Boolean getMostrarsql2VariableNomi() {
		return this.mostrarsql2VariableNomi;
	}

	public void setMostrarsql2VariableNomi(Boolean mostrarsql2VariableNomi) {
		this.mostrarsql2VariableNomi= mostrarsql2VariableNomi;
	}

	public Boolean getActivarsql2VariableNomi() {
		return this.activarsql2VariableNomi;
	}

	public void setActivarsql2VariableNomi(Boolean activarsql2VariableNomi) {
		this.activarsql2VariableNomi= activarsql2VariableNomi;
	}

	public Border setResaltarsql3VariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarsql3VariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsql3VariableNomi() {
		return this.resaltarsql3VariableNomi;
	}

	public void setResaltarsql3VariableNomi(Border borderResaltar) {
		this.resaltarsql3VariableNomi= borderResaltar;
	}

	public Boolean getMostrarsql3VariableNomi() {
		return this.mostrarsql3VariableNomi;
	}

	public void setMostrarsql3VariableNomi(Boolean mostrarsql3VariableNomi) {
		this.mostrarsql3VariableNomi= mostrarsql3VariableNomi;
	}

	public Boolean getActivarsql3VariableNomi() {
		return this.activarsql3VariableNomi;
	}

	public void setActivarsql3VariableNomi(Boolean activarsql3VariableNomi) {
		this.activarsql3VariableNomi= activarsql3VariableNomi;
	}

	public Border setResaltarvalorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//variablenomiBeanSwingJInternalFrame.jTtoolBarVariableNomi.setBorder(borderResaltar);
		
		this.resaltarvalorVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorVariableNomi() {
		return this.resaltarvalorVariableNomi;
	}

	public void setResaltarvalorVariableNomi(Border borderResaltar) {
		this.resaltarvalorVariableNomi= borderResaltar;
	}

	public Boolean getMostrarvalorVariableNomi() {
		return this.mostrarvalorVariableNomi;
	}

	public void setMostrarvalorVariableNomi(Boolean mostrarvalorVariableNomi) {
		this.mostrarvalorVariableNomi= mostrarvalorVariableNomi;
	}

	public Boolean getActivarvalorVariableNomi() {
		return this.activarvalorVariableNomi;
	}

	public void setActivarvalorVariableNomi(Boolean activarvalorVariableNomi) {
		this.activarvalorVariableNomi= activarvalorVariableNomi;
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
		
		
		this.setMostraridVariableNomi(esInicial);
		this.setMostrarid_empresaVariableNomi(esInicial);
		this.setMostrarid_moduloVariableNomi(esInicial);
		this.setMostrarid_tipo_variable_nomiVariableNomi(esInicial);
		this.setMostrarid_tipo_valor_variable_nomiVariableNomi(esInicial);
		this.setMostrarcodigoVariableNomi(esInicial);
		this.setMostrarnombreVariableNomi(esInicial);
		this.setMostrarsql1VariableNomi(esInicial);
		this.setMostrarsql2VariableNomi(esInicial);
		this.setMostrarsql3VariableNomi(esInicial);
		this.setMostrarvalorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VariableNomiConstantesFunciones.ID)) {
				this.setMostraridVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI)) {
				this.setMostrarid_tipo_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI)) {
				this.setMostrarid_tipo_valor_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL1)) {
				this.setMostrarsql1VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL2)) {
				this.setMostrarsql2VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL3)) {
				this.setMostrarsql3VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.VALOR)) {
				this.setMostrarvalorVariableNomi(esAsigna);
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
		
		
		this.setActivaridVariableNomi(esInicial);
		this.setActivarid_empresaVariableNomi(esInicial);
		this.setActivarid_moduloVariableNomi(esInicial);
		this.setActivarid_tipo_variable_nomiVariableNomi(esInicial);
		this.setActivarid_tipo_valor_variable_nomiVariableNomi(esInicial);
		this.setActivarcodigoVariableNomi(esInicial);
		this.setActivarnombreVariableNomi(esInicial);
		this.setActivarsql1VariableNomi(esInicial);
		this.setActivarsql2VariableNomi(esInicial);
		this.setActivarsql3VariableNomi(esInicial);
		this.setActivarvalorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VariableNomiConstantesFunciones.ID)) {
				this.setActivaridVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI)) {
				this.setActivarid_tipo_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI)) {
				this.setActivarid_tipo_valor_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL1)) {
				this.setActivarsql1VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL2)) {
				this.setActivarsql2VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL3)) {
				this.setActivarsql3VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.VALOR)) {
				this.setActivarvalorVariableNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVariableNomi(esInicial);
		this.setResaltarid_empresaVariableNomi(esInicial);
		this.setResaltarid_moduloVariableNomi(esInicial);
		this.setResaltarid_tipo_variable_nomiVariableNomi(esInicial);
		this.setResaltarid_tipo_valor_variable_nomiVariableNomi(esInicial);
		this.setResaltarcodigoVariableNomi(esInicial);
		this.setResaltarnombreVariableNomi(esInicial);
		this.setResaltarsql1VariableNomi(esInicial);
		this.setResaltarsql2VariableNomi(esInicial);
		this.setResaltarsql3VariableNomi(esInicial);
		this.setResaltarvalorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VariableNomiConstantesFunciones.ID)) {
				this.setResaltaridVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI)) {
				this.setResaltarid_tipo_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI)) {
				this.setResaltarid_tipo_valor_variable_nomiVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL1)) {
				this.setResaltarsql1VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL2)) {
				this.setResaltarsql2VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.SQL3)) {
				this.setResaltarsql3VariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(VariableNomiConstantesFunciones.VALOR)) {
				this.setResaltarvalorVariableNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaVariableNomi=true;

	public Boolean getMostrarFK_IdEmpresaVariableNomi() {
		return this.mostrarFK_IdEmpresaVariableNomi;
	}

	public void setMostrarFK_IdEmpresaVariableNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVariableNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloVariableNomi=true;

	public Boolean getMostrarFK_IdModuloVariableNomi() {
		return this.mostrarFK_IdModuloVariableNomi;
	}

	public void setMostrarFK_IdModuloVariableNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloVariableNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoValorVariableNomiVariableNomi=true;

	public Boolean getMostrarFK_IdTipoValorVariableNomiVariableNomi() {
		return this.mostrarFK_IdTipoValorVariableNomiVariableNomi;
	}

	public void setMostrarFK_IdTipoValorVariableNomiVariableNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoValorVariableNomiVariableNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoVariableNomiVariableNomi=true;

	public Boolean getMostrarFK_IdTipoVariableNomiVariableNomi() {
		return this.mostrarFK_IdTipoVariableNomiVariableNomi;
	}

	public void setMostrarFK_IdTipoVariableNomiVariableNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoVariableNomiVariableNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaVariableNomi=true;

	public Boolean getActivarFK_IdEmpresaVariableNomi() {
		return this.activarFK_IdEmpresaVariableNomi;
	}

	public void setActivarFK_IdEmpresaVariableNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVariableNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloVariableNomi=true;

	public Boolean getActivarFK_IdModuloVariableNomi() {
		return this.activarFK_IdModuloVariableNomi;
	}

	public void setActivarFK_IdModuloVariableNomi(Boolean habilitarResaltar) {
		this.activarFK_IdModuloVariableNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoValorVariableNomiVariableNomi=true;

	public Boolean getActivarFK_IdTipoValorVariableNomiVariableNomi() {
		return this.activarFK_IdTipoValorVariableNomiVariableNomi;
	}

	public void setActivarFK_IdTipoValorVariableNomiVariableNomi(Boolean habilitarResaltar) {
		this.activarFK_IdTipoValorVariableNomiVariableNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoVariableNomiVariableNomi=true;

	public Boolean getActivarFK_IdTipoVariableNomiVariableNomi() {
		return this.activarFK_IdTipoVariableNomiVariableNomi;
	}

	public void setActivarFK_IdTipoVariableNomiVariableNomi(Boolean habilitarResaltar) {
		this.activarFK_IdTipoVariableNomiVariableNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaVariableNomi=null;

	public Border getResaltarFK_IdEmpresaVariableNomi() {
		return this.resaltarFK_IdEmpresaVariableNomi;
	}

	public void setResaltarFK_IdEmpresaVariableNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVariableNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVariableNomi= borderResaltar;
	}

	public Border resaltarFK_IdModuloVariableNomi=null;

	public Border getResaltarFK_IdModuloVariableNomi() {
		return this.resaltarFK_IdModuloVariableNomi;
	}

	public void setResaltarFK_IdModuloVariableNomi(Border borderResaltar) {
		this.resaltarFK_IdModuloVariableNomi= borderResaltar;
	}

	public void setResaltarFK_IdModuloVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloVariableNomi= borderResaltar;
	}

	public Border resaltarFK_IdTipoValorVariableNomiVariableNomi=null;

	public Border getResaltarFK_IdTipoValorVariableNomiVariableNomi() {
		return this.resaltarFK_IdTipoValorVariableNomiVariableNomi;
	}

	public void setResaltarFK_IdTipoValorVariableNomiVariableNomi(Border borderResaltar) {
		this.resaltarFK_IdTipoValorVariableNomiVariableNomi= borderResaltar;
	}

	public void setResaltarFK_IdTipoValorVariableNomiVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoValorVariableNomiVariableNomi= borderResaltar;
	}

	public Border resaltarFK_IdTipoVariableNomiVariableNomi=null;

	public Border getResaltarFK_IdTipoVariableNomiVariableNomi() {
		return this.resaltarFK_IdTipoVariableNomiVariableNomi;
	}

	public void setResaltarFK_IdTipoVariableNomiVariableNomi(Border borderResaltar) {
		this.resaltarFK_IdTipoVariableNomiVariableNomi= borderResaltar;
	}

	public void setResaltarFK_IdTipoVariableNomiVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*VariableNomiBeanSwingJInternalFrame variablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoVariableNomiVariableNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}