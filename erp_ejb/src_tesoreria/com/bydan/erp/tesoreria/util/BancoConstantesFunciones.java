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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.BancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BancoConstantesFunciones extends BancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Banco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Banco"+BancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BancoConstantesFunciones.SCHEMA+"_"+BancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BancoConstantesFunciones.SCHEMA+"_"+BancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BancoConstantesFunciones.SCHEMA+"_"+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BancoConstantesFunciones.SCHEMA+"_"+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Banco";
	public static final String SCLASSWEBTITULO_LOWER="Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Banco";
	public static final String OBJECTNAME="banco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select banco from "+BancoConstantesFunciones.SPERSISTENCENAME+" banco";
	public static String QUERYSELECTNATIVE="select "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".version_row,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_empresa,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_sucursal,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".codigo,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".codigo_institucion,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".nombre,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_tipo_banco,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".dias_efectivo_local,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".dias_efectivo_extranjero,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".delimitador,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_formato1,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_formato2 from "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME;//+" as "+BancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BancoConstantesFuncionesAdditional bancoConstantesFuncionesAdditional=null;
	
	public BancoConstantesFuncionesAdditional getBancoConstantesFuncionesAdditional() {
		return this.bancoConstantesFuncionesAdditional;
	}
	
	public void setBancoConstantesFuncionesAdditional(BancoConstantesFuncionesAdditional bancoConstantesFuncionesAdditional) {
		try {
			this.bancoConstantesFuncionesAdditional=bancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String CODIGOINSTITUCION= "codigo_institucion";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOBANCO= "id_tipo_banco";
    public static final String DIASEFECTIVOLOCAL= "dias_efectivo_local";
    public static final String DIASEFECTIVOEXTRANJERO= "dias_efectivo_extranjero";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String DELIMITADOR= "delimitador";
    public static final String IDFORMATO1= "id_formato1";
    public static final String IDFORMATO2= "id_formato2";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_CODIGOINSTITUCION= "Codigo Institucion";
		public static final String LABEL_CODIGOINSTITUCION_LOWER= "Codigo Institucion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOBANCO= "Tipo Banco Sri";
		public static final String LABEL_IDTIPOBANCO_LOWER= "Tipo Banco";
    	public static final String LABEL_DIASEFECTIVOLOCAL= "Dias Efectivo Local";
		public static final String LABEL_DIASEFECTIVOLOCAL_LOWER= "Dias Efectivo Local";
    	public static final String LABEL_DIASEFECTIVOEXTRANJERO= "Dias Efectivo Extranjero";
		public static final String LABEL_DIASEFECTIVOEXTRANJERO_LOWER= "Dias Efectivo Extranjero";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta Contable Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_DELIMITADOR= "Delimitador";
		public static final String LABEL_DELIMITADOR_LOWER= "Delimitador";
    	public static final String LABEL_IDFORMATO1= "Formato1";
		public static final String LABEL_IDFORMATO1_LOWER= "Formato1";
    	public static final String LABEL_IDFORMATO2= "Formato2";
		public static final String LABEL_IDFORMATO2_LOWER= "Formato2";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_INSTITUCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_INSTITUCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDELIMITADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDELIMITADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BancoConstantesFunciones.CODIGO)) {sLabelColumna=BancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(BancoConstantesFunciones.CODIGOINSTITUCION)) {sLabelColumna=BancoConstantesFunciones.LABEL_CODIGOINSTITUCION;}
		if(sNombreColumna.equals(BancoConstantesFunciones.NOMBRE)) {sLabelColumna=BancoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDTIPOBANCO)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDTIPOBANCO;}
		if(sNombreColumna.equals(BancoConstantesFunciones.DIASEFECTIVOLOCAL)) {sLabelColumna=BancoConstantesFunciones.LABEL_DIASEFECTIVOLOCAL;}
		if(sNombreColumna.equals(BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO)) {sLabelColumna=BancoConstantesFunciones.LABEL_DIASEFECTIVOEXTRANJERO;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(BancoConstantesFunciones.DELIMITADOR)) {sLabelColumna=BancoConstantesFunciones.LABEL_DELIMITADOR;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDFORMATO1)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDFORMATO1;}
		if(sNombreColumna.equals(BancoConstantesFunciones.IDFORMATO2)) {sLabelColumna=BancoConstantesFunciones.LABEL_IDFORMATO2;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(banco !=null/* && banco.getId()!=0*/) {
			sDescripcion=banco.getnombre();//bancobanco.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getBancoDescripcionDetallado(Banco banco) {
		String sDescripcion="";
			
		sDescripcion+=BancoConstantesFunciones.ID+"=";
		sDescripcion+=banco.getId().toString()+",";
		sDescripcion+=BancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=banco.getVersionRow().toString()+",";
		sDescripcion+=BancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=banco.getid_empresa().toString()+",";
		sDescripcion+=BancoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=banco.getid_sucursal().toString()+",";
		sDescripcion+=BancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=banco.getcodigo()+",";
		sDescripcion+=BancoConstantesFunciones.CODIGOINSTITUCION+"=";
		sDescripcion+=banco.getcodigo_institucion()+",";
		sDescripcion+=BancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=banco.getnombre()+",";
		sDescripcion+=BancoConstantesFunciones.IDTIPOBANCO+"=";
		sDescripcion+=banco.getid_tipo_banco().toString()+",";
		sDescripcion+=BancoConstantesFunciones.DIASEFECTIVOLOCAL+"=";
		sDescripcion+=banco.getdias_efectivo_local().toString()+",";
		sDescripcion+=BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO+"=";
		sDescripcion+=banco.getdias_efectivo_extranjero().toString()+",";
		sDescripcion+=BancoConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=banco.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=BancoConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=banco.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=BancoConstantesFunciones.DELIMITADOR+"=";
		sDescripcion+=banco.getdelimitador()+",";
		sDescripcion+=BancoConstantesFunciones.IDFORMATO1+"=";
		sDescripcion+=banco.getid_formato1().toString()+",";
		sDescripcion+=BancoConstantesFunciones.IDFORMATO2+"=";
		sDescripcion+=banco.getid_formato2().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBancoDescripcion(Banco banco,String sValor) throws Exception {			
		if(banco !=null) {
			banco.setnombre(sValor);;//bancobanco.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTipoBancoDescripcion(TipoBanco tipobanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipobanco!=null/*&&tipobanco.getId()>0*/) {
			sDescripcion=TipoBancoConstantesFunciones.getTipoBancoDescripcion(tipobanco);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getFormato1Descripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormato2Descripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorCodigoInstitucion")) {
			sNombreIndice="Tipo=  Por Codigo Institucion";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato1")) {
			sNombreIndice="Tipo=  Por Formato1";
		} else if(sNombreIndice.equals("FK_IdFormato2")) {
			sNombreIndice="Tipo=  Por Formato2";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoBanco")) {
			sNombreIndice="Tipo=  Por Tipo Banco Sri";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorCodigoInstitucion(String codigo_institucion) {
		String sDetalleIndice=" Parametros->";
		if(codigo_institucion!=null) {sDetalleIndice+=" Codigo Institucion="+codigo_institucion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato1(Long id_formato1) {
		String sDetalleIndice=" Parametros->";
		if(id_formato1!=null) {sDetalleIndice+=" Codigo Unico De Formato1="+id_formato1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato2(Long id_formato2) {
		String sDetalleIndice=" Parametros->";
		if(id_formato2!=null) {sDetalleIndice+=" Codigo Unico De Formato2="+id_formato2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoBanco(Long id_tipo_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_banco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Banco Sri="+id_tipo_banco.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBanco(Banco banco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		banco.setcodigo(banco.getcodigo().trim());
		banco.setcodigo_institucion(banco.getcodigo_institucion().trim());
		banco.setnombre(banco.getnombre().trim());
		banco.setdelimitador(banco.getdelimitador().trim());
	}
	
	public static void quitarEspaciosBancos(List<Banco> bancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Banco banco: bancos) {
			banco.setcodigo(banco.getcodigo().trim());
			banco.setcodigo_institucion(banco.getcodigo_institucion().trim());
			banco.setnombre(banco.getnombre().trim());
			banco.setdelimitador(banco.getdelimitador().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBanco(Banco banco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && banco.getConCambioAuxiliar()) {
			banco.setIsDeleted(banco.getIsDeletedAuxiliar());	
			banco.setIsNew(banco.getIsNewAuxiliar());	
			banco.setIsChanged(banco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			banco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			banco.setIsDeletedAuxiliar(false);	
			banco.setIsNewAuxiliar(false);	
			banco.setIsChangedAuxiliar(false);
			
			banco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBancos(List<Banco> bancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Banco banco : bancos) {
			if(conAsignarBase && banco.getConCambioAuxiliar()) {
				banco.setIsDeleted(banco.getIsDeletedAuxiliar());	
				banco.setIsNew(banco.getIsNewAuxiliar());	
				banco.setIsChanged(banco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				banco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				banco.setIsDeletedAuxiliar(false);	
				banco.setIsNewAuxiliar(false);	
				banco.setIsChangedAuxiliar(false);
				
				banco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBanco(Banco banco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			banco.setdias_efectivo_local(0);
			banco.setdias_efectivo_extranjero(0);
		}
	}		
	
	public static void InicializarValoresBancos(List<Banco> bancos,Boolean conEnteros) throws Exception  {
		
		for(Banco banco: bancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				banco.setdias_efectivo_local(0);
				banco.setdias_efectivo_extranjero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaBanco(List<Banco> bancos,Banco bancoAux) throws Exception  {
		BancoConstantesFunciones.InicializarValoresBanco(bancoAux,true);
		
		for(Banco banco: bancos) {
			if(banco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bancoAux.setdias_efectivo_local(bancoAux.getdias_efectivo_local()+banco.getdias_efectivo_local());			
			bancoAux.setdias_efectivo_extranjero(bancoAux.getdias_efectivo_extranjero()+banco.getdias_efectivo_extranjero());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BancoConstantesFunciones.getArrayColumnasGlobalesBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Banco> bancos,Banco banco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Banco bancoAux: bancos) {
			if(bancoAux!=null && banco!=null) {
				if((bancoAux.getId()==null && banco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bancoAux.getId()!=null && banco.getId()!=null){
					if(bancoAux.getId().equals(banco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBanco(List<Banco> bancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Banco banco: bancos) {			
			if(banco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_ID, BancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_VERSIONROW, BancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDEMPRESA, BancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDSUCURSAL, BancoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_CODIGO, BancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_CODIGOINSTITUCION, BancoConstantesFunciones.CODIGOINSTITUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_NOMBRE, BancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDTIPOBANCO, BancoConstantesFunciones.IDTIPOBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_DIASEFECTIVOLOCAL, BancoConstantesFunciones.DIASEFECTIVOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_DIASEFECTIVOEXTRANJERO, BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, BancoConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, BancoConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_DELIMITADOR, BancoConstantesFunciones.DELIMITADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDFORMATO1, BancoConstantesFunciones.IDFORMATO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoConstantesFunciones.LABEL_IDFORMATO2, BancoConstantesFunciones.IDFORMATO2,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.CODIGOINSTITUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDTIPOBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.DIASEFECTIVOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.DELIMITADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDFORMATO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoConstantesFunciones.IDFORMATO2;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBanco() throws Exception  {
		return BancoConstantesFunciones.getTiposSeleccionarBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBanco(Boolean conFk) throws Exception  {
		return BancoConstantesFunciones.getTiposSeleccionarBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_CODIGOINSTITUCION);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_CODIGOINSTITUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDTIPOBANCO);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDTIPOBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_DIASEFECTIVOLOCAL);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_DIASEFECTIVOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_DIASEFECTIVOEXTRANJERO);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_DIASEFECTIVOEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_DELIMITADOR);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_DELIMITADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDFORMATO1);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDFORMATO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoConstantesFunciones.LABEL_IDFORMATO2);
			reporte.setsDescripcion(BancoConstantesFunciones.LABEL_IDFORMATO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBanco(Banco bancoAux) throws Exception {
		
			bancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancoAux.getEmpresa()));
			bancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bancoAux.getSucursal()));
			bancoAux.settipobanco_descripcion(TipoBancoConstantesFunciones.getTipoBancoDescripcion(bancoAux.getTipoBanco()));
			bancoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bancoAux.getCuentaContableDebito()));
			bancoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bancoAux.getCuentaContableCredito()));
			bancoAux.setformato1_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(bancoAux.getFormato1()));
			bancoAux.setformato2_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(bancoAux.getFormato2()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBanco(List<Banco> bancosTemp) throws Exception {
		for(Banco bancoAux:bancosTemp) {
			
			bancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancoAux.getEmpresa()));
			bancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bancoAux.getSucursal()));
			bancoAux.settipobanco_descripcion(TipoBancoConstantesFunciones.getTipoBancoDescripcion(bancoAux.getTipoBanco()));
			bancoAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bancoAux.getCuentaContableDebito()));
			bancoAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bancoAux.getCuentaContableCredito()));
			bancoAux.setformato1_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(bancoAux.getFormato1()));
			bancoAux.setformato2_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(bancoAux.getFormato2()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoBanco.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoBanco.class)) {
						classes.add(new Classe(TipoBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBanco.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBanco.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoConstantesFunciones.getClassesRelationshipsOfBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaBancoPunVen.class));
				classes.add(new Classe(PoliticasCliente.class));
				classes.add(new Classe(FormularioRentaExtra.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				classes.add(new Classe(AutoriPagoOrdenCompra.class));
				classes.add(new Classe(ReciboPuntoVenta.class));
				classes.add(new Classe(TarjetaCredito.class));
				classes.add(new Classe(AutoriPago.class));
				classes.add(new Classe(TipoCuentaBancoGeneral.class));
				classes.add(new Classe(ReferenciaBancaria.class));
				classes.add(new Classe(DepositoBanco.class));
				classes.add(new Classe(BancoTipoCuentaBancoGlobal.class));
				classes.add(new Classe(CuentaBanco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBancoPunVen.class)) {
						classes.add(new Classe(CuentaBancoPunVen.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRentaExtra.class)) {
						classes.add(new Classe(FormularioRentaExtra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPagoOrdenCompra.class)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReciboPuntoVenta.class)) {
						classes.add(new Classe(ReciboPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPago.class)) {
						classes.add(new Classe(AutoriPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGeneral.class)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaBancaria.class)) {
						classes.add(new Classe(ReferenciaBancaria.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DepositoBanco.class)) {
						classes.add(new Classe(DepositoBanco.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoConstantesFunciones.getClassesRelationshipsFromStringsOfBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaBancoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBancoPunVen.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(ReciboPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReciboPuntoVenta.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}

					if(TipoCuentaBancoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); continue;
					}

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(DepositoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepositoBanco.class)); continue;
					}

					if(BancoTipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaBancoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBancoPunVen.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(ReciboPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReciboPuntoVenta.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}

					if(TipoCuentaBancoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); continue;
					}

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(DepositoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepositoBanco.class)); continue;
					}

					if(BancoTipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
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
	public static void actualizarLista(Banco banco,List<Banco> bancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Banco bancoEncontrado=null;
			
			for(Banco bancoLocal:bancos) {
				if(bancoLocal.getId().equals(banco.getId())) {
					bancoEncontrado=bancoLocal;
					
					bancoLocal.setIsChanged(banco.getIsChanged());
					bancoLocal.setIsNew(banco.getIsNew());
					bancoLocal.setIsDeleted(banco.getIsDeleted());
					
					bancoLocal.setGeneralEntityOriginal(banco.getGeneralEntityOriginal());
					
					bancoLocal.setId(banco.getId());	
					bancoLocal.setVersionRow(banco.getVersionRow());	
					bancoLocal.setid_empresa(banco.getid_empresa());	
					bancoLocal.setid_sucursal(banco.getid_sucursal());	
					bancoLocal.setcodigo(banco.getcodigo());	
					bancoLocal.setcodigo_institucion(banco.getcodigo_institucion());	
					bancoLocal.setnombre(banco.getnombre());	
					bancoLocal.setid_tipo_banco(banco.getid_tipo_banco());	
					bancoLocal.setdias_efectivo_local(banco.getdias_efectivo_local());	
					bancoLocal.setdias_efectivo_extranjero(banco.getdias_efectivo_extranjero());	
					bancoLocal.setid_cuenta_contable_debito(banco.getid_cuenta_contable_debito());	
					bancoLocal.setid_cuenta_contable_credito(banco.getid_cuenta_contable_credito());	
					bancoLocal.setdelimitador(banco.getdelimitador());	
					bancoLocal.setid_formato1(banco.getid_formato1());	
					bancoLocal.setid_formato2(banco.getid_formato2());	
					
					
					bancoLocal.setAutoriPagos(banco.getAutoriPagos());
					bancoLocal.setTarjetaCreditos(banco.getTarjetaCreditos());
					bancoLocal.setCuentaBancoPunVens(banco.getCuentaBancoPunVens());
					bancoLocal.setPoliticasClientes(banco.getPoliticasClientes());
					bancoLocal.setFormaPagoPuntoVentas(banco.getFormaPagoPuntoVentas());
					bancoLocal.setCuentaBancos(banco.getCuentaBancos());
					bancoLocal.setTipoCuentaBancoGenerals(banco.getTipoCuentaBancoGenerals());
					
					existe=true;
					break;
				}
			}
			
			if(!banco.getIsDeleted()) {
				if(!existe) {
					bancos.add(banco);
				}
			} else {
				if(bancoEncontrado!=null && permiteQuitar)  {
					bancos.remove(bancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Banco banco,List<Banco> bancos) throws Exception {
		try	{			
			for(Banco bancoLocal:bancos) {
				if(bancoLocal.getId().equals(banco.getId())) {
					bancoLocal.setIsSelected(banco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBanco(List<Banco> bancosAux) throws Exception {
		//this.bancosAux=bancosAux;
		
		for(Banco bancoAux:bancosAux) {
			if(bancoAux.getIsChanged()) {
				bancoAux.setIsChanged(false);
			}		
			
			if(bancoAux.getIsNew()) {
				bancoAux.setIsNew(false);
			}	
			
			if(bancoAux.getIsDeleted()) {
				bancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBanco(Banco bancoAux) throws Exception {
		//this.bancoAux=bancoAux;
		
			if(bancoAux.getIsChanged()) {
				bancoAux.setIsChanged(false);
			}		
			
			if(bancoAux.getIsNew()) {
				bancoAux.setIsNew(false);
			}	
			
			if(bancoAux.getIsDeleted()) {
				bancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Banco bancoAsignar,Banco banco) throws Exception {
		bancoAsignar.setId(banco.getId());	
		bancoAsignar.setVersionRow(banco.getVersionRow());	
		bancoAsignar.setid_empresa(banco.getid_empresa());
		bancoAsignar.setempresa_descripcion(banco.getempresa_descripcion());	
		bancoAsignar.setid_sucursal(banco.getid_sucursal());
		bancoAsignar.setsucursal_descripcion(banco.getsucursal_descripcion());	
		bancoAsignar.setcodigo(banco.getcodigo());	
		bancoAsignar.setcodigo_institucion(banco.getcodigo_institucion());	
		bancoAsignar.setnombre(banco.getnombre());	
		bancoAsignar.setid_tipo_banco(banco.getid_tipo_banco());
		bancoAsignar.settipobanco_descripcion(banco.gettipobanco_descripcion());	
		bancoAsignar.setdias_efectivo_local(banco.getdias_efectivo_local());	
		bancoAsignar.setdias_efectivo_extranjero(banco.getdias_efectivo_extranjero());	
		bancoAsignar.setid_cuenta_contable_debito(banco.getid_cuenta_contable_debito());
		bancoAsignar.setcuentacontabledebito_descripcion(banco.getcuentacontabledebito_descripcion());	
		bancoAsignar.setid_cuenta_contable_credito(banco.getid_cuenta_contable_credito());
		bancoAsignar.setcuentacontablecredito_descripcion(banco.getcuentacontablecredito_descripcion());	
		bancoAsignar.setdelimitador(banco.getdelimitador());	
		bancoAsignar.setid_formato1(banco.getid_formato1());
		bancoAsignar.setformato1_descripcion(banco.getformato1_descripcion());	
		bancoAsignar.setid_formato2(banco.getid_formato2());
		bancoAsignar.setformato2_descripcion(banco.getformato2_descripcion());	
	}
	
	public static void inicializarBanco(Banco banco) throws Exception {
		try {
				banco.setId(0L);	
					
				banco.setid_empresa(-1L);	
				banco.setid_sucursal(-1L);	
				banco.setcodigo("");	
				banco.setcodigo_institucion("");	
				banco.setnombre("");	
				banco.setid_tipo_banco(-1L);	
				banco.setdias_efectivo_local(0);	
				banco.setdias_efectivo_extranjero(0);	
				banco.setid_cuenta_contable_debito(null);	
				banco.setid_cuenta_contable_credito(null);	
				banco.setdelimitador("");	
				banco.setid_formato1(null);	
				banco.setid_formato2(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_CODIGOINSTITUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDTIPOBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_DIASEFECTIVOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_DIASEFECTIVOEXTRANJERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_DELIMITADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDFORMATO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoConstantesFunciones.LABEL_IDFORMATO2);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBanco(String sTipo,Row row,Workbook workbook,Banco banco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getcodigo_institucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.gettipobanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getdias_efectivo_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getdias_efectivo_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getdelimitador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getformato1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(banco.getformato2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBanco() {
		return this.sFinalQueryBanco;
	}
	
	public void setsFinalQueryBanco(String sFinalQueryBanco) {
		this.sFinalQueryBanco= sFinalQueryBanco;
	}
	
	public Border resaltarSeleccionarBanco=null;
	
	public Border setResaltarSeleccionarBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBanco() {
		return this.resaltarSeleccionarBanco;
	}
	
	public void setResaltarSeleccionarBanco(Border borderResaltarSeleccionarBanco) {
		this.resaltarSeleccionarBanco= borderResaltarSeleccionarBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBanco=null;
	public Boolean mostraridBanco=true;
	public Boolean activaridBanco=true;

	public Border resaltarid_empresaBanco=null;
	public Boolean mostrarid_empresaBanco=true;
	public Boolean activarid_empresaBanco=true;
	public Boolean cargarid_empresaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBanco=false;//ConEventDepend=true

	public Border resaltarid_sucursalBanco=null;
	public Boolean mostrarid_sucursalBanco=true;
	public Boolean activarid_sucursalBanco=true;
	public Boolean cargarid_sucursalBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBanco=false;//ConEventDepend=true

	public Border resaltarcodigoBanco=null;
	public Boolean mostrarcodigoBanco=true;
	public Boolean activarcodigoBanco=true;

	public Border resaltarcodigo_institucionBanco=null;
	public Boolean mostrarcodigo_institucionBanco=true;
	public Boolean activarcodigo_institucionBanco=true;

	public Border resaltarnombreBanco=null;
	public Boolean mostrarnombreBanco=true;
	public Boolean activarnombreBanco=true;

	public Border resaltarid_tipo_bancoBanco=null;
	public Boolean mostrarid_tipo_bancoBanco=true;
	public Boolean activarid_tipo_bancoBanco=true;
	public Boolean cargarid_tipo_bancoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_bancoBanco=false;//ConEventDepend=true

	public Border resaltardias_efectivo_localBanco=null;
	public Boolean mostrardias_efectivo_localBanco=true;
	public Boolean activardias_efectivo_localBanco=true;

	public Border resaltardias_efectivo_extranjeroBanco=null;
	public Boolean mostrardias_efectivo_extranjeroBanco=true;
	public Boolean activardias_efectivo_extranjeroBanco=true;

	public Border resaltarid_cuenta_contable_debitoBanco=null;
	public Boolean mostrarid_cuenta_contable_debitoBanco=true;
	public Boolean activarid_cuenta_contable_debitoBanco=true;
	public Boolean cargarid_cuenta_contable_debitoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoBanco=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoBanco=null;
	public Boolean mostrarid_cuenta_contable_creditoBanco=true;
	public Boolean activarid_cuenta_contable_creditoBanco=true;
	public Boolean cargarid_cuenta_contable_creditoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoBanco=false;//ConEventDepend=true

	public Border resaltardelimitadorBanco=null;
	public Boolean mostrardelimitadorBanco=true;
	public Boolean activardelimitadorBanco=true;

	public Border resaltarid_formato1Banco=null;
	public Boolean mostrarid_formato1Banco=true;
	public Boolean activarid_formato1Banco=true;
	public Boolean cargarid_formato1Banco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato1Banco=false;//ConEventDepend=true

	public Border resaltarid_formato2Banco=null;
	public Boolean mostrarid_formato2Banco=true;
	public Boolean activarid_formato2Banco=true;
	public Boolean cargarid_formato2Banco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato2Banco=false;//ConEventDepend=true

	
	

	public Border setResaltaridBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltaridBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBanco() {
		return this.resaltaridBanco;
	}

	public void setResaltaridBanco(Border borderResaltar) {
		this.resaltaridBanco= borderResaltar;
	}

	public Boolean getMostraridBanco() {
		return this.mostraridBanco;
	}

	public void setMostraridBanco(Boolean mostraridBanco) {
		this.mostraridBanco= mostraridBanco;
	}

	public Boolean getActivaridBanco() {
		return this.activaridBanco;
	}

	public void setActivaridBanco(Boolean activaridBanco) {
		this.activaridBanco= activaridBanco;
	}

	public Border setResaltarid_empresaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBanco() {
		return this.resaltarid_empresaBanco;
	}

	public void setResaltarid_empresaBanco(Border borderResaltar) {
		this.resaltarid_empresaBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaBanco() {
		return this.mostrarid_empresaBanco;
	}

	public void setMostrarid_empresaBanco(Boolean mostrarid_empresaBanco) {
		this.mostrarid_empresaBanco= mostrarid_empresaBanco;
	}

	public Boolean getActivarid_empresaBanco() {
		return this.activarid_empresaBanco;
	}

	public void setActivarid_empresaBanco(Boolean activarid_empresaBanco) {
		this.activarid_empresaBanco= activarid_empresaBanco;
	}

	public Boolean getCargarid_empresaBanco() {
		return this.cargarid_empresaBanco;
	}

	public void setCargarid_empresaBanco(Boolean cargarid_empresaBanco) {
		this.cargarid_empresaBanco= cargarid_empresaBanco;
	}

	public Border setResaltarid_sucursalBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBanco() {
		return this.resaltarid_sucursalBanco;
	}

	public void setResaltarid_sucursalBanco(Border borderResaltar) {
		this.resaltarid_sucursalBanco= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBanco() {
		return this.mostrarid_sucursalBanco;
	}

	public void setMostrarid_sucursalBanco(Boolean mostrarid_sucursalBanco) {
		this.mostrarid_sucursalBanco= mostrarid_sucursalBanco;
	}

	public Boolean getActivarid_sucursalBanco() {
		return this.activarid_sucursalBanco;
	}

	public void setActivarid_sucursalBanco(Boolean activarid_sucursalBanco) {
		this.activarid_sucursalBanco= activarid_sucursalBanco;
	}

	public Boolean getCargarid_sucursalBanco() {
		return this.cargarid_sucursalBanco;
	}

	public void setCargarid_sucursalBanco(Boolean cargarid_sucursalBanco) {
		this.cargarid_sucursalBanco= cargarid_sucursalBanco;
	}

	public Border setResaltarcodigoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoBanco() {
		return this.resaltarcodigoBanco;
	}

	public void setResaltarcodigoBanco(Border borderResaltar) {
		this.resaltarcodigoBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoBanco() {
		return this.mostrarcodigoBanco;
	}

	public void setMostrarcodigoBanco(Boolean mostrarcodigoBanco) {
		this.mostrarcodigoBanco= mostrarcodigoBanco;
	}

	public Boolean getActivarcodigoBanco() {
		return this.activarcodigoBanco;
	}

	public void setActivarcodigoBanco(Boolean activarcodigoBanco) {
		this.activarcodigoBanco= activarcodigoBanco;
	}

	public Border setResaltarcodigo_institucionBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarcodigo_institucionBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_institucionBanco() {
		return this.resaltarcodigo_institucionBanco;
	}

	public void setResaltarcodigo_institucionBanco(Border borderResaltar) {
		this.resaltarcodigo_institucionBanco= borderResaltar;
	}

	public Boolean getMostrarcodigo_institucionBanco() {
		return this.mostrarcodigo_institucionBanco;
	}

	public void setMostrarcodigo_institucionBanco(Boolean mostrarcodigo_institucionBanco) {
		this.mostrarcodigo_institucionBanco= mostrarcodigo_institucionBanco;
	}

	public Boolean getActivarcodigo_institucionBanco() {
		return this.activarcodigo_institucionBanco;
	}

	public void setActivarcodigo_institucionBanco(Boolean activarcodigo_institucionBanco) {
		this.activarcodigo_institucionBanco= activarcodigo_institucionBanco;
	}

	public Border setResaltarnombreBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarnombreBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreBanco() {
		return this.resaltarnombreBanco;
	}

	public void setResaltarnombreBanco(Border borderResaltar) {
		this.resaltarnombreBanco= borderResaltar;
	}

	public Boolean getMostrarnombreBanco() {
		return this.mostrarnombreBanco;
	}

	public void setMostrarnombreBanco(Boolean mostrarnombreBanco) {
		this.mostrarnombreBanco= mostrarnombreBanco;
	}

	public Boolean getActivarnombreBanco() {
		return this.activarnombreBanco;
	}

	public void setActivarnombreBanco(Boolean activarnombreBanco) {
		this.activarnombreBanco= activarnombreBanco;
	}

	public Border setResaltarid_tipo_bancoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_tipo_bancoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_bancoBanco() {
		return this.resaltarid_tipo_bancoBanco;
	}

	public void setResaltarid_tipo_bancoBanco(Border borderResaltar) {
		this.resaltarid_tipo_bancoBanco= borderResaltar;
	}

	public Boolean getMostrarid_tipo_bancoBanco() {
		return this.mostrarid_tipo_bancoBanco;
	}

	public void setMostrarid_tipo_bancoBanco(Boolean mostrarid_tipo_bancoBanco) {
		this.mostrarid_tipo_bancoBanco= mostrarid_tipo_bancoBanco;
	}

	public Boolean getActivarid_tipo_bancoBanco() {
		return this.activarid_tipo_bancoBanco;
	}

	public void setActivarid_tipo_bancoBanco(Boolean activarid_tipo_bancoBanco) {
		this.activarid_tipo_bancoBanco= activarid_tipo_bancoBanco;
	}

	public Boolean getCargarid_tipo_bancoBanco() {
		return this.cargarid_tipo_bancoBanco;
	}

	public void setCargarid_tipo_bancoBanco(Boolean cargarid_tipo_bancoBanco) {
		this.cargarid_tipo_bancoBanco= cargarid_tipo_bancoBanco;
	}

	public Border setResaltardias_efectivo_localBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltardias_efectivo_localBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_efectivo_localBanco() {
		return this.resaltardias_efectivo_localBanco;
	}

	public void setResaltardias_efectivo_localBanco(Border borderResaltar) {
		this.resaltardias_efectivo_localBanco= borderResaltar;
	}

	public Boolean getMostrardias_efectivo_localBanco() {
		return this.mostrardias_efectivo_localBanco;
	}

	public void setMostrardias_efectivo_localBanco(Boolean mostrardias_efectivo_localBanco) {
		this.mostrardias_efectivo_localBanco= mostrardias_efectivo_localBanco;
	}

	public Boolean getActivardias_efectivo_localBanco() {
		return this.activardias_efectivo_localBanco;
	}

	public void setActivardias_efectivo_localBanco(Boolean activardias_efectivo_localBanco) {
		this.activardias_efectivo_localBanco= activardias_efectivo_localBanco;
	}

	public Border setResaltardias_efectivo_extranjeroBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltardias_efectivo_extranjeroBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_efectivo_extranjeroBanco() {
		return this.resaltardias_efectivo_extranjeroBanco;
	}

	public void setResaltardias_efectivo_extranjeroBanco(Border borderResaltar) {
		this.resaltardias_efectivo_extranjeroBanco= borderResaltar;
	}

	public Boolean getMostrardias_efectivo_extranjeroBanco() {
		return this.mostrardias_efectivo_extranjeroBanco;
	}

	public void setMostrardias_efectivo_extranjeroBanco(Boolean mostrardias_efectivo_extranjeroBanco) {
		this.mostrardias_efectivo_extranjeroBanco= mostrardias_efectivo_extranjeroBanco;
	}

	public Boolean getActivardias_efectivo_extranjeroBanco() {
		return this.activardias_efectivo_extranjeroBanco;
	}

	public void setActivardias_efectivo_extranjeroBanco(Boolean activardias_efectivo_extranjeroBanco) {
		this.activardias_efectivo_extranjeroBanco= activardias_efectivo_extranjeroBanco;
	}

	public Border setResaltarid_cuenta_contable_debitoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoBanco() {
		return this.resaltarid_cuenta_contable_debitoBanco;
	}

	public void setResaltarid_cuenta_contable_debitoBanco(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoBanco= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoBanco() {
		return this.mostrarid_cuenta_contable_debitoBanco;
	}

	public void setMostrarid_cuenta_contable_debitoBanco(Boolean mostrarid_cuenta_contable_debitoBanco) {
		this.mostrarid_cuenta_contable_debitoBanco= mostrarid_cuenta_contable_debitoBanco;
	}

	public Boolean getActivarid_cuenta_contable_debitoBanco() {
		return this.activarid_cuenta_contable_debitoBanco;
	}

	public void setActivarid_cuenta_contable_debitoBanco(Boolean activarid_cuenta_contable_debitoBanco) {
		this.activarid_cuenta_contable_debitoBanco= activarid_cuenta_contable_debitoBanco;
	}

	public Boolean getCargarid_cuenta_contable_debitoBanco() {
		return this.cargarid_cuenta_contable_debitoBanco;
	}

	public void setCargarid_cuenta_contable_debitoBanco(Boolean cargarid_cuenta_contable_debitoBanco) {
		this.cargarid_cuenta_contable_debitoBanco= cargarid_cuenta_contable_debitoBanco;
	}

	public Border setResaltarid_cuenta_contable_creditoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoBanco() {
		return this.resaltarid_cuenta_contable_creditoBanco;
	}

	public void setResaltarid_cuenta_contable_creditoBanco(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoBanco= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoBanco() {
		return this.mostrarid_cuenta_contable_creditoBanco;
	}

	public void setMostrarid_cuenta_contable_creditoBanco(Boolean mostrarid_cuenta_contable_creditoBanco) {
		this.mostrarid_cuenta_contable_creditoBanco= mostrarid_cuenta_contable_creditoBanco;
	}

	public Boolean getActivarid_cuenta_contable_creditoBanco() {
		return this.activarid_cuenta_contable_creditoBanco;
	}

	public void setActivarid_cuenta_contable_creditoBanco(Boolean activarid_cuenta_contable_creditoBanco) {
		this.activarid_cuenta_contable_creditoBanco= activarid_cuenta_contable_creditoBanco;
	}

	public Boolean getCargarid_cuenta_contable_creditoBanco() {
		return this.cargarid_cuenta_contable_creditoBanco;
	}

	public void setCargarid_cuenta_contable_creditoBanco(Boolean cargarid_cuenta_contable_creditoBanco) {
		this.cargarid_cuenta_contable_creditoBanco= cargarid_cuenta_contable_creditoBanco;
	}

	public Border setResaltardelimitadorBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltardelimitadorBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardelimitadorBanco() {
		return this.resaltardelimitadorBanco;
	}

	public void setResaltardelimitadorBanco(Border borderResaltar) {
		this.resaltardelimitadorBanco= borderResaltar;
	}

	public Boolean getMostrardelimitadorBanco() {
		return this.mostrardelimitadorBanco;
	}

	public void setMostrardelimitadorBanco(Boolean mostrardelimitadorBanco) {
		this.mostrardelimitadorBanco= mostrardelimitadorBanco;
	}

	public Boolean getActivardelimitadorBanco() {
		return this.activardelimitadorBanco;
	}

	public void setActivardelimitadorBanco(Boolean activardelimitadorBanco) {
		this.activardelimitadorBanco= activardelimitadorBanco;
	}

	public Border setResaltarid_formato1Banco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato1Banco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato1Banco() {
		return this.resaltarid_formato1Banco;
	}

	public void setResaltarid_formato1Banco(Border borderResaltar) {
		this.resaltarid_formato1Banco= borderResaltar;
	}

	public Boolean getMostrarid_formato1Banco() {
		return this.mostrarid_formato1Banco;
	}

	public void setMostrarid_formato1Banco(Boolean mostrarid_formato1Banco) {
		this.mostrarid_formato1Banco= mostrarid_formato1Banco;
	}

	public Boolean getActivarid_formato1Banco() {
		return this.activarid_formato1Banco;
	}

	public void setActivarid_formato1Banco(Boolean activarid_formato1Banco) {
		this.activarid_formato1Banco= activarid_formato1Banco;
	}

	public Boolean getCargarid_formato1Banco() {
		return this.cargarid_formato1Banco;
	}

	public void setCargarid_formato1Banco(Boolean cargarid_formato1Banco) {
		this.cargarid_formato1Banco= cargarid_formato1Banco;
	}

	public Border setResaltarid_formato2Banco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato2Banco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato2Banco() {
		return this.resaltarid_formato2Banco;
	}

	public void setResaltarid_formato2Banco(Border borderResaltar) {
		this.resaltarid_formato2Banco= borderResaltar;
	}

	public Boolean getMostrarid_formato2Banco() {
		return this.mostrarid_formato2Banco;
	}

	public void setMostrarid_formato2Banco(Boolean mostrarid_formato2Banco) {
		this.mostrarid_formato2Banco= mostrarid_formato2Banco;
	}

	public Boolean getActivarid_formato2Banco() {
		return this.activarid_formato2Banco;
	}

	public void setActivarid_formato2Banco(Boolean activarid_formato2Banco) {
		this.activarid_formato2Banco= activarid_formato2Banco;
	}

	public Boolean getCargarid_formato2Banco() {
		return this.cargarid_formato2Banco;
	}

	public void setCargarid_formato2Banco(Boolean cargarid_formato2Banco) {
		this.cargarid_formato2Banco= cargarid_formato2Banco;
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
		
		
		this.setMostraridBanco(esInicial);
		this.setMostrarid_empresaBanco(esInicial);
		this.setMostrarid_sucursalBanco(esInicial);
		this.setMostrarcodigoBanco(esInicial);
		this.setMostrarcodigo_institucionBanco(esInicial);
		this.setMostrarnombreBanco(esInicial);
		this.setMostrarid_tipo_bancoBanco(esInicial);
		this.setMostrardias_efectivo_localBanco(esInicial);
		this.setMostrardias_efectivo_extranjeroBanco(esInicial);
		this.setMostrarid_cuenta_contable_debitoBanco(esInicial);
		this.setMostrarid_cuenta_contable_creditoBanco(esInicial);
		this.setMostrardelimitadorBanco(esInicial);
		this.setMostrarid_formato1Banco(esInicial);
		this.setMostrarid_formato2Banco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoConstantesFunciones.ID)) {
				this.setMostraridBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGOINSTITUCION)) {
				this.setMostrarcodigo_institucionBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDTIPOBANCO)) {
				this.setMostrarid_tipo_bancoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOLOCAL)) {
				this.setMostrardias_efectivo_localBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO)) {
				this.setMostrardias_efectivo_extranjeroBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DELIMITADOR)) {
				this.setMostrardelimitadorBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO1)) {
				this.setMostrarid_formato1Banco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO2)) {
				this.setMostrarid_formato2Banco(esAsigna);
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
		
		
		this.setActivaridBanco(esInicial);
		this.setActivarid_empresaBanco(esInicial);
		this.setActivarid_sucursalBanco(esInicial);
		this.setActivarcodigoBanco(esInicial);
		this.setActivarcodigo_institucionBanco(esInicial);
		this.setActivarnombreBanco(esInicial);
		this.setActivarid_tipo_bancoBanco(esInicial);
		this.setActivardias_efectivo_localBanco(esInicial);
		this.setActivardias_efectivo_extranjeroBanco(esInicial);
		this.setActivarid_cuenta_contable_debitoBanco(esInicial);
		this.setActivarid_cuenta_contable_creditoBanco(esInicial);
		this.setActivardelimitadorBanco(esInicial);
		this.setActivarid_formato1Banco(esInicial);
		this.setActivarid_formato2Banco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoConstantesFunciones.ID)) {
				this.setActivaridBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGOINSTITUCION)) {
				this.setActivarcodigo_institucionBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDTIPOBANCO)) {
				this.setActivarid_tipo_bancoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOLOCAL)) {
				this.setActivardias_efectivo_localBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO)) {
				this.setActivardias_efectivo_extranjeroBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DELIMITADOR)) {
				this.setActivardelimitadorBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO1)) {
				this.setActivarid_formato1Banco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO2)) {
				this.setActivarid_formato2Banco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBanco(esInicial);
		this.setResaltarid_empresaBanco(esInicial);
		this.setResaltarid_sucursalBanco(esInicial);
		this.setResaltarcodigoBanco(esInicial);
		this.setResaltarcodigo_institucionBanco(esInicial);
		this.setResaltarnombreBanco(esInicial);
		this.setResaltarid_tipo_bancoBanco(esInicial);
		this.setResaltardias_efectivo_localBanco(esInicial);
		this.setResaltardias_efectivo_extranjeroBanco(esInicial);
		this.setResaltarid_cuenta_contable_debitoBanco(esInicial);
		this.setResaltarid_cuenta_contable_creditoBanco(esInicial);
		this.setResaltardelimitadorBanco(esInicial);
		this.setResaltarid_formato1Banco(esInicial);
		this.setResaltarid_formato2Banco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoConstantesFunciones.ID)) {
				this.setResaltaridBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.CODIGOINSTITUCION)) {
				this.setResaltarcodigo_institucionBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDTIPOBANCO)) {
				this.setResaltarid_tipo_bancoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOLOCAL)) {
				this.setResaltardias_efectivo_localBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO)) {
				this.setResaltardias_efectivo_extranjeroBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.DELIMITADOR)) {
				this.setResaltardelimitadorBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO1)) {
				this.setResaltarid_formato1Banco(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoConstantesFunciones.IDFORMATO2)) {
				this.setResaltarid_formato2Banco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaBancoPunVenBanco=null;

	public Border getResaltarCuentaBancoPunVenBanco() {
		return this.resaltarCuentaBancoPunVenBanco;
	}

	public void setResaltarCuentaBancoPunVenBanco(Border borderResaltarCuentaBancoPunVen) {
		if(borderResaltarCuentaBancoPunVen!=null) {
			this.resaltarCuentaBancoPunVenBanco= borderResaltarCuentaBancoPunVen;
		}
	}

	public Border setResaltarCuentaBancoPunVenBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaBancoPunVen=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarCuentaBancoPunVen);
			
		this.resaltarCuentaBancoPunVenBanco= borderResaltarCuentaBancoPunVen;

		 return borderResaltarCuentaBancoPunVen;
	}



	public Boolean mostrarCuentaBancoPunVenBanco=true;

	public Boolean getMostrarCuentaBancoPunVenBanco() {
		return this.mostrarCuentaBancoPunVenBanco;
	}

	public void setMostrarCuentaBancoPunVenBanco(Boolean visibilidadResaltarCuentaBancoPunVen) {
		this.mostrarCuentaBancoPunVenBanco= visibilidadResaltarCuentaBancoPunVen;
	}



	public Boolean activarCuentaBancoPunVenBanco=true;

	public Boolean gethabilitarResaltarCuentaBancoPunVenBanco() {
		return this.activarCuentaBancoPunVenBanco;
	}

	public void setActivarCuentaBancoPunVenBanco(Boolean habilitarResaltarCuentaBancoPunVen) {
		this.activarCuentaBancoPunVenBanco= habilitarResaltarCuentaBancoPunVen;
	}


	public Border resaltarPoliticasClienteBanco=null;

	public Border getResaltarPoliticasClienteBanco() {
		return this.resaltarPoliticasClienteBanco;
	}

	public void setResaltarPoliticasClienteBanco(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteBanco= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteBanco= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteBanco=true;

	public Boolean getMostrarPoliticasClienteBanco() {
		return this.mostrarPoliticasClienteBanco;
	}

	public void setMostrarPoliticasClienteBanco(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteBanco= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteBanco=true;

	public Boolean gethabilitarResaltarPoliticasClienteBanco() {
		return this.activarPoliticasClienteBanco;
	}

	public void setActivarPoliticasClienteBanco(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteBanco= habilitarResaltarPoliticasCliente;
	}


	public Border resaltarFormaPagoPuntoVentaBanco=null;

	public Border getResaltarFormaPagoPuntoVentaBanco() {
		return this.resaltarFormaPagoPuntoVentaBanco;
	}

	public void setResaltarFormaPagoPuntoVentaBanco(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaBanco= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaBanco= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaBanco=true;

	public Boolean getMostrarFormaPagoPuntoVentaBanco() {
		return this.mostrarFormaPagoPuntoVentaBanco;
	}

	public void setMostrarFormaPagoPuntoVentaBanco(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaBanco= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaBanco=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaBanco() {
		return this.activarFormaPagoPuntoVentaBanco;
	}

	public void setActivarFormaPagoPuntoVentaBanco(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaBanco= habilitarResaltarFormaPagoPuntoVenta;
	}


	public Border resaltarTarjetaCreditoBanco=null;

	public Border getResaltarTarjetaCreditoBanco() {
		return this.resaltarTarjetaCreditoBanco;
	}

	public void setResaltarTarjetaCreditoBanco(Border borderResaltarTarjetaCredito) {
		if(borderResaltarTarjetaCredito!=null) {
			this.resaltarTarjetaCreditoBanco= borderResaltarTarjetaCredito;
		}
	}

	public Border setResaltarTarjetaCreditoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCredito=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarTarjetaCredito);
			
		this.resaltarTarjetaCreditoBanco= borderResaltarTarjetaCredito;

		 return borderResaltarTarjetaCredito;
	}



	public Boolean mostrarTarjetaCreditoBanco=true;

	public Boolean getMostrarTarjetaCreditoBanco() {
		return this.mostrarTarjetaCreditoBanco;
	}

	public void setMostrarTarjetaCreditoBanco(Boolean visibilidadResaltarTarjetaCredito) {
		this.mostrarTarjetaCreditoBanco= visibilidadResaltarTarjetaCredito;
	}



	public Boolean activarTarjetaCreditoBanco=true;

	public Boolean gethabilitarResaltarTarjetaCreditoBanco() {
		return this.activarTarjetaCreditoBanco;
	}

	public void setActivarTarjetaCreditoBanco(Boolean habilitarResaltarTarjetaCredito) {
		this.activarTarjetaCreditoBanco= habilitarResaltarTarjetaCredito;
	}


	public Border resaltarAutoriPagoBanco=null;

	public Border getResaltarAutoriPagoBanco() {
		return this.resaltarAutoriPagoBanco;
	}

	public void setResaltarAutoriPagoBanco(Border borderResaltarAutoriPago) {
		if(borderResaltarAutoriPago!=null) {
			this.resaltarAutoriPagoBanco= borderResaltarAutoriPago;
		}
	}

	public Border setResaltarAutoriPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarAutoriPago);
			
		this.resaltarAutoriPagoBanco= borderResaltarAutoriPago;

		 return borderResaltarAutoriPago;
	}



	public Boolean mostrarAutoriPagoBanco=true;

	public Boolean getMostrarAutoriPagoBanco() {
		return this.mostrarAutoriPagoBanco;
	}

	public void setMostrarAutoriPagoBanco(Boolean visibilidadResaltarAutoriPago) {
		this.mostrarAutoriPagoBanco= visibilidadResaltarAutoriPago;
	}



	public Boolean activarAutoriPagoBanco=true;

	public Boolean gethabilitarResaltarAutoriPagoBanco() {
		return this.activarAutoriPagoBanco;
	}

	public void setActivarAutoriPagoBanco(Boolean habilitarResaltarAutoriPago) {
		this.activarAutoriPagoBanco= habilitarResaltarAutoriPago;
	}


	public Border resaltarTipoCuentaBancoGeneralBanco=null;

	public Border getResaltarTipoCuentaBancoGeneralBanco() {
		return this.resaltarTipoCuentaBancoGeneralBanco;
	}

	public void setResaltarTipoCuentaBancoGeneralBanco(Border borderResaltarTipoCuentaBancoGeneral) {
		if(borderResaltarTipoCuentaBancoGeneral!=null) {
			this.resaltarTipoCuentaBancoGeneralBanco= borderResaltarTipoCuentaBancoGeneral;
		}
	}

	public Border setResaltarTipoCuentaBancoGeneralBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoCuentaBancoGeneral=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarTipoCuentaBancoGeneral);
			
		this.resaltarTipoCuentaBancoGeneralBanco= borderResaltarTipoCuentaBancoGeneral;

		 return borderResaltarTipoCuentaBancoGeneral;
	}



	public Boolean mostrarTipoCuentaBancoGeneralBanco=true;

	public Boolean getMostrarTipoCuentaBancoGeneralBanco() {
		return this.mostrarTipoCuentaBancoGeneralBanco;
	}

	public void setMostrarTipoCuentaBancoGeneralBanco(Boolean visibilidadResaltarTipoCuentaBancoGeneral) {
		this.mostrarTipoCuentaBancoGeneralBanco= visibilidadResaltarTipoCuentaBancoGeneral;
	}



	public Boolean activarTipoCuentaBancoGeneralBanco=true;

	public Boolean gethabilitarResaltarTipoCuentaBancoGeneralBanco() {
		return this.activarTipoCuentaBancoGeneralBanco;
	}

	public void setActivarTipoCuentaBancoGeneralBanco(Boolean habilitarResaltarTipoCuentaBancoGeneral) {
		this.activarTipoCuentaBancoGeneralBanco= habilitarResaltarTipoCuentaBancoGeneral;
	}


	public Border resaltarCuentaBancoBanco=null;

	public Border getResaltarCuentaBancoBanco() {
		return this.resaltarCuentaBancoBanco;
	}

	public void setResaltarCuentaBancoBanco(Border borderResaltarCuentaBanco) {
		if(borderResaltarCuentaBanco!=null) {
			this.resaltarCuentaBancoBanco= borderResaltarCuentaBanco;
		}
	}

	public Border setResaltarCuentaBancoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaBanco=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//bancoBeanSwingJInternalFrame.jTtoolBarBanco.setBorder(borderResaltarCuentaBanco);
			
		this.resaltarCuentaBancoBanco= borderResaltarCuentaBanco;

		 return borderResaltarCuentaBanco;
	}



	public Boolean mostrarCuentaBancoBanco=true;

	public Boolean getMostrarCuentaBancoBanco() {
		return this.mostrarCuentaBancoBanco;
	}

	public void setMostrarCuentaBancoBanco(Boolean visibilidadResaltarCuentaBanco) {
		this.mostrarCuentaBancoBanco= visibilidadResaltarCuentaBanco;
	}



	public Boolean activarCuentaBancoBanco=true;

	public Boolean gethabilitarResaltarCuentaBancoBanco() {
		return this.activarCuentaBancoBanco;
	}

	public void setActivarCuentaBancoBanco(Boolean habilitarResaltarCuentaBanco) {
		this.activarCuentaBancoBanco= habilitarResaltarCuentaBanco;
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

		this.setMostrarCuentaBancoPunVenBanco(esInicial);
		this.setMostrarPoliticasClienteBanco(esInicial);
		this.setMostrarFormaPagoPuntoVentaBanco(esInicial);
		this.setMostrarTarjetaCreditoBanco(esInicial);
		this.setMostrarAutoriPagoBanco(esInicial);
		this.setMostrarTipoCuentaBancoGeneralBanco(esInicial);
		this.setMostrarCuentaBancoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaBancoPunVen.class)) {
				this.setMostrarCuentaBancoPunVenBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setMostrarTarjetaCreditoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setMostrarAutoriPagoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setMostrarTipoCuentaBancoGeneralBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaBanco.class)) {
				this.setMostrarCuentaBancoBanco(esAsigna);
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

		this.setActivarCuentaBancoPunVenBanco(esInicial);
		this.setActivarPoliticasClienteBanco(esInicial);
		this.setActivarFormaPagoPuntoVentaBanco(esInicial);
		this.setActivarTarjetaCreditoBanco(esInicial);
		this.setActivarAutoriPagoBanco(esInicial);
		this.setActivarTipoCuentaBancoGeneralBanco(esInicial);
		this.setActivarCuentaBancoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaBancoPunVen.class)) {
				this.setActivarCuentaBancoPunVenBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setActivarTarjetaCreditoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setActivarAutoriPagoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setActivarTipoCuentaBancoGeneralBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaBanco.class)) {
				this.setActivarCuentaBancoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaBancoPunVenBanco(esInicial);
		this.setResaltarPoliticasClienteBanco(esInicial);
		this.setResaltarFormaPagoPuntoVentaBanco(esInicial);
		this.setResaltarTarjetaCreditoBanco(esInicial);
		this.setResaltarAutoriPagoBanco(esInicial);
		this.setResaltarTipoCuentaBancoGeneralBanco(esInicial);
		this.setResaltarCuentaBancoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaBancoPunVen.class)) {
				this.setResaltarCuentaBancoPunVenBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setResaltarTarjetaCreditoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setResaltarAutoriPagoBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setResaltarTipoCuentaBancoGeneralBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaBanco.class)) {
				this.setResaltarCuentaBancoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoBanco=true;

	public Boolean getMostrarBusquedaPorCodigoBanco() {
		return this.mostrarBusquedaPorCodigoBanco;
	}

	public void setMostrarBusquedaPorCodigoBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoBanco= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorCodigoInstitucionBanco=true;

	public Boolean getMostrarBusquedaPorCodigoInstitucionBanco() {
		return this.mostrarBusquedaPorCodigoInstitucionBanco;
	}

	public void setMostrarBusquedaPorCodigoInstitucionBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoInstitucionBanco= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreBanco=true;

	public Boolean getMostrarBusquedaPorNombreBanco() {
		return this.mostrarBusquedaPorNombreBanco;
	}

	public void setMostrarBusquedaPorNombreBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBanco=true;

	public Boolean getMostrarFK_IdEmpresaBanco() {
		return this.mostrarFK_IdEmpresaBanco;
	}

	public void setMostrarFK_IdEmpresaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalBanco=true;

	public Boolean getMostrarFK_IdSucursalBanco() {
		return this.mostrarFK_IdSucursalBanco;
	}

	public void setMostrarFK_IdSucursalBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoBancoBanco=true;

	public Boolean getMostrarFK_IdTipoBancoBanco() {
		return this.mostrarFK_IdTipoBancoBanco;
	}

	public void setMostrarFK_IdTipoBancoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoBancoBanco= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoBanco=true;

	public Boolean getActivarBusquedaPorCodigoBanco() {
		return this.activarBusquedaPorCodigoBanco;
	}

	public void setActivarBusquedaPorCodigoBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoBanco= habilitarResaltar;
	}

	public Boolean activarBusquedaPorCodigoInstitucionBanco=true;

	public Boolean getActivarBusquedaPorCodigoInstitucionBanco() {
		return this.activarBusquedaPorCodigoInstitucionBanco;
	}

	public void setActivarBusquedaPorCodigoInstitucionBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoInstitucionBanco= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreBanco=true;

	public Boolean getActivarBusquedaPorNombreBanco() {
		return this.activarBusquedaPorNombreBanco;
	}

	public void setActivarBusquedaPorNombreBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBanco=true;

	public Boolean getActivarFK_IdEmpresaBanco() {
		return this.activarFK_IdEmpresaBanco;
	}

	public void setActivarFK_IdEmpresaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalBanco=true;

	public Boolean getActivarFK_IdSucursalBanco() {
		return this.activarFK_IdSucursalBanco;
	}

	public void setActivarFK_IdSucursalBanco(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoBancoBanco=true;

	public Boolean getActivarFK_IdTipoBancoBanco() {
		return this.activarFK_IdTipoBancoBanco;
	}

	public void setActivarFK_IdTipoBancoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdTipoBancoBanco= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoBanco=null;

	public Border getResaltarBusquedaPorCodigoBanco() {
		return this.resaltarBusquedaPorCodigoBanco;
	}

	public void setResaltarBusquedaPorCodigoBanco(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoBanco= borderResaltar;
	}

	public Border resaltarBusquedaPorCodigoInstitucionBanco=null;

	public Border getResaltarBusquedaPorCodigoInstitucionBanco() {
		return this.resaltarBusquedaPorCodigoInstitucionBanco;
	}

	public void setResaltarBusquedaPorCodigoInstitucionBanco(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoInstitucionBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoInstitucionBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoInstitucionBanco= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreBanco=null;

	public Border getResaltarBusquedaPorNombreBanco() {
		return this.resaltarBusquedaPorNombreBanco;
	}

	public void setResaltarBusquedaPorNombreBanco(Border borderResaltar) {
		this.resaltarBusquedaPorNombreBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreBanco= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBanco=null;

	public Border getResaltarFK_IdEmpresaBanco() {
		return this.resaltarFK_IdEmpresaBanco;
	}

	public void setResaltarFK_IdEmpresaBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBanco= borderResaltar;
	}

	public Border resaltarFK_IdSucursalBanco=null;

	public Border getResaltarFK_IdSucursalBanco() {
		return this.resaltarFK_IdSucursalBanco;
	}

	public void setResaltarFK_IdSucursalBanco(Border borderResaltar) {
		this.resaltarFK_IdSucursalBanco= borderResaltar;
	}

	public void setResaltarFK_IdSucursalBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalBanco= borderResaltar;
	}

	public Border resaltarFK_IdTipoBancoBanco=null;

	public Border getResaltarFK_IdTipoBancoBanco() {
		return this.resaltarFK_IdTipoBancoBanco;
	}

	public void setResaltarFK_IdTipoBancoBanco(Border borderResaltar) {
		this.resaltarFK_IdTipoBancoBanco= borderResaltar;
	}

	public void setResaltarFK_IdTipoBancoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*BancoBeanSwingJInternalFrame bancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoBancoBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}